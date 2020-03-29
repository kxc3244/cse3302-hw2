// Chawla, Kevin.
// kxc3244
// 2020-03-29

import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Arrays;

//----------------------------------------------------------
public class hmwk_02 {
  public static void processToken( String token )
  {
    // Replace the following line with your code to classify
    // the string in 'token' according to your three Regular
    // Expressions and print the appropriate message.
    boolean first = false;
    boolean second = false;
    boolean third = false;
    first = token.matches("^(%|\\*)(%%|\\*\\*|%\\*|\\*%)*((J(J)*AY)|(p(p)*ay)|(J|p)*)$");
    second = token.matches("^(\\+([0-9A-F][0-9A-F])*(\\-|:))|(\\-([0-9A-F][0-9A-F])*(:|\\+))|(:([0-9A-F][0-9A-F])*(\\-|\\+))$");
    third = token.matches("^(\\|[AEIOU]*\\*)|(\\|[aeiou]*=)|(\\|\\$)$");

    // Rattle: ("^(\\+|-|:)$");

    if(first == true)
    {
      System.out.println(">"+token+"< matches PayJay.");
    }
    else if(second == true)
    {
      System.out.println(">"+token+"< matches Rattle.");
    }
    else if(third == true)
    {
      System.out.println(">"+token+"< matches Tork.");
    }
    else
    {
      System.out.println(">"+token+"< does not match.");
    }

   
  }

  //--------------------------------------------------------
  // DO NOT CHANGE anything below this line!
  public static void main( String[] args )
  {
    System.out.println( "processing tokens from " + args[ 0 ] + " ..." );

    try {
      Files.lines( Paths.get( args[ 0 ] ) ).filter(line -> line.length() > 0).forEachOrdered(
        line -> Arrays.stream( line.split( "\\s+" )  )
            .forEachOrdered( token -> processToken( token ) ) );
    } catch ( java.io.IOException e ) {
      e.printStackTrace();
    }
  }
}

//----------------------------------------------------------
