import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Stream;

public class StringCalculator {

        private String delimiter;
        private String numbers;

        private StringCalculator(String delimiter, String numbers) {
            this.delimiter = delimiter;
            this.numbers = numbers;
        }

        private int sum() {
            return Arrays.stream(numbers.split(delimiter))
                    .mapToInt(Integer::parseInt)
                    .sum();
        }

        public static int add(String numbers) {
            if(numbers.isEmpty()) {
                return 0;
            }

            return parseInput(numbers).sum();
        }


        private static StringCalculator parseInput(String numbers) {
            if(numbers.startsWith("//")) {
                String[] parts = numbers.split("\n", 2);
                return new StringCalculator(parts[0].substring(2), parts[1]);
            }
            else {
                return new StringCalculator(",|\n", numbers);
            }
        }

}
