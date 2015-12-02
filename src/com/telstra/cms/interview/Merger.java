package com.telstra.cms.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Merger {
	
	/**
	 * Please merge 2 list of numbers into 1, order from smallest to largest value. Please remove duplicates and any invalid entries detected.
	 * You are free to use any approach, except that you are not allowed to use methods or class from JDK which contains "sort" in name.
	 * 
	 * @param list1 
	 * @param list2
	 * @return a merge list. Never return null. 
	 */
	public List<Integer> mergeSort(List<Integer> list1, List<Integer> list2) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		if (null==list1 && null==list2)
			return result;
		if (null==list1 || list1.isEmpty())
			result.addAll(list2);
		else if (null==list2 || list2.isEmpty())
			result.addAll(list1);
		else {
			// Merge list
			for (Integer i : list1) {
				if (null!=i){
					if (!result.contains(i))
						result.add(i);
				}
			}
			for (Integer x : list2){
				if (null!=x){
					if (!result.contains(x))
						result.add(x);
				}
			}
		}

		// Sort list
		int size = result.size();
		for (int y=0; y<size; y++){
			// init | re-init smallest
			int smallest = result.get(y); 
			int smallestIndex = y;
			int sorted = 1;
			for (int z=y+1; z<size; z++){
				// check how many in list are sorted
				if (result.get(z-1) <= result.get(z))
					sorted++;
				// found smallest value
				if (smallest >= result.get(z)){
					smallest = result.get(z);
					smallestIndex = z;
				}
			}

			// System.out.print("loop " + y + ": ");
			// for (int i : result) {
	  		// System.out.print(i + ", ");
	  		// }
	  		// System.out.println("end loop");

			if (sorted == size-y)
				break;

			if (smallestIndex != y) {
				int xchg = result.get(y);
				result.set(y, smallest);
				result.set(smallestIndex, xchg);
			}
		}

		return result;
	}

	public static void main(String[] args){
        
        //Integer[] numbers1 = new Integer[] { 0, 34, 2, 56, 7, 67, 88, 42 };
        //Integer[] numbers2 = new Integer[] { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
        Integer[] numbers1 = new Integer[] { 1, 2, null, 4 };
        Integer[] numbers2 = new Integer[] { 4, 5, 6, 7, 8 };

        List<Integer> list1 = Arrays.asList(numbers1);
        List<Integer> list2 = Arrays.asList(numbers2);

        Merger merger = new Merger();
        List<Integer> result = merger.mergeSort(list1, list2);
        
        for (Integer i : result) {
        	System.out.print(i + ", ");
        }

    }

}