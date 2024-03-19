package com.ismet;

import java.util.Arrays;

public class FindMean {
        public static double calculateMean(int[] arr) {
            return Arrays.stream(arr).average().orElse(0);
        }

        public static void main(String[] args) {
            int[] numbers = {1, 2, 3, 4, 5};
            double mean = calculateMean(numbers);
            System.out.println("Mean: " + mean);
        }
}
