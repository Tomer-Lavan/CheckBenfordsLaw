import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TextManipulation {


    public static int wordValueByAscii(String word) {
        int len = word.length();
        int wordValue = 0;
        for (int i =0; i < len; i++) {
            wordValue += word.charAt(i);
        }
        return wordValue;
    }

    public static int wordValueOnlyByLetters(String word) {
        int len = word.length();
        int wordValue = 0;
        for (int i = 0; i < len; i++) {
            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                wordValue += word.charAt(i) - 'a' + 1;
            }
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                wordValue += word.charAt(i) - 'A' + 1;
            }
        }
        return wordValue;
    }

    public static double wordValueOnlyByLettersDistribution(String word) {
        double[] lettersValue = {8.2, 1.5, 2.8, 4.3, 13, 2.2, 2, 6.1, 7 ,0.15, 0.77, 4, 2.4, 6.7, 7.5, 1.9, 0.095, 6, 6.3, 9.1, 2.8, 0.98, 2.4, 0.15, 2, 0.074};
        int len = word.length();
        double wordValue = 0;
        for (int i = 0; i < len; i++) {
            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                wordValue += lettersValue[word.charAt(i) - 'a'] * 100;
            }
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                wordValue += lettersValue[word.charAt(i) - 'A'] * 100;
            }
        }
        return wordValue;
    }

    public static int getFirstDigit(int wordValue) {
        while(wordValue / 10 != 0) {
            wordValue = wordValue/10;
        }
        return wordValue;
    }

    public static int getFirstDigit(double wordValue) {
        int val = (int) wordValue;
        while(val / 10 != 0) {
            val = val / 10;
        }
        return val;
    }

    public static IntArrayAndStringListArray CountFirstNumAppearance(String[] files, char method) throws IOException {
        double[] numCount = new double[9];
        String currentLine;
        int wordValue;
        double wordVal;
        int firstDig;
        Set<String> wordsByFirstDig[] = new Set[9];
        for( int i = 0; i < 9; i++) {
            wordsByFirstDig[i] = new HashSet<>();
        }
        for(int j = 0; j < files.length; j++) {
            File file = new File(files[j]);
            FileReader fil = new FileReader(file);
            BufferedReader buff = new BufferedReader(fil);
            while ((currentLine = buff.readLine()) != null) {  //Reading Content from the file
                String[] words = currentLine.split(" ");  //Split the word using space
                for (String word : words) {
                    if (method == 'A') {
                        wordValue = wordValueByAscii(word);
                        firstDig = getFirstDigit(wordValue);
                    } else if (method == 'O') {
                        wordValue = wordValueOnlyByLetters(word);
                        firstDig = getFirstDigit(wordValue);
                    } else {
                        wordVal = wordValueOnlyByLettersDistribution(word);
                        firstDig = getFirstDigit(wordVal);
                    }
                    if (firstDig != 0) {
                        numCount[firstDig - 1]++;
                        wordsByFirstDig[firstDig - 1].add(word);
                    }
                }
            }
        }
        IntArrayAndStringListArray ans = new IntArrayAndStringListArray(numCount,wordsByFirstDig);
        return ans;
    }

    public static double[] FirstNumDistribution(double[] numCount) {
        double[] numDist = new double[9];
        double total = 0;
        for (int i = 0; i < 9; i++) {
            total += numCount[i];
        }
        for ( int i =0; i < 9; i++) {
            numDist[i] = numCount[i] / total;
        }
        return numDist;
    }


    public static void main(String args[]) {
        String str1 = "tomer";
        String str2 = "tomorrow";
        String str3 = "hello";
        String str4 = "I";
        String str5 = "A";
        System.out.println(wordValueByAscii(str1));
        System.out.println(wordValueByAscii(str2));
        System.out.println(wordValueByAscii(str3));
        System.out.println(wordValueByAscii(str4));
        System.out.println(wordValueByAscii(str5));
        System.out.println(wordValueOnlyByLetters(str1));
        System.out.println(wordValueOnlyByLetters(str2));
        System.out.println(wordValueOnlyByLetters(str3));
        System.out.println(wordValueOnlyByLetters(str4));
        System.out.println(wordValueOnlyByLetters(str5));
        System.out.println(wordValueOnlyByLettersDistribution(str1));
        System.out.println(wordValueOnlyByLettersDistribution(str2));
        System.out.println(wordValueOnlyByLettersDistribution(str3));
        System.out.println(wordValueOnlyByLettersDistribution(str4));
        System.out.println(wordValueOnlyByLettersDistribution(str5));
        System.out.println(getFirstDigit(98388783));
    }





    }
