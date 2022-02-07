package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongPair {

	public static void main(String[] args) {
			
		int [] songs = new int[]{ 10, 15 ,20 , 25, 5, 30, 40, 50};
		int dur = 20;
		
	//	takeSongs(songs, dur);
		
		System.out.print(0x000F & 0x2222);
	}
	
	private static int[] takeSongs(int[] longs, int duration) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < longs.length; i++) {
			int s1 = longs[i];
			int s2 = duration - s1;
			if (map.containsKey(s2)) {
				list.add(new int[] {i, map.get(s2)});
			}
			map.put(s1, i);
		}
		int[] res = list.get(0); int max = Math.max(res[0], res[1]);
		for (int[] arr: list) {
			if (max < Math.max(arr[0], arr[1])) {
				res = arr;
				max= Math.max(res[0], res[1]);
			}
		}
		
		System.out.print(res[0] + " , " + res[1]);
		return res;
	}

}
