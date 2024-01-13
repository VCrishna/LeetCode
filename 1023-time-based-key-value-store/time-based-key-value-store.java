class TimeMap {
    Map<String, TreeMap<Integer, String>> tMap;

    public TimeMap() {
        tMap = new HashMap<String, TreeMap<Integer, String>>();
    }

    public void set(String key, String value, int timestamp) {
        tMap.computeIfAbsent(key, n -> new TreeMap<Integer, String>());
        tMap.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!tMap.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> kMap = tMap.get(key);

        Integer floorTimestamp = kMap.floorKey(timestamp);
        if (floorTimestamp != null) {
            return kMap.get(floorTimestamp);
        }

        return "";
    }

}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */