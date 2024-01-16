class RandomizedSet {
    public Map<Integer,Integer> numMap;
    public List<Integer> numList;

    public RandomizedSet() {
        numMap = new HashMap<>();
        numList = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(numMap.containsKey(val)) {
            return false;
        }
        numMap.put(val, numList.size());
        numList.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!numMap.containsKey(val)) {
            return false;
        }
        int lastIndex = numList.size() - 1;
        int lastElement = numList.get(lastIndex);
        int indexElement = numMap.get(val);

        // Swap with last element
        numList.set(indexElement, lastElement);

        // Update indices [Add & Delete]
        numMap.put(lastElement, indexElement);
        numMap.remove(val);

        // Remove from list
        numList.remove(lastIndex);
        return true;
    }
    
    public int getRandom() {
        int randomIndex = (int) (Math.random() * this.numList.size());
        return this.numList.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */