package com.mycompany.rankj;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mycompany.rankj.comparator.ScoreComparatorDesc;

/*
 * This is class is responsible to collect a set of journal and rank them
 * based on their score.
 */
public class RankHolder {

	private List<Journal> journals;
	
	// it's used as a flag. The list is sorted only when it's true
	private Boolean rankUpdated = false;
	
	
	public RankHolder() {
		journals = new ArrayList<Journal>();
		
	}
	
	/*
	 * Add a new journal in the list.
	 */
	public void put(Journal j) {
		rankUpdated = true;
		journals.add(j);
	}
	
	/*
	 * It ranks all the journals in the list
	 */
	private void rank() {
		
		this.rankUpdated = false;
		Collections.sort(this.journals, new ScoreComparatorDesc());
		
		Integer _rank = 0;
		Journal jPrev = null;
		
		for (Journal j : this.journals ) {
			if(! j.isReview())
				if(jPrev != null && jPrev.equals(j))
					// same rank since the score is equals.
					j.setRank(_rank++);
				else
					j.setRank(++_rank);
			
			jPrev = j;
		}
	}
	
	/*
	 * given a journal it return it's rank in the list.
	 */
	public Integer getRank(Journal j) {
		
		if( rankUpdated )
			rank();
		
		// ranked journal
		if(journals.indexOf(j) >= 0)
			return journals.get(journals.indexOf(j)).getRank();
		
		return 0;
		
	}
	
	/*
	 * It shows on the standard output all the journal ranked.
	 */
	public void printAll() {
		
		if(rankUpdated)
			rank();
		
		for (Journal entry : journals) {
			if(!entry.isReview())
				System.out.println(entry);
		}
	}
}
