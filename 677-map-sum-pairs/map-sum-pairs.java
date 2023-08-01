class MapSum {
    Map<String,Integer> MapSumPairs;
    public MapSum() {
        MapSumPairs = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        MapSumPairs.put(key,val);
    }
    
    public int sum(String prefix) {
        int sum = 0;
        for(String s:MapSumPairs.keySet()) {
            if(s.startsWith(prefix))
                sum += MapSumPairs.get(s);
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */