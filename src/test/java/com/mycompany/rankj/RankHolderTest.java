package com.mycompany.rankj;

import junit.framework.TestCase;

public class RankHolderTest extends TestCase {

	private Journal j1;
	private Journal j2;
	private Journal j3;
	
	private RankHolder rh = new RankHolder();
	
	protected void setUp() {
		
		j1 = new Journal("Journal A", 5.6);
		j2 = new Journal("Journal B", 2.1);
		j3 = new Journal("Journal C", 3.1);
		
		
	}
	/*
	 * test three ranking position.
	 */
	public final void testGetRank() {
			
		rh.put(j1);
		rh.put(j2);
		rh.put(j3);
			
		assertTrue(rh.getRank(j2) == 1);
		assertTrue(rh.getRank(j3) == 2);
		assertTrue(rh.getRank(j1) == 3);
		
	}
	
	/*
	 * the list of journals should be empty.
	 * ranking would be 0
	 */
	public final void testVoidList() {
		
		assertTrue(rh.getRank(new Journal("any name", 10.0)) == 0);
		
	}
	
	/*
	 * the list has only one journal
	 */
	public final void testRankOne() {
		
		rh.put(j1);
		assertTrue(rh.getRank(j1) == 1);
		
	}
	
	/*
	 * the list has only one journal
	 */
	public final void testSameRank() {
	
		rh.put(j1);
		rh.put(j2);
		rh.put(j3);
		
		rh.put(new Journal("Journal D", 2.1));
			
		assertTrue(rh.getRank(j1) == 4);
		
		assertTrue(rh.getRank(j2) == 2);
		
	}
	
	
}
