import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class VDN1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your numbers seperated by one blank space: ");
        try {
            String userInput = sc.nextLine();
            String[] userInputTokenised = userInput.split(" ");
            long[] userInputNumbers = Shortcuts.StringArrayToLongArray(userInputTokenised);
            long[] userInputNumbersFlipped = Shortcuts.FlipLongArray(userInputNumbers);
            System.out.println("Sum of the numbers entered: " + Sum(userInputNumbers));
            System.out.println("Total numbers entered: " + NumberOfItems(userInputNumbers));
            System.out.println("Frequency of occurance of each number in the array:");
                FrequencyOfOccurance(userInputNumbers);
            System.out.println("Average of the numbers entered: " + Average(userInputNumbers));
            System.out.println("Number of Odd numbers: " + NumberOfOddNumbers(userInputNumbers));
            System.out.println("Number of Even numbers: " + NumberOfEvenNumbers(userInputNumbers));
            System.out.println("Number of Different numbers: " + NumberOfDifferentNumber(userInputNumbers));
            System.out.println("Standard deviation of the array is: " + StandardDeviaton(userInputNumbers));
            System.out.println("Median of the array is(If 0 then it doesnt exist): " + Median(userInputNumbers));
            System.out.println("The biggest number is: " + BiggestNumber(userInputNumbers));
            System.out.println("The second biggest number is: " + SecondBiggestNumber(userInputNumbers));
            System.out.println("The second smallest number is: " + SecondSmallestNumber(userInputNumbers));
            System.out.println("The most repeated number is: " + MostRepeatedNumber(userInputNumbers));
            System.out.println("Total number of palindromes entered: " + NumberOfPalindromes(userInputTokenised));
            System.out.println("Second biggest palindrome(If 0 then it doesnt exist): " + SecondBiggestPalindrome(userInputTokenised));
            System.out.print("Reverse order of the array: "); Shortcuts.PrintLongArrayInOneLine(userInputNumbersFlipped);
            sc.close();
        } catch (Exception e) {
            System.out.println("Error!");
            System.out.println(e);
        }

    }

    // Functions

    public static long Average(long[] numbers){
        long average = 0;
        for (int i = 0; i < numbers.length; i++) {
            average += numbers[i];
        }
        average /= numbers.length;
        return average;
    }

    public static int NumberOfItems(long[] numbers){
        int counter = 0;
        for (int i = 0; i < numbers.length; i++) {
            counter++;
        }
        return counter;
    }
    
    public static int NumberOfEvenNumbers(long[] numbers){
        int counter = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                counter++;
            }
        }
        return counter;
    }

    public static int NumberOfOddNumbers(long[] numbers){
        int counter = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 1) {
                counter++;
            }
        }
        return counter;
    }

    public static int NumberOfDifferentNumber(long[] numbers){
        int count = 0;
        HashSet<Long> numbersSet = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            numbersSet.add(numbers[i]);
        }
        count = numbersSet.size();
        return count;
    }

    public static long BiggestNumber(long[] numbers){
        long biggestNumber = Long.MIN_VALUE;
        for (int j = 0; j < numbers.length; j++) {
            if (biggestNumber < numbers[j]) {
                biggestNumber = numbers[j];
            }
        }
        return biggestNumber;
    }
    
    public static long SecondBiggestNumber(long[] numbers){
        long biggestNumber = Long.MIN_VALUE;
        long secondBiggestNumber = Long.MIN_VALUE;
    
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > biggestNumber) {
                secondBiggestNumber = biggestNumber;
                biggestNumber = numbers[i];
            } else if (numbers[i] > secondBiggestNumber){
                secondBiggestNumber = numbers[i];
            }
        }
        return secondBiggestNumber;
        }

    public static long SecondSmallestNumber(long[] numbers){
        long smallestNumber = numbers[0];
        long secondSmallestNumber = numbers[1];
    
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < smallestNumber) {
                secondSmallestNumber = smallestNumber;
                smallestNumber = numbers[i];
            } else if (numbers[i] < secondSmallestNumber){
                secondSmallestNumber = numbers[i];
            }
        }
        return secondSmallestNumber;
        }

    public static double StandardDeviaton(long[] numbers){
        double sum = Sum(numbers);
        double standardDeviation = 0.0;
        double mean = sum / numbers.length;
        
        for (int i = 0; i < numbers.length; i++) {
            standardDeviation += Math.pow((numbers[i] - mean), 2);
        }
        double square = standardDeviation / numbers.length;
        double result = Math.sqrt(square);

        return result;

    }

    public static long Median(long[] numbers){
        long median = Long.MIN_VALUE;
        if(numbers.length % 2 == 1){
            median = numbers[numbers.length/2];
        }else{
            median = 0;
        }
        return median;
    }

    public static long MostRepeatedNumber(long[] numbers){
        Arrays.sort(numbers);
        // LinkedList<CounterObj> counters = new LinkedList<CounterObj>();

        Map<Long,Long> map = new HashMap<Long,Long>();
        for (long nextNumber : numbers) {
            Long count = map.get(nextNumber);
            if (count == null) {
                count = (long) 1;
            } else {
                count++;
            }
            map.put(nextNumber, count);
        }
        Long mostRepeatedNumber = null;
        Long mostRepeatedCount = null;
        Set<Long>keys = map.keySet();
        for (Long key : keys) {
            Long count = map.get(key);
            if (mostRepeatedNumber == null) {
                mostRepeatedNumber = key;
                mostRepeatedCount = count;
            } else if (count > mostRepeatedCount) {
                mostRepeatedNumber = key;
                mostRepeatedCount = count;
            } else if (count == mostRepeatedCount && key < mostRepeatedNumber) {
                mostRepeatedNumber = key;
                mostRepeatedCount = count;
            }
        }
        return mostRepeatedNumber;
    }

    public static int NumberOfPalindromes(String[] aTokenisedString){
        int counter = 0;
        String[] aTokenisedStringReversed = new String[aTokenisedString.length];
        for (int i = 0; i < aTokenisedString.length; i++) {
            aTokenisedStringReversed[i] = Shortcuts.ReverseString(aTokenisedString[i]);
        }
        for (int i = 0; i < aTokenisedStringReversed.length; i++) {
            if (aTokenisedStringReversed[i].equals(aTokenisedString[i])) {
                counter++;
            }
        }
        return counter;
    }

    public static long SecondBiggestPalindrome(String[] aTokenisedString){
        String[] extractedPalindromes = Shortcuts.ExtractPalindromes(aTokenisedString);
        long[] extractedPalindromesLong = Shortcuts.StringArrayToLongArray(extractedPalindromes);
        long secondBiggestPalindrome = SecondBiggestNumber(extractedPalindromesLong);
        if (secondBiggestPalindrome == Long.MIN_VALUE) {
            return 0;
        }else{
            return secondBiggestPalindrome;
        }
    }

    public static long Sum(long[] numbers){
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
    return sum;
    }

    public static void FrequencyOfOccurance(long[] numbers){
        HashMap<Long, Integer> numCounts = new HashMap<>();

        for (long element : numbers) {
            if (numCounts.containsKey(element)) {
                int count = numCounts.get(element);
                numCounts.put(element, count + 1);
            } else {
                numCounts.put(element, 1);
            }
        }
        int totalElements = numbers.length;
        for (long element : numCounts.keySet()) {
            double frequency = (double) numCounts.get(element) / totalElements * 100;
            System.out.println("    " + element + " occurs " + frequency + "% of the time.");
        }

    }

    
}