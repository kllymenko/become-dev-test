package ua.klymenko;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberAnalysis {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        String filePath = "src/main/resources/10m.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line.trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (numbers.isEmpty()) {
            System.out.println("The file is empty or no valid numbers found.");
        } else {
            int max = findMax(numbers);
            int min = findMin(numbers);
            double average = findAverage(numbers);
            double median = findMedian(numbers);
            List<Integer> increasingSequence = findLongestIncreasingSequence(numbers);
            List<Integer> decreasingSequence = findLongestDecreasingSequence(numbers);

            System.out.println("Max: " + max);
            System.out.println("Min: " + min);
            System.out.println("Average: " + average);
            System.out.println("Median: " + median);
            System.out.println("Longest Increasing Sequence: " + increasingSequence);
            System.out.println("Longest Decreasing Sequence: " + decreasingSequence);
        }
    }

    public static int findMax(List<Integer> numbers) {
        int max = numbers.iterator().next();
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static int findMin(List<Integer> numbers) {
        int min = numbers.iterator().next();
        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static double findAverage(List<Integer> numbers) {
        double sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum / numbers.size();
    }

    public static double findMedian(List<Integer> numbers) {
        int size = numbers.size();
        List<Integer> sorted = new ArrayList<>(numbers);
        Collections.sort(sorted);
        if (size % 2 == 0) {
            return (sorted.get(size / 2 - 1) + sorted.get(size / 2)) / 2.0;
        } else {
            return sorted.get(size / 2);
        }
    }

    public static List<Integer> findLongestIncreasingSequence(List<Integer> numbers) {
        List<Integer> longestSeq = new ArrayList<>();
        List<Integer> currentSeq = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (i == 0 || numbers.get(i) > numbers.get(i - 1)) {
                currentSeq.add(numbers.get(i));
            } else {
                if (currentSeq.size() >= longestSeq.size()) {
                    longestSeq = new ArrayList<>(currentSeq);
                }
                currentSeq.clear();
                currentSeq.add(numbers.get(i));
            }
        }
        if (currentSeq.size() >= longestSeq.size()) {
            longestSeq = currentSeq;
        }
        return longestSeq;
    }

    public static List<Integer> findLongestDecreasingSequence(List<Integer> numbers) {
        List<Integer> longestSeq = new ArrayList<>();
        List<Integer> currentSeq = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (i == 0 || numbers.get(i) < numbers.get(i - 1)) {
                currentSeq.add(numbers.get(i));
            } else {
                if (currentSeq.size() >= longestSeq.size()) {
                    longestSeq = new ArrayList<>(currentSeq);
                }
                currentSeq.clear();
                currentSeq.add(numbers.get(i));
            }
        }
        if (currentSeq.size() >= longestSeq.size()) {
            longestSeq = currentSeq;
        }
        return longestSeq;
    }
}