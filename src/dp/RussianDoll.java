package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Quang-Khai TRAN
 * @date 26/09/2023
 */

public class RussianDoll {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b)-> {
            if(a[0]==b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });
        List<Integer> res = new ArrayList<>();
        res.add(envelopes[0][1]);
        for(int i=1;i<envelopes.length;i++){
            if(envelopes[i][1]>res.get(res.size()-1)){
                res.add(envelopes[i][1]);
            }
            else{
                int lowerBoundIndex = lowerBound(res, envelopes[i][1]);
                res.set(lowerBoundIndex, envelopes[i][1]);
            }
        }
        System.out.println(res);
        return res.size();
    }

    public static void main(String[] args) {
        RussianDoll russianDoll = new RussianDoll();

        int[][] v = {{1,2}, {2,3}, {3,4}, {5,10}, {5,9}, {5,6}, {6,40}, {6,20}, {6,6}};

        System.out.println(russianDoll.maxEnvelopes(v));
    }

    private int lowerBound(List<Integer> res, int val){
        int low =0, high =res.size()-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(res.get(mid)<val){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }


}
