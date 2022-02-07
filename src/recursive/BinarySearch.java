package recursive;

public class BinarySearch {

    public static void main (String ...args){

        // { 1,2,3,4,5,6,7}

        int[] arr = {1,3,4,5,6,7};

        System.out.println(binarySearch(arr,0,arr.length-1, 2));

    }

    /*
    * arr is sorted before
     */
    private static int binarySearch(int[] arr, int begin, int end, int k) {


        if (end - begin == 1) return k == arr[end] ? end : k == arr[begin] ? begin : -1;
        int mid = (end + begin) /2;

        if (k == arr[mid]) return mid;
        if (k < arr[mid]) {
            return binarySearch(arr, begin, mid, k);
        }
        if (k > arr[mid]) {
            return binarySearch(arr, mid, end, k);
        }
        return -1;
    }

}
