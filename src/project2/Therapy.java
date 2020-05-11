package project2;

import java.util.Arrays;
import java.util.Scanner;
public class Therapy {

    private static Scanner scnr = new Scanner(System.in);
    static String tempString = " ";
    static String userName = " ";
    final static String BOT_NAME = "Eliza";

    public static void main(String[] args) {
        
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

        //Step 6 (Store the first word, last word, and last character entered)
        //Step 6a. (Seperate the contents of the line entered)
        String [] contents = tempString.split(" ");
        //Step 6b. (Set userInput1)
        PromptBank.setUserInput1(contents[0]);
        //Step 6c. (Set userInput2)
        PromptBank.setUserInput2(contents[contents.length-1]);
        char lastChar = contents[contents.length-1].charAt(contents[contents.length-1].length()-1);

        //Step 7 (Conditional Response based on the last characted of the previous input)

        if (Character.toString(lastChar).contentEquals("!")){
            System.out.println(PromptBank.getDramaticStatement());
        }
        else if (Character.toString(lastChar).contentEquals("?")){
            System.out.println(PromptBank.getRandomQuestionTrunk());
        }
        else{
            System.out.println(PromptBank.getRandomStatementTrunk());
        }




        
    }

}