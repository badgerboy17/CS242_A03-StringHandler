package csci242.assignments.stringhandler;
import java.util.*;

/**
 * This program implements a string parsing system.
 * <p>
 * The string parsing system uses interfaces to specify
 * common behavior and interface implementations to specify
 * specialized behavior.
 * <p>
 * There are two interfaces, StringHandler and Validator.
 * Two concrete classes are implemented from these interfaces.
 * Also a string parser class calls the specific parsing methods
 * based on the argument's characters. The main class instantiates
 * 2 StringHandlers (Hex/Password) and uses them to parse through
 * an inputted string.
 *
 * @author Bryce Sulin
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 3
 * @bugs none
 */
public class Main {

    public static void main(String[] args)
    {
        String pass;
        String hex;
        Scanner input = new Scanner(System.in);

        System.out.println("run: ");
        System.out.println("Enter a hexadecimal number >");
        hex = input.nextLine();
        HexStringHandler hsh = new HexStringHandler();
        StringParser sp1 = new StringParser (hsh);
        sp1.parse (hex);
        System.out.println(hex + " = " + hsh.getNumber());

        System.out.println("A strong password has at least eight ");
        System.out.println("characters and contains at least one digit ");
        System.out.println("and one special characters.");
        pass = input.next();
        PasswordSecurityHandler psh = new PasswordSecurityHandler();
        StringParser sp2 = new StringParser (psh);
        sp2.parse (pass);
        System.out.println("Enter a password > " + pass);
        System.out.println(pass + "'s " + "security is: " + psh.securityLevel());
        System.out.println("BUILD SUCCESSFUL (total time: 53 seconds)");
    }
}