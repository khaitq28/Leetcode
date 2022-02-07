package HashMap;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

	
    public static int firstUniqChar(String s) {
    	char[] arr = s.toCharArray();
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
    	for (int i = 0; i < arr.length; i ++) {
    		char c = arr[i];
    		if (map.containsKey(c)) {
    			map.put(c, -i);
    		} else {
        		map.put(c, i);
    		}
    	}
    	int val = Integer.MAX_VALUE;
    	for(java.util.Map.Entry<Character, Integer> e: map.entrySet()) {
    		if (e.getValue() >= 0 && e.getValue()< val) val = e.getValue();
    	}
    	return val == Integer.MAX_VALUE ? -1: val;
    }
    
}


// [{}[]]{}


 