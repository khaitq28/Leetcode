package daily;

/**
 * @author Quang-Khai TRAN
 * @date 28/03/2024
 */

public class WayMakeFairArray {

    public static void main(String[] args) {
        WayMakeFairArray main = new WayMakeFairArray();
        System.out.println(main.waysToMakeFair(new int[]{1,2,3}));
    }

    public int waysToMakeFair(int[] arr) {
        int n = arr.length;
        if (arr.length == 1) return 1;
        int[] odd = new int[arr.length];
        int[] even = new int[arr.length];
        odd[1] = arr[1];
        even[0] = arr[0];even[1] = even[0];
        for(int i = 2; i < arr.length; i ++) {
            if (i  % 2 == 0) {
                odd[i] = odd[i-1];
                even[i] = even[i-1] + arr[i];
            } else {
                even[i] = even[i-1];
                odd[i] = odd[i-1] + arr[i];
            }
        }
        int ret = 0;
        for(int i = 0 ; i < arr.length; i++ ) {
            int sumeven = (i < 1 ? 0: even[i-1]) + odd[arr.length-1] - odd[i];
            int sumodd =  (i < 1 ? 0: odd[i-1]) + even[arr.length -1] - even[i];
            if (sumodd == sumeven) ret ++;
        }
        return ret;
    }

}
