class Solution {
    class Node {
        int maxLen, prefixLen, suffixLen;
        char leftChar, rightChar;

        Node(int maxLen, int prefixLen, int suffixLen, char leftChar, char rightChar) {
            this.maxLen = maxLen;
            this.prefixLen = prefixLen;
            this.suffixLen = suffixLen;
            this.leftChar = leftChar;
            this.rightChar = rightChar;
        }
    }

    String s;
    Node[] segTree;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        this.s = s;
        int n = s.length();
        segTree = new Node[4 * n];
        build(1, 0, n - 1);

        int k = queryIndices.length;
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = segTree[1].maxLen;
        }
        return ans;
    }

    private void build(int idx, int l, int r) {
        if (l == r) {
            char c = s.charAt(l);
            segTree[idx] = new Node(1, 1, 1, c, c);
            return;
        }
        int mid = (l + r) / 2;
        build(idx * 2, l, mid);
        build(idx * 2 + 1, mid + 1, r);
        segTree[idx] = merge(segTree[idx * 2], segTree[idx * 2 + 1], mid - l + 1, r - mid);
    }

    private void update(int idx, int l, int r, int pos, char c) {
        if (l == r) {
            segTree[idx] = new Node(1, 1, 1, c, c);
            return;
        }
        int mid = (l + r) / 2;
        if (pos <= mid)
            update(idx * 2, l, mid, pos, c);
        else
            update(idx * 2 + 1, mid + 1, r, pos, c);
        segTree[idx] = merge(segTree[idx * 2], segTree[idx * 2 + 1], mid - l + 1, r - mid);
    }

    private Node merge(Node left, Node right, int leftSize, int rightSize) {
        Node res = new Node(0, 0, 0, left.leftChar, right.rightChar);

        res.prefixLen = left.prefixLen;
        if (left.prefixLen == leftSize && left.rightChar == right.leftChar) {
            res.prefixLen += right.prefixLen;
        }

        res.suffixLen = right.suffixLen;
        if (right.suffixLen == rightSize && left.rightChar == right.leftChar) {
            res.suffixLen += left.suffixLen;
        }

        res.maxLen = Math.max(left.maxLen, right.maxLen);
        if (left.rightChar == right.leftChar) {
            res.maxLen = Math.max(res.maxLen, left.suffixLen + right.prefixLen);
        }

        return res;
    }
}