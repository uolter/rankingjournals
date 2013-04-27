package com.mycompany.rankj.comparator;

import java.util.Comparator;
import com.mycompany.rankj.Journal;

/*
 * This comparator is useful to sort journals by their score in a List 
 */
public class ScoreComparatorDesc implements Comparator<Journal> {

	@Override
	public int compare(Journal o1, Journal o2) {
		
		int ret = o2.getScore().compareTo(o1.getScore());
		
		if(ret == 0) {
			// journals have the same score => compare theis names
			
			return o1.getName().compareTo(o2.getName());
		}
		
		return ret;
		 
	}
	
	public static Comparator<Journal> scoreComparator() {
		return new ScoreComparatorDesc();
	}

}
