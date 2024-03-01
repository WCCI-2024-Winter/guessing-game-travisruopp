import java.util.Random;

public class PlayAI {

    Keyboard keys = new Keyboard();

    private int maxNumber= 100;
    private int minNumber= 1;
    private int secretNumber;

    public void PlayAIGame(){
        secretNumber = CreateRandomNumber();
        while(true){
            int AIGuess = getAIGuess();
            int humanGuess = getHumanGuess();
            if(CheckGuess(AIGuess, humanGuess)!=0){
                break;
            }
        }
    }

    private int CreateRandomNumber(){
        Random random = new Random();
        return random.nextInt(maxNumber)+minNumber;
    }

    private int getAIGuess(){
        Random random = new Random();
        return random.nextInt(maxNumber)+minNumber;
    }

    private int getHumanGuess(){
        int userGuess = keys.getInteger("Pick a number from 1 to 100 ", "");
        return userGuess;
    }

    private void getHelp(){

    }

    private int CheckGuess(int AIGuess, int humanGuess){
        int results = 0; // neither AI or user guessed right
        if (humanGuess == secretNumber){
            return 1;
        } else if (AIGuess == secretNumber){
            return -1;
        }
        if (AIGuess>secretNumber){
            System.out.println("AI guess is too high.");
            maxNumber = AIGuess;
        } else if (AIGuess<secretNumber){
            System.out.println("AI guess is too low.");
            minNumber = AIGuess;
        }
        if (humanGuess>secretNumber){
            System.out.println("User guess is too high.");
        } else if (humanGuess<secretNumber){
            System.out.println("User guess is too low.");
        }
        return results;
    }
}
