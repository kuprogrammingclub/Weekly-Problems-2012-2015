import java.util.Scanner;
import java.lang.StringBuilder;
import java.lang.Math;

public class funnyCheck {

    //main function will gather user input, check validity, run funnyCheck test, output results
    public static void main (String[] args)
    {
        System.out.println( "Number of Words to check: " + args[0] );
        System.out.println( "Words to check: " );

        boolean[] resultsArray = new boolean[args.length - 1];

        //run funnyChecker on all words passed in
        for (int i = 1; i < args.length; i++)
        {
            System.out.println( args[i] + " " + funnyChecker( args[i] ) );
        }
    }

    //private method to handle Funny check
    private static String funnyChecker( String a )
    {
        //reverse a and save as String b
        String b = new StringBuilder(a).reverse().toString();

        boolean isFunny = true;

        int val1, val2;

        for( int i = 1; i < a.length(); i++ )
        {

            //cast each char value to an int, take absolute value
            val1 = Math.abs( ( (int) a.charAt(i) ) - ( (int) a.charAt( i - 1 ) ) );
            val2 =  Math.abs( ( (int) b.charAt(i) ) - ( (int) b.charAt( i - 1 ) ) );

            if( val1 != val2 )
            {
                isFunny = false;
            }

        }//end for

        if( isFunny != true )
        {
            return("Not Funny");
        }
        else
        {
            return("Funny");
        }
    }

}
