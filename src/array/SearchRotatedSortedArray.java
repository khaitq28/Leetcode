package array;

/**
 * @author Quang-Khai TRAN
 * @date 21/03/2023
 */

public class SearchRotatedSortedArray {

    int[] arr;
    public int search(int[] nums, int target) {
        arr = nums;
        v = target;
        return check(0, nums.length-1);
    }
    private int v;

    private int check(int b, int e) {

        if (b == e) return arr[b] == v ? b: -1;

        if (arr[b] < arr[e]) {
            if (arr[b] > v || arr[e] < v) return -1;
            return bs(b,e);
        }

        int m = (b + e)/2;

        int left = check(b, m);
        return left >=0 ? left:  check(m +1, e);
    }

    private int bs(int b, int e) {
        if (b == e || b +1 == e) {
            return arr[b] == v ? b: arr[e] == v ? e : -1;
        }
        int m = (e + b)/2;
        return v >= arr[m+1] ? bs(m+1, e) : bs(b, m);
    }

}
