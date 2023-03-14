import java.util.Scanner;

public class test {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = 5;
        int[] arr = new int[n];
        System.out.print("Nhap mang: \n");
        for (int i = 0; i < n; i++) {
            System.out.printf("a[%d] = ", i);
            arr[i] = scanner.nextInt();
        }
        sortASC(arr);
        int min = 0, max = 0, tong = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            min = min + arr[i];
        }
        for (int i = 0; i < arr.length - 1; i++) {
            max = max + arr[i + 1];
        }

        for (int i = 0; i < arr.length; i++) {
            tong = tong + arr[i];
        }
        System.out.println("Tong 4 so nho nhat la:" + min);
        System.out.println("\nTong 4 so nho lon la:" + max);
        System.out.println("\nTong cua mang la:" + tong);
        System.out.print("\ncac phan tu chan: ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.print("\n Cac phan tu le: ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static void sortASC(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}