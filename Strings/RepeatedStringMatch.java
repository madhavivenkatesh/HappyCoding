class Solution {
    public int repeatedStringMatch(String A, String B) {
        int minrep = 1;
        StringBuilder S = new StringBuilder(A);
        for (; S.length() < B.length(); minrep++) S.append(A);
        if (S.indexOf(B) >= 0) return minrep;
        if (S.append(A).indexOf(B) >= 0) return minrep+1;
        return -1;
    }
}
