package com.codegnan.model;

import java.util.Comparator;

public class PopularityComparator implements Comparator<Object>{

	public int compare(Object o1, Object o2) { 
		Book b1=(Book)o1;
		Book b2=(Book)o2;
		return Double.compare(b2.getRating(),b1.getRating()); 
	}

}
