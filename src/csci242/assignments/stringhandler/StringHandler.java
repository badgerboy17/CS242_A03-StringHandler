package csci242.assignments.stringhandler;

/**
 * The StringHandler Interface implements two concrete classes & StringParser.
 * <p>
 * The interface contains 3 methods that process digit chars, letter chars,
 * and other chars. Each interface implementor must provide specialized implementations
 * of processDigit(), processLetter(), and processOther().
 *
 * @author Bryce Sulin
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 3
 * @bugs none
 */
public interface StringHandler
{
    void processDigit(char digit);
    void processLetter(char letter);
    void processOther(char other);
}
