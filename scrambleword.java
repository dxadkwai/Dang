import java.util.Random;
import java.util.Scanner;

public class scrambleword {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String [] wordlist = {"magic", "color", "student"};

        int playerScore = 0;
        boolean playing = true;
        
        System.out.println("Welcome to Scramble!");


        while (playing) {
            String word = wordlist[random.nextInt(wordlist.length)];
            String scramble = scrambleWord(word, random);
            System.out.println("Scrambled word: " + scramble);
            boolean wordGuessed = false;
            int attempt = 3;


            while (attempt != 0 && !wordGuessed) {
                System.out.print("Guess the word: ");
                String guess = scanner.nextLine();
                
                if (guess.equalsIgnoreCase(word)) {
                    System.out.println("Correct! The word is " + word);
                    playerScore +=1;
                    wordGuessed = true;
                } else {
                    attempt -= 1;
                    System.out.println("Wrong! Remaining attempt is " + attempt);
                    wordGuessed = false;

                }
            }
            if (!wordGuessed) {
                System.out.println("The correct word is " + word);
            }

            System.out.println("YOur score is: " + playerScore);
            System.out.println("DO you want to keep playing? (yes/no) ");
            String yn = scanner.nextLine();
            playing = yn.equalsIgnoreCase("yes");

        }
        System.out.print("Thanks. Your final score is " + playerScore);
        scanner.close();
        
    }


    public static String scrambleWord(String word, Random random) {
        char[] letters = word.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int j = random.nextInt(letters.length);
            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;


        }
        return new String(letters);
    }
}
