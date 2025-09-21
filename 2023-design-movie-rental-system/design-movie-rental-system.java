class MovieRentingSystem {
    /**
     * Represents one movie copy in one shop.
     * We store shop, movie, and price for quick comparisons.
     */
    private static class Node {
        final int shop;
        final int movie;
        final int price;
        Node(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }
    }

    /**
     * Comparator defines the ordering rule for movies/shops.
     * Intuition: When picking movies, we need to sort by:
     *   1. price (cheapest first)
     *   2. shop index (if tie in price, smaller shop ID first)
     *   3. movie index (final tie-breaker, for rented report)
     * 
     * Strict ordering is important because we’re putting Nodes into TreeSets,
     * which need consistent and unique ordering.
     */
    private static final Comparator<Node> CMP =
        (a, b) -> {
            int c = Integer.compare(a.price, b.price);
            if (c != 0) return c;  // cheapest price first
            c = Integer.compare(a.shop, b.shop);
            if (c != 0) return c;  // tie → smaller shop first
            return Integer.compare(a.movie, b.movie); // tie → smaller movie first
        };

    // ------------------- CORE DATA STRUCTURES -------------------
    /**
     * availableByMovie:
     * For each movie ID → keep a sorted set of Nodes that have it available.
     * Intuition: When someone searches for a movie, we only need to look at
     * this movie’s TreeSet to get the top 5 cheapest shops instantly.
     */
    private final Map<Integer, TreeSet<Node>> availableByMovie = new HashMap<>();

    /**
     * rentedSet:
     * Global TreeSet of all currently rented Nodes.
     * Intuition: Needed for the "report" API (top 5 rented movies by order).
     * Sorting uses CMP (cheapest → shop → movie).
     */
    private final TreeSet<Node> rentedSet = new TreeSet<>(CMP);

    /**
     * byPair:
     * Maps (shop, movie) pair → Node object.
     * Intuition: Quick lookup when we rent/drop.
     * We need this so we don’t create duplicate Nodes and so we can remove
     * them from sets in O(log n).
     */
    private final Map<Long, Node> byPair = new HashMap<>();

    /**
     * Key encoding for shop+movie pair.
     * We combine into a single long using bit shifts:
     *   upper 32 bits = shop
     *   lower 32 bits = movie
     * 
     * Intuition: Avoids having to build custom pair objects or use arrays
     * as map keys (cheaper + faster).
     */
    private static long key(int shop, int movie) {
        return (((long) shop) << 32) ^ (movie & 0xffffffffL);
    }

    // ------------------- CONSTRUCTOR -------------------
    /**
     * Build system with initial entries.
     * Each entry = [shop, movie, price].
     * - Store node in byPair for quick lookup.
     * - Add node to availableByMovie[movie].
     * Intuition: Start with everything available, nothing rented.
     */
    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            Node node = new Node(shop, movie, price);
            byPair.put(key(shop, movie), node);
            availableByMovie
                .computeIfAbsent(movie, k -> new TreeSet<>(CMP))
                .add(node);
        }
    }

    // ------------------- API FUNCTIONS -------------------

    /**
     * search(movie):
     * Return up to 5 shop IDs that have this movie available.
     * Ordering = cheapest price → shop ID.
     * 
     * Intuition: Just grab the first 5 elements from the TreeSet for this movie.
     */
    public List<Integer> search(int movie) {
        List<Integer> ans = new ArrayList<>(5);
        TreeSet<Node> set = availableByMovie.get(movie);
        if (set == null || set.isEmpty()) return ans; // no availability
        Iterator<Node> it = set.iterator();
        for (int i = 0; i < 5 && it.hasNext(); i++) {
            ans.add(it.next().shop);
        }
        return ans;
    }

    /**
     * rent(shop, movie):
     * Move a copy from available → rented.
     * Steps:
     * 1. Look up Node by (shop,movie).
     * 2. Remove from availableByMovie[movie].
     * 3. Add to rentedSet.
     * 
     * Intuition: Renting removes it from search results but makes it appear in report().
     */
    public void rent(int shop, int movie) {
        long k = key(shop, movie);
        Node node = byPair.get(k);
        if (node == null) return; // defensive check
        TreeSet<Node> set = availableByMovie.get(movie);
        if (set != null) set.remove(node);
        rentedSet.add(node);
    }

    /**
     * drop(shop, movie):
     * Move a copy from rented → available.
     * Steps:
     * 1. Look up Node by (shop,movie).
     * 2. Remove from rentedSet.
     * 3. Re-add to availableByMovie[movie].
     * 
     * Intuition: Dropping frees up the copy, so it should show up in search again.
     */
    public void drop(int shop, int movie) {
        long k = key(shop, movie);
        Node node = byPair.get(k);
        if (node == null) return; // defensive
        rentedSet.remove(node);
        availableByMovie
            .computeIfAbsent(movie, x -> new TreeSet<>(CMP))
            .add(node);
    }

    /**
     * report():
     * Return up to 5 rented copies, as [shop, movie].
     * Ordering = cheapest price → shop ID → movie ID.
     * 
     * Intuition: Just read the global rentedSet (already sorted).
     * Since we only need the first 5, it’s efficient.
     */
    public List<List<Integer>> report() {
        List<List<Integer>> ans = new ArrayList<>(5);
        Iterator<Node> it = rentedSet.iterator();
        for (int i = 0; i < 5 && it.hasNext(); i++) {
            Node n = it.next();
            ans.add(Arrays.asList(n.shop, n.movie));
        }
        return ans;
    }
}


/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */