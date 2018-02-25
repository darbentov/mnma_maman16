public class Main {
    public static void main(int[] arr, int n1, int n2, int n3) {
        S s = new S(arr.length);
        for (int i = 0; i < arr.length; i++){
            int a = arr[i];
            s.insert(a);
            if (i == n1 || i == n2 || i == n3){
                s.printMedian();
            }
        }
        System.out.println(s.toString());

    }
}
