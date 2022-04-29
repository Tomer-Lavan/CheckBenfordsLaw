import processing.core.*;
import processing.opengl.PGraphics3D;

import java.awt.*;
import java.io.IOException;

public class DistInProcessing extends PApplet {
    public DistInProcessing() throws IOException {
    }

    public static void main(String[] args) {
        PApplet.main("DistInProcessing",args);
    }
    String file1 = "C:\\Users\\tomer\\IdeaProjects\\BenfoedsLawTextFunctions\\testingText.txt";
    String file2 = "C:\\Users\\tomer\\IdeaProjects\\BenfoedsLawTextFunctions\\textFile.txt";
    String file3 = "C:\\Users\\tomer\\IdeaProjects\\BenfoedsLawTextFunctions\\WarAndPeace.txt";
    String file4 = "C:\\Users\\tomer\\IdeaProjects\\BenfoedsLawTextFunctions\\AliceInWonderland.txt";
    String file5 = "C:\\Users\\tomer\\IdeaProjects\\BenfoedsLawTextFunctions\\SherlockHolmes.txt";
    String[] files = {file1,file2,file3,file4,file5};
    IntArrayAndStringListArray wordsAndDist = CheckBenfordsLaw.CheckBenfordsLawByMethod(files,'D');
    String[][] words = wordsAndDist.transferToArrays();
    double[] dist = wordsAndDist.intArr;

    @Override
    public void settings() {
        super.settings();
        size(1000, 600);
    }

    @Override
    public void setup() {
        super.setup();
        background(0);
        Color[] colors = new Color[9];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = new Color((int)random(30,255),(int)random(30,255),(int)random(30,255));
        }
        for (int i = 0; i < 9;i++) {
            fill(colors[i].getRed(),colors[i].getGreen(),colors[i].getBlue());
            for (int j = 0; j < 400 * 1/(2*i+1); j++) {
                int size = (int) random(5, 25);
                textSize(size);
                if (words[i][j].length() < 11) {
                    text(words[i][j],random(800/9 + i * 800/9 + 30, 800/9 + 800/9 * (i+1) - (words[i][j].length()/2)),random(590 - 600*(float)dist[i]*3,550));
                }
                textSize(20);
                text((float)dist[i],(800/9 + i * 800/9 + 60 + 800/9 + 800/9 * (i+1))/2 -19,30);
                text(i + 1,(800/9 + i * 800/9 + 60 + 800/9 + 800/9 * (i+1))/2 + 5, 575);
            }
        }
        save("C:\\Users\\tomer\\Desktop\\Tomer\\BenfordsLaw.jpg");
    }

}


