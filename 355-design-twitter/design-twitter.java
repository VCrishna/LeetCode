class Twitter {
    // User - follower list
    // userid, followers set
    // Map<User, Set<Users>>
    // userid, [timestamp, tweet]
    // Map<Integer, List<int[]> tweetMap;
    Map<Integer, Set<Integer>> users;
    Map<Integer, List<int[]>> tweetMap;
    int time;

    public Twitter() {
        users = new HashMap<>();
        tweetMap = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        int[] tweet = new int[] { time, tweetId };
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<>());
        }
        tweetMap.get(userId).add(tweet);
        time++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        Set<Integer> followers = users.getOrDefault(userId, new HashSet<>());
        followers.add(userId);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int user : followers) {
            if (tweetMap.containsKey(user)) {
                List<int[]> lst = tweetMap.get(user);
                lst.forEach(x -> maxHeap.offer(x));
            }
        }

        // Populate feed with top 10 posts
        while (!maxHeap.isEmpty() && feed.size() < 10) {
            feed.add(maxHeap.poll()[1]);
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            users.put(followerId, new HashSet<>());
        }
        users.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (users.containsKey(followerId)) users.get(followerId).remove(followeeId);
    }
}
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
