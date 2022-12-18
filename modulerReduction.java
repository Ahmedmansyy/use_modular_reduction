package use_modular_reduction;

import java.util.Scanner;

public class modulerReduction {
    static Scanner cin = new Scanner(System.in);
    static int value = 0, prime, y = 1;

    public static void prime() {
        boolean flag = false, flag2;
        do {
            System.out.println("Enter the prime num ");
            prime = cin.nextInt();

            for (int i = 2; i <= prime / 2; ++i) {
                // condition for nonprime number
                if (prime % i == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                System.out.println(prime + " is a prime number.");
            else {
                System.out.println(prime + " is not a prime number.");
            }
            flag2 = flag;
            flag = false;
        } while (flag2 == true);

    }

    public static int power(int base, int exponent) {
        int result = 0;

        if (exponent == 0) {
            result = 1;
        } else if (exponent == 1) {
            result = base;
        } else if (exponent > 1) {
            // result = 2147483647;
            result = base * power(base, exponent - 1);
        }
        return result;
    }

    public static int calcmod(int base, int power, int primee) {
        double pow = power / 5; // 103 /5 = 20.6 ...100/5 = 20.00
        int divi = power % 5; // 3 ... 0

        if (divi == 0) {
            for (int i = 0; i < (int) pow; i++) {
                int x = power(base, 5) % primee;
                y = (y * x) % primee;
            }
        } else {
            for (int i = 0; i < (int) pow; i++) {
                int x = power(base, 5) % primee;
                y = (y * x) % primee;
            }
            y = y * power(base, divi) % primee;
        }
        y = y % primee;
        return y;
    }

    public static void main(String[] args) {
        prime();
        // System.out.println(5);
        // calcmod(5, 100);
        // System.out.println(calcmod(5, 100));
        System.out.println(calcmod(10, 51, prime));
    }
}
