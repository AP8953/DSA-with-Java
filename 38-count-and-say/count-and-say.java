class Solution {
    public String countAndSay(int n) {
        String prev="1";
        
            for(int i=2;i<=n;i++){
                String current="";
                for(int j=0;j<prev.length();j++){
                    int count=1;
                    while((j+1)<prev.length()&&(prev.charAt(j)==prev.charAt(j+1))){
                        count++;
                        j++;
                    }
                    
                current=current+String.valueOf(count)+String.valueOf(prev.charAt(j));
                     
                }
                System.out.println(current);
                prev=current;
            
           
        } return prev;
    }
}