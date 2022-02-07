package easy;

public class UpdateMatrix {

	public static void main(String[] args) {

		
		int[][] mat = 
		 {{1,1,0,0,1,0,0,1,1,0},
		 {1,0,0,1,0,1,1,1,1,1},
		 {1,1,1,0,0,1,1,1,1,0},
		 {0,1,1,1,0,1,1,1,1,1},
		 {0,0,1,1,1,1,1,1,1,0},
		 {1,1,1,1,1,1,0,1,1,1},
		 {0,1,1,1,1,1,1,0,0,1},
		 {1,1,1,1,1,0,0,1,1,1},
		 {0,1,0,1,1,0,1,1,1,1},
		 {1,1,1,0,1,0,1,1,1,1}};

				
		int[][] ret = updateMatrix(mat);
		
    	for ( int i = 0; i < ret.length; i++) {
        	for ( int j = 0; j < ret[0].length; j++) {
        		System.out.print(ret[i][j] + "  ");
        	}
    		System.out.println();
    	}
    	
	}
	
	
    public static int[][] updateMatrix(int[][] mat) {
        
        int x = mat.length;
    	int y = mat[0].length;
    	int[][] ret = new int[x][y];
        
    	
    	for ( int i = 0; i < x; i++) {
        	for ( int j = 0; j < y; j++) {
        		if (mat[i][j] == 0) {
        			ret[i][j] = 0;
        			continue;
        		} else {
        			ret[i][j] = distance(mat, i , j, x, y);
        		}
        	}
    		
    	}
    	
    	return ret;
        
    }


    
    private static int distance(int[][] mat, int i, int j, int x, int y) {
		boolean f  = false;
		int k = 1;
		int d = 1;
		int l = Math.min(i, j);
		while (!f || k <  l) {
			for (int m = i -k; m <= (i +k); m ++) {
				for (int n = j -k; n <= (j +k); n ++) {
					if (m >= 0 && m < x && n >= 0 & n < y && mat[m][n] == 0) {
						d = f ? Math.min(d, Math.abs(i-m) + Math.abs(j-n)) : Math.abs(i-m) + Math.abs(j-n);
						f =true;
					}
				}
			}
			k++;
		}
		
		return d;
	}

}
