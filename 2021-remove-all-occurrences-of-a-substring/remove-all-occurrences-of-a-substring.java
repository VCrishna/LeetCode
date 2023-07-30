class Solution 
{
    public String removeOccurrences(String s, String part) 
    {
        // Start index of {part} in {s}
        int index = s.indexOf(part);
        
        // If {index == - 1}-> then {part} is not substring of {s} and return {s}
        if (index == -1) return s;
        
        // Otherwise and in a recursive way, take only the parts before and after the 'first' {part} (from left)
        s = s.substring(0, index) + s.substring(index + part.length());

        // Recursive return
        return removeOccurrences(s, part);
    }
}