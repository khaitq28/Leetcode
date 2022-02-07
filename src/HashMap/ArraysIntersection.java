package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArraysIntersection {

	public static void main(String[] args) {

	}
	
    public static int[] intersection(int[] nums1, int[] nums2) {
    	Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    	for (int i : nums1) map.put(i, true);
    	List<Integer> list = new ArrayList<>();
    	for (int i : nums2) {
    		if (map.containsKey(i) && map.get(i) == true) {
    			list.add(i);
    			map.put(i, false);
    		}
    	}
    	int[] res = new int[list.size()];

    	for(int i = 0; i < list.size(); i ++) {
    		res[i] = list.get(i);
    	}
    	return res;
    }

}
