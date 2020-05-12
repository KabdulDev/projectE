package project2;

import java.util.Scanner;
public class ProjectEliza {

    private static Scanner scnr = new Scanner(System.in);
    static String tempString = " ";
    static String userName = " ";
    final static String BOT_NAME = "Eliza";
    static PromptBank session = new PromptBank();

    
    public static void therapist(){
        
        //Step 1 (Introduce Eliza and Ask User their name)
        
        System.out.printf("Hello, my name is %s. What is your name?%n", BOT_NAME);

        //Step 2 (Grab the String the user enters in response)
        tempString = scnr.nextLine();

        //Step 3 (Assing the String to userName)
        userName = tempString;

        //Step 4 (Greet user by name & prompt user for Therapy Input)
        System.out.printf("Hello %s. Tell me what is on your mind today in 1 sentence.%n", userName);

        //Step 5 (Grab the String the user supplies in response)
        tempString = scnr.nextLine();
        prompt(tempString);
        reRun();

    }

    public static void prompt(String tempString){
        
        while (!(tempString.equalsIgnoreCase("EXIT"))) {
            // Step 1 (Store the first word, last word, and last character entered)
            // Step 1a. (Seperate the contents of the line entered)
            String[] contents = tempString.split(" ");
            // Step 1b. (Set userInput1)
            session.setUserInput1(contents[0]);
            // Step 1c. (Set userInput2)
            session.setUserInput2(contents[contents.length - 1]);
            char lastChar = contents[contents.length - 1].charAt(contents[contents.length - 1].length() - 1);

            // Step 2 (Conditional Response based on the last characted of the previous
            // input)

            if (Character.toString(lastChar).contentEquals("!")) {
                System.out.println(session.getDramaticStatement());
            } else if (Character.toString(lastChar).contentEquals("?")) {
                System.out.println(session.getRandomQuestionTrunk());
            } else {
                System.out.println(session.getRandomStatementTrunk());
            }

            // Step 3 (Get incoming line)
            tempString = scnr.nextLine();
        }
    }

    public static void reRun(){
        System.out.println("Do you want to run the session again?");
        tempString = scnr.nextLine();
        if(tempString.equalsIgnoreCase("yes")){
            therapist();
        }
        else if(tempString.equalsIgnoreCase("no")){
            System.out.println("Goodbye, until next time");
        }
        else{
            System.out.println("Please enter yes or no.");
            reRun();
        }

    }


    public static void promptTest(String tempString){
        
        while (!(tempString.equalsIgnoreCase("EXIT"))) {
            
            String[] contents = tempString.split(" ");
            
            session.setUserInput1(contents[0]);
            System.out.println(session.getUserInput1());
            
            // Step 1c. (Set userInput2)
            session.setUserInput2(contents[contents.length - 1]);
            System.out.println(session.getUserInput2());
            char lastChar = contents[contents.length - 1].charAt(contents[contents.length - 1].length() - 1);
            System.out.println(lastChar);

            tempString = "Exit";
        }
    }
    public static void main(String [] args) {
        
        therapist();
        //promptTest("Where do you fail?");

        
    }

}