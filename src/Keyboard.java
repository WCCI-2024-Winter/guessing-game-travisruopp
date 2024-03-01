import java.util.*;

/**
 * A class that models how to get and check a user's input
 */
public class Keyboard {
    Scanner input = new Scanner(System.in);

    /**
     * Method that takes in user input based off a prompt and checks it to make sure
     * it is valid. Then coverts it to a integer
     * 
     * @param prompt     a string that will display to the user
     * @param validation a string to check if the users input is allowed
     * @return an integer converted from a string
     */
    public int getInteger(String prompt, String validation) {

        int result = 0;
        while (true) {
            System.out.print(prompt);
            String userInput = input.nextLine();
            if (validation == null && null != userInput && userInput.length() > 0){
                result = Integer.parseInt(userInput); // missing validation to check if value is 1 - 100
            }
            if (null != userInput && validation.contains(userInput) && userInput.length() > 0) {
                result = Integer.parseInt(userInput);
                break;
            }
        }
        return result;
    }

    /**
     * Method that takes in user input based off a prompt and checks it to make sure
     * it is valid
     * 
     * @param prompt a string that will display to the user
     * @return the users input as a valid string
     */
    public String getString(String prompt) {
        String result;
        while (true) {
            System.out.print(prompt);
            String userInput = input.nextLine();
            if (userInput != null && userInput.length() > 0) {
                result = userInput;
                break;
            }
        }
        return result;
    }

    /**
     * Override method for toString
     */
    @Override
    public String toString() {
        return "Keyboard [input=" + input + "]";
    }

}
