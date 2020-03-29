// Chawla, Kevin.
// kxc3244
// 2020-03-29

#include <fstream>
#include <iostream>
#include <regex>

using namespace std;

//----------------------------------------------------------
void processToken( string token )
{
  // Replace the following line with your code to classify
  // the string in 'token' according to your three Regular
  // Expressions and print the appropriate message.

  regex first("^(%|\\*)(%%|\\*\\*|%\\*|\\*%)*((J(J)*AY)|(p(p)*ay)|(J|p)*)$");
  regex second("^(\\+([0-9A-F][0-9A-F])*(\\-|:))|(\\-([0-9A-F][0-9A-F])*(:|\\+))|(:([0-9A-F][0-9A-F])*(\\-|\\+))$");
  regex third("^(\\|[AEIOU]*\\*)|(\\|[aeiou]*=)|(\\|\\$)$");

  if (regex_match(token, first))
  {
    cout << ">" << token << "< matches PayJay.\n";
  }
  else if(regex_match(token, second))
  {
    cout << ">" << token << "< matches Rattle.\n";
  }
  else if(regex_match(token, third))
  {
    cout << ">" << token << "< matches Tork.\n";
  }
  else
  {
    cout << ">" << token << "< does not match.\n";
  }

  //cout << ">" << token << "< is the proposed token.\n";
}

//----------------------------------------------------------
// DO NOT CHANGE anything below this line!
int main( int argc, char *argv[] )
{
  if ( argc > 1 ) {
    cout << "processing tokens from " << argv[ 1 ] << " ...\n";

    ifstream inputFile;
    string   token;

    inputFile.open( argv[ 1 ] );

    if ( inputFile.is_open() ) {
      while ( inputFile >> token ) {
        processToken( token );
      }
      inputFile.close();
    } else {
      cout << "unable to open " << argv[ 1 ] << "?\n";
    }
  } else {
    cout << "No input file specified.\n";
  }
}

//----------------------------------------------------------
