package csci242.assignments.stringhandler;

/**
 * The StringParser class is an implementation of StringHandler interface.
 * <p>
 * This class contains 1 private class variable: StringHandler handler
 * This class also has 1 public method: parse().
 *
 * @author Bryce Sulin
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 3
 * @bugs none
 */
public class StringParser
{
    /**
     * StringHandler-type object member variable
     */
    private StringHandler handler;

    /**
     * String member variable that contains the parse(string b) argument string
     */
    //protected String s;  NOT USED

    /**
     * Default Constructor
     *
     * @param handler is a StringHandler-type object
     */
    public StringParser(StringHandler handler)
    {
        this.handler = handler;
    }

    /**
     * This method takes the String to parse as a parameter
     * and walks through the String, determining the type of character,
     * and calling the appropriate method of the StringHandler interface
     * for each character.
     *
     * @param b String that is parsed through character by character.
     */
    public void parse(String b)
    {
        for (int i = 0; i < b.length(); i++)
        {
            char c = b.charAt(i);
            if (Character.isLetter(c))
            {
                handler.processLetter(c);
            }
            else if (Character.isDigit(c))
            {
                handler.processDigit(c);
            }
            else if (!Character.isLetterOrDigit(c) || !Character.isISOControl(c))
            {
                handler.processOther(c);
            }
        }
    }
}