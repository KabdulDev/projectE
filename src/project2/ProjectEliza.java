/* 
Author: Karimu Mohammed
Title: Project Eliza
Description: A small proof of concept and rebuild of the famous Eliza psychotherapy "AI"
Github: https://github.com/KabdulDev/projectE.git
Youtube: https://youtu.be/5BHnugfXeWI
*/

package project2;

import java.util.Scanner;
public class ProjectEliza {

    private static Scanner scnr = new Scanner(System.in);
    static String tempString = " ";
    static String userName = " ";
    final static String BOT_NAME = "Eliza";
    static PromptBank session = new PromptBank();

    
    public static void therapist(){
        
        System.out.printf("Hello, my name is %s. What is your name?%n", BOT_NAME);

        tempString = scnr.nextLine();

        userName = tempString;

        System.out.printf("Hello %s. Tell me what is on your mind today in 1 sentence.%n", userName);

        tempString = scnr.nextLine();
        prompt(tempString);
        reRun();

    }

    public static void prompt(String tempString){
        
        while (!(tempString.equalsIgnoreCase("EXIT"))) {
            String[] contents = tempString.split(" ");

            session.setUserInput1(contents[0]);
            session.setUserInput2(contents[contents.length - 1]);
            char lastChar = contents[contents.length - 1].charAt(contents[contents.length - 1].length() - 1);


            if (Character.toString(lastChar).contentEquals("!")) {
                System.out.println(session.getDramaticStatement());
            } else if (Character.toString(lastChar).contentEquals("?")) {
                System.out.println(session.getRandomQuestionTrunk());
            } else {
                System.out.println(session.getRandomStatementTrunk());
            }

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


    public static void main(String [] args) {
        
        therapist();
        scnr.close();
       
    }

}