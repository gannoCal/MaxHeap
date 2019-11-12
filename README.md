# MaxHeap
Impliments a Maxheap class in Java

Does so by using a makeHeap() function. This function correctly places an integer into 
the tree by first insering at the bottom, and letting it "float" upwards to the top.
It runs in nlog(n) time.

The heapSort() function creates a maxheap, then pulls off the top element into an array, sorting the elements.
This also runs in nlog(n) time.

The TestMaxHeap class is a main function to run tests on the MaxHeap class.
