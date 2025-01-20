class Solution {
    private int[] calculateLPS(String needle){
        int lps[]=new int[needle.length()];
        int j=0;
        for(int i=1;i<needle.length();){
            if(needle.charAt(i)==needle.charAt(j)){
                j+=1;
                lps[i]=j;
                i+=1;
            }else{
                if(j!=0){
                    j=lps[j-1];
                }
                else{
                    lps[i]=0;
                    i+=1;
                }
            }
        }
        return lps;
    }
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        int[] lps=calculateLPS(needle);
        int i=0,j=0;
        while(i<haystack.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i+=1;
                j+=1;
            }
            if(j==needle.length()){
                return i-j;

            }
            
                if(i<haystack.length() && needle.charAt(j)!=haystack.charAt(i)){
                    if(j!=0){
                        j=lps[j-1];
                    }else{
                        i+=1;
                    }
                
                
                
            }
        }
        return -1;
    }
}