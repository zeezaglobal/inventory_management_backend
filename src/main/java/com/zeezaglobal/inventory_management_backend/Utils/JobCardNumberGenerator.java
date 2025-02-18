package com.zeezaglobal.inventory_management_backend.Utils;

import java.util.Random;

public class JobCardNumberGenerator {

    // A simple random alphabetic prefix generator (2 characters)
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Random RANDOM = new Random();
    private static long counter = 1000;  // Start the counter from 1000 (or any other number)

    // Method to generate a unique JobCard number
    public static String generateJobCardNumber() {
        // Generate a random 2-letter prefix
        String prefix = generateRandomPrefix();

        // Generate a sequential counter number
        String counterPart = String.valueOf(counter++);

        // Combine prefix and counter to form the final job card number
        return prefix + "-" + counterPart;
    }

    // Helper method to generate a random 2-letter prefix
    private static String generateRandomPrefix() {
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            int randomIndex = RANDOM.nextInt(CHARACTERS.length());
            prefix.append(CHARACTERS.charAt(randomIndex));
        }
        return prefix.toString();
    }


}

