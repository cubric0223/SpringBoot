import java.util.Scanner;

public class Main4 {
    static int N, S, count = 0;
    static int[] numbers;

    public static void Sum(int index, int sum) {
        if (index == N) {
            return;
        }
        if (sum + numbers[index] == S) {
            count++;
        }

        Sum(index + 1, sum);
        Sum(index + 1, sum + numbers[index]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        S = scanner.nextInt();
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        Sum(0, 0);

        System.out.println(count);
        scanner.close();
    }
}
