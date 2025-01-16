class Solution {
    public int repeatedStringMatch(String a, String b) {
    int count = 1;
    String repeated = a;
    while (repeated.length() < b.length()) {
        repeated += a;
        count++;
    }
    if (repeated.contains(b)) {
        return count;
    }
    repeated += a;
    count++;
    if (repeated.contains(b)) {
        return count;
    }
    return -1;
}

}