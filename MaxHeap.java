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
public class MaxHeap {
    private Integer[] heap;
    private int heapSize;
    private int loadCnt;
    
    public MaxHeap(int size){
        this.heap=new Integer[size];
        this.heapSize=this.heap.length;
        this.loadCnt=0;
    }
    
    public MaxHeap(Integer[] array){
        
        
        int size=0;
        int k=0;
        while(true){
            size=(int)Math.pow(2, k)-1;                 //Finds heap size that Represents a full tree (power of two minus one)              
            if(size>array.length){
                break;
            }
            k++;
        }
        
        
        
        
        
        
        this.heap=new Integer[size];         //updates object variables.
        this.heapSize=size;
        
        for(int i=0;i<array.length;i++){
            
            insert(array[i]);                   //inserts each array element into Heap
        }
        
        
        
        
        this.loadCnt=array.length;              //updates object variable.
        
    }
    
    private int parent(int i){return (i-1)/2;}
    
    private int left(int i){return 2*i+1;}          //Three functions to perform tree movement
    
    private int right(int i){return 2*i+2;}
    
    public int removeMax() {
        if(heap[0]==null){throw new IllegalArgumentException("Remove from empty list");}            //O=logn
        int a=heap[0];
        heap[0]=heap[this.loadCnt--];       //replaces root with last leaf, then checks to
        makeHeap(0);                        //maintain proper MaxTree order
        
        return a;
    }
    
    
    
    
    public Integer[] bubbleSort(Integer[] input) {

    int temp=0;                                 //O=[n^2]
    for (int i=0;i<input.length;i++) {              //iterates through "list length-i", "list length" times
        for (int j=1;j<input.length-i;j++) {      

            if (input[j-1]>input[j]) {          //if previous value greater than current, swap
                temp=input[j-1]; 
                
                input[j-1]=input[j];
                input[j]=temp;
                
            }
            }
    }
    return input;
    
}
    
    private void makeHeap(int i){
        if (isLeaf(i)) return;                  //O= n logn
        
        if(heap[i]==null||heap[left(i)]==null||heap[right(i)]==null){       //Checks specific null cases
           if(heap[right(i)]!=null&&(heap[left(i)]==null||heap[left(i)]<heap[right(i)])) {      //treat null as always less than
                swap(i, right(i));  
                makeHeap(right(i));
            }
            else {swap(i, left(i));makeHeap(left(i));} 
        }
        
        else if(heap[i]<heap[left(i)]||heap[i]<heap[right(i)]){
            if(heap[left(i)]<heap[right(i)]) {                       //if not null, check parents are always greater than children
                swap(i, right(i));                                      //if they arent, swap
                makeHeap(right(i));
            }
            else {swap(i, left(i));makeHeap(left(i));}
            
            
        }
        
    }
    
    public void insert(int n){
        if(heap.length==0){throw new IllegalArgumentException("Empty Heap");}
                                                                                    //O= logn
        
        
        
        else{
            int i=++this.loadCnt-1;
            if(i==this.heapSize){
                
                Integer[] storage=new Integer[2*this.heapSize];
                for(int j=0;j<this.heapSize;j++){
                    storage[j]=heap[j];
                }                                               //if array size is exceeded, double its size and copy elements
                this.heap=storage;
                this.heapSize*=2;                               
            }
            heap[i]=n;
            
            
            while(heap[parent(i)]==null||heap[i]>heap[parent(i)]){
                swap(i,parent(i));
                i=parent(i);                                    //element has been inserted at end of array
            }                                                   //Run through entire tree, floating the value upwards 
                                                                //until it reaches a parent greater in value
            
            
    }
    }
        private boolean isLeaf(int i){
            if((2*i+1<heap.length-1)&&(2*i+2<heap.length-1))
            return (heap[left(i)]==null&&heap[right(i)]==null);         //O=1           
            else return true;                                           //wrote to check if node is leaf
            
        }
        
        private void swap(int init, int fin){
            if(heap[init]!=null&&heap[fin]!=null){                  //O=1
            int a=heap[init];
            heap[init]=heap[fin];
            heap[fin]=a;                                            //wrote to simplify the swap process
            }                                                       //lots of null case conditionals
            else if(heap[init]==null){heap[init]=heap[fin];heap[fin]=null;}
            else{heap[fin]=heap[init];heap[init]=null;
        }
        }
        
    
        public String toString(){
            String str=new String();
            for(int i=0; i<this.loadCnt;i++){            //O=n
                str=str.concat(heap[i]+", ");            //Concats elements in level order
                
            }
            return str;
        }
        
        public void print(){                                        //O=n
            for(int i=0;i<heap.length;i++){
                if((2*i+1<heap.length-1)&&(2*i+2<heap.length-1)){   //wrote myself to check Parent child relationships
                    if(!(isLeaf(i))){
                    
                    System.out.println("Parent-> "+heap[i]+"; left-> "+heap[2*i+1]+"; right-> "+heap[2*i+2]);
                    }
                
            }
        }
            
}
        
        
        public static void heapSort(Integer[] sortArr){
            MaxHeap storage=new MaxHeap(sortArr);
                                                            //O= n logn
            
            
            for(int i=sortArr.length-1;i>=0;i--){           //generates maxHeap using sortArr, then performs removeMax n times
                sortArr[i]=storage.removeMax();             //and copies the values from least to greatest back into sortArr
            }
        }

    public Integer[] getHeap() {
        return heap;
    }

    public int getHeapSize() {
        return heapSize;                    //Gettors
    }

    public int getLoadCnt() {
        return loadCnt;
    }
}
        
        
        
    
    
    
