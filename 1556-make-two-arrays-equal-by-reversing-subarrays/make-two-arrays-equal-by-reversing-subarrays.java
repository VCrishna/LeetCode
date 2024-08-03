class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] targetCount = new int[1001];
        int[] arrCount = new int[1001];
        for(int i = 0;i < target.length; i++){
            int n = target[i];
            targetCount[n]++;
        }
        for(int i = 0;i < arr.length; i++){
            int n = arr[i];
            arrCount[n]++;
        }
        for(int i = 0;i < target.length; i++){
            int n = target[i];
            if(targetCount[n]!=arrCount[n]) return false;
        }

        return true;
    }
}