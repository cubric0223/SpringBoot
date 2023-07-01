import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            String word = scanner.next();
            int[] alpha = new int[26];
            int group = 1;
            char pre = word.charAt(0);

            alpha[pre - 'a']++;

            for (int j = 1; j < word.length(); j++) {
                if (pre != word.charAt(j) && alpha[word.charAt(j) - 'a'] > 0) {
                    group = 0;
                    break;
                }

                pre = word.charAt(j);
                alpha[pre - 'a']++;
            }

            if (group == 1) {
                cnt++;
            }
        }
        System.out.println(cnt);
        scanner.close();
    }
}
