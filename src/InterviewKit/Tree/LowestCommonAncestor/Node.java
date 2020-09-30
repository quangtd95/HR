package InterviewKit.Tree.LowestCommonAncestor;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    /*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
    public static Node lca(Node root, int v1, int v2) {
        if (root.data < v1 && root.data < v2) {
            return lca(root.right, v1, v2);
        }
        if (root.data > v1 && root.data > v2) {
            return lca(root.left, v1, v2);
        }
        return root;
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