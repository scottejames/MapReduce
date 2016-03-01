package com.scottejames.mapreduce.friendgraph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Utils {

	public static String intersection(String s1, String s2) {

		s1 = s1.replaceAll("\\s","");
		s2 = s2.replaceAll("\\s","");

		Set<Character> ss1 = toSet(s1);
		ss1.retainAll(toSet(s2));
		return ss1.toString();

	}

	private static Set<Character> toSet(String s) {
		Set<Character> ss = new HashSet<Character>(s.length());
		for (char c : s.toCharArray())
			ss.add(Character.valueOf(c));
		return ss;
	}

	public static String sortString(String s) {
		char[] ar = s.toCharArray();
		Arrays.sort(ar);
		String sorted = String.valueOf(ar);
		return sorted;
	}

	public static void main(String[] args)

	{
		String s1 = "A B C D";
		String s2 = "ABE";
		
		System.out.println(s1 + " _U_ " + s2 + " = " + intersection(s1,s2));
		
	}

}
