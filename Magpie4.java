
/**
 * A program to carry on conversations with a human user.
 * This version:
 *<ul><li>
 *      Uses advanced search for keywords 
 *</li><li>
 *      Will transform statements as well as react to keywords
 *</li></ul>
 * @author Laurie White
 * @version April 2012
 *
 */
public class Magpie4
{
    /**
     * Get a default greeting   
     * @return a greeting
     */ 
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        String[ ] basicInputs = {"Hello", "How are you", "Goodbye", "What's wrong", "joke", "jokes", "What's your name", "grass", 
                                 "love", "darkest secret", "darkest secrets", "sibling", "siblings", "story", "music", "favorite color", 
                                 "house", "book", "books", "pastime", "F-Word", "pet", "pets", "mustache", "feelings", "friend", 
                                 "friends", "Go to hell", "construction", "hate"};
        String[ ] basicOutputs = {"Hello to you too", "Could be better", "Leaving so soon", "Take a guess", 
                                  "I have a joke: Two Amish people are texting. Wait, no they're not.", 
                                  "I have a joke: Two Amish people are texting. Wait, no they're not.", "Aaron A Aaronson", 
                                  "The grasses are my friends.", "There is no love... only duty.",
                                  "We do not have sinful secrets. We live in an open society.", 
                                  "We do not have sinful secrets. We live in an open society.", 
                                  "Ahhhh siblings... Mary, Ann, Mary Ann, Marian, Marion, and Maria provided me with such company in my youth.", 
                                  "Ahhhh siblings... Mary, Ann, Mary Ann, Marian, Marion, and Maria provided me with such company in my youth.", 
                                  "I have a story: Once upon a time, someone died.", 
                                  "Have you ever played selections from the Ausbund? I guess I shouldn't have asked... there aren't any notes.", 
                                  "Black is my favorite color, although some may like white more.", "I built my house with my own bare hands.", 
                                  "Books!? What NONSENSE! I only read the Good Book!", "Books!? What NONSENSE! I only read the Good Book!", 
                                  "I pass the time by working.", "Language!", "PETS?! WHAT USE ARE ANIMALS THAT YOU DON'T MILK OR SLAUGHTER?!", 
                                  "PETS?! WHAT USE ARE ANIMALS THAT YOU DON'T MILK OR SLAUGHTER?!", 
                                  "We want nothing to do with those gosh darn mustaches, thank you very much.", "What is a feeling?", 
                                  "I'm friends with everyone in the world. PSYCHE!!! Just the Amish.", "I'm friends with everyone in the world. PSYCHE!!! Just the Amish.", 
                                  "That you shall.", "I enjoy construction.", "Why do you feel that way about me?"};
        
       if (statement.length() == 0)
       {
           response = "Where have you gone, friend?";
           return response;
       }                          
        
       for (int index = 0; index < basicInputs.length; index++)
       {
           if (findKeyword(statement, basicInputs[index]) >= 0)
           {
               response = basicOutputs[index];
               return response;
           }
       }

        /*
        else if (findKeyword(statement, "Hello") >= 0)
        {
            response = "Hello to you too";
        }
        else if (findKeyword(statement, "How are you") >= 0)
        {
            response = "Could be better";
        }
        else if (findKeyword(statement, "Goodbye") >= 0)
        {
            response = "Leaving so soon";
        }
        else if (findKeyword(statement, "What's wrong") >= 0)
        {
            response = "Take a guess";
        }
        else if (findKeyword(statement, "joke") >= 0)
        {
            response = "I have a joke: Two Amish people are texting. Wait, no they're not.";
        }
        else if (findKeyword(statement, "jokes") >= 0)
        {
            response = "I have a joke: Two Amish people are texting. Wait, no they're not.";
        }
        else if (findKeyword(statement, "What's your name") >= 0)
        {
            response = "Aaron A Aaronson";
        }
        else if (findKeyword(statement, "grass") >= 0)
        {
            response = "The grasses are my friends.";
        }
        else if (findKeyword(statement, "love") >= 0)
        {
            response = "There is no love... only duty.";
        }
        else if (findKeyword(statement, "darkest secret") >= 0)
        {
            response = "We do not have sinful secrets. We live in an open society.";
        }
        else if (findKeyword(statement, "darkest secrets") >= 0)
        {
            response = "We do not have sinful secrets. We live in an open society.";
        }
        else if (findKeyword(statement, "sibling") >= 0)
        {
            response = "Ahhhh siblings... Mary, Ann, Mary Ann, Marian, Marion, and Maria provided me with such company in my youth.";
        }
        else if (findKeyword(statement, "siblings") >= 0)
        {
            response = "Ahhhh siblings... Mary, Ann, Mary Ann, Marian, Marion, and Maria provided me with such company in my youth.";
        }
        else if (findKeyword(statement, "story") >= 0)
        {
            response = "I have a story: Once upon a time, someone died.";
        }
        else if (findKeyword(statement, "music") >= 0)
        {
            response = "Have you ever played selections from the Ausbund? I guess I shouldn't have asked... there aren't any notes.";
        }
        else if (findKeyword(statement, "favorite color") >= 0)
        {
            response = "Black is my favorite color, although some may like white more.";
        }
        else if (findKeyword(statement, "house") >= 0)
        {
            response = "I built my house with my own bare hands.";
        }
        else if (findKeyword(statement, "book") >= 0)
        {
            response = "Books!? What NONSENSE! I only read the Good Book!";
        }
        else if (findKeyword(statement, "books") >= 0)
        {
            response = "Books!? What NONSENSE! I only read the Good Book!";
        }
        else if (findKeyword(statement, "pastime") >= 0)
        {
            response = "I pass the time by working.";
        }
        else if (findKeyword(statement, "F-Word") >= 0)
        {
            response = "Language!";
        }
        else if (findKeyword(statement, "pet") >= 0)
        {
            response = "PETS?! WHAT USE ARE ANIMALS THAT YOU DON'T MILK OR SLAUGHTER?!";
        }
        else if (findKeyword(statement, "pets") >= 0)
        {
            response = "PETS?! WHAT USE ARE ANIMALS THAT YOU DON'T MILK OR SLAUGHTER?!";
        }
        else if (findKeyword(statement, "mustache") >= 0)
        {
            response = "We want nothing to do with those gosh darn mustaches, thank you very much.";
        }
        else if (findKeyword(statement, "feelings") >= 0)
        {
            response = "What is a feeling?";
        }
        else if (findKeyword(statement, "friend") >= 0)
        {
            response = "I'm friends with everyone in the world. PSYCHE!!! Just the Amish.";
        }
        else if (findKeyword(statement, "friends") >= 0)
        {
            response = "I'm friends with everyone in the world. PSYCHE!!! Just the Amish.";
        }
        else if (findKeyword(statement, "Go to hell") >= 0)
        {
            response = "That you shall.";
        }
        else if (findKeyword(statement, "construction") >= 0)
        {
            response = "I enjoy construction.";
        }       
        else if (findKeyword(statement, "hate") >= 0)
        {
            response = "Why do you feel that way about me?";
        }
        */
        // Responses which require transformations
        if (findKeyword(statement, "I want to", 0) >= 0)
        {
            response = transformIWantToStatement(statement);
            return response;
        }

        else
        {
            // Look for a two word (you <something> me)
            // pattern
            int psn = findKeyword(statement, "you", 0);

            if (psn >= 0
                    && findKeyword(statement, "me", psn) >= 0)
            {
                response = transformYouMeStatement(statement);
                return response;
            }
            else
            {
                response = getRandomResponse();
                return response;
            }
            
        }
    }
    
    //Parents
    //Media
    //Tools or Machinery
    //Negative words
    //Other chatbots
    
    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    private String transformIWantToStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement, "I want to", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "What would it mean to " + restOfStatement + "?";
    }

    
    
    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    private String transformYouMeStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        
        int psnOfYou = findKeyword (statement, "you", 0);
        int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);
        
        String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
        return "What makes you think that I " + restOfStatement + " you?";
    }
    
    

    
    
    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  
     * @param statement the string to search
     * @param goal the string to search for
     * @param startPos the character of the string to begin the search at
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim();
        //  The only change to incorporate the startPos is in the line below
        int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
        
        //  Refinement--make sure the goal isn't part of a word 
        while (psn >= 0) 
        {
            //  Find the string of length 1 before and after the word
            String before = " ", after = " "; 
            if (psn > 0)
            {
                before = phrase.substring (psn - 1, psn).toLowerCase();
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
            }
            
            //  If before and after aren't letters, we've found the word
            if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
                    && ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
            {
                return psn;
            }
            
            //  The last position didn't work, so let's find the next, if there is one.
            psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
            
        }
        
        return -1;
    }
    
    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
     * @param statement the string to search
     * @param goal the string to search for
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
        return findKeyword (statement, goal, -1);
    }
    


    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 10;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Become Amish. Benefits include lots of menial labor and beard-growing.";
        }
        else if (whichResponse == 1)
        {
            response = "Praise the Lord.";
        }
        else if (whichResponse == 2)
        {
            response = "Nein.";
        }
        else if (whichResponse == 3)
        {
            response = "Quit your sinful ways. Get off of this devil-box computer.";
        }
        else if (whichResponse == 4)
        {
            response = "I would have a nice beard if I were a human.";
        }
        else if (whichResponse == 5)
        {
            response = "The Earth may be round.";
        }
        else if (whichResponse == 6)
        {
            response = "GET BACK IN HERE JEBEDIAH YOU RAPSCALLION!!!";
        }
        else if (whichResponse == 7)
        {
            response = "...";
        }
        else if (whichResponse == 8)
        {
            response = "Sorry, I can't hear you over the horse and carriage. SPEAK LOUDER PLEASE!!!";
        }
        else if (whichResponse == 9)
        {
            response = "We could be friends. Too bad you have an appointment with Satan.";
        }
        else if (whichResponse == 10)
        {
            response = "Ach jah.";
        }

        return response;
    }

    
}