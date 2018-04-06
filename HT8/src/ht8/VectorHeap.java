
package ht8;

/**
 * @author Rodrigo Urrutia 16139
 * @version 1.0
 * @since 06.04.2018
 */

import java.util.Vector;
import java.util.PriorityQueue;

public class VectorHeap<E extends Comparable<E>> extends PriorityQueue<E>
{

    /**
     * The data, kept in heap order
     */
    protected Vector<E> data; 

    /**
     * Constructor 
     */
    public VectorHeap()
    {
            data = new Vector<>();
    }

    /**
    * Constructs a new priority queue from an unordered vector
    * @param v
    */
    public VectorHeap(Vector<E> v)
    {
            int i;
            data = new Vector<>(v.size()); // we know ultimate size
            for (i = 0; i < v.size(); i++)
            { // add elements to heap
                    add(v.get(i));
            }
    }

    /**
     * Padre
     * @param i
     * @return returns parent of node at location i
     */
    protected static int parent(int i)
    {
            return (i-1)/2;
    }

    /**
     * Access left method
     * @param i
     * @return returns index of left child of node at location i
     */
    protected static int left(int i)
    // pre: 0 <= i < size
    // post: 
    {
            return 2*i+1;
    }

    /**
     * Access right method
     * @param i
     * @return returns index of right child of node at location i
     */
    protected static int right(int i)
    // pre: 0 <= i < size
    // post: 
    {
            return (2*i+1) + 1;
    }

    /**
     * Moves node at index leaf up to appropriate position
     * @param leaf 
     */
    protected void percolateUp(int leaf)
    {
            int parent = parent(leaf);
            E value = data.get(leaf);
            while (leaf > 0 &&
            (value.compareTo(data.get(parent)) < 0))
            {
                    data.set(leaf,data.get(parent));
                    leaf = parent;
                    parent = parent(leaf);
            }
            data.set(leaf,value);
    }

    /**
     * Agrega objetos al VectorHeap
     * @param e
     * @return 
     */
    @Override
    public boolean add(E e) {
        return offer(e);
    }

    /**
     * Moves node at index root down to appropriate position in subtree
     * @param root 
     */
    protected void pushDownRoot(int root)
    {
            int heapSize = data.size();
            E value = data.get(root);
            while (root < heapSize) {
                    int childpos = left(root);
                    if (childpos < heapSize)
                    {
                            if ((right(root) < heapSize) &&
                            ((data.get(childpos+1)).compareTo
                            (data.get(childpos)) < 0))
                            {
                                    childpos++;
                            }
                    // Assert: childpos indexes smaller of two children
                    if ((data.get(childpos)).compareTo
                            (value) < 0)
                    {
                            data.set(root,data.get(childpos));
                            root = childpos; // keep moving down
                    } else { // found right location
                            data.set(root,value);
                            return;
                    }
                    } else { // at a leaf! insert and halt
                            data.set(root,value);
                            return;
                    }
            }
    }

    /**
     * Elimina el valor de prioridad en el VectorHeap
     * @return 
     */
    @Override
    public E remove()
    {
            E minVal = poll();
            return minVal;
    }
        
}