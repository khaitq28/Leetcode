package tree;

/**
 * @author Quang-Khai TRAN
 * @date 24/03/2023
 */

public class ConvertSortedArrayBinarySearchTree {

    int[] arr;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.arr= nums;
        return get(0, nums.length -1);
    }

    TreeNode get(int b, int e) {
        if (b== e) return new TreeNode(arr[b]);
        if (b + 1 == e) {
            TreeNode node = new TreeNode(arr[b]);
            node.right = new TreeNode(arr[e]);
            return node;
        }
        int m = (b+e)/2;
        TreeNode node = new TreeNode(arr[m]);
        node.left = get(b, m-1);
        node.right =get(m +1, e);
        return node;
    }

}
