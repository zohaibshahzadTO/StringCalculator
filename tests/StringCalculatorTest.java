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
            assertEquals(StringCalculator.add("//;\n1;2;3;4"), 10);
        }

        @Test
        public void useDelimiterSpecifiedVersionTwo() {
            assertEquals(StringCalculator.add("//@\n2@2@3"), 7);
            assertEquals(StringCalculator.add("//.\n2.3.1"), 6);
        }

        @Test
        public void useDelimiterSpecifiedVersionThree() {
        assertEquals(StringCalculator.add("//$\n1$2$3$4"), 10);
    }

        @Rule
        public ExpectedException expectedException = ExpectedException.none();

        @Test
        public void throwsOnNegativeNumber() {
            expectedException.expect(IllegalArgumentException.class);
            expectedException.expectMessage("Negatives not allowed: -3");
            StringCalculator.add("-3");
        }

        @Test
        public void throwsOnNegativeNumbersWithAllNumbersInExceptionMessage() {
            expectedException.expect(IllegalArgumentException.class);
            expectedException.expectMessage("Negatives not allowed: -3,-5,-13");

            StringCalculator.add("1,-3,5,-5,-13");
        }

        @Test
        public void ignoreNumbersBiggerThan1000() {
            assertEquals(StringCalculator.add("2,1001"), 2);
        }

        @Test
        public void acceptsDelimiterOfArbitraryLength() {
            assertEquals(StringCalculator.add("//[***]\n1***2***3"), 6);
        }

        @Test
        public void acceptsMultipleDelimiters() {
            assertEquals(StringCalculator.add("//[-][;]\n1-2;3"), 6);
            assertEquals(StringCalculator.add("//[--][...]\n2--3...4"), 9);
        }
}


