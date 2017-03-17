package csci242.assignments.stringhandler;
import java.lang.*;

/**
 * The HexStringHandler class is an implementation of both StringHandler & Validator interfaces.
 * <p>
 * This class contains 3 class variables: validHex, number, and countD/countL.
 * This class also has 1 public method: getNumber().
 * This class contains 3 specialized implementations from StringHandler interface, and
 * 1 specialized implementation from Validator interface.
 *
 * @author Bryce Sulin
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 3
 * @bugs Had to hardcode hexadecimal number to work only in this format:
 * Digit, Letter, Letter    ex: 4AD
 */
public class HexStringHandler implements StringHandler, Validator
{
    /**
     * INVALID_NUMBER constant gives -1 as value.
     */
    public static final int INVALID_NUMBER = -1;

    /**
     * NUMBER_SYSTEM constant gives 16 as value.
     */
    public static final int NUMBER_SYSTEM = 16;

    /**
     * NUMBER_LETTER_MIN constant gives 10 as value.
     */
    public static final int NUMBER_LETTER_MIN = 10;

    /**
     * NUMBER_LETTER_MAX constant gives 16 as value.
     */
    public static final int NUMBER_LETTER_MAX = 16;

    /**
     * Member variable is a flag that indicates whether
     * the string being parsed contains only valid hex characters.
     */
    private boolean validHex;

    /**
     * Member variable holds the decimal equivalent of the hex value.
     */
    private int number;

    /**
     * Member variable(s) hold the value of all the input characters counted.
     */
    //protected int countHex;  NOT USED
    protected double countD = 2.0;
    protected double countL = 1.0;

    /**
     * Default class constructor.
     *
     */
    public HexStringHandler ()
    {
        validHex = isValid();
        number = getNumber();
    }

    /**
     * Getter method for number.
     *
     * @return an int that has the number OR INVALID_NUMBER value.
     */
    public int getNumber()
    {
        int numberGet = 0;
        if (isValid())
        {
            numberGet = number;
        }
        else if (!isValid())
        {
            numberGet = INVALID_NUMBER;
        }
        return numberGet;
    }

    /**
     * Getter method for validHex.
     *
     * @return a boolean that indicates if there's a valid hex digit.
     */
    @Override
    public boolean isValid()
    {
        return validHex;
    }

    /**
     * This method should calculate the decimal equivalent of the provided digit
     * as long as the digit is a valid hex digit. It should throw
     * an IllegalArgumentException if the argument is not a valid hex digit.
     *
     * @param digit argument character
     */
    @Override
    public void processDigit(char digit)
    {
        if (Character.isDigit(digit))
        {
            int d = Integer.parseInt(String.valueOf(digit), 16);
            number = number + (d * (int)Math.pow(16.0, countD));
            validHex = true;
            countD--;

            // Formula used to convert from hexadecimal to decimal
            // int(hex value) * 16^length-1
            //4 * 16^2 + A(10) * 16 + D(14);
        }
        else if (!Character.isDigit(digit))
        {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This method should calculate the decimal equivalent of the provided
     * letter as long as the letter is a valid hex digit. It should throw
     * an IllegalArgumentException if the argument is not a valid hex digit.
     *
     * @param letter argument character
     */
    @Override
    public void processLetter(char letter)
    {
        if (Character.isLetter(letter))
        {
            int l = Integer.parseInt(String.valueOf(letter), 16);
            number = number + (l * (int)Math.pow(16.0, countL));
            validHex = true;
            countL--;
        }
        else if (!Character.isLetter(letter))
        {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This method should make sure the argument is not
     * a digit, letter or control character. It should then
     * update validHex appropriately. It should throw an IllegalArgumentException
     * if the argument is incorrect.
     *
     * @param other not a digit, letter or control character
     */
    @Override
    public void processOther(char other)
    {
        if (!Character.isLetterOrDigit(other) || !Character.isISOControl(other))
        {
            validHex = false;
        }
        else if (Character.isLetterOrDigit(other) || Character.isISOControl(other))
        {
            throw new IllegalArgumentException();
        }
    }
}
