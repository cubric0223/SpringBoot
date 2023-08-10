import java.util.Scanner;

public class Main2 {
    public static int way(int n) {
        int[] arr = new int[12];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for (int i = 4; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }

        return arr[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();

        while (cnt-- > 0) {
            int n = scanner.nextInt();

            int a = way(n);
            System.out.println(a);
        }
        scanner.close();
    }
}

// 1, 1
// 2, (1+1, 2) 2
// 3, (2+1, 1+2, 1+1+1, 3) 4
// 4, (1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 1+3, 3+1) 7
// 5, (1+1+1+1+1, 1+1+1+2, 1+2+1+1, 2+1+1+1, 1+1+2+1, 3+1+1, 1+3+1, 1+1+3, 3+2, 2+3, 2+2+1, 1+2+2, 2+1+2) 13