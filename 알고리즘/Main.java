import java.util.Scanner;

public class Main {
    public static void countNum(int k, int[] count) {
        int a = 0, b = 1;

        for (int i = 2; i <= k; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }

        count[0] = a;
        count[1] = b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();

        int[] count = new int[2];
        countNum(c, count);

        System.out.println(count[0] + " " + count[1]);
        scanner.close();
    }
}

// 	    a   b
// 1,	0	1
// 2,	1	2
// 3,	2	3
// 4,	3	5