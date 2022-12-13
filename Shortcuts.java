import java.util.ArrayList;

public class Shortcuts {

    public static void PrintStringArray(String[] aStringArray, String arrayName){
        for (int i = 0; i < aStringArray.length; i++) {
            System.out.println(arrayName + "[" +  i + "]: " + aStringArray[i]);
        }
    }

    public static void PrintStringArrayInOneLine(String[] aStringArray){
        for (int i = 0; i < aStringArray.length; i++) {
            System.out.print(aStringArray[i] + " ");
        }
    }
    
    public static void PrintLongArray(long[] aLongArray, String arrayName){
        for (int i = 0; i < aLongArray.length; i++) {
            System.out.println(arrayName + "[" +  i + "]: " + aLongArray[i]);
        }
    }

    public static void PrintLongArrayInOneLine(long[] aLongArray){
        for (int i = 0; i < aLongArray.length; i++) {
            System.out.print(aLongArray[i] + " ");
        }
    }

    public static int StringToInt(String aString){
        int convertedStringToInt = Integer.parseInt(aString);
        return convertedStringToInt; 
    }

    public static int[] StringArrayToIntArray(String[] aStringArray){
        int[] convertedStringToInt = new int[aStringArray.length];
        for (int i = 0; i < aStringArray.length; i++) {
            convertedStringToInt[i] = Integer.parseInt(aStringArray[i]);
        }
        return convertedStringToInt; 
    }
    
    public static long[] StringArrayToLongArray(String[] aStringArray){
        long[] convertedStringToLong = new long[aStringArray.length];
        for (int i = 0; i < aStringArray.length; i++) {
            convertedStringToLong[i] = Integer.parseInt(aStringArray[i]);
        }
        return convertedStringToLong; 
    }

    public static String[] LongArrayToStringArray(long[] aLongArray){
        String[] convertedLongToString = new String[aLongArray.length];
        for (int i = 0; i < aLongArray.length; i++) {
            convertedLongToString[i] = Long.toString(aLongArray[i]);
        }
        return convertedLongToString; 
    }
    
    public static String[] IntArrayToStringArray(int[] aIntArray){
        String[] convertedIntToString = new String[aIntArray.length];
        for (int i = 0; i < aIntArray.length; i++) {
            convertedIntToString[i] = Integer.toString(aIntArray[i]);
        }
        return convertedIntToString; 
    }

    public static String[] StringArrayListToStringArray(ArrayList<String> aStringArrayList){
        String stringArray[] = new String[aStringArrayList.size()];
  
        for (int i = 0; i <aStringArrayList.size(); i++) {
            stringArray[i] = aStringArrayList.get(i);
        }
  
        return stringArray;
    }

    public static String ReverseString(String aString){
        String reversedString = "";
        for (int i = aString.length()-1; i >= 0; i--){
            reversedString = reversedString + aString.charAt(i);
        }
        return reversedString;
    }

    public static long[] FlipLongArray(long[] numbers){
        long[] numbersFlipped = new long[numbers.length];
        int numbersFlippedIndex = 0;
        for (int i = numbersFlipped.length-1; i >= 0 ; i--) {
            numbersFlipped[numbersFlippedIndex] = numbers[i];
            numbersFlippedIndex++;
        }
        return numbersFlipped;
    }

    public static String[] ExtractPalindromes(String[] aTokenisedString){
        ArrayList<String> palindromesExtracted = new ArrayList<String>();
        String[] aTokenisedStringReversed = new String[aTokenisedString.length];
        for (int i = 0; i < aTokenisedString.length; i++) {
            aTokenisedStringReversed[i] = ReverseString(aTokenisedString[i]);
        }
        for (int i = 0; i < aTokenisedStringReversed.length; i++) {
            if (aTokenisedStringReversed[i].equals(aTokenisedString[i])) {
                palindromesExtracted.add(aTokenisedString[i]);
            }
        }
        return StringArrayListToStringArray(palindromesExtracted);
    }



}


