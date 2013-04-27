package com.mycompany.rankj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.mycompany.rankj.comparator.ScoreComparatorDesc;

import junit.framework.TestCase;

public class ScoreComparatorTest extends TestCase {
	
	
	private Journal j1;
	private Journal j2;
	private Journal j3;
	
	
	protected void setUp() {
		
		j1 = new Journal("Journal A", 5.6);
		j2 = new Journal("Journal B", 2.1);
		j3 = new Journal("Journal C", 3.1);
		
	}
	
	
	public void testCompareGT() {		
		/*
		 * it checks whether two journals are different:
		 * the score of journal A is greater than the score of journal B
		 */
		Comparator<Journal>  sc = new ScoreComparatorDesc();	
		assertEquals(1, sc.compare(j2, j1));	 
		
	}
	
	public void testCompareEQ() {		
		
		/*
		 * if checks whether two journals have the sampe score
		 */
		 
		Comparator<Journal>  sc = new ScoreComparatorDesc();	
		assertEquals(0, sc.compare(j1, j1 ));	 
		
	}
	
	public void testListByScore() {		
		
		/*
		 *  Check in a sorted list that the journal with the highest score is on top.
		 */
		 
		ArrayList<Journal> listOfJournals = new ArrayList<Journal>();
		
		listOfJournals.add(j1);
		listOfJournals.add(j2);
		listOfJournals.add(j3);
		
		Collections.sort(listOfJournals, ScoreComparatorDesc.scoreComparator());
		
		System.out.println(listOfJournals);
		
		assertEquals(0, listOfJournals.indexOf(j1));
		
	}
	
public void testSameScoreOrder() {		
		
		/*
		 *  Check in a sorted list that two journals with the same score
		 *  are sorted by the name ascending
		 */
		 
		ArrayList<Journal> listOfJournals = new ArrayList<Journal>();
		
		listOfJournals.add(new Journal("A", 1.0));
		listOfJournals.add(new Journal("B", 1.0));
		
		
		Collections.sort(listOfJournals, ScoreComparatorDesc.scoreComparator());
		
		assertEquals("A", listOfJournals.get(0).getName());
		assertEquals("B", listOfJournals.get(1).getName());
		
	}

}
