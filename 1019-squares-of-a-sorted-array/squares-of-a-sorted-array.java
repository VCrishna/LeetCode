class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] squareArray=new int[nums.length];
        int temp=0;
        for (int i=0; i<nums.length; i++){
            squareArray[i]=nums[i]*nums[i];
        }
        
        // for (int j=0; j<squareArray.length; j++){
        //     for(int k=0; k<squareArray.length; k++){
        //         if(squareArray[k]>squareArray[j]){
        //             temp=squareArray[j];
        //             squareArray[j]=squareArray[k];
        //             squareArray[k]=temp;
        //         }
        //     }
        // }
        Arrays.sort(squareArray);
        return squareArray;
    }
}