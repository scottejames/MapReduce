package com.scottejames.mapreduce.friendgraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.scottejames.mapreduce.IMapReduce;
import com.scottejames.mapreduce.Pair;

public class MapReduce implements
		IMapReduce<Pair<String, String>, Pair<String, String>> {

	@Override
	public List<Pair<String, String>> map(Pair<String, String> node) {
		List<Pair<String, String>> result = new ArrayList<Pair<String, String>>();

		for (String s : node.getValue().split(" ")) {
			result.add(new Pair<String, String>(Utils.sortString(node.getKey()
					+ s), node.getValue()));
		}
		return result;
	}

	@Override
	public Pair<String, String> reduce(List<Pair<String, String>> i) {
		
		
		Pair<String, String> result = new Pair<String, String>();
		result.setKey(i.get(0).getKey());
		String accum =null;

		for (Pair<String, String> node : i) {
			System.out.println(" Reducing: " + accum + " & " + node.getValue() );
			accum = Utils.intersection(accum, node.getValue());
		}
		result.setValue(accum);
		System.out.println(" Reduced too: " + accum );

		return result;

	}

	@Override
	public Comparator<Pair<String, String>> getComparator() {
		return new PairComparator();
	}

	public static class PairComparator implements
			Comparator<Pair<String, String>> {
		@Override
		public int compare(Pair<String, String> p1, Pair<String, String> p2) {
			return p1.getKey().compareTo(p2.getKey());
		}
	}

	@Override
	public boolean match(Pair<String, String> m1, Pair<String, String> m2) {
		return m1.getKey().equals(m2.getKey());

	}

}
