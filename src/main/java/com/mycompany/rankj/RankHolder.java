package com.mycompany.rankj;


import java.util.TreeSet;

import com.mycompany.rankj.comparator.ScoreComparatorDesc;

public class RankHolder {

	private TreeSet<Journal> map;
	
	
	public RankHolder() {
		map = new TreeSet<Journal>(ScoreComparatorDesc.scoreComparator());
	}
	
	public void put(Journal j) {
		
		map.add(j);
	}
	
	
	public Integer getRank(Journal j) {
		
		Integer rank = map.headSet(j).size();	
		return rank==null?0:map.size() - rank;
	}
	
	
	public void printAll() {
		
		for (Journal entry : map) {
			System.out.print(this.getRank(entry));
			System.out.println(" - " + entry);		
		}
	}

}
