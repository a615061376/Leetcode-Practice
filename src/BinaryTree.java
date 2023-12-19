public class BinaryTree {

    // 前序遞歸
    public static void preorder(TreeDeep.TreeNode root) {
        if (root == null) {
            return;
        }
        //System.out.println(root.val); //前序: 第一次成為棧頂元素即打印-->(1245673)
        preorder(root.left);
        //System.out.println(root.val); //中序: 第二次成為棧頂元素即打印-->(4265713)
        preorder(root.right);
        //System.out.println(root.val); //後序: 第三次成為棧頂元素即打印-->(4675231)
    }

    public static void main(String[] args) {
        TreeDeep.TreeNode node7 = new TreeDeep.TreeNode(7, null, null);
        TreeDeep.TreeNode node6 = new TreeDeep.TreeNode(6, null, null);
        TreeDeep.TreeNode node5 = new TreeDeep.TreeNode(5, node6, node7);
        TreeDeep.TreeNode node4 = new TreeDeep.TreeNode(4, null, null);
        TreeDeep.TreeNode node3 = new TreeDeep.TreeNode(3, null, null);
        TreeDeep.TreeNode node2 = new TreeDeep.TreeNode(2, node4, node5);
        TreeDeep.TreeNode node1 = new TreeDeep.TreeNode(1, node2, node3);
        preorder(node1);
    }
}
