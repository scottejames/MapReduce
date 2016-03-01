package com.scottejames.mapreduce;
import java.util.Comparator;
import java.util.List;



public interface IMapReduce<I,O> {

	public List<O> map(I i);
	public O reduce(List<O> i);
	public Comparator<O> getComparator();
	public boolean match(O m1,O m2);

}
