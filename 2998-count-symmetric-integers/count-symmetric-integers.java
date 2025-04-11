class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count=0;
        if((low<10&&high<10) || ((low>99&& low<1000)&&(high>99&& high<1000)) || (low>9999&&high>9999)){
            return 0;
        }
        else {
            
            for(int i=low;i<=high;i++){
                if(((i<10) || (i>99&& i<1000) || i>9999)){
                    
                }
                else{
                    if(check(i)) count++;
                }
                
            }
        }
        return count;
    }
    private boolean check(int i){
        int length=0;
        int temp=i;
        while(temp>0){
            temp=temp/10;
            length++;
        }
        temp=i;
        int lastTwo=0,firstTwo=0;
        for(int j=0;j<length/2;j++){
            lastTwo=lastTwo+i%10;
            i=i/10;
        }
        for(int j=0;j<length/2;j++){
            firstTwo=firstTwo+i%10;
            i=i/10;
        }
        if(lastTwo==firstTwo) {
            System.out.println(temp);
            return true;
        }return false;
    }
}