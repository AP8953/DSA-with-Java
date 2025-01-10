class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    for (int gift : gifts) {
        maxHeap.add(gift);
    }

    // Perform k operations
    for (int i = 0; i < k; i++) {
        int max = maxHeap.poll(); // Extract the largest element
        maxHeap.add((int) Math.sqrt(max)); // Replace it with its square root
    }

    // Compute the sum of remaining elements
    long sum = 0;
    while (!maxHeap.isEmpty()) {
        sum += maxHeap.poll();
    }

    return sum;
    }
}