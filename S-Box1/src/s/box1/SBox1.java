/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package s.box1;

/**
 *
 * @author Anchal
 */
public class SBox1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         int[][] sbox = {
            {9, 4, 10, 11, 13, 1, 8, 5, 6, 2, 0, 3, 12, 14, 15, 7},
            {4, 15, 1, 12, 10, 6, 9, 8, 13, 14, 7, 5, 3, 11, 0, 2},
            {14, 5, 13, 11, 4, 1, 3, 7, 10, 6, 15, 0, 9, 2, 12, 8},
            {13, 11, 4, 1, 3, 15, 5, 9, 0, 10, 14, 7, 6, 8, 2, 12},
            {1, 3, 10, 9, 8, 13, 15, 0, 11, 5, 6, 14, 2, 12, 7, 4},
            {7, 12, 2, 10, 6, 9, 1, 13, 15, 3, 5, 8, 4, 11, 14, 0},
            {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11},
            {12, 9, 8, 13, 6, 15, 3, 0, 11, 1, 2, 5, 4, 10, 14, 7}
        };

        int input = 0b1100; // input value
        int row = (input & 0b1000) >> 3; // get the first bit and shift it to the rightmost position
        int col = input & 0b111; // get the last three bits

        int output = sbox[row][col]; // look up the output value in the S-box table
        System.out.println("Input: " + Integer.toBinaryString(input));
        System.out.println("Output: " + Integer.toBinaryString(output));
    }
    
}
