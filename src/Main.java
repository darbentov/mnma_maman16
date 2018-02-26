/**
 * This class holds the main algorithm.
 *
 * @author Dar Ben-Tov & David Dadon.
 * @version (2018)
 */

public class Main {
    public static S main(int[] arr, int n1, int n2, int n3) {
        // Initializing the DS with the length of the array.
        S s = new S(arr.length);
        // Iterating in the array
        for (int i = 0; i < arr.length; i++){
            int a = arr[i]; // Get current element (By index: i)
            s.insert(a); // Insert the element to the DS.
            if (i + 1 == n1 || i + 1 == n2 || i + 1 == n3){ // If it is one of the check points, print the median
                System.out.print("Median in check point #");
                System.out.print(i + 1);
                System.out.print(": ");
                s.printMedian();
                System.out.println(s.toString());
            }
        }
        // Return s for testing purposes.
        return s;
    }
}
