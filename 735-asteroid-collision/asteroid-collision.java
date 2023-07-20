class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stck=new Stack<Integer>();
        int i = 0;
        while(i < asteroids.length){
            if(asteroids[i]>0){
                stck.push(asteroids[i]);
            }
            else{
                while(!stck.isEmpty() && stck.peek() > 0 && stck.peek() < Math.abs(asteroids[i])){
                    stck.pop();
                }
                if(stck.isEmpty() || stck.peek() < 0){
                    stck.push(asteroids[i]);
                }
                else if(stck.peek() == Math.abs(asteroids[i])){
                    stck.pop();
                }
            }
            i++;
        }

        // stck.forEach(System.out::println);
        int[] result=new int[stck.size()];
        int index=stck.size()-1;
        while(!stck.isEmpty()){
            result[index--]=stck.pop();
        }

        return result;
    }
}