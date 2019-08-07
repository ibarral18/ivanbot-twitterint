import java.util.Scanner;
import java.util.*;
public class main {
    public static void main(String[] args) {
        int x = 0;
        while (x < 100) {
            sentenceGen yuh = new sentenceGen();
            yuh.sendTweet();
            System.out.println("Ivan Bot says: " + yuh.getSentence());
            try {
                System.out.println("30 minutes delay");
                Thread.sleep(1800000); // every 30 minutes THIS IS IN MILLISECONDS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            x++;
        }
    }
}
