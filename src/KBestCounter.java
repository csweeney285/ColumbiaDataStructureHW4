/*Conor Sweeney
 * cjs2201
 * KBestCounter.java
*/

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


public class KBestCounter<T extends Comparable<? super T>> {

	//declare variables
	//heap is a PriorityQueue
	 PriorityQueue<T> heap;
     int k;
    
     //create KBestCounter
     public KBestCounter(int k) {
    	 this.k = k;
    	 this.heap = new PriorityQueue<T>(k);
     }
    
    
     public void count(T x) {
    	 
             // For each new element, check to see if the heap has less than k values
             // If so, add the element
             if (heap.size() < k) {
                     heap.add(x);
             }
             
             // If not check to see if the min element in the heap is smaller than the new element
             // If it is remove the min element and insert the new element
             else {
                     if (x.compareTo(heap.peek()) > 0) {
                             heap.poll();
                             heap.add(x);
                     }
             }
     }
    
     public List<T> kbest() {
             LinkedList<T> kBestList = new LinkedList<T>();
             Iterator<T> iterator = heap.iterator();
             for (int i = 0; i < heap.size(); i++) {
                     kBestList.add(iterator.next());
             }
             Collections.sort(kBestList, Collections.reverseOrder());
             return kBestList;
     }
}
