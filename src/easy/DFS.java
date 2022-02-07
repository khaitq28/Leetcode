package easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import easy.DFS.Node;

public class DFS {
	
	public static class Node {
		public int x;
		public int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}

	public static void main(String[] args) {
		
		int[][] xx =   {{1,0,0,1,0,0,1,0,0,0,1,0,0,1,1,0,0,1,0,1,0,0,1,1,0,1,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,1,0,0,1,1},
						{0,1,1,0,1,0,1,1,1,1,0,1,1,1,0,0,0,0,0,0,1,0,1,1,1,0,0,1,1,0,0,0,0,1,1,0,1,0,1,1,0,0,1,0,0,0,0,1,1,0},
						{1,0,0,1,0,1,1,1,0,0,1,1,1,0,0,1,1,0,1,0,1,1,1,0,0,1,0,1,0,1,0,0,1,1,1,0,0,1,1,1,0,1,1,0,1,0,1,1,1,0},
						{1,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1,1,0,1,0,0,1,1,1,0,1,0,1,1,1,0,1,0,0,1,1,1,1,1,0,1,0,1,0,0,1,1,1,0,1}};
		
		System.out.println(maxAreaOfIsland(xx));
	}

    public static int maxAreaOfIsland(int[][] grid) {
    	
        boolean [][] check = new boolean[grid.length][grid[0].length];
		Map<Node, Boolean> map = new HashMap<>();
		Stack<Node> list = new Stack<Node>();
        int ret = 0;
        
		list.add(new Node(0,0));
		
		
		boolean [][] land = new boolean[grid.length][grid[0].length];
		
		check[0][0] = true;
        int c = 1;
        Node a = null;
		while(list.size() > 0) {
        	
			a = list.pop();
	        int x = a.x; 
	        int y = a.y;
	        
        	if (grid[x][y] == 0) {
        		
        		if (y < grid[0].length - 1 &&  check[x][y + 1] == false) {
        			list.push(new Node(x, y  + 1));
        			c++;
        			check[x][y + 1] = true;
        		}
        		if (x < grid.length - 1  && check[x +1][y] == false) {
        			list.push(new Node(x + 1, y));
        			c++;
        			check[x +1][y] = true; 
        		}

        	} else if (land[x][y] == false) {
				int t = getLand(grid, x, y, land);

				System.out.println(x + " _  " + y);
				System.out.println("t= " + t);
				System.out.println("============ ");
				
        		ret = ret > t ? ret: t;
			}
        	
        	if (c < grid.length * grid[0].length) {
        		if (y < grid[0].length - 1 &&  check[x][y + 1] == false) {
        			list.push(new Node(x, y  + 1));
        			c++;
        			check[x][y + 1] = true;
        		}
        		if (x < grid.length - 1  && check[x +1][y] == false) {
        			list.push(new Node(x + 1, y)); c++;
        			check[x +1][y] = true; 
        		}
    			if (y >0 && check[x][y - 1] == false) {
        			list.push(new Node(x, y  - 1));
        			check[x][y - 1] = true; c++;
        		}
    			if (x >0 && check[x - 1][y] == false) {
        			list.push(new Node(x - 1, y));
        			check[x - 1][y] = true; c++;
        		}
        	}
        	
        }
        
    	return ret;
    }
    
	private static int getLand(int[][] grid, int x, int y, boolean [][] map) {
		
		int t = 1;
		Stack<Node> list = new Stack<Node>();
		list.add(new Node(x,y));
		boolean [][] check = new boolean[grid.length][grid[0].length];
        check[x][y] = true;
		while (list.size() > 0) {
			
			Node  a = list.pop();
			 x = a.x; 
			 y = a.y;
			 
			if (y < grid[0].length - 1 && grid[x][y + 1] == 1 && check[x][y + 1] == false) {
    			list.push(new Node(x, y  + 1));
    			check[x][y + 1] = true;
    			t ++;
    			map[x][y + 1] = true;
    		}
    		if (x < grid.length  - 1 && grid[x + 1][y] == 1 && check[x +1][y] == false) {
    			list.push(new Node(x + 1, y));
    			check[x + 1][y] = true;
    			t ++;
    			map[x +1][y] = true;
    		}
			if (y >0 && grid[x][y - 1] == 1 && check[x][y - 1] == false) {
    			list.push(new Node(x, y - 1));
    			check[x][y - 1] = true;
    			t ++;
    			map[x][y - 1] = true;

    		}
			if (x >0 && grid[x -1][y] == 1 && check[x - 1][y] == false) {
    			list.push(new Node(x - 1, y));
    			check[x - 1][y] = true;
    			t ++;
    			map[x -1][y] = true;
    		}
		}
		return t;
	}
    
}
