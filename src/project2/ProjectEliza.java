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

class PromptBank {

	String [] questions;
    String [] statements;
    private String userInput1;
    private String userInput2;
	
	public PromptBank(){
		questions = new String[3]; //initialize your array to the correct length to match your number of questions you populate it with
        statements = new String[3]; //initialize your array to the correct length to match your number of questions you populate it with
        populateStatementsArray();
        populateQuestionsArray();
		
	}

	public void populateStatementsArray(){
        statements[0] = "Tell me more about " + this.userInput1 + " and " + this.userInput2 + ".";
		statements[1] = this.userInput1 + " seems important to you, so does " + this.userInput2 + ". Please tell me more.";
		statements[2] = this.userInput1 + " and " + this.userInput2 + " seem to be on your mind. Let's talk about it.";
		
	}
	public void populateQuestionsArray(){
        questions[0] = "Is there anything else about " + this.userInput1 + " and "+ this.userInput2+"?";
		questions[1] = "Does "+ this.userInput1 +" bother you? How about "+ this.userInput2 +"?";
		questions[2] = "Are " + this.userInput1 +" and " + this.userInput2 + " things you think about often?";
		
		
		
	}
	
	public String getRandomStatementTrunk(){
        return statements[(int)(Math.random()*statements.length)];
	}
	
	
	public String getRandomQuestionTrunk(){
        return questions[(int)(Math.random()*questions.length)];
    }
    
    public String getDramaticStatement(){
        return "WOW! Dramtic! " + getRandomStatementTrunk();
    }
	
	public void setUserInput1(String userInput){
        this.userInput1=userInput;
        
    }

    public void setUserInput2(String userInput){
        if (userInput.endsWith(".")|| userInput.endsWith("?") || userInput.endsWith("!") ){
        this.userInput2=userInput.substring(0,userInput.length()-1);
        }
        else{
            this.userInput2=userInput.substring(0,userInput.length());
        }
        populateQuestionsArray();
        populateStatementsArray();
    }

    public String getUserInput1(){
        return userInput1;
    }

    public String getUserInput2(){
        return userInput2;
    }
	
}