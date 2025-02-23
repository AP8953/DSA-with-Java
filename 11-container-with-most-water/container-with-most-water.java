class Solution {
    public int maxArea(int[] height) {
        int first=0;
        int last=height.length-1;
        int max=Integer.MIN_VALUE;
        while(first<last){
            int min=Math.min(height[last], height[first]);//height[first]>height[last]?height[last]:height[first];
            int temp=min*(last-first);
            max=Math.max(max, temp);
            if(height[first]<height[last]) first++;
            else last--;
        }
        return max;
    }
}