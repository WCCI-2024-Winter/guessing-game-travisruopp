import java.util.Random;

public class GameLoop {
    private Keyboard keys = new Keyboard();
    private int secretNumber;
    private int maxLimit= 3;

    public GameLoop() {
        Random random = new Random();
        secretNumber = random.nextInt(10)+1;
    }
    
    public void StartUp(){
        System.out.println("Welcome to the guessing game!");
        boolean quitExit = false;
        while (!quitExit) {
            MainMenu.gameMenu();
            int result = keys.getInteger("Select an option to play: ", "123");
            switch (result) {
                case 1:
                    PlayGame();
                    break;
                case 2:
                    PlayAI aiGame = new PlayAI();
                    aiGame.PlayAIGame();
                    break;
                case 3:
                    quitExit = true;
                    break;
                default:
                    break;
            }
        }
    }

    private boolean PlayGame(){
        int count = 0;
        while(true){
            count++;
            if (count>maxLimit){
                System.out.println("You have reached your limit of guesses.");
                return false;
            }
            System.out.println("Guess a Number or 0 to exit?");
            System.out.println("You have " + (maxLimit-count+1) + " guesses left");
            int result = keys.getInteger("Guess a number between 1 and 10?", "-1012345678910");
            if (result == 0){
                System.out.println("Enter a number");
            } else if (result == -1) {
                return false;
            } else if (result==secretNumber){
                System.out.println("Winner Winner Chicken Dinner!");
                return false;
            } else if (result < secretNumber){
                System.out.println("Higher");
            } else if (result > secretNumber){
                System.out.println("Lower");
            } else {
                System.out.println("You lose!!");
            }
            
        }
        
    }
}
