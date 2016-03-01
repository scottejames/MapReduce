package com.scottejames.mapreduce.wordcount;
import java.util.List;

import com.scottejames.mapreduce.MapReduceDriverLogic;
import com.scottejames.mapreduce.Pair;

public class Main {

	public static void main(String[] args) {
		
		List<Pair<String, String>> testData = TestData.getData();
		
		MapReduceDriverLogic<Pair<String,String>,Pair<String,Integer>> mrdl = 
				new MapReduceDriverLogic<Pair<String,String>,Pair<String,Integer>>();
		mrdl.setMR(new MapReduce());
		
		
		List<Pair<String, Integer>> result= mrdl.process(testData);
		
		TestData.printResults(result);

	}

}
