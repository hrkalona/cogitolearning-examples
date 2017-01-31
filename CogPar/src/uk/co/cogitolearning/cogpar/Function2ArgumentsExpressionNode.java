/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.cogitolearning.cogpar;

/**
 * An ExpressionNode that handles mathematical functions with 2 arguments.
 *
 * Some pre-defined functions are handled, others can easily be added.
 */
public class Function2ArgumentsExpressionNode implements ExpressionNode {

    /**
     * function id for the bipolar function
     */
    public static final int TO_BIPOLAR = 0;

    /**
     * function id for the inversed bipolar function
     */
    public static final int FROM_BIPOLAR = 1;

    /**
     * function id for the inflection function
     */
    public static final int INFLECTION = 2;
    
     /**
     * function id for the fold up function
     */
    public static final int FOLD_UP = 3;
    
    /**
     * function id for the fold down function
     */
    public static final int FOLD_DOWN = 4;
    
    /**
     * function id for the fold left function
     */
    public static final int FOLD_LEFT = 5;
    
    /**
     * function id for the fold right function
     */
    public static final int FOLD_RIGHT = 6;
    
    /**
     * function id for the fold in function
     */
    public static final int FOLD_IN = 7;
    
    /**
     * function id for the fold out function
     */
    public static final int FOLD_OUT = 8;
    
    /**
     * function id for the shear function
     */
    public static final int SHEAR = 9;
    
    /**
     * function id for the compare function
     */
    public static final int COMPARE = 10;

    /**
     * the id of the function to apply to the argument
     */
    private int function;

    /**
     * the argument of the function
     */
    private ExpressionNode argument;
    
    /**
     * the second argument of the function
     */
    private ExpressionNode argument2;

    /**
     * Construct a function by id and argument.
     *
     * @param function the id of the function to apply
     * @param argument the first argument of the function
     * @param argument2 the second argument of the function
     */
    public Function2ArgumentsExpressionNode(int function, ExpressionNode argument, ExpressionNode argument2) {
        super();
        this.function = function;
        this.argument = argument;
        this.argument2 = argument2;
    }

    /**
     * Returns the type of the node, in this case ExpressionNode.FUNCTION_2_ARG_NODE
     */
    public int getType() {
        return ExpressionNode.FUNCTION_2_ARG_NODE;
    }

    /**
     * Converts a string to a function id.
     *
     * If the function is not found this method throws an error.
     *
     * @param str the name of the function
     * @return the id of the function
     */
    public static int stringToFunction(String str) {
        if(str.equals("bipol")) {
            return Function2ArgumentsExpressionNode.TO_BIPOLAR;
        }

        if(str.equals("ibipol")) {
            return Function2ArgumentsExpressionNode.FROM_BIPOLAR;
        }
        
        if(str.equals("inflect")) {
            return Function2ArgumentsExpressionNode.INFLECTION;
        }
        
        if(str.equals("foldu")) {
            return Function2ArgumentsExpressionNode.FOLD_UP;
        }
        
        if(str.equals("foldd")) {
            return Function2ArgumentsExpressionNode.FOLD_DOWN;
        }
        
        if(str.equals("foldl")) {
            return Function2ArgumentsExpressionNode.FOLD_LEFT;
        }
        
        if(str.equals("foldr")) {
            return Function2ArgumentsExpressionNode.FOLD_RIGHT;
        }
        
        if(str.equals("foldi")) {
            return Function2ArgumentsExpressionNode.FOLD_IN;
        }
        
        if(str.equals("foldo")) {
            return Function2ArgumentsExpressionNode.FOLD_OUT;
        }
        
        if(str.equals("shear")) {
            return Function2ArgumentsExpressionNode.SHEAR;
        }
        
        if(str.equals("cmp")) {
            return Function2ArgumentsExpressionNode.COMPARE;
        }

        throw new ParserException("Unexpected Function " + str + " found.");
    }

    /**
     * Returns a string with all the function names concatenated by a | symbol.
     *
     * This string is used in Tokenizer.createExpressionTokenizer to create a
     * regular expression for recognizing function names.
     *
     * @return a string containing all the function names
     */
    public static String getAllFunctions() {
        return "bipol|ibipol|inflect|foldu|foldd|foldl|foldr|foldi|foldo|shear|cmp";
    }

    /**
     * Returns the value of the sub-expression that is rooted at this node.
     *
     * The argument is evaluated and then the function is applied to the
     * resulting value.
     */
    public Complex getValue() {
        switch (function) {
            
            case TO_BIPOLAR:
                return argument.getValue().toBiPolar(argument2.getValue().getRe());

            case FROM_BIPOLAR:
                return argument.getValue().fromBiPolar(argument2.getValue().getRe());
                
            case INFLECTION:
                return argument.getValue().inflection(argument2.getValue());    
                
            case FOLD_UP:
                return argument.getValue().fold_up(argument2.getValue());
                
            case FOLD_DOWN:
                return argument.getValue().fold_down(argument2.getValue());                
                
            case FOLD_LEFT:
                return argument.getValue().fold_left(argument2.getValue());
                
            case FOLD_RIGHT:
                return argument.getValue().fold_right(argument2.getValue());
                
            case FOLD_IN:
                return argument.getValue().fold_in(argument2.getValue());
                
            case FOLD_OUT:
                return argument.getValue().fold_out(argument2.getValue());
                
            case SHEAR:
                return argument.getValue().shear(argument2.getValue());
                
            case COMPARE:
                return new Complex(argument.getValue().compare(argument2.getValue()), 0);
        }

        throw new EvaluationException("Invalid function id " + function + "!");
    }

    /**
     * Implementation of the visitor design pattern.
     *
     * Calls visit on the visitor and then passes the visitor on to the accept
     * method of the argument.
     *
     * @param visitor the visitor
     */
    public void accept(ExpressionNodeVisitor visitor) {
        visitor.visit(this);
        argument.accept(visitor);
    }

}
