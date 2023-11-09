package com.example.sortingalgorithms;

import java.util.Random;

public class SortingAlgorithms {

    public static long[] GenerateRandomNumbers(int numbers, long limit) {
        Random rand = new Random();
        long[] randomNumbers = new long[numbers];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = rand.nextLong() % limit;
        }
        return randomNumbers;
    }

    public static boolean IsSorted(long[] randomNumbers){
        for (int i = 0; i < randomNumbers.length-1; i++){
            if(randomNumbers[i] > randomNumbers[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void swap(long[] randomNumbers, int i, int j){
        long temp = randomNumbers[i];
        randomNumbers[i] = randomNumbers[j];
        randomNumbers[j] = temp;
    }

    public static void bubbleSort(long[] randomNumbers){
        for(int i = 0; i < randomNumbers.length-1; i++){
            for(int j = 0; j < randomNumbers.length-i-1; j++){
                if(randomNumbers[j] > randomNumbers[j+1]){
                    swap(randomNumbers, j, j+1);
                }
            }
        }
    }


    public static void selectionSort(long[] randomNumbers){
        for(int i = 0; i < randomNumbers.length-1; i++){
            int minIndex = i;
            for(int j = i+1; j < randomNumbers.length; j++){
                if(randomNumbers[j] < randomNumbers[minIndex]){
                    minIndex = j;
                }
            }
            swap(randomNumbers, i, minIndex);
        }
    }
    public static void insertionSort(long[] randomNumbers){
        for(int i = 1; i < randomNumbers.length; i++){
            long key = randomNumbers[i];
            int j = i-1;
            while(j >= 0 && randomNumbers[j] > key){
                randomNumbers[j+1] = randomNumbers[j];
                j--;
            }
            randomNumbers[j+1] = key;
        }
    }
    public static void quickSort(long[] randomNumbers) {
        quickSort(randomNumbers, 0, randomNumbers.length - 1);
    }

    public static void mergeSort(long[] randomNumbers) {
        mergeSort(randomNumbers, 0, randomNumbers.length - 1);
    }
    public static void quickSort(long[] randomNumbers, int low, int high) {
        if (low < high) {
            int pi = partition(randomNumbers, low, high);
            quickSort(randomNumbers, low, pi - 1);
            quickSort(randomNumbers, pi + 1, high);
        }
    }
    public static void mergeSort(long[] randomNumbers, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(randomNumbers, low, mid);
            mergeSort(randomNumbers, mid + 1, high);
            merge(randomNumbers, low, mid, high);
        }
    }
    public static int partition(long[] randomNumbers, int low, int high){
        long pivot = randomNumbers[high];
        int i = low-1;
        for(int j = low; j < high; j++){
            if(randomNumbers[j] < pivot){
                i++;
                swap(randomNumbers, i, j);
            }
        }
        swap(randomNumbers, i+1, high);
        return i+1;
    }
    public static void merge(long[] randomNumbers, int low, int mid, int high){
        int n1 = mid-low+1;
        int n2 = high-mid;
        long[] left = new long[n1];
        long[] right = new long[n2];
        for(int i = 0; i < n1; i++){
            left[i] = randomNumbers[low+i];
        }
        for(int j = 0; j < n2; j++){
            right[j] = randomNumbers[mid+1+j];
        }
        int i = 0;
        int j = 0;
        int k = low;
        while(i < n1 && j < n2){
            if(left[i] <= right[j]){
                randomNumbers[k] = left[i];
                i++;
            }else{
                randomNumbers[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < n1){
            randomNumbers[k] = left[i];
            i++;
            k++;
        }
        while(j < n2){
            randomNumbers[k] = right[j];
            j++;
            k++;
        }
    }
}
