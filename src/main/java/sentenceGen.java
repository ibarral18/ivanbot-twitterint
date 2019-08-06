import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
class sentenceGen {
    String noun;
    String adjective;
    String expletive;
    String occupation;
    public sentenceGen (){
        expletive = "C:\\Users\\ibarral\\Documents\\Ivan Intern Files\\IJ proj\\src\\main\\java\\expletives.txt";
        noun = "C:\\Users\\ibarral\\Documents\\Ivan Intern Files\\IJ proj\\src\\main\\java\\nouns.txt";
        adjective = "C:\\Users\\ibarral\\Documents\\Ivan Intern Files\\IJ proj\\src\\main\\java\\adjectives.txt";
        occupation = "C:\\Users\\ibarral\\Documents\\Ivan Intern Files\\IJ proj\\src\\main\\java\\occupations.txt";
    }

    public String getRandomWord(String wordType){
        ArrayList<String> wordStorage =  new ArrayList<>();
        try{
            File fileReader = new File(wordType);
            Scanner s = new Scanner(fileReader);
            for(int y = 0; s.hasNextLine(); y++){
                String word = s.nextLine();
                wordStorage.add(word);
            }
        }


        catch(Exception e){
            System.out.println("File not found ! ");
        }
        Random r=new Random();
        if(wordStorage.size() > 0) {
            int randomNumber = r.nextInt(wordStorage.size());
            return wordStorage.get(randomNumber);
        }

        else
            return "invalid";
    }

    public String getSentence() {
        ArrayList<String> sentenceStorage = new ArrayList<>();
        String one = getRandomWord(noun) + " is so " + getRandomWord(adjective);
        String two = "franky is allergic to " + getRandomWord(noun);
        String three = getRandomWord(noun) + " is a " + getRandomWord(noun);
        String four = "i am baby";
        String five = getRandomWord(noun) + " is so " + getRandomWord(expletive) + " " + getRandomWord(adjective);
        String six = getRandomWord(occupation) + " said fuck work";
        String seven = "i'm baby";
        sentenceStorage.add(one);
        sentenceStorage.add(two);
        sentenceStorage.add(three);
        sentenceStorage.add(four);
        sentenceStorage.add(five);
        sentenceStorage.add(six);
        sentenceStorage.add(one);
        sentenceStorage.add(one);
        sentenceStorage.add(one);
        sentenceStorage.add(six);
        sentenceStorage.add(six);
        sentenceStorage.add(seven);
        sentenceStorage.add(seven);
        Random random = new Random();
        int index = random.nextInt(sentenceStorage.size());
        return sentenceStorage.get(index);

    }


    public void sendTweet() {
        Twitter twitter = TwitterFactory.getSingleton();
        Status status;
        try {
            status = twitter.updateStatus(getSentence());
            System.out.println(status);
        } catch (TwitterException e) {;
            e.printStackTrace();
        }
    }


}
