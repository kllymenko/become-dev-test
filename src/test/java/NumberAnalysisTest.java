import org.junit.Test;
import ua.klymenko.NumberAnalysis;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NumberAnalysisTest {
    @Test
    public void testMedianOdd() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        double median = NumberAnalysis.findMedian(numbers);
        assertEquals(3.0, median, 0.001);
    }

    @Test
    public void testMedianEven() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        double median = NumberAnalysis.findMedian(numbers);
        assertEquals(3.5, median, 0.001);
    }

    @Test
    public void testLongestIncreasingSequence() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 3, 4, 1);
        List<Integer> expected = Arrays.asList(2, 3, 4);
        List<Integer> actual = NumberAnalysis.findLongestIncreasingSequence(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void testLongestDecreasingSequence() {
        List<Integer> numbers = Arrays.asList(5, 4, 3, 2, 1, 4, 3);
        List<Integer> expected = Arrays.asList(5, 4, 3, 2, 1);
        List<Integer> actual = NumberAnalysis.findLongestDecreasingSequence(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void testSingleElementList() {
        List<Integer> numbers = Arrays.asList(1);
        assertEquals(Integer.valueOf(1), Collections.max(numbers));
        assertEquals(Integer.valueOf(1), Collections.min(numbers));
        assertEquals(1.0, numbers.stream().mapToInt(Integer::intValue).average().orElse(Double.NaN), 0.001);
        assertEquals(1.0, NumberAnalysis.findMedian(numbers), 0.001);
    }

    @Test
    public void testAllSameElements() {
        List<Integer> numbers = Arrays.asList(5, 5, 5, 5, 5);
        assertEquals(Integer.valueOf(5), Collections.max(numbers));
        assertEquals(Integer.valueOf(5), Collections.min(numbers));
        assertEquals(5.0, numbers.stream().mapToInt(Integer::intValue).average().orElse(Double.NaN), 0.001);
        assertEquals(5.0, NumberAnalysis.findMedian(numbers), 0.001);
    }

    @Test
    public void testMaxNegativeNumbers() {
        List<Integer> numbers = Arrays.asList(-1, -2, -3, -4, -5);
        assertEquals(Integer.valueOf(-1), Collections.max(numbers));
    }

    @Test
    public void testMinNegativeNumbers() {
        List<Integer> numbers = Arrays.asList(-1, -2, -3, -4, -5);
        assertEquals(Integer.valueOf(-5), Collections.min(numbers));
    }

    @Test
    public void testMedianNegativeNumbers() {
        List<Integer> numbers = Arrays.asList(-1, -2, -3, -4, -5);
        double median = NumberAnalysis.findMedian(numbers);
        assertEquals(-3.0, median, 0.001);
    }

    @Test
    public void testAverageNegativeNumbers() {
        List<Integer> numbers = Arrays.asList(-1, -2, -3, -4, -5);
        double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(Double.NaN);
        assertEquals(-3.0, average, 0.001);
    }

    @Test
    public void testLongestIncreasingSequenceNegative() {
        List<Integer> numbers = Arrays.asList(-5, -4, -3, -6, -2, -1);
        List<Integer> expected = Arrays.asList(-6, -2, -1);
        List<Integer> actual = NumberAnalysis.findLongestIncreasingSequence(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void testLongestDecreasingSequenceNegative() {
        List<Integer> numbers = Arrays.asList(-1, -2, -3, -1, -4, -5);
        List<Integer> expected = Arrays.asList(-1, -4, -5);
        List<Integer> actual = NumberAnalysis.findLongestDecreasingSequence(numbers);
        assertEquals(expected, actual);
    }
}
