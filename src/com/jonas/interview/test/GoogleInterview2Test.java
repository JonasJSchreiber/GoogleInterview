package com.jonas.interview.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.jonas.interview.GoogleInterview2;
import com.jonas.interview.GoogleInterview2.Point;

public class GoogleInterview2Test {
	
	@Test
	public void testInterview2() {
		int[][] continent = {{0,  3,  4,  4, -1, -2},
							 {0, -1,  2,  1,  0,  2},
							 {0, -1,  3, -1, -1,  2},
							 {0, -1, -1, -1, -2,  2}};
		Point highestAlongPath = GoogleInterview2.findHighestPoint(continent);
		Point expected = new Point();
		expected.x = 0;
		expected.y = 2;
		//Seems I looked at this with axes reversed.
		assertEquals(expected.x, highestAlongPath.y);
		assertEquals(expected.y, highestAlongPath.x);

	}
}
