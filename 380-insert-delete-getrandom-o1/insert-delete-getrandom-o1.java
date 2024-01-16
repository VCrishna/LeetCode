class RandomizedSet {
    Map<Integer, Integer> indexingMap;
    List<Integer> numbers;

    public RandomizedSet() {
        indexingMap = new HashMap<>();
        numbers = new ArrayList<>();
    }

    // Append to the end, maintain indexing
    // Delete by swapping with the end, maintain indexing
    // Get random by getting a random index wrt list's size
    public boolean insert(int val) {
        if (indexingMap.containsKey(val)) {
            return false;
        }
        int indexInsert = numbers.size();
        numbers.add(val);
        indexingMap.put(val, indexInsert);
        return true;
    }

    public boolean remove(int val) {
        if (!indexingMap.containsKey(val)) {
            return false;
        }

        int lastIndex = numbers.size() - 1;
        int lastElement = numbers.get(lastIndex);
        int indexElement = indexingMap.get(val);

        // Swap with last element
        numbers.set(indexElement, lastElement);

        // Update indices [Add & Delete]
        indexingMap.put(lastElement, indexElement);
        indexingMap.remove(val);

        // Remove from list
        numbers.remove(lastIndex);
        return true;
    }

    public int getRandom() {
        int randomIndex = (int) (Math.random() * numbers.size());
        return numbers.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */