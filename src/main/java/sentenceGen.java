import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
class sentenceGen {
    private String noun;
    private String adjective;
    private String expletive;
    private String occupation;
    private String postfix;
    private String food;
    private String action;
    private String city;
    private String insult;
    private String name;
    private String verb;
    public sentenceGen (){
        expletive = "C:\\Users\\ibarral\\Documents\\Ivan Intern Files\\IJ proj\\src\\main\\java\\expletives.txt";
        noun = "C:\\Users\\ibarral\\Documents\\Ivan Intern Files\\IJ proj\\src\\main\\java\\nouns.txt";
        adjective = "C:\\Users\\ibarral\\Documents\\Ivan Intern Files\\IJ proj\\src\\main\\java\\adjectives.txt";
        occupation = "C:\\Users\\ibarral\\Documents\\Ivan Intern Files\\IJ proj\\src\\main\\java\\occupations.txt";
        postfix = "C:\\Users\\ibarral\\Documents\\Ivan Intern Files\\IJ proj\\src\\main\\java\\postfix.txt";
        food = "C:\\Users\\ibarral\\Documents\\Ivan Intern Files\\IJ proj\\src\\main\\java\\foods.txt";
        action = "C:\\Users\\ibarral\\Documents\\Ivan Intern Files\\IJ proj\\src\\main\\java\\actions.txt";
        city = "C:\\Users\\ibarral\\Documents\\Ivan Intern Files\\IJ proj\\src\\main\\java\\cities.txt";
        insult = "C:\\Users\\ibarral\\Documents\\Ivan Intern Files\\IJ proj\\src\\main\\java\\insults.txt";
        name = "C:\\Users\\ibarral\\Documents\\Ivan Intern Files\\IJ proj\\src\\main\\java\\names.txt";
        verb = "C:\\Users\\ibarral\\Documents\\Ivan Intern Files\\IJ proj\\src\\main\\java\\verbs.txt";
    }

    private String getRandomWord(String wordType){
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
        String two = "@frankybanana is allergic to " + getRandomWord(noun);
        String three = "@frankybanana is allergic to " + getRandomWord(food);
        String four = "i am baby";
        String five = getRandomWord(noun) + " is so " + getRandomWord(expletive) + " " + getRandomWord(adjective);
        String six = getRandomWord(occupation) + " said fuck work";
        String seven = "i'm baby";
        String eight = getRandomWord(noun) + " is so " + getRandomWord(adjective) + " " + getRandomWord(postfix);
        String nine = getRandomWord(noun) + " is so " + getRandomWord(expletive) + " " + getRandomWord(adjective) + " " + getRandomWord(postfix);
        String ten = "i want " + getRandomWord(food);
        String eleven = "i want " + getRandomWord(food) + " " + getRandomWord(postfix);
        String twelve = "i'm just " + getRandomWord(action) + " in " + getRandomWord(city);
        String thirteen = "@RobiLopezIr is " + getRandomWord(insult);
        String fourteen = "where is " + getRandomWord(name) + " ?";
        String fifteen = getRandomWord(name) + " got not chips";
        String sixteen = "noooo don't " + getRandomWord(verb) + " ur so sexy ahaha";
        sentenceStorage.add(one);
        sentenceStorage.add(two);
        sentenceStorage.add(three);
        sentenceStorage.add(four);
        sentenceStorage.add(five);
        sentenceStorage.add(six);
        sentenceStorage.add(six);
        sentenceStorage.add(seven);
        sentenceStorage.add(eight);
        sentenceStorage.add(nine);
        sentenceStorage.add(ten);
        sentenceStorage.add(eleven);
        sentenceStorage.add(twelve);
        sentenceStorage.add(thirteen);
        sentenceStorage.add(fourteen);
        sentenceStorage.add(fifteen);
        sentenceStorage.add(sixteen);
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
