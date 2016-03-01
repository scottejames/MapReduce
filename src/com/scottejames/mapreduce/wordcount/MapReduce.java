package com.scottejames.mapreduce.wordcount;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.scottejames.mapreduce.IMapReduce;
import com.scottejames.mapreduce.Pair;

public class MapReduce implements
		IMapReduce<Pair<String, String>, Pair<String, Integer>> {

	public List<Pair<String, Integer>> map(Pair<String, String> node) {

		List<Pair<String, Integer>> result = new ArrayList<Pair<String, Integer>>();

		for (String s : node.getValue().split(" ")) {
			result.add(new Pair<String, Integer>(s, 1));
		}
		return result;
	}

	public Pair<String, Integer> reduce(List<Pair<String, Integer>> interimData) {

		int accum = 0;
		String name = interimData.get(0).getKey();
		for (Pair<String, Integer> p : interimData) {

			accum += p.getValue();

		}
		return new Pair<String, Integer>(name, accum);
	}

	public Comparator<Pair<String, Integer>> getComparator() {
		return new PairComparator();
	}

	// Explain how to sort my list...
	public static class PairComparator implements
			Comparator<Pair<String, Integer>> {
		@Override
		public int compare(Pair<String, Integer> p1, Pair<String, Integer> p2) {
			return p1.getKey().compareTo(p2.getKey());
		}
	}

	@Override
	public boolean match(Pair<String, Integer> m1, Pair<String, Integer> m2) {
		return m1.getKey().equals(m2.getKey());
	}

}
