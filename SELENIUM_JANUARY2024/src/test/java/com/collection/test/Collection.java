package com.collection.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

public class Collection {

	@Test
	public void arrayList() {

		//NonGeneric ArayList type
		ArrayList<String> obj1 = new ArrayList<>();
		obj1.add("Test1");
		obj1.add("Mrinal");
		obj1.add("Moon");
		obj1.add("Stars");

		int i = 0;
		for (String abc: obj1)
// IF was using a non generic array we would do then
//for (Object abc: obj1)


{
			//System.out.println("Array Number at position " +i+ " is: " +obj1.get(i));


			System.out.println("Array Number at position " +i+ " is: " +abc);
			i++;
		}


		Set<String> setNumbers = new HashSet<>();
		setNumbers.addAll(obj1);
		System.out.println("Set:: " +setNumbers);


	}



	@Test
	public void hashSet() {


		Set<String> nms = new HashSet<>();
		nms.add("Mrinal");
		nms.add("Walter");
		nms.add("Star");
		nms.add("Mike");
		nms.add("Jessie");
		nms.add("Skylar");
		nms.remove("Mike");

		System.out.println(nms);


		for (String name: nms) {
		System.out.println("Each Name in list: " +name);
		}


	}

}
