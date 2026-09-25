class Solution {
    // Returns the cartesian product of two lists of strings 
    public List<String> join(List<String> expression1, List<String> expression2) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        
        for (String s1 : expression1) {
            sb.setLength(0);
            sb.append(s1);
            for (String s2 : expression2) {
                sb.setLength(s1.length());
                sb.append(s2);
                res.add(sb.toString());
            }
        }
        return res;
    }
    
    // Returns the union of two lists of strings 
    public List<String> concat(List<String> expression1, List<String> expression2) {
        List<String> res = new ArrayList<>();
        res.addAll(expression1);
        res.addAll(expression2);
        return res;
    }
    
    // Returns an integer, i, such that the expansion of S is the union of the expansion of two substrings S[..i] U S[i..]
    public Integer concatSubExpressions(String s) {
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ',' && count == 0) {
                return i;
            } else if (c == '{') {
                count++;
            } else if (c == '}') {
                count--;
            }
        }
        return null;
    }
    
    // Returns an integer, i, such that the expansion of S is the cartesian product of the expansion of two substrings S[..i] x S[i..]
    // Returns -1 when S = "{S1}", such that S1 is a valid expression
    public Integer joinSubExpressions(String s) {
        int openI = -1, count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{') {
                if (openI == -1) {
                    openI = i;
                }
                count++;
            } else if (c == '}') {
                count--;
                if (count <= 0) {
                    if (i == s.length() - 1) {
                        if (openI == 0) {
                            return -1;
                        } 
                        return openI;
                    }
                    return i + 1;
                }
            }
        }
        return null;
    }
    
    public List<String> expand(String s) {
        if (s.equals("")) return Arrays.asList(new String[]{""});
        
        Integer concatIndex = concatSubExpressions(s);
        if (concatIndex != null) { // If S can be divided into two substrings S1, S2, such that S = "S1,S2" and both S1 and S2 are valid expressions
            return concat(expand(s.substring(0, concatIndex)), expand(s.substring(concatIndex + 1, s.length())));
        }
        
        Integer joinIndex = joinSubExpressions(s);
        if (joinIndex != null) { // If S can be divided into two substrings S1, S2, such that S = "S1S2" and both S1 and S2 are valid expressions
            if (joinIndex == -1) {
                return expand(s.substring(1, s.length() - 1)); // If S = "{S1}", return the expansion of S1
            } else {
                return join(expand(s.substring(0, joinIndex)), expand(s.substring(joinIndex, s.length())));
            }
        }
        
        // Otherwise this expression has no subexpressions
        return Arrays.asList(s.split(","));
    }
    
    
    public List<String> braceExpansionII(String expression) {
        TreeSet<String> set = new TreeSet<>(expand(expression));
        
        List<String> res = new ArrayList<>();
        
        // Sort and get unique expansions via a treeset
        for (String s : set) {
            if (s.equals("")) continue;
            res.add(s);
        }
        return res;
    }
}