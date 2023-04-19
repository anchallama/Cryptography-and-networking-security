/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;

public class Main {
    public static int findgcd(int a, int b) {
        int r1, r2, r;
        r1 = a;
        r2 = b;
        while(r2 > 0) {
            r = r1 % r2;
            r1 = r2;
            r2 = r;
        }
        return r1;
    }

    public static int ext_euclid(int m, int b) {
        int q;
        int a1 = 1, a2 = 0, a3 = m;
        int b1 = 0, b2 = 1, b3 = b;
        int t1 = 0, t2 = 0, t3 = 0;
        while(true) {
            if(b3 == 0) {
                return 0; // no inverse exist
            }
            if(b3 == 1) {
                while(b2 < 0) {
                    b2 = b2 + m; // add modulus if multiplicative inverse is negative
                }
                return b2; // b2 is multiplicative inverse of b mod m
            }
            q = a3 / b3;
            t1 = a1 - (q * b1);
            t2 = a2 - (q * b2);
            t3 = a3 - (q * b3);
            a1 = b1;
            a2 = b2;
            a3 = b3;
            b1 = t1;
            b2 = t2;
            b3 = t3;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String msg, cipher = "";
        int i, temp, a = 0, c;
        int gcd;
        int mul_inv;

        do {
            System.out.print("Enter the multiplicative key: ");
            a = input.nextInt();
            gcd = findgcd(a, 26);
        } while(gcd != 1);

        System.out.print("Enter the message: ");
        msg = input.next();

        mul_inv = ext_euclid(26, a);
        for(i = 0; i < msg.length(); i++) {
            if(msg.charAt(i) >= 'A' && msg.charAt(i) <= 'Z') {
                temp = (msg.charAt(i) - 'A') % 26;
                if(temp < 0) {
                    temp += 26;
                }
                cipher += (char)((mul_inv * temp) % 26 + 'A');
            }
            else if(msg.charAt(i) >= 'a' && msg.charAt(i) <= 'z') {
                temp = (msg.charAt(i) - 'a') % 26;
                if(temp < 0) {
                    temp += 26;
                }
                cipher += (char)((mul_inv * temp) % 26 + 'a');
            }
            else {
                cipher += msg.charAt(i);
            }
        }
        System.out.println("Plain text = " + cipher);
    }
}