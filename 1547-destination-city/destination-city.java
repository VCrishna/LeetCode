class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> src = new HashSet<>();

        for(List<String> lst : paths) {
            src.add(lst.get(0));
        }

        for(List<String> lst : paths) {
            if(!src.contains(lst.get(1))) return lst.get(1);
        }

        return "";
    }
}