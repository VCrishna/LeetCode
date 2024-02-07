class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        // Iterate until the target point (tx, ty) is greater 
        // than or equal to the source point (sx, sy)
        while (tx >= sx && ty >= sy) {
            // Base case: if the target point matches the source point, return true
            if (tx == sx && ty == sy) {
                return true;
            }

            // Reduce the larger coordinate of the target point 
            // until it's less than the other coordinate
            if (tx > ty) {
                tx %= ty; // Subtract ty from tx if tx > ty
            } else {
                ty %= tx; // Subtract tx from ty if ty > tx
            }

            // Check if we've reached a point where one coordinate matches the source
            // and the other coordinate is a multiple of the source
            if (tx == sx) {
                // If the difference between the target and source coordinates of the other axis
                // is a multiple of the source coordinate, it means we can reach the target point.
                if ((ty - sy) % tx == 0) {
                    return true;
                } else {
                    // If not, it's impossible to reach the target point
                    return false;
                }
            }

            // Similar check for the other coordinate
            if (ty == sy) {
                if ((tx - sx) % ty == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        // If we can't reach the target point within the boundaries defined by the source,
        // return false
        return false;
    }
}
/**
-math problem, work backwards, modulo variant
         
        (x+y, y)   or   (x, x+y)   
        
        
        source = 2,5     target = 19,12
        
                            
                            2,5
                            /\
                        7,5   2,7
                        /\
                   12,5  7,12
                          /\
                     19,12   7,19
                     
              
              if tx > ty:
                tx %= ty
              elif ty > tx:
                ty -= tx 
              
              
              
              
              
              
              source = 1,9       target = 100,9
                           
                           
                           1,9
                           /\
                        10,9  1,10
                        /\
                   19,9    10,19
                    /\
                28,9  19,28
                /\
            37,9  28,37
            /\
          46,9  37,46
          /  \
         55,9  46,55
        / \
        ...
       .....
       82,9
       /  \
     91,9
     /    \
    100,9  91,100
                 
                 
                                
                    source = 3,3      target = 21,9            
                    
                                 3,3
                                /   \
                              6,3   3,6
                                    /   \
                                  9,6    3,9
                                  / \     /  \   
                             15,6  9,15  12,9  3,12
                                         / \
                                      21,9  12,21   
                        
                        
                        
                        
                        1) x=21, y=9
                        2) x=3, y=9
                        3) 9%=3 = 3
                        
                        
                        sx,sy (3,3)
                        
                               3,3
                               3,6
                        tx,ty (3,9)
                        
                        
                        9-3 = 6%3 == 0, return True
                        
                        
                        
                        sx,sy (3,2)
                               5,2
                               7,2
                               9,2
                        tx,ty (11,2)
                        
                        11-3 = 8%2 == 0, its V
*/
