
public class Main {

    public static class TreeNode {

        int val;
        TreeNode left=null;
        TreeNode right=null;
        TreeNode(int x) { val = x; }

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(10);
        root.right.right.left = new TreeNode(7);
        root.right.right.left.right = new TreeNode(8);

        //if uncommented we should get 32, if commented we should get 8
        //root.right.right.right = new TreeNode(32);

        System.out.println(findSecongBiggest(root));
    }

    public static int findSecongBiggest(TreeNode root){

        //get the right most node and node before that
        TreeNode prev= new TreeNode(0);

        while(root.right != null){
            prev=root;
            root = root.right;
        }

        //if right most node doesn't have a left node return prev
        if(root.left==null){
            return prev.val;
        }

        //if right most has left node get the MAX val [rightest node] in the sub-tree made of its left node
        else{

            TreeNode left = root.left;

            while(left.right!=null){
                left = left.right;
            }

            return left.val;

        }

    }

}
