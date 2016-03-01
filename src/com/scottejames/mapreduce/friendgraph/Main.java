package com.scottejames.mapreduce.friendgraph;

import java.util.List;

import com.scottejames.mapreduce.MapReduceDriverLogic;
import com.scottejames.mapreduce.Pair;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Pair<String, String>> testData = TestData.getData();
		
		MapReduceDriverLogic<Pair<String,String>,Pair<String,String>> mrdl = 
				new MapReduceDriverLogic<Pair<String,String>,Pair<String,String>>();
		mrdl.setMR(new MapReduce());
		
		
		List<Pair<String, String>> result= mrdl.process(testData);
		
		TestData.printResults(result);
	}

}
