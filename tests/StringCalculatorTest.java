import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

public class StringCalculatorTest {

        @Test
        public void emptyStringReturnsZero() {
            assertEquals(StringCalculator.add(""), 0);
        }

        @Test
        public void singleValueReturned() {
            String numbers = "1";
            int expectedResult = 1;
            int actualResult = StringCalculator.add(numbers);
            assertEquals(expectedResult, actualResult);
        }

        @Test
        public void twoNumbersCommaDelimitedReturnSum() {
            String numbers = "1,1";
            int expectedResult = 2;
            int actualResult = StringCalculator.add(numbers);
            assertEquals(expectedResult, actualResult);

        }

        @Test
        public void threeNumbersCommaDelimitedReturnSum() {
            String numbers = "1,2,5";
            int expectedResult = 8;
            int actualResult = StringCalculator.add(numbers);
            assertEquals(expectedResult, actualResult);
        }

        @Test
        public void twoNumbersNewLineDelimitedReturnSum() {
            String numbers = "1\n2";
            int expectedResult = 3;
            int actualResult = StringCalculator.add(numbers);
            assertEquals(expectedResult, actualResult);
        }

        @Test
        public void threeNumbersNewLineDelimitedReturnSumVersionOne() {
            String numbers = "1\n2,3";
            int expectedResult = 6;
            int actualResult = StringCalculator.add(numbers);
            assertEquals(expectedResult, actualResult);
        }

        @Test
        public void threeNumbersNewLineDelimitedReturnSumVersionTwo() {
            String numbers = "1\n2,3";
            int expectedResult = 6;
            int actualResult = StringCalculator.add(numbers);
            assertEquals(expectedResult, actualResult);
        }

        @Test
        public void useDelimiterSpecified() {
            assertEquals(StringCalculator.add("//;\n1;2"), 3);
        }

        @Test(expected = IllegalArgumentException.class)
        public void throwsOnNegativeNumber() {
            StringCalculator.add("-3");
        }

}

