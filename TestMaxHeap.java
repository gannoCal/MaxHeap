/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxheap;

/**
 *
 * @author calebgannon
 */
public class TestMaxHeap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer[] arr1 = {34,23,65,84,24,85,90,78,348,24,75,24,86,36,87,12,47,98};
        Integer[] arr2 = {65,84,25,74,96,13,67,876,45,890,53,63,653,745,244,75,1,35,6,4};
        Integer[] arr3 = {1,2,3,4,6,8,11,13,35,17,24,29,36,38,45,49,59,63};
        
        MaxHeap heap1=new MaxHeap(arr1);
        MaxHeap heap2=new MaxHeap(arr2);
        MaxHeap heap3=new MaxHeap(arr3);
        
        
        System.out.println(""+heap1.toString());
        
        Integer[] arr4 = {34,23,65,84,24,85,90,78,348,24,75,24,86,36,87,12,47,98,57,12,1234122,21412,1353,24624,347,347,24783,468};
        Integer[] arr5=heap1.bubbleSort(arr4);
        heap1.heapSort(arr4);
        System.out.println("");
        System.out.println("HeapSort:");
        for(int i=0;i<arr4.length;i++){
            System.out.print(", "+arr4[i]);
        }
        System.out.println("");
        System.out.println("BubbleSort:");
        for(int i=0;i<arr4.length;i++){
            System.out.print(", "+arr5[i]);
        }
        System.out.println("");
        System.out.println("");
        
        
        
        System.out.println("Insert:");
        System.out.println(""+heap2.toString());
        System.out.println("Insert 360->");
        heap2.insert(360);
        System.out.println(""+heap2.toString());
        System.out.println("");
        System.out.println("");
        System.out.println("RemoveMax");
        System.out.println("Removed-> "+heap2.removeMax());
        System.out.println(""+heap2.toString());
        
        System.out.println("");
        System.out.println("");
        
        
        heap2.print();
        
        
        Integer[] arrFull={1,2,3,4,5};
        MaxHeap testFull=new MaxHeap(arrFull);
        System.out.println("Heap Size="+testFull.getHeapSize());
        testFull.insert(45);
        testFull.insert(435);
        testFull.insert(46);
        testFull.insert(23);
        testFull.insert(415);
        System.out.println("Heap Size="+testFull.getHeapSize());
    }
    
    
    
}
