/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab11;

/**
 *
 * @author Mathew Aziz
 */
public class Question1 {

   public static void main(String[] args) {
        int[][] arr = new int[10][10000];

        // **Run using one thread**
        int numThreads = 1;
        Thread[] threads = new Thread[numThreads];
        threads[0] = new Thread(new ArrayFiller(arr, 0, 10));

        long startTime = System.nanoTime();
        threads[0].start();
        try {
            threads[0].join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        long endTime = System.nanoTime();

        print2DArr(arr);
        System.out.println("Time taken with " + numThreads + " thread(s): " + (endTime - startTime) / 1_000_000_000 + " s");

        // **Run using 10 threads**
        numThreads = 10;
        threads = new Thread[numThreads];
        startTime = System.nanoTime();
        
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new ArrayFiller(arr, i, i + 1));
            threads[i].start();
        }

        // **Wait for all threads to finish**
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        endTime = System.nanoTime();
        print2DArr(arr);
        System.out.println("Time taken with " + numThreads + " thread(s): " + (endTime - startTime) / 1_000_000_000 + " s");
    }

    public static void print2DArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class ArrayFiller implements Runnable {
    private int[][] arr;
    private int startRow, endRow;

    public ArrayFiller(int[][] arr, int startRow, int endRow) {
        this.arr = arr;
        this.startRow = startRow;
        this.endRow = endRow;
    }

    public void fillRows() {
        for (int i = startRow; i < endRow; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (j + 1) * (i + 1);
                try {
                    Thread.sleep(1); // Simulating memory delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    @Override
    public void run() {
        fillRows();
    }
}