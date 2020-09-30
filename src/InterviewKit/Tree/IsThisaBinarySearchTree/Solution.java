package InterviewKit.Tree.IsThisaBinarySearchTree;

import java.util.HashSet;
import java.util.Set;

class Node {
    int data;
    Node left;
    Node right;
}

public class Solution {

    boolean checkBST(Node root) {
        HashSet<Integer> integers = new HashSet<>();
        int max = 0;
        return checkBST(root, integers, max);
    }

    boolean checkBST(Node root, Set<Integer> value, int max) {
        if (root.data > max) {
            return false;

        }
        if (value.contains(root.data)) {
            return false;
        }
        value.add(root.data);
        if (root.left != null) {
            max = Math.max(root.data, root.left.data);
            return checkBST(root.left, value, max);
        }
        if (root.right != null) {
            max = Math.max(root.data, root.right.data);
            return checkBST(root.right, value, max);
        }
        return true;
    }
}
