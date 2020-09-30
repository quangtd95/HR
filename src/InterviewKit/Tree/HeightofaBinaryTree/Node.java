package InterviewKit.Tree.HeightofaBinaryTree;


class Solution {
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    /*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
    public static int height(Node root) {
        int leftHeight = 0;
        int rightHeight = 0;
        if (root.left != null) {
            leftHeight = 1 + height(root.left);
        }
        if (root.right != null) {
            rightHeight = 1 + height(root.right);
        }
        return Math.max(leftHeight, rightHeight);
    }


    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
}
