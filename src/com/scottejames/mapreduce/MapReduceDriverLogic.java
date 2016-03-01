package com.scottejames.mapreduce;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MapReduceDriverLogic<I, O> {

	IMapReduce<I, O> mr = null;

	public void setMR(IMapReduce<I, O> mr) {
		this.mr = mr;
	}

	public List<O> process(List<I> input) {

		// Map the input list to produce a set of interim Results

		List<O> interimData = new ArrayList<O>();
		for (I node : input) {
			List<O> interimResult = mr.map(node);

			if (interimResult != null)
				interimData.addAll(interimResult);
		}
		
		
		// Sort the interim results using the comparator defined in the MR class
		Collections.sort(interimData, mr.getComparator());

		// Loop over the interimResults and call reduce for all 'similar' nodes
		// Capture the results in a final list
		O accum = null;
		List<O> subList = new ArrayList<O>();
		List<O> results = new ArrayList<O>();
		for (O node : interimData) {

			if (accum == null)
				accum = node;
			else {
				if (mr.match(accum, node))
					subList.add(node);
				else {
					results.add(mr.reduce(subList));
					subList = new ArrayList<O>();
					accum = node;
					subList.add(node);

				}

			}

		}
		return results;

	}
}
