package csci242.assignments.stringhandler;

/**
 * The PasswordSecurityHandler class is an implementation of StringHandler interface.
 * <p>
 * This class contains 3 private class variables: int length, boolean digit, boolean otherCharacter.
 * This class also has 1 public method: securityLevel().
 * This class also has 3 protected methods: getLength(), getDigit(), getOtherCharacter().
 * This class also has 3 specialized implementations from StringHandler interface.
 *
 * @author Bryce Sulin
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 3
 * @bugs none
 */
public class PasswordSecurityHandler implements StringHandler
{
    /**
     * SECURITY_LEVEL_WEAK constant describes the password security level.
     */
    public static final String SECURITY_LEVEL_WEAK = "weak";

    /**
     * SECURITY_LEVEL_MEDIUM constant describes the password security level.
     */
    public static final String SECURITY_LEVEL_MEDIUM = "medium";

    /**
     * SECURITY_LEVEL_STRONG constant describes the password security level.
     */
    public static final String SECURITY_LEVEL_STRONG = "strong";

    /**
     * length variable holds the number of characters in the password.
     */
    private int length;

    /**
     * digit variable is a flag that indicates a digit was found in the password.
     */
    private boolean digit;

    /**
     * otherCharacter is a flag that indicates an “other” character was found in the password.
     * "other" characters are neither a letter nor a digit.
     */
    private boolean otherCharacter;

    /**
     * Default class constructor.
     *
     */
    public PasswordSecurityHandler ()
    {
        length = getLength();
        digit = getDigit();
        otherCharacter = getOtherCharacter();
    }

    /**
     * Getter method for length variable.
     *
     * @return an int length.
     */
    protected int getLength ()
    {
        return length;
    }

    /**
     * Getter method for digit variable.
     *
     * @return a boolean digit.
     */
    protected boolean getDigit()
    {
        return digit;
    }

    /**
     * Getter method for otherCharacter variable.
     *
     * @return a boolean otherCharacter.
     */
    protected boolean getOtherCharacter ()
    {
        return otherCharacter;
    }

    /**
     * Method is the specialized implementation of the interface method.
     * It should make sure the argument is a digit,
     * then update length and digit appropriately.
     * It should throw an IllegalArgumentException if the argument is not a digit.
     *
     * @param digit is the character argument.
     */
    @Override
    public void processDigit(char digit)
    {
        if (Character.isDigit(digit))
        {
            this.digit = true;
            length++;
        }
        else if (!Character.isDigit(digit))
        {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Method is the specialized implementation of the interface method.
     * It should make sure the argument is a letter and update length appropriately.
     * It should throw an IllegalArgumentException if the argument is not a letter.
     *
     * @param letter is the character argument.
     */
    @Override
    public void processLetter(char letter)
    {
        if (Character.isLetter(letter))
        {
            length++;
        }
        else if (!Character.isLetter(letter))
        {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Method is the specialized implementation of the interface method.
     * It should make sure the argument is not a digit, letter or control character.
     * It should then update length and otherCharacter appropriately.
     * It should throw an IllegalArgumentException if the argument is incorrect.
     *
     * @param other is the character argument.
     */
    @Override
    public void processOther(char other)
    {
        if (!Character.isLetterOrDigit(other) || !Character.isISOControl(other))
        {
            otherCharacter = true;
            length++;
        }
        else if (Character.isLetterOrDigit(other) || Character.isISOControl(other))
        {
            throw new IllegalArgumentException();
        }
    }

    /**
     * securityLevel() method returns a String that represents the security level of password.
     *
     * @return a String that represents the security level of the password.
     */
    public String securityLevel ()
    {
        String security = "";
        if (length < 8 )
        {
            security = SECURITY_LEVEL_WEAK;
        }
        else if (length >= 8 && (digit || otherCharacter))
        {
            security = SECURITY_LEVEL_MEDIUM;
        }
        if (length >= 8 && digit && otherCharacter)
        {
            security = SECURITY_LEVEL_STRONG;
        }
        return security;
    }
}