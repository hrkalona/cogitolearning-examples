/*
 * This software and all files contained in it are distrubted under the MIT license.
 * 
 * Copyright (c) 2013 Cogito Learning Ltd
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package uk.co.cogitolearning.cogpar;

/**
 * Test the Parser
 */
public class Test
{

  /**
   * The main method to test the functionality of the parser
   */
  public static void main(String[] args)
  {
        
    Parser parser = new Parser();
    try
    {
      ExpressionNode expr = parser.parse("2i*(1+sin(pi/2))^2 -3.0i");
      ExpressionNode expr2 = parser.parse("+12/+3++4^+4/-2*+3/-2+-24/+3*+8/-2*+cos(0)+-(+10/-2-+3*-5)"); // 218 like wolfram
      ExpressionNode expr3 = parser.parse("12/3+4^4/(-2)*3/(-2)-24/3*8/(-2)*cos(0)-(10/(-2)-3*(-5))"); 
      ExpressionNode expr4 = parser.parse("-------2++++++-+++++i"); 
      ExpressionNode expr5 = parser.parse("(0.4+1.3i) % (0.6-3.33i)"); 
      ExpressionNode expr6 = parser.parse("3%-4");
      //expr.accept(new SetVariable("pi", new Complex(Math.PI, 0)));
      System.out.println("The value of the expression is "+expr.getValue());
      System.out.println("The value of the expression is "+expr2.getValue());
      System.out.println("The value of the expression is "+expr3.getValue());
      System.out.println("The value of the expression is "+expr4.getValue());
      System.out.println("The value of the expression is "+expr5.getValue());
      System.out.println("The value of the expression is "+expr6.getValue());
      
    }
    catch (ParserException e)
    {
      System.out.println(e.getMessage());
    }
    catch (EvaluationException e)
    {
      System.out.println(e.getMessage());
    }
  }
}