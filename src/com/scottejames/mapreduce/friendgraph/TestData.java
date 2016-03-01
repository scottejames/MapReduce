package com.scottejames.mapreduce.friendgraph;

import java.util.LinkedList;
import java.util.List;

import com.scottejames.mapreduce.Pair;

public class TestData {
	public static List<Pair<String, String>> getData() {
		List<Pair<String, String>> results = new LinkedList<Pair<String, String>>();
		results.add(new Pair<String, String>("A","B C D"));
		results.add(new Pair<String, String>("B","A C D E"));
		results.add(new Pair<String, String>("C","A B D E"));
		results.add(new Pair<String, String>("D","A B C E "));
		results.add(new Pair<String, String>("E","B C D"));
	

		return results;
	}

	public static void printResults(List<Pair<String, String>> results) {
		if ((results == null) || (results.size() == 0))
			System.out.println("NULL results");
		else
			for (Pair<String, String> p : results) {
				System.out.println(p.getKey() + " -> " + p.getValue());
			}

	}

}
