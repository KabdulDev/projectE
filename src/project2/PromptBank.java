package project2;

public class PromptBank {

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