package com.scottejames.mapreduce.wordcount;
import java.util.LinkedList;
import java.util.List;

import com.scottejames.mapreduce.Pair;

public class TestData {

	public static List<Pair<String, String>> getData() {
		List<Pair<String, String>> results = new LinkedList<Pair<String, String>>();
		results.add(new Pair<String, String>("FileOne",
				"This is a string for the first file"));
		results.add(new Pair<String, String>("FileTwo",
				"This is the string list for the second file file file"));

		return results;
	}



	public static void printResults(List<Pair<String, Integer>> results) {
		if ((results == null) || (results.size() == 0))
			System.out.println("NULL results");
		else
			for (Pair<String, Integer> p : results) {
				System.out.println(p.getKey() + " -> " + p.getValue());
			}
			
	}
	
}
