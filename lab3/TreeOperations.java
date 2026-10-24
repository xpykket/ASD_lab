public class TreeOperations {

    public static TreeNode createTree() {
        //             10
        //           /    \
        //          3      15
        //         / \    /  \
        //        7   12 3    20
        //       /              \
        //      7                25

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(12);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(20);
        root.left.left.left = new TreeNode(7);
        root.right.right.right = new TreeNode(25);
        return root;
    }


    private static boolean SameNumber(TreeNode node, int number, TreeNode exclusion) {
        if (node == null) {
            return false;
        }

        if (node != exclusion && node.value == number) {
            return true;
        }
        return SameNumber(node.left, number, exclusion)
                || SameNumber(node.right, number, exclusion);
    }


    private static void findDuplicates(TreeNode node, TreeNode root) {
        if (node == null) {
            return;
        }

        if (SameNumber(root, node.value, node)) {
            System.out.println("Найден повторяющийся номер: " + node.value);
        }

        findDuplicates(node.left, root);
        findDuplicates(node.right, root);
    }

    public static void printsame(TreeNode root) {
        System.out.println("Вершины с одинаковыми номерами:");
        findDuplicates(root, root);
    }
}
