public class Main {
    public static void main(String[] args) {
        TreeNode root = createTree();
        TreeOperations.printLongestIncreasingPaths(root);
    }

    public static TreeNode createTree() {
        //             1
        //          /   |   \
        //         3    15   20
        //       / | \   |    |
        //      7  12 14 18   25
        //     / \
        //    6   8
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node12 = new TreeNode(12);
        TreeNode node14 = new TreeNode(14);
        TreeNode node15 = new TreeNode(15);
        TreeNode node18 = new TreeNode(18);
        TreeNode node20 = new TreeNode(20);
        TreeNode node25 = new TreeNode(25);

        node1.setChildren(new TreeNode[] {node3, node15, node20});
        node3.setChildren(new TreeNode[] {node7, node12, node14});
        node7.setChildren(new TreeNode[] {node6, node8});
        node15.setChildren(new TreeNode[] {node18});
        node20.setChildren(new TreeNode[] {node25});

        return node1;
    }
}
