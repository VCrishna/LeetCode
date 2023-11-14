class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> s1=new HashSet<String>();
        
        for(int i=0;i<emails.length;i++){
            String s="";
            String[] str=emails[i].split("@");
            s1.add(str[0].split("\\+")[0].replace(".","")+"@"+str[1]);
        }
        
        return s1.size();
    }
}