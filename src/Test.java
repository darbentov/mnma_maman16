import java.util.Arrays;
import java.util.Random;

/**
 * This class is used for testing
 *
 * @author Dar Ben-Tov & David Dadon.
 * @version (2018)
 */

public class Test {
    public static void main(String args[]) {
        int arr1Size = 200;
        int arr2Size = 300;
        int arr3Size = 400;
        int arr1[] = new int[arr1Size];
        int arr2[] = new int[arr2Size];
        int arr3[] = new int[arr3Size];
        Random rand = new Random();

        for (int i = 0; i < arr1Size; i++){
            arr1[i] = rand.nextInt(1024);
        }
        Main.main(arr1, arr1Size /4, arr1Size /2, 3* arr1Size /4);
        for (int i = 0; i < arr2Size; i++){
            arr2[i] = rand.nextInt(1024);
        }
        Main.main(arr2, arr2Size /4, arr2Size /2, 3* arr2Size /4);
        for (int i = 0; i < arr3Size; i++){
            arr3[i] = rand.nextInt(1024);
        }
        Main.main(arr3, arr3Size /4, arr3Size /2, 3* arr3Size /4);
    }
}
