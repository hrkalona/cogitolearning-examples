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
/**
 * @mainpage CogPar is lightweight but versatile parser for mathematical
 * expressions.
 *
 * It can be used to analyse expressions and store them in an internal data
 * structure for later evaluation. Repeated evaluation of the same expression
 * using CogPar is fast.
 *
 * CogPar comes with a highly configurable tokenizer which can be adapted for
 * your own needs.
 *
 * Arbitrary named variables are supported and values can be assigned in a
 * single line of code.
 *
 * The parser, it's grammar an the tokenizer are well documented. You can read
 * more about the internal workings of CogPar
 * <a href="http://cogitolearning.co.uk/?p=523" alt="CogPar tutorial">in these
 * posts</a>.
 *
 * CogPar is distributed under the MIT license, so feel free to use it in your
 * own projects.
 *
 * To download CogPar, <a href="" alt="Download CogPar">follow this link.</a>
 */
package uk.co.cogitolearning.cogpar;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 * A parser for mathematical expressions. The parser class defines a method
 * parse() which takes a string and returns an ExpressionNode that holds a
 * representation of the expression.
 *
 * Parsing is implemented in the form of a recursive descent parser.
 *
 */
public class Parser {

    /**
     * the tokens to parse
     */
    LinkedList<Token> tokens;
    /**
     * the next token
     */
    Token lookahead;

    /**
     * Parse a mathematical expression in a string and return an ExpressionNode.
     *
     * This is a convenience method that first converts the string into a linked
     * list of tokens using the expression tokenizer provided by the Tokenizer
     * class.
     *
     * @param expression the string holding the input
     * @return the internal representation of the expression in form of an
     * expression tree made out of ExpressionNode objects
     */
    public ExpressionNode parse(String expression) {
        Tokenizer tokenizer = Tokenizer.getExpressionTokenizer();
        tokenizer.tokenize(expression);
        LinkedList<Token> tokens = tokenizer.getTokens();
        return this.parse(tokens);
    }

    /**
     * Parse a mathematical expression in contained in a list of tokens and
     * return an ExpressionNode.
     *
     * @param tokens a list of tokens holding the tokenized input
     * @return the internal representation of the expression in form of an
     * expression tree made out of ExpressionNode objects
     */
    public ExpressionNode parse(LinkedList<Token> tokens) {
        // implementing a recursive descent parser
        this.tokens = (LinkedList<Token>)tokens.clone();

        try {
            lookahead = this.tokens.getFirst();
        }
        catch(NoSuchElementException ex) {
            throw new ParserException("No input found.");
        }

        // top level non-terminal is expression
        ExpressionNode expr = expression();

        if(lookahead.token != Token.EPSILON) {
            throw new ParserException("Unexpected symbol %s found.", lookahead);
        }

        return expr;
    }

    /**
     * handles the non-terminal expression
     */
    private ExpressionNode expression() {
        // only one rule
        // expression -> signed_term sum_op
        ExpressionNode expr = signedTerm();
        expr = sumOp(expr);
        return expr;
    }

    /**
     * handles the non-terminal sum_op
     */
    private ExpressionNode sumOp(ExpressionNode expr) {
        // sum_op -> PLUSMINUS signed_term sum_op
        if(lookahead.token == Token.PLUSMINUS) {
            AdditionExpressionNode sum;
            // This means we are actually dealing with a sum
            // If expr is not already a sum, we have to create one
            if(expr.getType() == ExpressionNode.ADDITION_NODE) {
                sum = (AdditionExpressionNode)expr;
            }
            else {
                sum = new AdditionExpressionNode(expr, AdditionExpressionNode.ADD);
            }

            // reduce the input and recursively call sum_op
            int mode = lookahead.sequence.equals("+") ? AdditionExpressionNode.ADD : AdditionExpressionNode.SUB;
            nextToken();
            ExpressionNode t = signedTerm();
            sum.add(t, mode);

            return sumOp(sum);
        }

        // sum_op -> EPSILON
        return expr;
    }

    /**
     * handles the non-terminal signed_term
     */
    private ExpressionNode signedTerm() {
        // signed_term -> PLUSMINUS signed_term
        if(lookahead.token == Token.PLUSMINUS) {
            int mode = lookahead.sequence.equals("+") ? AdditionExpressionNode.ADD : AdditionExpressionNode.SUB;
            nextToken();
            ExpressionNode t = signedTerm();
            if(mode == AdditionExpressionNode.ADD) {
                return t;
            }
            else {
                return new AdditionExpressionNode(t, AdditionExpressionNode.SUB);
            }
        }

        // signed_term -> term
        return term();
    }

    /**
     * handles the non-terminal term
     */
    private ExpressionNode term() {
        // term -> factor term_op
        ExpressionNode f = factor();
        return termOp(f);
    }

    /**
     * handles the non-terminal term_op
     */
    private ExpressionNode termOp(ExpressionNode expression) {
        // term_op -> MULTDIV signed_factor term_op
        if(lookahead.token == Token.MULTDIVREM) {
            MultiplicationExpressionNode prod;

            // This means we are actually dealing with a product
            // If expr is not already a product, we have to create one
            if(expression.getType() == ExpressionNode.MULTIPLICATION_NODE) {
                prod = (MultiplicationExpressionNode)expression;
            }
            else {
                prod = new MultiplicationExpressionNode(expression, MultiplicationExpressionNode.MULT);
            }

            // reduce the input and recursively call sum_op
            int mode;

            if(lookahead.sequence.equals("*")) {
                mode = MultiplicationExpressionNode.MULT;
            }
            else if(lookahead.sequence.equals("/")) {
                mode = MultiplicationExpressionNode.DIV;
            }
            else {
                mode = MultiplicationExpressionNode.REM;
            }
            nextToken();
            ExpressionNode f = signedFactor();
            prod.add(f, mode);

            return termOp(prod);
        }

        // term_op -> EPSILON
        return expression;
    }

    /**
     * handles the non-terminal signed_factor
     */
    private ExpressionNode signedFactor() {
        // signed_factor -> PLUSMINUS signed_factor
        if(lookahead.token == Token.PLUSMINUS) {
            int mode = lookahead.sequence.equals("+") ? AdditionExpressionNode.ADD : AdditionExpressionNode.SUB;
            nextToken();
            ExpressionNode t = signedFactor();
            if(mode == AdditionExpressionNode.ADD) {
                return t;
            }
            else {
                return new AdditionExpressionNode(t, AdditionExpressionNode.SUB);
            }
        }

        // signed_factor -> factor
        return factor();
    }

    /**
     * handles the non-terminal factor
     */
    private ExpressionNode factor() {
        // factor -> argument factor_op
        ExpressionNode a = argument();
        return factorOp(a);
    }

    /**
     * handles the non-terminal factor_op
     */
    private ExpressionNode factorOp(ExpressionNode expr) {
        // factor_op -> RAISED signed_factor
        if(lookahead.token == Token.RAISED) {
            nextToken();
            ExpressionNode exponent = signedFactor();

            return new ExponentiationExpressionNode(expr, exponent);
        }

        // factor_op -> EPSILON
        return expr;
    }

    /**
     * handles the non-terminal argument
     */
    private ExpressionNode argument() {
        // argument -> FUNCTION function_argument
        if(lookahead.token == Token.FUNCTION) {
            int function = FunctionExpressionNode.stringToFunction(lookahead.sequence);

            nextToken();
            ExpressionNode expr = functionArgument();
            return new FunctionExpressionNode(function, expr);
        }
        // argument -> FUNCTION_2ARG function_argument2
        else if(lookahead.token == Token.FUNCTION_2ARGUMENTS) {
            int function = Function2ArgumentsExpressionNode.stringToFunction(lookahead.sequence);

            nextToken();
            ExpressionNode expr[] = functionArgument2();
            return new Function2ArgumentsExpressionNode(function, expr[0], expr[1]);
        }
        // argument -> FUNCTION_DERIVATIVE_2_ARG function_argument2
        else if(lookahead.token == Token.FUNCTION_DERIVATIVE_2ARGUMENTS) {
            int function = FunctionDerivative2ArgumentsExpressionNode.stringToFunction(lookahead.sequence);

            nextToken();
            ExpressionNode expr[] = functionArgument2();

            if(!(expr[1] instanceof VariableExpressionNode)) {
                throw new ParserException("The second argument of a derivative function must be a variable.", lookahead);
            }

            return new FunctionDerivative2ArgumentsExpressionNode(function, expr[0], expr[1]);
        }
        // argument -> OPEN_BRACKET expression CLOSE_BRACKET
        else if(lookahead.token == Token.OPEN_BRACKET) {
            nextToken();
            ExpressionNode expr = expression();
            if(lookahead.token != Token.CLOSE_BRACKET) {
                throw new ParserException("Closing brackets expected.", lookahead);
            }
            nextToken();
            return expr;
        }

        // argument -> value
        return value();
    }

    /*handles the function with 2 arguments */
    private ExpressionNode[] functionArgument2() {
        // function_argument2 -> OPEN_BRACKET expression COMMA expression CLOSE_BRACKET
        if(lookahead.token == Token.OPEN_BRACKET) {
            ExpressionNode[] exprs = new ExpressionNode[2];

            nextToken();
            exprs[0] = expression();
            if(lookahead.token != Token.COMMA) {
                throw new ParserException("Comma expected.", lookahead);
            }
            nextToken();
            exprs[1] = expression();
            if(lookahead.token != Token.CLOSE_BRACKET) {
                throw new ParserException("Closing brackets expected.", lookahead);
            }
            nextToken();
            return exprs;
        }

        throw new ParserException("Opening brackets expected.", lookahead);
    }

    /*handles the function with 1 argument */
    private ExpressionNode functionArgument() {
        // function_argument -> OPEN_BRACKET expression CLOSE_BRACKET
        if(lookahead.token == Token.OPEN_BRACKET) {
            nextToken();
            ExpressionNode expr = expression();
            if(lookahead.token != Token.CLOSE_BRACKET) {
                throw new ParserException("Closing brackets expected.", lookahead);
            }
            nextToken();
            return expr;
        }

        throw new ParserException("Opening brackets expected.", lookahead);
    }

    /**
     * handles the non-terminal value
     */
    private ExpressionNode value() {
        // value -> REAL_NUMBER
        if(lookahead.token == Token.REAL_NUMBER) {
            ExpressionNode expr = new RealConstantExpressionNode(lookahead.sequence);
            nextToken();
            return expr;
        }

        // value -> IMAGINARY_NUMBER
        if(lookahead.token == Token.IMAGINARY_NUMBER) {
            StringTokenizer tok = new StringTokenizer(lookahead.sequence, "iI");
            ExpressionNode expr;
            if(tok.hasMoreTokens()) {
                expr = new ImaginaryConstantExpressionNode(tok.nextToken());
            }
            else {
                expr = new ImaginaryConstantExpressionNode(1.0);
            }
            nextToken();
            return expr;
        }

        // value -> VARIABLE
        if(lookahead.token == Token.VARIABLE) {
            
            if(lookahead.sequence.equalsIgnoreCase("pi") || lookahead.sequence.equalsIgnoreCase("e") || lookahead.sequence.equalsIgnoreCase("phi")) {
                RealConstantExpressionNode expr = null;

                if(lookahead.sequence.equalsIgnoreCase("pi")) {
                    expr = new RealConstantExpressionNode(Math.PI);
                }

                if(lookahead.sequence.equalsIgnoreCase("e")) {
                    expr = new RealConstantExpressionNode(Math.E);
                }

                if(lookahead.sequence.equalsIgnoreCase("phi")) {
                    expr = new RealConstantExpressionNode(1.618033988749895);
                }

                nextToken();
                return expr;
            }
            
            ExpressionNode expr = new VariableExpressionNode(lookahead.sequence);
            
            nextToken();
            return expr;
        }

        if(lookahead.token == Token.EPSILON) {
            throw new ParserException("Unexpected end of input.");
        }
        else {
            throw new ParserException("Unexpected symbol %s found.", lookahead);
        }
    }

    /**
     * Remove the first token from the list and store the next token in
     * lookahead
     */
    private void nextToken() {
        tokens.pop();
        // at the end of input we return an epsilon token
        if(tokens.isEmpty()) {
            lookahead = new Token(Token.EPSILON, "", -1);
        }
        else {
            lookahead = tokens.getFirst();
        }
    }

}
