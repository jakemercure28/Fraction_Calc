import java.util.*;

public class FracCalcchanged {
   public static void main(String[] args) {
      Scanner scannerinput = new Scanner(System.in);
      System.out.println("Hello, welcome to my fraction calculator program."); 
      System.out.println("When prompted, enter an equation that uses underscores to separate a whole number and its fraction, a forward slash to create a fraction, and spaces to separate the operands and operators.");
      System.out.println("Enter 'test' to run test cases or 'quit' to end the program.");
      System.out.println();
      System.out.print("Enter your equation: ");
      String user = scannerinput.nextLine();               //first user input
      
      String test = "test";
      String quit = "quit";
     
      if (user.equals(quit)) {       //runs test cases if user inputs 'quit'
         System.out.println();
         System.out.print("Thank you for using Frac Calc.");
         return;            
      }
      else if (user.equals(test)) {       //ends program if user inputs 'test'
         runTests();            
      }
      else {
         String userinput = produceAnswer(user);   //runs users input through produceAnswer if neither 'test' nor 'quit' was entered
         System.out.print(userinput);
         System.out.println();
      }
   
      while (user != quit) {        //while loop that continously asks user for input until 'quit' is entered
         System.out.println();
         System.out.print("Enter equation: ");  
         user = scannerinput.nextLine();
         if (user.equals(test)) {   //runs test cases if user inputs 'test'
            runTests();
         }
         else if (user.equals(quit)) {    //ends program if user inputs 'quit'
            System.out.println();
            System.out.print("Thank you for using Frac Calc.");
            return;
         }
         else {
            String answer = produceAnswer(user);   //runs users input through produceAnswer if neither 'test' nor 'quit' was entered
            System.out.print(answer);
            System.out.println();
         }
      }
   }   
   
   public static String produceAnswer(String input) {
      int w = 0;     //whole
      int n = 0;     //numerator
      int d = 0;     //denominator
      String fraction1 = "";
      String operand = "";
      String fraction2 = "";
      
      
      
      System.out.println(input);
         
      
      String finalAnwser = "";
    
      StringTokenizer str = new StringTokenizer(input, " "); //separates string
      String part1 = str.nextToken();                 //first fraction
      String part2 = str.nextToken();                          //operator 
      String part3 = str.nextToken(); //second fraction
      System.out.println("Fraction 1: " + part1); 
      System.out.println("Operation: " + part2); 
      System.out.println("Fraction 2: " + part3); 
        
      if (part1.contains("_")) {                
         String[] parts1 = part1.split("_|/");
         int whole = Integer.parseInt(parts1[0]);
         int numerator = Integer.parseInt(parts1[1]);
         int denominator = Integer.parseInt(parts1[2]);        //if first operand has whole number, nominator, and denominator
         if (whole < 0) {
            numerator = numerator * -1;
         }  
         w = whole;
         n = numerator;
         d = denominator;       
      }
      
      else if (part1.contains("/") && !part1.contains("_")) {
         String[] parts2 = part1.split("/");
         int whole1 = 0;
         int numerator1 = Integer.parseInt(parts2[0]);
         int denominator1 = Integer.parseInt(parts2[1]);       //if first operand has nominator and denominator but no whole number
         w = whole1;
         n = numerator1;
         d = denominator1; 
      }
      
      else if (!part1.contains("/") && !part1.contains("_")) {
         int wholefinal = Integer.parseInt(part1);
         int numeratorfinal = 0;
         int denominatorfinal = 1;            //if first operand has whole number but no fraction
         w = wholefinal;
         n = numeratorfinal;
         d = denominatorfinal;   
      
      }
      
      if (part3.contains("_")) {                //lines 69-91 parse the second operand and return its different parts + parts of first operand from first 3 if and else if statements using w,n,d
         String[] parts3 = part3.split("_|/");
         int whole2 = Integer.parseInt(parts3[0]);
         int numerator2 = Integer.parseInt(parts3[1]);
         int denominator2 = Integer.parseInt(parts3[2]);
         if (whole2 < 0) {
            numerator2 = numerator2 * -1;
         }
         if (part2.contains("+")) {                                        //if and else if statements determine if equations contains addition, subtraction, multiplication, or division
            finalAnwser = addition(w,n,d,whole2,numerator2,denominator2);
            return finalAnwser;
         }
         else if (part2.contains("-")) {
            finalAnwser = subtraction(w,n,d,whole2,numerator2,denominator2);
            return finalAnwser;
         }
         else if (part2.contains("*")) {
            finalAnwser = multiplication(w,n,d,whole2,numerator2,denominator2);
            return finalAnwser;
         }
         else {
            finalAnwser = division(w,n,d,whole2,numerator2,denominator2);
            return finalAnwser;
         }      
      }
      
      else if (part3.contains("/") && !part3.contains("_")) {
         String[] parts4 = part3.split("/");
         int whole3 = 0;
         int numerator3 = Integer.parseInt(parts4[0]);
         int denominator3 = Integer.parseInt(parts4[1]);
         if (part2.contains("+")) {                                        //if and else if statements determine if equations contains addition, subtraction, multiplication, or division
            finalAnwser = addition(w,n,d,whole3,numerator3,denominator3);
            return finalAnwser;
         }
         else if (part2.contains("-")) {
            finalAnwser = subtraction(w,n,d,whole3,numerator3,denominator3);
            return finalAnwser;
         }
         else if (part2.contains("*")) {
            finalAnwser = multiplication(w,n,d,whole3,numerator3,denominator3);
            return finalAnwser;
         }
         else {
            finalAnwser = division(w,n,d,whole3,numerator3,denominator3);
            return finalAnwser;
         }
      }
      else if (!part3.contains("/") && !part3.contains("_")) {
         int wholefinal1 = Integer.parseInt(part3);
         int numeratorfinal1 = 0;
         int denominatorfinal1 = 1;
         if (part2.contains("+")) {                                                       //if and else if statements determine if equations contains addition, subtraction, multiplication, or division
            finalAnwser = addition(w,n,d,wholefinal1,numeratorfinal1,denominatorfinal1);
            return finalAnwser; 
         }
         else if (part2.contains("-")) {
            finalAnwser = subtraction(w,n,d,wholefinal1,numeratorfinal1,denominatorfinal1);
            return finalAnwser;
         }
         else if (part2.contains("*")) {
            finalAnwser = multiplication(w,n,d,wholefinal1,numeratorfinal1,denominatorfinal1);
            return finalAnwser;
         }
         else {
            finalAnwser = division(w,n,d,wholefinal1,numeratorfinal1,denominatorfinal1);
            return finalAnwser;
         }
      }
      
      else {
         return finalAnwser;        //returns correctly parsed operands based on what operator was used and passes it to correct method
      }     
   }
   
   public static String addition (int leftWhole,int leftNumerator,int leftDenominator,int rightWhole,int rightNumerator,int rightDenominator) {          //addition method
      int start = rightDenominator;
      int rcd = 0;
      int lcd = 0;
      int theAnwserNumerator = 0;                           //method finds correct common denominator using while loop and multiplies denominator and numerator to match it
      int theAnwserDenominator = 0;
      String theAnwserNumeratorString;
      String theAnwserDenominatorString;
      String additionAnwser;
      int leftAnwser = (leftWhole * leftDenominator) + leftNumerator;
      int rightAnwser = (rightWhole * rightDenominator) + rightNumerator;
      if (leftDenominator < rightDenominator) {                                  //if left denominator is smaller than right, while loop finds common denominator
         while(start/rightDenominator == 0 || start/rightDenominator == 1 && start/leftDenominator == 0 || start/leftDenominator == 0 || start%leftDenominator != 0 || start%rightDenominator != 0) {
            start++;
         }
         rcd = start/rightDenominator;
         lcd = start/leftDenominator;
         leftNumerator = leftAnwser * lcd;
         leftDenominator = leftDenominator * lcd;
         rightNumerator = rightAnwser * rcd;
         rightDenominator = rightDenominator * rcd;
         theAnwserNumerator = leftNumerator + rightNumerator;
         theAnwserNumeratorString = Integer.toString(theAnwserNumerator);              //changes int into a string so a dash can be placed in middle of numerator and denominator
         theAnwserDenominator = leftDenominator;
         theAnwserDenominatorString = Integer.toString(theAnwserDenominator);
         additionAnwser = (theAnwserNumeratorString + "/" + theAnwserDenominatorString);
         String additionReduced = reduce(additionAnwser);
         return additionReduced;  
      
      }
      
      else if (rightDenominator == leftDenominator) {                                                                               //if denominator is same then fractions are just added
         theAnwserNumerator = ((leftWhole * leftDenominator) + leftNumerator) + ((rightWhole * rightDenominator) + rightNumerator);
         theAnwserNumeratorString = Integer.toString(theAnwserNumerator);
         theAnwserDenominator = leftDenominator;
         theAnwserDenominatorString = Integer.toString(theAnwserDenominator);
         additionAnwser = (theAnwserNumeratorString + "/" + theAnwserDenominatorString);
         String additionReduced1 = reduce(additionAnwser);
         return additionReduced1;
      }
      else {
         start = leftDenominator;
         while (start/leftDenominator == 0 || start/leftDenominator == 1 && start/rightDenominator == 0 || start/rightDenominator == 0 || start%rightDenominator != 0 || start%leftDenominator != 0) {       //if left denominator is greater than right denominator, while loop finds common denominator
            start++;
         }
         rcd = start/rightDenominator;
         lcd = start/leftDenominator;
         leftNumerator = leftAnwser * lcd;
         leftDenominator = leftDenominator * lcd;
         rightNumerator = rightAnwser * rcd;
         rightDenominator = rightDenominator * rcd;
         theAnwserNumerator = leftNumerator + rightNumerator;
         theAnwserNumeratorString = Integer.toString(theAnwserNumerator);
         theAnwserDenominator = leftDenominator;
         theAnwserDenominatorString = Integer.toString(theAnwserDenominator);
         additionAnwser = (theAnwserNumeratorString + "/" + theAnwserDenominatorString);
         String additionReduced2 = reduce(additionAnwser);
         return additionReduced2;                                                //additional answer is returned and gives correct fraction
      }
   }
 
   public static String subtraction (int leftWhole1,int leftNumerator1,int leftDenominator1,int rightWhole1,int rightNumerator1,int rightDenominator1) {       //subtraction method
      int start1 = rightDenominator1;
      int rcd1 = 0;                                      //does the same thing as addition method with same structure but uses subtraction to find final fraction
      int lcd1 = 0;                                                                 
      int theAnwserNumerator1 = 0;
      int theAnwserDenominator1 = 0;
      String subtractionAnwser;
      String theAnwserNumeratorString1;
      String theAnwserDenominatorString1;
      int leftAnwser1 = (leftWhole1 * leftDenominator1) + leftNumerator1;
      int rightAnwser1 = (rightWhole1 * rightDenominator1) + rightNumerator1;
      if (leftDenominator1 < rightDenominator1) {                                
         while(start1/rightDenominator1 == 0 || start1/rightDenominator1 == 1 && start1/leftDenominator1 == 0 || start1/leftDenominator1 == 0 || start1%leftDenominator1 != 0 || start1%rightDenominator1 != 0) {
            start1++;
         }
         rcd1 = start1/rightDenominator1;
         lcd1 = start1/leftDenominator1;
         leftNumerator1 = leftAnwser1 * lcd1;
         leftDenominator1 = leftDenominator1 * lcd1;
         rightNumerator1 = rightAnwser1 * rcd1;
         rightDenominator1 = rightDenominator1 * rcd1;
         theAnwserNumerator1 = leftNumerator1 - rightNumerator1;
         theAnwserNumeratorString1 = Integer.toString(theAnwserNumerator1);
         theAnwserDenominator1 = leftDenominator1;
         theAnwserDenominatorString1 = Integer.toString(theAnwserDenominator1);
         subtractionAnwser = (theAnwserNumeratorString1 + "/" + theAnwserDenominatorString1);
         String subtractionReduced = reduce(subtractionAnwser);
         return subtractionReduced;
      }
      else if (rightDenominator1 == leftDenominator1) {
         theAnwserNumerator1 = ((leftWhole1 * leftDenominator1) + leftNumerator1) - ((rightWhole1 * rightDenominator1) + rightNumerator1);
         theAnwserNumeratorString1 = Integer.toString(theAnwserNumerator1);
         theAnwserDenominator1 = leftDenominator1;
         theAnwserDenominatorString1 = Integer.toString(theAnwserDenominator1);
         subtractionAnwser = (theAnwserNumeratorString1 + "/" + theAnwserDenominatorString1);
         String subtractionReduced1 = reduce(subtractionAnwser);
         return subtractionReduced1;
      }
      
      else {
         start1 = leftDenominator1;
         while (start1/leftDenominator1 == 0 || start1/leftDenominator1 == 1 && start1/rightDenominator1 == 0 || start1/rightDenominator1 == 0 || start1%rightDenominator1 != 0 || start1%leftDenominator1 != 0) {
            start1++;
         }
         rcd1 = start1/rightDenominator1;
         lcd1 = start1/leftDenominator1;
         leftNumerator1 = leftAnwser1 * lcd1;
         leftDenominator1 = leftDenominator1 * lcd1;
         rightNumerator1 = rightAnwser1 * rcd1;
         rightDenominator1 = rightDenominator1 * rcd1;
         theAnwserNumerator1 = leftNumerator1 - rightNumerator1;
         theAnwserNumeratorString1 = Integer.toString(theAnwserNumerator1);
         theAnwserDenominator1 = leftDenominator1;
         theAnwserDenominatorString1 = Integer.toString(theAnwserDenominator1);
         subtractionAnwser = (theAnwserNumeratorString1 + "/" + theAnwserDenominatorString1);
         String subtractionReduced2 = reduce(subtractionAnwser);
         return subtractionReduced2;     
      }
   }
   public static String multiplication (int leftWhole2,int leftNumerator2,int leftDenominator2,int rightWhole2,int rightNumerator2,int rightDenominator2) {       //multiplication method
      int topRight = (leftWhole2 * leftDenominator2) + leftNumerator2;
      int topLeft = (rightWhole2 * rightDenominator2) + rightNumerator2;                  //multiplies tops of fractions and bottoms of both fractions
      int topAnwser = topRight * topLeft;
      int bottomAnwser = leftDenominator2 * rightDenominator2;
      String topAnwserString = Integer.toString(topAnwser);
      String bottomAnwserString = Integer.toString(bottomAnwser);
      String multiplicationAnwser = (topAnwserString + "/" + bottomAnwserString);
      String multiplicationReduced = reduce(multiplicationAnwser);
      return multiplicationReduced;
   }
   
   public static String division (int leftWhole3,int leftNumerator3,int leftDenominator3,int rightWhole3,int rightNumerator3,int rightDenominator3) {          //division methods
      int topLeft1 = (leftWhole3 * leftDenominator3) + leftNumerator3;
      int topRight1 = (rightWhole3 * rightDenominator3) + rightNumerator3;                //flips second fraction and multiplies tops and bottoms of both fractions
      rightNumerator3 = rightDenominator3;
      rightDenominator3 = topRight1;
      int topAnwser1 = topLeft1 * rightNumerator3;
      int bottomAnwser1 = leftDenominator3 * rightDenominator3;
      String topAnwser2 = Integer.toString(topAnwser1);
      String bottomAnwser2 = Integer.toString(bottomAnwser1);
      String divisionAnwser = (topAnwser2 + "/" + bottomAnwser2);
      String divisionReduced = reduce(divisionAnwser);
      return divisionReduced;
   }
   
   public static String reduce (String reducedAnwser) {
      String finalReducedAnwser = "";
      String[] fractionSplit = reducedAnwser.split("/");
      String numeratorReduced = fractionSplit [0];
      String denominatorReduced = fractionSplit [1];
      int numeratorIntReduced = Integer.parseInt(numeratorReduced);
      int denominatorIntReduced = Integer.parseInt(denominatorReduced);
      if (Math.abs(numeratorIntReduced) == Math.abs(denominatorIntReduced)) {
         if (numeratorIntReduced < 0 && denominatorIntReduced > 0 || numeratorIntReduced > 0 && denominatorIntReduced < 0) {
            String answerOfNegativeOne = "-1";
            return answerOfNegativeOne;
         }
         else {
            String answerOfOne = "1";
            return answerOfOne;
         }
      }
      int factor = Math.abs(numeratorIntReduced) + Math.abs(denominatorIntReduced);
      while (numeratorIntReduced % factor != 0 && denominatorIntReduced % factor != 0 
      || numeratorIntReduced % factor == 0 && denominatorIntReduced % factor != 0 
      || numeratorIntReduced % factor != 0 && denominatorIntReduced % factor == 0) {
         factor--;
      }
      numeratorIntReduced = numeratorIntReduced / factor;
      denominatorIntReduced = denominatorIntReduced / factor;
      int wholeNumber = 0;
      if (Math.abs(numeratorIntReduced) > Math.abs(denominatorIntReduced)) {
         while(Math.abs(numeratorIntReduced) > Math.abs(denominatorIntReduced)) {
            if (numeratorIntReduced < 0) {
               numeratorIntReduced = numeratorIntReduced + denominatorIntReduced;
               wholeNumber--;
            }
            else {
               numeratorIntReduced = numeratorIntReduced - denominatorIntReduced;
               wholeNumber++;
            }
         }  
         if (Math.abs(numeratorIntReduced) != Math.abs(denominatorIntReduced)) {
            numeratorIntReduced = Math.abs(numeratorIntReduced);
            String numeratorBackToString1 = Integer.toString(numeratorIntReduced);
            String denominatorBackToString1 = Integer.toString(denominatorIntReduced);
            String wholeNumberBackToString = Integer.toString(wholeNumber);
            finalReducedAnwser = (wholeNumberBackToString + "_" + numeratorBackToString1 + "/" + denominatorBackToString1);
            return finalReducedAnwser;
         }
         else {
            if (numeratorIntReduced < 0) {
               wholeNumber -= 1;
               String negativeWholeNumberNoFraction = Integer.toString(wholeNumber);
               return negativeWholeNumberNoFraction;
            }
            else {
               wholeNumber += 1;
               String wholeNumberNoFraction = Integer.toString(wholeNumber);
               return wholeNumberNoFraction;
            }
         }
      }
      else if (numeratorIntReduced == 0) {
         String zeroFraction = "0";
         return zeroFraction;
      }
      else {
         if (denominatorIntReduced < 0) {
            denominatorIntReduced = Math.abs(denominatorIntReduced);
            numeratorIntReduced = numeratorIntReduced * -1;
            String numeratorBackToStringNegative = Integer.toString(numeratorIntReduced);
            String denominatorBackToStringNegative = Integer.toString(denominatorIntReduced);
            finalReducedAnwser = (numeratorBackToStringNegative + "/" + denominatorBackToStringNegative);
            return finalReducedAnwser;
         }
         else {
            String numeratorBackToString = Integer.toString(numeratorIntReduced);
            String denominatorBackToString = Integer.toString(denominatorIntReduced);
            finalReducedAnwser = (numeratorBackToString + "/" + denominatorBackToString);
            return finalReducedAnwser;
         }
      }
   }
   
    
   
   public static void runTests() {         //test cases
      String test1 = "1/4 + 1_1/2";
      produceAnswer(test1);
      System.out.println("Equation = " + test1);
      String correctAnwser = (produceAnswer(test1));
      System.out.println("Anwser = " + correctAnwser);
      if (correctAnwser.contains("1_3/4")) {
         System.out.println("Test is correct.");
         System.out.println();
      }
      else {
         System.out.println("Test is incorrect.");
         System.out.println();
      }
      
      String test2 = "8/4 + -2";
      produceAnswer(test2);
      System.out.println("Equation = " + test2);
      String correctAnwser1 = (produceAnswer(test2));
      System.out.println("Anwser = " + correctAnwser1);
      if (correctAnwser1.contains("0")) {
         System.out.println("Test is correct.");
         System.out.println();
      }
      else {
         System.out.println("Test is incorrect.");
         System.out.println();
      } 
      
      String test3 = "17 + 3_9/2";
      produceAnswer(test3);
      System.out.println("Equation = " + test3);
      String correctAnwser2 = (produceAnswer(test3));
      System.out.println("Anwser = " + correctAnwser2);
      if (correctAnwser2.contains("24_1/2")) {
         System.out.println("Test is correct.");
         System.out.println();
      }
      else {
         System.out.println("Test is incorrect.");
         System.out.println();
      } 
   
      String test4 = "20/7 - 3/5";
      produceAnswer(test4);
      System.out.println("Equation = " + test4);
      String correctAnwser3 = (produceAnswer(test4));
      System.out.println("Anwser = " + correctAnwser3);
      if (correctAnwser3.contains("2_9/35")) {
         System.out.println("Test is correct.");
         System.out.println();
      }
      else {
         System.out.println("Test is incorrect.");
         System.out.println();
      } 
      
      String test5 = "26 - 2/1";
      produceAnswer(test5);
      System.out.println("Equation = " + test5);
      String correctAnwser4 = (produceAnswer(test5));
      System.out.println("Anwser = " + correctAnwser4);
      if (correctAnwser4.contains("24")) {
         System.out.println("Test is correct.");
         System.out.println();
      }
      else {
         System.out.println("Test is incorrect.");
         System.out.println();
      }
            
      String test6 = "4/7 - -2";
      produceAnswer(test6);
      System.out.println("Equation = " + test6);
      String correctAnwser5 = (produceAnswer(test6));
      System.out.println("Anwser = " + correctAnwser5);
      if (correctAnwser5.contains("2_4/7")) {
         System.out.println("Test is correct.");
         System.out.println();
      }
      else {
         System.out.println("Test is incorrect.");
         System.out.println();
      }
            
      String test7 = "-2 - 8_50/7";
      produceAnswer(test7);
      System.out.println("Equation = " + test7);
      String correctAnwser6 = (produceAnswer(test7));
      System.out.println("Anwser = " + correctAnwser6);
      if (correctAnwser6.contains("-17_1/7")) {
         System.out.println("Test is correct.");
         System.out.println();
      }
      else {
         System.out.println("Test is incorrect.");
         System.out.println();
      } 
            
      String test8 = "36 * 4_7/8";
      produceAnswer(test8);
      System.out.println("Equation = " + test8);
      String correctAnwser7 = (produceAnswer(test8));
      System.out.println("Anwser = " + correctAnwser7);
      if (correctAnwser7.contains("175_1/2")) {
         System.out.println("Test is correct.");
         System.out.println();
      }
      else {
         System.out.println("Test is incorrect.");
         System.out.println();
      }
            
      String test9 = "3/4 * -45/2";
      produceAnswer(test9);
      System.out.println("Equation = " + test9);
      String correctAnwser8 = (produceAnswer(test9));
      System.out.println("Anwser = " + correctAnwser8);
      if (correctAnwser8.contains("-16_7/8")) {
         System.out.println("Test is correct.");
         System.out.println();
      }
      else {
         System.out.println("Test is incorrect.");
         System.out.println();
      }
            
      String test10 = "-4_9/13 * -30_3/2";
      produceAnswer(test10);
      System.out.println("Equation = " + test10);
      String correctAnwser9 = (produceAnswer(test10));
      System.out.println("Anwser = " + correctAnwser9);
      if (correctAnwser9.contains("147_21/26")) {
         System.out.println("Test is correct.");
         System.out.println();
      }
      else {
         System.out.println("Test is incorrect.");
         System.out.println();
      }
            
      String test11 = "21/6 * 4";
      produceAnswer(test11);
      System.out.println("Equation = " + test11);
      String correctAnwser10 = (produceAnswer(test11));
      System.out.println("Anwser = " + correctAnwser10);
      if (correctAnwser10.contains("14")) {
         System.out.println("Test is correct.");
         System.out.println();
      }
      else {
         System.out.println("Test is incorrect.");
         System.out.println();
      }
            
      String test12 = "0 / 25_462/543";
      produceAnswer(test12);
      System.out.println("Equation = " + test12);
      String correctAnwser11 = (produceAnswer(test12));
      System.out.println("Anwser = " + correctAnwser11);
      if (correctAnwser11.contains("0")) {
         System.out.println("Test is correct.");
         System.out.println();
      }
      else {
         System.out.println("Test is incorrect.");
         System.out.println();
      }
            
      String test13 = "2 / 9";
      produceAnswer(test13);
      System.out.println("Equation = " + test13);
      String correctAnwser12 = (produceAnswer(test13));
      System.out.println("Anwser = " + correctAnwser12);
      if (correctAnwser12.contains("2/9")) {
         System.out.println("Test is correct.");
         System.out.println();
      }
      else {
         System.out.println("Test is incorrect.");
         System.out.println();
      }
            
      String test14 = "9 / 4";
      produceAnswer(test14);
      System.out.println("Equation = " + test14);
      String correctAnwser13 = (produceAnswer(test14));
      System.out.println("Anwser = " + correctAnwser13);
      if (correctAnwser13.contains("2_1/4")) {
         System.out.println("Test is correct.");
         System.out.println();
      }
      else {
         System.out.println("Test is incorrect.");
         System.out.println();
      }
            
      String test15 = "6_5/6 / 30";
      produceAnswer(test15);
      System.out.println("Equation = " + test15);
      String correctAnwser14 = (produceAnswer(test15));
      System.out.println("Anwser = " + correctAnwser14);
      if (correctAnwser14.contains("41/180")) {
         System.out.println("Test is correct.");
         System.out.println();
      }
      else {
         System.out.println("Test is incorrect.");
         System.out.println();
      }
       
      String test16 = "-5_3/7 / 3/4";
      produceAnswer(test16);
      System.out.println("Equation = " + test16);
      String correctAnwser15 = (produceAnswer(test16));
      System.out.println("Anwser = " + correctAnwser15);
      if (correctAnwser15.contains("-7_5/21")) {
         System.out.println("Test is correct.");
         System.out.println();
      }
      else {
         System.out.println("Test is incorrect.");
         System.out.println();
      }
            
      String test17 = "-1 / -1";
      produceAnswer(test17);
      System.out.println("Equation = " + test17);
      String correctAnwser16 = (produceAnswer(test17));
      System.out.println("Anwser = " + correctAnwser16);
      if (correctAnwser16.contains("1")) {
         System.out.println("Test is correct.");
         System.out.println();
      }
      else {
         System.out.println("Test is incorrect.");
         System.out.println();
      }
       
      String test18 = "10 / 10";
      produceAnswer(test18);
      System.out.println("Equation = " + test18);
      String correctAnwser17 = (produceAnswer(test18));
      System.out.println("Anwser = " + correctAnwser17);
      if (correctAnwser17.contains("1")) {
         System.out.println("Test is correct.");
         System.out.println();
      }
      else {
         System.out.println("Test is incorrect.");
         System.out.println();
      }
            
      String test19 = "3_19/7 / 43_3/2";
      produceAnswer(test19);
      System.out.println("Equation = " + test19);
      String correctAnwser18 = (produceAnswer(test19));
      System.out.println("Anwser = " + correctAnwser18);
      if (correctAnwser18.contains("80/623")) {
         System.out.println("Test is correct.");
         System.out.println();
      }
      else {
         System.out.println("Test is incorrect.");
         System.out.println();
      }
       
   }
}