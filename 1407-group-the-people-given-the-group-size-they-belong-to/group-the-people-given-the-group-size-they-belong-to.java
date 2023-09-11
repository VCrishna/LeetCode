class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ret=new ArrayList<>();
        Map<Integer, List<Integer>> mp=new HashMap<>();
        for(int i=0;i<groupSizes.length;i++){
            // Creating a map with groupsize as key
            // new list as value
            mp.putIfAbsent(groupSizes[i],new ArrayList<>());
            // adding values to the list
            mp.get(groupSizes[i]).add(i);
            // if list size is equal to the groupsize then we are adding
            // that list to the final return list and removing that key value
            // pair from the map and in the next iteration as the groupsize value
            // is removed, it will be added again
            if(mp.get(groupSizes[i]).size()==groupSizes[i])
            {
                ret.add(mp.get(groupSizes[i]));
                mp.remove(groupSizes[i]);
            }
        }


        return ret;
    }
}