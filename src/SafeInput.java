import java.util.Scanner;

public class SafeInput {










    /**
     *
     * @param pipe Scanner
     * @param prompt Prompt user on what to enter
     * @param regEx Regular expression to match
     * @return a string in the format of regEx
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx){
        boolean done = false;
        String val = "";
        do{
            System.out.print(prompt + ": ");
            val = pipe.nextLine();
            if(val.matches(regEx)){
                done= true;
            }else {
                System.out.println("Enter a value that matches the pattern: "+regEx + " Not "+val);
                continue;
            }
        }while (!done);
        return val;
    }




    /**
     *
     * @param pipe Scanner
     * @param prompt Prompts the user
     * @return Returns
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt){
        boolean done = false;
        String val = "";
        do{
            System.out.print(prompt + " [Y/N]: ");
            val = pipe.nextLine();
            if(val.equalsIgnoreCase("Y")||val.equalsIgnoreCase("N")){
                done=true;
            }else {
                System.out.println("Enter Y or N");
                continue;
            }
        }while (!done);
        return val.equalsIgnoreCase("Y");
    }



    /** @param pipe Scanner
     * @param prompt Prompts the user
     * @param low Lower bound
     * @param high Upper bound
     * @return a double within the range
     */

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        boolean done = false;
        double val = 0;
        do{
            System.out.print(prompt + "["+low +", "+high+ "]: ");
            if (pipe.hasNextDouble()){
                val =pipe.nextDouble();
                if (val >= low && val <= high)
                    done= true;
                else {
                    System.out.println("The double is not in range. Must be larger than " +low +" and smaller than " + high );
                    continue;
                }
            }
            else{
                String trash = pipe.nextLine();
                System.out.println("Enter a valid double, not " + trash);
                continue;
            }
        }while (!done);
        return val;
    }



    /**
     * Gets a number from user and determines if it is within a bound
     * @param pipe Scanner
     * @param prompt Prompts the user
     * @param low Lower bound
     * @param high Upper bound
     * @return an int within the range
     */

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        boolean done = false;
        int val = 0;
        do{
            System.out.print(prompt + "["+low+" - "+high+"] : ");
            if (pipe.hasNextInt())
            {
                val =pipe.nextInt();
                pipe.nextLine();
                if (val >= low && val <= high)
                    done= true;
                else
                    System.out.println("The integer is not in range. Must be larger than " +low +" and smaller than " + high );


            }
            else{
                String trash = pipe.nextLine();
                System.out.println("Enter a valid integer, not " + trash);


            }
        }while (!done);
        return val;
    }


    /**
     * A method that gets a double from the user
     * @param pipe Scanner to read the double
     * @param prompt prompt user
     * @return a double value
     *
     *
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        boolean done = false;
        double val = 0;
        do{
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()){
                val =pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else{
                String trash = pipe.nextLine();
                System.out.println("Enter a valid double, not " + trash);
            }
        }while (!done);
        return val;
    }






    /**
     * A method that gets an integer from the user
     * @param pipe Scanner to read the Int
     * @param prompt prompt user
     * @return an int value
     *
     *
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        boolean done = false;
        double val = 0;
        do{
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()){
                val =pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else{
                String trash = pipe.nextLine();
                System.out.println("Enter a valid integer, not " + trash);
            }
        }while (!done);
        return (int) val;
    }




    /**
     *
     * @param msg
     */
    public static void prettyHeader(String msg){
        int totalWidth = 60;
        int sideStars = 3;
        for (int j = 0; j< totalWidth; j++){
            System.out.print("*");
        }
        System.out.println();
        System.out.print("***");
        int totalSpace = totalWidth - 6 - msg.length();
        int leftSpace = totalSpace / 2;
        int rightSpace = totalSpace - leftSpace;
        for (int j=0; j<leftSpace;j++ ){
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int j=0; j<rightSpace; j++){
            System.out.print(" ");
        }
        System.out.println("***");
        for (int j = 0; j< totalWidth; j++){
            System.out.print("*");
        }

    }









    /**
     * A method that gets a non-zero length String from the user.
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;

    }
}
