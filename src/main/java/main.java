import java.util.Scanner;
import java.util.*;
public class main {
    public static void main(String[] args) {
      sentenceGen yuh = new sentenceGen();
      yuh.sendTweet();
      System.out.println("Ivan Bot says: " + yuh.getSentence());
    }
}
