class TimeMap {

    private Map<String, TreeMap<Integer, String>> map;
    
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!this.map.containsKey(key)) {
            this.map.put(key, new TreeMap<>());
        }
        this.map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!this.map.containsKey(key)) return "";
        Integer floorKey = this.map.get(key).floorKey(timestamp);
        
        if (floorKey == null) return "";
        return this.map.get(key).get(floorKey);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */