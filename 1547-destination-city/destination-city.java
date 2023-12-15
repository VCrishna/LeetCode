class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> src = new HashSet<>();
        Set<String> dest = new HashSet<>();

        for(List<String> lst : paths) {
            src.add(lst.get(0));
            dest.add(lst.get(1));
        }

        for(String s : dest) {
            if(!src.contains(s)) return s;
        }

        return "";
    }
}