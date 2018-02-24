import java.util.Random;

public class Test {
    public static void main(String args[]) {
        int arr1[] = new int[200];
        int arr2[] = new int[300];
        int arr3[] = new int[400];
        Random rand = new Random();
        for (int i = 0; i < 200; i++){
            arr1[i] = rand.nextInt(1024);
        }
        Main.main(arr1, 200/4, 200/2, 3*200/4);
        for (int i = 0; i < 300; i++){
            arr2[i] = rand.nextInt(1024);
        }
        Main.main(arr2, 300/4, 300/2, 3*300/4);
        for (int i = 0; i < 400; i++){
            arr3[i] = rand.nextInt(1024);
        }
        Main.main(arr3, 400/4, 400/2, 3*400/4);
    }
}
