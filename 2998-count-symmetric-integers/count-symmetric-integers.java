class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        if((low<10&&high<10) || ((low>99&& low<1000)&&(high>99&& high<1000)) || (low>9999&&high>9999)){
            return 0;
        }
        for (int i = low; i <= high; i++) {
            String s = String.valueOf(i);
            int len = s.length();
            if (len % 2 == 0) {
                int mid = len / 2;
                int leftSum = 0, rightSum = 0;
                for (int j = 0; j < mid; j++) {
                    leftSum += s.charAt(j) - '0';
                    rightSum += s.charAt(j + mid) - '0';
                }
                if (leftSum == rightSum) {
                    count++;
                }
            }
        }
        return count;
    }
}
