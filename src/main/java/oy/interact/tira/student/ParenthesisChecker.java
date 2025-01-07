package oy.interact.tira.student;

import oy.interact.tira.util.StackInterface;

public class ParenthesisChecker {

   private ParenthesisChecker() {
   }

   /**
    *  Implement this method which checks if the given string has matching opening and closing
    * parentheses. It should check for matching parentheses:

    *   Lorem ipsum ( dolor sit {  amet, [ consectetur adipiscing ] elit, sed } do eiusmod tempor ) incididunt ut...,
    * 
    * that can be found for example in Java source code and JSON structures.
    * 
    * If the string has issues with parentheses, you should throw a {@code ParenthesisException} with a
    * descriptive message and error code. Error codes are already defined for you in the ParenthesesException
    * class to be used.
    *
    * Note that the exception thrown must include correct line and column numbers of the
    * place where it became obvious that there are incorrect parenthesis in the input text.
    *
    * What is to be tested about the incoming string:
    *
    * - When an opening parenthesis is found in the string, it is successfully pushed to the stack (push may fail).
    * - When a closing parenthesis is found in the string, chech that a matching opening parenthesis is popped from the stack.
    * - If the stack was empty, this indicates an error, too many opening parentheses (or too few closing ones).
    *   Note that you can check if the stack is empty before calling pop() and throw an exception.
    * - When the string has been handled, and if the stack still has parentheses, there are too few closing parentheses.
    * 
    * @param stack The stack object used in checking the parentheses from the string.
    * @param fromString A string containing parentheses to check if it is valid.
    * @return Returns the number of parentheses found from the input in total (both opening and closing).
    * @throws ParenthesesException if the parentheses did not match as intended.
    */
   public static int checkParentheses(StackInterface<Character> stack, String fromString) throws ParenthesesException {
     
      int lines = 1;
      int column = 0;
      int parenthesesCount = 0;

      for (int i = 0; i < fromString.length(); i++) {

         char c = fromString.charAt(i);
         
         if (c == '"') {
            do {
               i++;
               if (i >= fromString.length()) {
                  throw new ParenthesesException("Closing quotation mark is missing", lines, column, -5);
               }
               c = fromString.charAt(i);
               column++;
            } while (c != '"');
         }

         if (c == '\n') {
            lines++;
            column = 0;
         } else {
            column++;
         }
         
         if (c == '{' || c == '(' || c == '[') {
            try {
               stack.push(c);
               parenthesesCount++;
            } catch (NullPointerException | OutOfMemoryError e) {
               throw new ParenthesesException("Push failed", lines, column, -4);
            }
            
         }

         if (c == '}' || c == ')' || c == ']') {
            if (stack.isEmpty()) {
               throw new ParenthesesException("Too many closing parentheses", lines, column, -1);
            } else {
               char popped = stack.pop();

               if ((popped == '(' && c != ')') ||
                   (popped == '[' && c != ']') ||
                   (popped == '{' && c != '}'))
                  {
                  throw new ParenthesesException("Wrong kind of parentheses in the text", lines, column, -3);
               }
            } 
            parenthesesCount++;
         }
      }

      if (!stack.isEmpty()) {
         throw new ParenthesesException("Too many opening parentheses", lines, column, -2);
      }

      return parenthesesCount;
   }
}
