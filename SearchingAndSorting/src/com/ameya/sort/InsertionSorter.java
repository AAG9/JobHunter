package com.ameya.sort;

/**
 * Created by chiko on 1/21/2017.
 */
public class InsertionSorter {
    public static void insertionSort(int A[]){
        int i, j, key;
        for(i=2; i < A.length;i++){
            key = A[i];
            j = i;
            while (j>0 && A[j-1] > key){
                A[j] = A[j-1];
                j--;
            }
            A[j] = key;
        }
    }

    public static void main(String[] args) {
        int A[] = new int[]{5,4,3,2,1,6};
        insertionSort(A);
        for(int i: A){
            System.out.print(i+" ");
        }
    }
}
