package array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Quang-Khai TRAN
 * @date 05/06/2022
 */

public class Total {




    public static void main(String[] args) {


        int[] arr = {-7,-3,2,3,11};

        System.out.println(firstBadVersion(1, 2126753390));


    }

    // time: O(n)
    //space: O(n)
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i< nums.length ; i++) {
            if (map.containsKey(target -nums[i])) {
                return new int[] {map.get(target -nums[i]), i};
            } else {
                map.put(i, nums[i]);
            }
        }
        return null;
    }

   //  1   3   5 2126753390
   //1702766719
    // 1 2 3 4 5 6 7 8 9
    // 5 - 4
    //isBadVersion(version)
    public static int firstBadVersion(long start, long n) {

        if (start +1 == n) {
            if ( isBadVersion((int)start)) {
                return (int) start;
            } else {
                return (int) n;
            }
        }
        if (isBadVersion((int) ((n+start)/2))) {
            return firstBadVersion(start, (n+start)/2);
        } else {
            return firstBadVersion((n+start)/2, n);
        }
    }
    //2126753390
    //1702766719
    private static boolean isBadVersion(int n) {
        if (n < 1702766719) return false;
        return true;
    }

    /*
        Input: nums = [-7,-3,2,3,11]
        Output: [4,9,9,49,121]
     */
    public static int[] sortedSquares(int[] nums) {


        int[] res = new int[nums.length];
        int l = 0; int r = nums.length -1;

        for (int i = nums.length - 1; i>= 0; i--) {
            int v = nums[l];
            if (Math.abs(v) < Math.abs(nums[r])) {
                v = Math.abs(nums[r]);
                r--;
            } else  {
                l ++;
            }
            res[i] = v *v;
        }

        System.out.println(IntStream.of(res).boxed().collect(Collectors.toList()));

        return  res;
    }


    /* 1,1
        nums[i] is in the range [1, n]
        nums = [4,3,2,7,8,2,3,1] => (5,6)    / 1 2 2 3 3 4 7 8
     */

    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        boolean[] b = new boolean[nums.length];
        for (int i :nums) {
            b[i-1] = true;
        }
        for (int  i = 0; i < b.length ; i++) {
            if (!b[i]) res.add(i+1);
        }
        return res;
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < nums.length+1; i++) {
            set.add(i);
        }
        for (int num : nums) {
            set.remove(num);
        }
        return new ArrayList<>(set);
    }

    //
    public static int thirdMax(int[] nums) {
        long c = Long.MIN_VALUE;
        long c1 = c, c2 =c, c3 = c;
        for (int num : nums) {
            if (num > c1) {
                c3 = c2;
                c2 = c1;
                c1 = num;
            } else if (num > c2 && num < c1) {
                c3 = c2;
                c2 = num;
            } else if (num > c3 && num < c2) {
                c3 = num;
            }
        }
        return (int) (c3 > c? c3:c1);
    }


    //  Given a binary array nums, return the maximum number of consecutive 1's in the array if you can flip at most one 0.
    /*
        Input: nums = [1,1,0,1,1,0, 1 , 1 ,0 , 0 ,1 ,1 ,1]
        Output: 4
        Keep index of 2 consecutive Zero element and Its precedent number of 1-element
        Other solution: Sliding Window
     */
    public  static int findMaxConsecutiveOnes(int[] nums) {
        int i1 = -1, c1 = -1;
        int i2 = -1, c2 = -1;
        boolean ok = false;
        int c = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (i2 >= 0) ok = true;
                if (ok) {
                    i1 = i2;
                    c1 = c2;
                }
                i2 = i;
                c2 = c2 < 0 ? i : (i - i1 - 1);
                c = Math.max(c, c1 + c2 + 1);
            }
        }
        c = Math.max(c, nums.length  - (Math.max(i2, 0)) +  (Math.max(c2, 0)));
        return c;
    }


    public int heightChecker(int[] heights) {

        int i = 0;
        int c = 0;
        int[] num = Arrays.copyOfRange(heights,0, heights.length);
        Arrays.sort(num);
        for(i = 0; i < heights.length; i++) {
            if (num[i] != heights[i]) c++;
        }
        return c;

    }


//[2,1,2,3,5,7,9,10,12,14,15,16,18,14,13]
    public static boolean validMountainArray(int[] arr) {
        if( arr.length < 3) return false;
        boolean p = false;
        boolean l = false;

        for (int i = 0; i < arr.length-1; i++) {

            if(arr[i] == arr[i+1]) return false;

            if(arr[i] < arr[i+1]) {
                if(p) return false;
                l = true;
                continue;
            }
            if(arr[i] > arr[i+1]) {
                if (!l) return  false;
                p = true;
            }
        }
        return p;
    }


    public boolean checkIfExist(int[] arr) {

        Map<Integer, Integer> s = new HashMap<>();

        for(int i:arr) {
            if (s.containsValue(i) || s.containsKey(i*2)) return true;
            s.put(i, i *2);
        }
        return false;
    }


    /*
    Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
    Return any array that satisfies this condition.
    Input: nums = [3,6,1,2,4]   4 6 1 2 3
    Output: [2,4,3,1]
     */
    public int[] sortArrayByParity(int[] nums) {

        int i = 0;
        int k = nums.length - 1;

        while (i < k) {
            if ( nums[i] %2 == 1 && nums[k] % 2 == 0) {
                int t = nums[i];
                nums[i] = nums[k];
                nums[k] = t;
                 k--;
            } else  {
                i++;
            }
        }

        return nums;
    }

    /*
         Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
        Note that you must do this in-place without making a copy of the array.
        Input: nums = [0,1,0,3,12]
        Output: [1,3,12,0,0]
     */
    public static void moveZero(int[] arr) {
        int k = 0;
        int i = 0;
        while (k < arr.length) {
            if (arr[k] != 0) {
                arr[i++] = arr[k];
            }
            k++;
        }
        while(i <arr.length) {
            arr[i++] = 0;
        }
        System.out.println(IntStream.of(arr).boxed().collect(Collectors.toList()));

    }

    // replace element by greatest element among the elements to its right
    //Input: arr =  [17,18,5,4,6,1]
    //Output:       [18,6,6,6,1,-1]
    public static int[] replaceElements(int[] arr) {

        int max  = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int  i = arr.length -2; i>= 0; i--) {
            int t = max;
            if (arr[i] > max) {
                max = arr[i];
            }
            arr[i] = t;
        }
        System.out.println(IntStream.of(arr).boxed().collect(Collectors.toList()));


        return arr;
    }

    // 0 1 1 2 3 3 4 4 4 5
    public static int removeDuplicates(int[] nums) {
        int k = 1; int i = 0;
        int last = nums[0];

        for (k = 1; k < nums.length; k ++) {
            if (nums[k] > last) {
                i++;
                nums[i] = nums[k];
                last = nums[k];
            }
        }
        System.out.println(IntStream.of(nums).boxed().collect(Collectors.toList()));
        System.out.println(i+1);

        return i+1;
    }

}
