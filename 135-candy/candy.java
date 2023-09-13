class Solution {

    /**
    arr[i] : no of candies ith child have

    First give every child 1 candy so arr[i] = 1 for all i .

    Traverse from left to right and if :

    ratings[i] > ratings[i-1] : we must give ith child atleast one more candy than (i-1)th child :
    arr[i] = arr[i-1] +1 ;

    Traverse from Right to Left and if :
    ratings[i] > ratings[i+1] : we must give ith child atleast one more candy than (i+1)th child:
    if(arr[i]<=arr[i+1])arr[i]=arr[i+1]+1 ;

    During the second traversal , we can observe that changing the values of arr doesn't affects the relation maintained in the first traversal

    Hence, both the right and left neighbours relation are maintained, without affecting each other.

    We must observe that this is the minimum number of increament we can perform
    
     */
    public int candy(int[] ratings) {
        int count = 0;
        if (ratings.length == 0) return count;
        int length = ratings.length;
        int[] counter = new int[length];
        Arrays.fill(counter, 1);
        boolean hasChanged = true;
        while (hasChanged) {
            hasChanged = false;
            for (int i = 0; i < length; i++) {
                // if (i - 1 >= 0 && ratings[i] > ratings[i - 1]) count++;
                if (i - 1 >= 0 && ratings[i] > ratings[i - 1]  && counter[i] <= counter[i - 1]) {
                    counter[i] = counter[i - 1] + 1;
                    hasChanged = true;
                }

                // if (i + 1 < length && ratings[i] > ratings[i + 1]) count++;
                if (i + 1 < length && ratings[i] > ratings[i + 1]  && counter[i] <= counter[i+1]) {
                    counter[i] = counter[i + 1] + 1;
                    hasChanged = true;
                }
            }
        }
        for (int i : counter) count += i;

        return count;
    }
}