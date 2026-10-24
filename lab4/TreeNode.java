public class TreeNode {
    int value;
    TreeNode[] children;

    public TreeNode(int value) {
        this.value = value;
        this.children = new TreeNode[0];
    }

    public void setChildren(TreeNode[] children) {
        this.children = children;
    }
}
