package com.jonas.interview;

public class GoogleInterview2 {
	/*
	 * Second Interview question: (45 minutes)
	 * Given a continent represented by a 2d matrix with values denoting altitude at this point 
	 * Find a path moving west to east where you can continuously ascend then continuously descend 
	 * If such a path exists, return the x,y values of the highest point
	 * 
	 * input:
	 * 3 2 9
	 * 2 2 2
	 * 3 4 3
	 * 
	 * output: 
	 * {3,2} - the altitude is four and the path is 2->3->4->3
	 * 
	 * input 2: (why you need backtracking)
	 * 0  3  4  4 -1 -2
	 * 0 -1  2  1  0  2
	 * 0 -1  3 -1 -1  2
	 * 0 -1 -1 -1 -2  2
	 * 
	 * output: 
	 * {0,2} - the altitude is 4 and the path is 0->3->4->2->1->0->(-1)->(-2) 
	 * 
	 */
	
	public static class Point {
	    public int x;
	    public int y;
	}
	
	public static Point findHighestPoint(int[][] continent) {
	    boolean ascending = true;
		return highestPointHelper(continent, 0, 0, 0, ascending, null);
	}
	
	public static Point highestPointHelper(int[][] continent, int i, int j, int rowToStart, boolean ascending, Point p) {
		
		Point returnPoint = null;
		while (j < continent[0].length-1) {
			int altitude = continent[i][j];
			
			if (testPoint(continent, i, j+1, altitude, ascending)) { //try east
				if (j+1 == continent[0].length-1) { //satisfies condition 
					return p; 
				} else {
					// start new instance, while not losing scope of current one
					returnPoint = highestPointHelper(continent, i, j+1, rowToStart, ascending, p); 
					if (returnPoint != null) {
						return returnPoint;
					}
				}
			} 
			
			if (i + 1 < continent.length && testPoint(continent, i+1, j, altitude, ascending)) { //try south
				returnPoint = highestPointHelper(continent, i+1, j, rowToStart, ascending, p);
				if (returnPoint != null) {
					return returnPoint;
				}
			} 
			
			if (i - 1 >= 0 && testPoint(continent, i-1, j, altitude, ascending)) { //try north
				returnPoint = highestPointHelper(continent, i-1, j, rowToStart, ascending, p);
				if (returnPoint != null) {
					return returnPoint;
				}
			} 
			
			if (returnPoint == null) { //cannot find a satisfactory neighbor
				if (ascending) { // highest point along current route, time to descend. 
					p = new Point();
					p.x = j;
					p.y = i;
					ascending = false;
				} else {
					if (rowToStart+1 < continent.length) {
						rowToStart++;
						i = rowToStart;
						return highestPointHelper(continent, i, 0, rowToStart, true, p);
					} else {
						return null;
					}
				}
			}
			
		}		
		return p;
	}

	public static boolean testPoint(int[][] continent, int i, int j, int altitude, boolean ascending) {
		int difference = continent[i][j] - altitude;
		if (ascending && difference > 0) {
			return true;
		} else if (!ascending && difference < 0) {
			return true;
		} else {
			return false;
		}
	}

}
