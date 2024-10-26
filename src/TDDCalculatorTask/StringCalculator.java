package TDDCalculatorTask;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n"; // Default delimiters: comma or newline

        // Check for custom delimiter format
        if (numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterEnd);
            numbers = numbers.substring(delimiterEnd + 1); // Update numbers to exclude the custom delimiter part
        }

        // Split numbers based on the specified or default delimiters
        String[] tokens = numbers.split(delimiter);

        // Calculate sum and check for negative numbers
        int sum = 0;
        List<Integer> negativeNumbers = new ArrayList<>();

        for (String token : tokens) {
            if (!token.isEmpty()) { // Ignore empty tokens
                int num = Integer.parseInt(token.trim());

                if (num < 0) {
                    negativeNumbers.add(num);
                } else {
                    sum += num;
                }
            }
        }

        // Throw exception if there are negative numbers
        if (!negativeNumbers.isEmpty()) {
            String negativeNumbersString = negativeNumbers.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            throw new IllegalArgumentException("negative numbers not allowed " + negativeNumbersString);
        }

        return sum;
    }
}