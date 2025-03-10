class Solution {

    public boolean isConsonant(char ch) {
        return !(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }

    public boolean hasAllVowels(int arr[]) {
        if (arr['a' - 'a'] >= 1 && arr['e' - 'a'] >= 1 && arr['i' - 'a'] >= 1
                && arr['o' - 'a'] >= 1 && arr['u' - 'a'] >= 1) {
            return true;
        }
        return false;
    }

    public long countOfSubstrings(String word, int k) {
        
        return (atLeastConsonants(k, word)-atLeastConsonants(k+1, word));
    }

    private long atLeastConsonants(int k, String word){
        long ans=0;
        int arr[]=new int[26];
        int cntCons=0;
        int left=0;
        long n=word.length();
        for(int right=0; right<n; right++){
            char ch=word.charAt(right);
            arr[ch-'a']++;
            if(isConsonant(ch)){
                cntCons++;
            }
            while(cntCons>=k && hasAllVowels(arr)){
                ans+=(n-right);
                char c=word.charAt(left);
                if(isConsonant(c)){
                    cntCons--;
                }
                arr[c-'a']--;
                left++;
            }
        }

        return ans;
    }
}