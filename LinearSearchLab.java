    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linearsearchlab;

/**
 *
 * @author ACER
 */
import java.util.Random;
import java.util.Scanner;

    /**
     * @param args the command line arguments
     */
    
    public class LinearSearchLab {
        
        
    public static void populateArray(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10) + 1; 
        }
    }

      public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; 
            }
        }
        return -1; 
    }

   
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        
        if (size <= 0) {
            System.err.println("Array size must be a positive integer.");
            scanner.close(); 
            return; 
        }

        try {
            int[] largeArray = new int[size];

           
            long startTime = System.nanoTime();
            populateArray(largeArray);
            long endTime = System.nanoTime();
            long populateTime = (endTime - startTime) / 1_000_000;

            System.out.println("Time taken to populate the array: " + populateTime + " milliseconds");

            
            if (size <= 1_000_000_000) { 
                System.out.println("Array contents:");
                printArray(largeArray);
            } else {
                System.out.println("Array size is too large to print all elements.");
            }

            
            int bestCaseTarget = largeArray[0]; 
            int worstCaseTarget = largeArray[size - 1]; 
            int averageCaseTarget = largeArray[(int) (Math.random() * size)]; 

            
            startTime = System.nanoTime();
            int indexBestCase = linearSearch(largeArray, bestCaseTarget);
            endTime = System.nanoTime();
            long bestCaseTime = (endTime - startTime) / 1_000_000; 

            
            startTime = System.nanoTime();
            int indexWorstCase = linearSearch(largeArray, worstCaseTarget);
            endTime = System.nanoTime();
            long worstCaseTime = (endTime - startTime) / 1_000_000; 


            startTime = System.nanoTime();
            int indexAverageCase = linearSearch(largeArray, averageCaseTarget);
            endTime = System.nanoTime();
            long averageCaseTime = (endTime - startTime) / 1_000_000; 

            System.out.println("Best-case scenario (first element) index: " + indexBestCase);
            System.out.println("Time taken for best-case scenario: " + bestCaseTime + " milliseconds");

            System.out.println("Worst-case scenario (last element) index: " + indexWorstCase);
            System.out.println("Time taken for worst-case scenario: " + worstCaseTime + " milliseconds");

            System.out.println("Average-case scenario (random element) index: " + indexAverageCase);
            System.out.println("Time taken for average-case scenario: " + averageCaseTime + " milliseconds");

        } catch (OutOfMemoryError e) {
            System.err.println("Not enough memory to allocate a large array.");
        } 
    }
    
}
