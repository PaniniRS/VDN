import java.util.Scanner;

public class testing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Get the numbers from the user, split the input and then convert them to integers.
        System.out.print("Enter your numbers seperated by one blank space: ");
        String userInput = sc.nextLine();
        String[] userInputTokenised = userInput.split(" ");
        long[] userInputNumbers = Shortcuts.StringArrayToLongArray(userInputTokenised);

        
        System.out.println("Second biggest number: " + SecondBiggestNumber(userInputNumbers));
        // System.out.println("Total palindromes: " + NumberOfPalindromes(userInputTokenised));
    }

    public static String ReverseString(String aString){
        String reversedString = "";
        for (int i = aString.length()-1; i >= 0; i--){
            reversedString = reversedString + aString.charAt(i);
        }
        return reversedString;
    }
    // public static boolean CheckPalindrome(String[] aTokenisedStringArray) {
    //     boolean isPalindrome = false;
    //     for (int i = 0; i < aTokenisedStringArray.length; i++) {
    //         String reversedElement = ReverseString(aTokenisedStringArray[i]);
    //         System.out.println("aTokenisedStringArray["+i+"]"+aTokenisedStringArray[i]);
    //         System.out.println("reversedElement["+i+"]"+reversedElement);
    //     if (aTokenisedStringArray[i].equals(reversedElement)) {
    //         isPalindrome = true;
    //         System.out.println("True");
    //     } else {
    //         isPalindrome = false;
    //         System.out.println("False");
    //         }
    //     }
    //     return isPalindrome;
    // }
    
    public static long BiggestNumber(long[] numbers){
        long biggestNumber = numbers[0];
        for (int j = 0; j < numbers.length; j++) {
            if (biggestNumber < numbers[j]) {
                biggestNumber = numbers[j];
            }
        }
        return biggestNumber;
    }

    public static long SecondBiggestNumber(long[] numbers){
    long biggestNumber = Integer.MIN_VALUE;
    long secondBiggestNumber = Integer.MIN_VALUE;

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

    public static int NumberOfPalindromes(String[] aTokenisedString){
        int counter = 0;
        String[] aTokenisedStringReversed = new String[aTokenisedString.length];
        for (int i = 0; i < aTokenisedString.length; i++) {
            aTokenisedStringReversed[i] = ReverseString(aTokenisedString[i]);
        }
        for (int i = 0; i < aTokenisedStringReversed.length; i++) {
            if (aTokenisedStringReversed[i].equals(aTokenisedString[i])) {
                counter++;
            }
        }
        return counter;
    }
    
}
