package util;

import java.time.LocalDate;

/**
 * @author Quang-Khai TRAN
 * @date 21/05/2023
 */

public class StringUtils {

    public static String remove(String s, char c) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch != c) sb.append(ch);
        }
        return sb.toString();
    }

    public static LocalDate  fromString(String s) {
        String[] arr = s.split("-");
        return LocalDate.of(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
    }

    public static int calculateDaysBetweenTwoLocalDate(LocalDate d1, LocalDate d2) {
        return (int) (d2.toEpochDay() - d1.toEpochDay());
    }

    public static boolean isPrimeNumber(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n%2 == 0) return false;
        for (int i = 3; i*i <= n; i+=2) {
            if (n%i == 0) return false;
        }
        return true;
    }

    public static String removeEvenOrder(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 1) sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(remove("abcda", 'a'));

        System.out.println(fromString("2021-02-21"));

        System.out.println(removeEvenOrder("123456789"));
    }

}
