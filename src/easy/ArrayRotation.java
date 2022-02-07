package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ArrayRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "abcabcbb";
		
		String s1 = "ab";  
		String s2 = "eidbaooo";  
		
        System.out.println( checkIncludePermutation3(s1, s2)); 
        
        int[][] image =  { {0,0,0},{0,0,0}};
        
        image = (floodFill(image, 0, 0, 2));
        
        for (int[] arr: image) {
        	for (int i: arr) {
        		System.out.print(i + "  ");
        	}
        	System.out.println(); 
        }
	}
	
	
	 public static int[][] floodFill(int[][] image, int x, int y, int newColor) {
	     
		 image[x][y] = newColor;
		 
		 LinkedList<int[]> list = new LinkedList<int[]>();
		 list.add(new int[]{x,y});
		 
		 while(list.size() > 0) {
			 
			 int [] a = list.remove(0);
			 x = a[0]; 
			 y = a[1];
			 image[x][y] = newColor;
			 
			 if (x > 0 && image[x-1][y] != 0 && image[x-1][y] != newColor) {
				 list.add(new int[]{x -1,y});
			 }
			 
			 if (y > 0 && image[x][y-1] != 0 && image[x][y-1] != newColor) {
				 list.add(new int[]{x,y - 1});
			 }
			 
			 if (x < image.length - 1 && image[x+1][y] != 0 && image[x+1][y] != newColor) {
				 list.add(new int[]{x + 1,y});
			 }
			 
			 if (y < image[0].length -1 && image[x][y + 1] != 0 && image[x][y + 1] != newColor) {
				 list.add(new int[]{x,y + 1});
			 }
			 
		 }
		 return image;
	 }
	 
	 public static class Node {
		 int x; int y;
	 }
	 
	 
	
	//check if S2 contains Permutation  of S1
    public static boolean checkIncludePermutation3(String s1, String s2) {

    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	for (int i = 0; i < s1.length(); i ++) {
    		char c = s1.charAt(i);
    		map.put(c, (map.get(c) != null ? map.get(c) : 0)  + 1);
    	}
    	
    	
    	HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
    	for (int j = 0; j < s1.length(); j ++) {
    		char c = s2.charAt(j); 
    		map2.put(c, (map2.get(c) != null ? map2.get(c) : 0) + 1);
    	}
    	if (map.equals(map2)) return true;
    	
    	if (s2.length() > s1.length()) {
    		for (int i = s1.length(); i < s2.length(); i++) {
    			char c = s2.charAt(i);
    			
    			char c2 = s2.charAt(i - s1.length());
    			map2.put(c2, map2.get(c2) -1);
    			
    			map2.put(c, (map2.get(c) != null ? map2.get(c) : 0) + 1);
    			if (map.equals(map2)) return true;
    		}
    	}
    	
    	return false; 
    }
    
	
	//check if S2 contains Permutation  of S1
    public static boolean checkIncludePermutation2(String s1, String s2) {

    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	for (int i = 0; i < s1.length(); i ++) {
    		char c = s1.charAt(i);
    		map.put(c, (map.get(c) != null ? map.get(c) : 0)  + 1);
    	}
    	
    	String s  = null;
    	HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
    	
    	
    	
    	for (int i = 0; i < s2.length() - s1.length() + 1; i ++) {
            
            if (map.get(s2.charAt(i)) == null) continue;
            
    		s = s2.substring(i, i + s1.length());
        	for (int j = 0; j < s.length(); j ++) {
        		char c = s.charAt(j); 
        		if (map.get(c) == null) break;
        		map2.put(c, (map2.get(c) != null ? map2.get(c) : 0) + 1);
        	}
        	
        	if (map.equals(map2))
        		return true;
        	
        	map2.clear();
    	}
    	return false; 
    }
    
	
	//check if S2 contains Permutation  of S1
    public static boolean checkIncludePermutation(String s1, String s2) {
        s1 = sort(s1);
        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
        	if (s1.equals( sort(s2.substring(i, i + s1.length())))) return true;
        }
    	return false;
    }
    
    private static String sort(String s) {
    	char[] arr = s.toCharArray();
    	Arrays.sort(arr);
    	return new String(arr);
    }
    
	
	public static int getLongestSub(String s) {
		if (s.length() <= 1) return s.length();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int temp = 0;
		int l = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.get(c) == null) {
				map.put(c, i);
				temp ++;
			} else {
				l = l > temp ? l : temp;
				i = map.get(c) ;
				temp = 0;
				map.clear();
			}
		}
		return l > temp ? l : temp;
		
	}
	
    public static void rotate(int[] nums, int k) {
        
        int i = nums.length -  k% nums.length;
        
        int[] r = new int[nums.length];
        
        int t = 0;
        for (int j = i; j < nums.length; j++) {
            r[t ] = nums[j]; t++;
        }
        
        for (int j = 0; j < i ; j++) {
            r[t] = nums[j]; t  ++;
        }
        
        for (int j = 0; j < nums.length ; j++) {
        	nums[j] = r[j];
        }
        
        
    }

}
