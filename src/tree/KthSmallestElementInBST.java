package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Quang-Khai TRAN
 * @date 24/03/2023
 */

public class KthSmallestElementInBST {

    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        get(root);
        return xx;
    }
    int v = 0;
    int k = 0;
    int xx = 0;
    boolean f =false;

    void get(TreeNode root) {
        if (f) return;
        if (root.left != null) {
            get(root.left);
            if (f) return;
        }
        list.add(root.val);
        v ++;
        if (v == k) {
            f = true;
            xx = root.val;
            return ;
        }
        if (root.right != null) {
            get(root.right);
        }
    }

}
