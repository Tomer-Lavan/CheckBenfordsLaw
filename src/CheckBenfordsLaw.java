import processing.core.PApplet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;


public class CheckBenfordsLaw {
    public static void main(String[] args) throws IOException {
        String file1 = "C:\\Users\\tomer\\IdeaProjects\\BenfoedsLawTextFunctions\\testingText.txt";
        String file2 = "C:\\Users\\tomer\\IdeaProjects\\BenfoedsLawTextFunctions\\textFile.txt";
        String file3 = "C:\\Users\\tomer\\IdeaProjects\\BenfoedsLawTextFunctions\\WarAndPeace.txt";
        String[] files = {file1,file2,file3};
        System.out.println("By Ascii:");
        CheckBenfordsLawByMethod(files, 'A' );
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("By only letters:");
        CheckBenfordsLawByMethod(files, 'O' );
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("By letters distribution:");
        IntArrayAndStringListArray check = CheckBenfordsLawByMethod(files, 'D' );
    }



    public static IntArrayAndStringListArray CheckBenfordsLawByMethod(String[] files, char method) throws IOException {
        int[] firstDigApearanceCount;
        IntArrayAndStringListArray firstDigDistributionAndWords;
        firstDigDistributionAndWords = TextManipulation.CountFirstNumAppearance(files, method);
        firstDigDistributionAndWords.intArr = TextManipulation.FirstNumDistribution(firstDigDistributionAndWords.intArr);
        for (int i = 0; i < 9; i++) {
            System.out.println("The number " + (i+1) + " distribution is: " + firstDigDistributionAndWords.intArr[i] * 100 + "%");
        }
        return firstDigDistributionAndWords;
    }
}
