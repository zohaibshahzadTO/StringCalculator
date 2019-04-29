import java.util.Arrays;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCalculator {

    private String delimiter;
    private String numbers;

    private StringCalculator(String delimiter, String numbers) {
        this.delimiter = delimiter;
        this.numbers = numbers;
    }

    private int sum() {
        ensureNoNegativeNumbers();
        return getNumber().filter(n -> n <= 1000).sum();
    }

    private void ensureNoNegativeNumbers() {
        String negativeNumberSequence = getNumber()
                .filter(n -> n < 0)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(","));
        if(!negativeNumberSequence.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negativeNumberSequence);
        }
    }

    private IntStream getNumber() {
        if(numbers.isEmpty()) {
            return IntStream.empty();
        }

        else {
            return Stream.of(numbers.split(delimiter)).mapToInt(Integer::parseInt);
        }
    }

    public static int add(String numbers) {
            return parseInput(numbers).sum();
        }


        private static StringCalculator parseInput(String numbers) {
            if(numbers.startsWith("//")) {
                String[] parts = numbers.split("\n", 2);
                String header = parts[0];
                return new StringCalculator(parseDelimiter(header), parts[1]);
            }
            else {
                return new StringCalculator(",|\n", numbers);
            }
        }

    private static String parseDelimiter(String header) {
        String delimiter = header.substring(2);
        if(delimiter.startsWith("[")) {
           delimiter = delimiter.substring(1, delimiter.length() - 1);
        }
        return Stream.of(delimiter.split("]\\["))
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
     }



}
