package com.ameya.sort;

/**
 * Created by chiko on 1/21/2017.
 */
public class MergeSorter {
    public static void mergeSort(int[] A, int temp[], int left, int right){
        int mid;
        if(left < right){
            mid = (left + right)/2;
            mergeSort(A,temp, left, mid);
            mergeSort(A, temp, mid+1, right);
            merge(A, temp, left, mid+1, right);
        }
    }

    public static void merge(int[] A, int temp[], int left, int mid, int right){
        int left_end = mid;
        int temp_pos = left;
        int size = right - left + 1;

        while ((left <= left_end) && (mid <= right)){
            if(A[left] < A[mid]){
                temp[temp_pos] = A[left];
                left++;
                temp_pos++;
            }else{
                temp[temp_pos] = A[mid];
                mid++;
                temp_pos++;
            }
        }

        while (left <= left_end){
            temp[temp_pos] = A[left];
            left++;
            temp_pos++;
        }

        while (mid <= right){
            temp[temp_pos] = A[mid];
            mid++;
            temp_pos++;
        }

        for(int i=0; i<size;i++){
            A[right] = temp[right--];
        }
    }

    public static void main(String[] args) {
        int A[] = new int[]{5,4,3,2,1};
        mergeSort(A, new int[A.length+1],0, A.length-1);
        for(int i: A){
            System.out.print(i+" ");
        }
    }
}
