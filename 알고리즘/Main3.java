import java.util.Scanner;

public class Main3 {
    private static String changeArray(int[] arr) {
        int i = arr.length - 2;

        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i == -1) {
            return "-1";
        }

        int j = arr.length - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }

        swap(arr, i++, j);

        j = arr.length - 1;
        while (i < j) {
            swap(arr, i++, j--);
        }

        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(' ');
        }

        return sb.toString().trim();
    }

    //i번째 j번째 자리 바꾸기
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        //배열에 n번 만큼 받은 숫자를 삽입
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(changeArray(arr));
        scanner.close();
    }
}
