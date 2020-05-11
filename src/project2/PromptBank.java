package project2;

public class PromptBank {

	String [] questions;
    String [] statements;
    private static String userInput1;
    private static String userInput2;
	
	public PromptBank(){
		//questions = new String[   ]; //initialize your array to the correct length to match your number of questions you populate it with
		//statements = //initialize your array to the correct length to match your number of questions you populate it with
		
	}

	public void populateStatementsArray(){
		questions[0] = "Tell me more about " + userInput1 + " and " + userInput2;
		questions[1] = userInput1 + " seems important to you, so does " + userInput2 + ". Please tell me more.";
		questions[2] = userInput1 + " and " + userInput2 + " seem to be on your mind. Let's talk about it.";
		/*complete this method with your other statements using BLANK1 for word1
		 * and BLANK2 for word2 place holder 
		 */
	}
	public void populateQuestionsArray(){
		questions[0] = "Is there anything else about " + userInput1 + " and "+ userInput2+"?";
		questions[1] = "Does "+ userInput1 +" bother you? How about "+ userInput2 +"?";
		questions[2] = "Are " + userInput1 +" and " + userInput2 + " things you think about often?";
		
		/*complete this method with your other questions using BLANK1 for word1
		 * and BLANK2 for word2 place holder 
		 */
		
	}
	
	public static String getRandomStatementTrunk(){
		//fill in the method so it randomly selects the statement template
		//from the questions array ... hint use Math.random() to get the random index
        //so you can replace BLANK1 and BLANK2 with the appropriate words
        return "Statement";
	}
	
	
	public static String getRandomQuestionTrunk(){
		//fill in the method so it randomly selects the question template
		//from the questions array ... hint use Math.random() to get the random index
        //so you can replace BLANK1 and BLANK2 with the appropriate words
        return "Question";
    }
    
    public static String getDramaticStatement(){
        return "WOW! Dramtic!" + getRandomStatementTrunk();
    }
	
	public static void setUserInput1(String userInput){
        userInput1=userInput;
    }

    public static void setUserInput2(String userInput){
        userInput2=userInput.substring(0,userInput.length()-1);
    }

    public static String getUserInput1(){
        return userInput1;
    }

    public static String getUserInput2(){
        return userInput2;
    }
	
}