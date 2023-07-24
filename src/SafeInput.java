
import java.security.PublicKey;
import java.text.MessageFormat;
import java.util.Scanner;

public class SafeInput 
{
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;
    }
    public static int getInt(Scanner pipe, String prompt)
    {
        /**
         * Get a Verified integer of any number or range
         * @param pipe a Scanner opened to read from System.in
         * @param prompt prompt for the user
         * @return an Integer of any range
         */
        int result = 0;
        boolean done = false;
        String trash = "";
        do {
            System.out.println("\n" +prompt + ": "); //show prompt add space
            if(pipe.hasNextInt())
            {
                result = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else {
                trash = pipe.nextLine();
                System.out.println("You have entered: " +trash + "\n Please enter a valid integer");
                done = false;
            }
        }while(!done);
        return result;
    }
    public static double getDouble(Scanner pipe, String prompt)
    {
        /**
         * Get a Verified double integer of any number or range
         * @param pipe s Scanner opented to read from System.in
         * @param prompt prompt for the user
         * @return a Double Integer of any range
         */
        double result = 0;
        boolean done = false;
        String trash = "";
        do {
            System.out.print("\n" +prompt + ": "); //show prompt add space
            if(pipe.hasNextDouble())
            {
                result = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else {
                trash = pipe.nextLine();
                System.out.print("You have entered: " +trash + "\n Please enter a valid double integer");
                done = false;
            }
        }while(!done);
        return result;
    }
    public static int getRangedInt(Scanner pipe, String prompt, int lo, int hi)
    {
        int result =0;
        boolean done = false;
        String trash = "";
        do {
            System.out.print(prompt + " [" + lo + " - " + hi + "]: ");
            if (pipe.hasNextInt()){
                result = pipe.nextInt();
                pipe.nextLine();
                if(result >= lo && result <= hi){
                    done = true;
                }
                else {
                    System.out.println("You must enter a valid int in the range [" + lo + " - " + hi + "] ");
                    done = false;
                }
            }
            else {
                trash = pipe.nextLine();
                System.out.println("You must enter an int [" + lo + " - " + hi + "]: ");
            }
        }while(!done);
        return result;
    }
    public static double getRangedDouble(Scanner pipe, String prompt, double lo, double hi)
    {
        double result = 0.0;
        boolean done = false;
        String trash = "";
        do {
            System.out.print(prompt + " [" + lo + " - " + hi + "]: ");
            if (pipe.hasNextDouble()){
                result = pipe.nextDouble();
                pipe.nextLine();
                if(result >= lo && result <= hi){
                    done = true;
                }
                else {
                    System.out.println("You must enter a valid double in the range [" + lo + " - " + hi + "] ");
                    done = false;
                }
            }
            else {
                trash = pipe.nextLine();
                System.out.println("You must enter a double [" + lo + " - " + hi + "]: ");
            }
        }while(!done);
        return result;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String trueFalse = "";
        boolean result = false;
        boolean done = false;
        do {
            System.out.println(prompt + ": ");
            trueFalse = pipe.nextLine();
            if(trueFalse.equalsIgnoreCase("Y"))
            {
                result = true;
                done = true;
            } else if (trueFalse.equalsIgnoreCase("N")) {
                result = false;
                done = true;
            }else {
                System.out.println("You must choose Y or N not " + trueFalse);
                done = false;
            }
        }while(!done);
        return result;
    }
 public static String getRegExString(Scanner pipe, String prompt, String regExPattern)
    {
        String value = "";
        boolean gotValue = false;
        do {
            System.out.print(prompt + ": ");
            value = pipe.nextLine();
            if (value.matches(regExPattern)){
                gotValue = true;
            }
            else {
                System.out.println("\n Invalid input: " + value);
            }
        }while(!gotValue);
        return value;
    }
    public static String prettyHeader(Scanner pipe, String msg) {
        int totalWidth = 60;
        int width;
        int msgLength = msg.length();
        int sides = (totalWidth - msgLength - 6) / 2;
        String header = "";

        for (width = 0; width < totalWidth; width++) {
            header += "*";
        }
        header += "\n";

        header += "***";
        for (width = 0; width < sides; width++) {
            header +=" ";
        }
        header += msg;
        for (width = 0; width < sides; width++) {
            header +=" ";
        }
        header +="***\n";

        for (width = 0; width < totalWidth; width++) {
            header +="*";
        }
        header += "\n";
    return header;
    }

}
