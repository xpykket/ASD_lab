public class TreeOperations {
    private static int maxLength;

    public static void printLongestIncreasingPaths(TreeNode root) {
        if (root == null) {
            System.out.println("Дерево пустое.");
            return;
        }

        maxLength = 0;
        findMaxLength(root, 0, 0, false);
        System.out.println("Длиннейшие возрастающие пути:");
        printPathsFromEveryNode(root, new int[maxLength]);
    }

    private static void findMaxLength(TreeNode node, int length, int previousValue, boolean hasPrevious) {
        if (hasPrevious && node.value > previousValue) {
            length++;
        } else {
            length = 1;
        }
        if (length > maxLength) {
            maxLength = length;
        }
        for (TreeNode child : node.children) {
            findMaxLength(child, length, node.value, true);
        }
    }

    private static void printPathsFromEveryNode(TreeNode node, int[] path) {
        printIncreasingPaths(node, path, 0);

        for (TreeNode child : node.children) {
            printPathsFromEveryNode(child, path);
        }
    }

    private static void printIncreasingPaths(TreeNode node, int[] path, int pathLength) {
        path[pathLength] = node.value;
        pathLength++;

        if (pathLength == maxLength) {
            for (int i = 0; i < pathLength; i++) {
                if (i > 0) {
                    System.out.print(" -> ");
                }
                System.out.print(path[i]);
            }
            System.out.println();
        }

        for (TreeNode child : node.children) {
            if (child.value > node.value) {
                printIncreasingPaths(child, path, pathLength);
            }
        }
    }
}
