package GuessTheWord;

import java.util.Random;

class AdvancedGame extends InputGame {
    private Random random;
 
    public AdvancedGame(String wordToGuess) {
        super(wordToGuess);
        this.random = new Random();
    }
 
    @Override
    public void displayHint() {
        super.displayHint();
        if (attempts > 0) {
            revealRandomLetter();
            System.out.println("Revealed so far: " + getRevealedWord());
        }
    }
 
    private void revealRandomLetter() {
        int index;
        do {
            index = random.nextInt(wordToGuess.length());
        } while (revealedLetters[index] != '-');
        revealedLetters[index] = wordToGuess.charAt(index);
    }
}
 


