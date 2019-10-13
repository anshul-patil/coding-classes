import java.util.Arrays;

/**
*   This program demonstrates the merge sort algorithm by
*   5 sorting an array that is filled with random numbers.
*/
public class SortAndSearchDemo {
    
    public static void main(String[] args) {
        // Create a random array of integers
        int maxVal = 100;
        String[] a = ArrayUtil.randomStringArray(10);
        
        // Sort the array with merge sort
        System.out.println("Original:\n" + Arrays.toString(a));
        MergeSorter.sort(a);
        System.out.println("Sorted:\n" + Arrays.toString(a));
        
        // Search the array with binary search
        int count = a.length;
        String targetVal = "twice";
        int targetIndx = BinarySearcher.search(a, 0, count, targetVal);
        System.out.println("\nSearched for " + targetVal + ", and found at index " + targetIndx);
        
        targetVal = a[(int) (Math.random() * count)];
        targetIndx = BinarySearcher.search(a, 0, count, targetVal);
        System.out.println("Searched for " + targetVal + ", and found at index " + targetIndx);
    }
}