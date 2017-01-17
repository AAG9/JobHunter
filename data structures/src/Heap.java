/**
 * Created by chiko on 1/4/2017.
 */
public class Heap {
    public int[] arr;
    public int count;
    public int capacity;

    public Heap(int capacity){
        this.capacity = capacity;
        this.count = 0;
        this.arr = new int[capacity];
    }

    public int parent(int i){
        if(i<=0 || i>=capacity)
            return -1;

        return (i-1)/2;
    }

    public int leftChild(int i){
        int left = 2*i+1;
        if(left >= capacity)
            return -1;
        return left;
    }

    public int rightChild(int i){
        int right = 2*i+2;
        if(right >= capacity)
            return -1;
        return right;
    }

    public void percolateDown(int i){
        int l,r,max, temp;
        l = leftChild(i);
        r = rightChild(i);
        if(l != -1 && arr[l] > arr[i])
            max = l;
        else max = i;

        if(r != -1 && arr[r] > arr[max])
            max = r;

        if(max != i){
            temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
        }

        percolateDown(max);
    }

    public int deleteMax(){
        if(count < 1)
            return -1;
        int data = arr[0];
        arr[0] = arr[count - 1];
        this.count--;
        percolateDown(0);
        return data;
    }


}
