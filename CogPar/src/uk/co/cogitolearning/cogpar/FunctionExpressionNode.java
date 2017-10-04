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
 * An ExpressionNode that handles mathematical functions.
 *
 * Some pre-defined functions are handled, others can easily be added.
 */
public class FunctionExpressionNode implements ExpressionNode {

    /**
     * function id for the sqrt function
     */
    public static final int SQRT = 1;
    /**
     * function id for the exp function
     */
    public static final int EXP = 2;

    /**
     * function id for the ln function
     */
    public static final int LN = 3;

    /**
     * function id for the abs function
     */
    public static final int ABS = 4;

    /**
     * function id for the sin function
     */
    public static final int SIN = 5;
    /**
     * function id for the asin function
     */
    public static final int ASIN = 6;
    /**
     * function id for the sinh function
     */
    public static final int SINH = 7;
    /**
     * function id for the asinh function
     */
    public static final int ASINH = 8;

    /**
     * function id for the cos function
     */
    public static final int COS = 9;
    /**
     * function id for the acos function
     */
    public static final int ACOS = 10;
    /**
     * function id for the cosh function
     */
    public static final int COSH = 11;
    /**
     * function id for the acosh function
     */
    public static final int ACOSH = 12;

    /**
     * function id for the tan function
     */
    public static final int TAN = 13;
    /**
     * function id for the tanh function
     */
    public static final int TANH = 14;
    /**
     * function id for the atan function
     */
    public static final int ATAN = 15;
    /**
     * function id for the atanth function
     */
    public static final int ATANH = 16;

    /**
     * function id for the cot function
     */
    public static final int COT = 17;
    /**
     * function id for the coth function
     */
    public static final int COTH = 18;
    /**
     * function id for the acot function
     */
    public static final int ACOT = 19;
    /**
     * function id for the acoth function
     */
    public static final int ACOTH = 20;

    /**
     * function id for the sec function
     */
    public static final int SEC = 21;
    /**
     * function id for the sech function
     */
    public static final int SECH = 22;
    /**
     * function id for the asec function
     */
    public static final int ASEC = 23;
    /**
     * function id for the asech function
     */
    public static final int ASECH = 24;

    /**
     * function id for the csc function
     */
    public static final int CSC = 25;
    /**
     * function id for the acsc function
     */
    public static final int ACSC = 26;
    /**
     * function id for the csch function
     */
    public static final int CSCH = 27;
    /**
     * function id for the acsch function
     */
    public static final int ACSCH = 28;

    /**
     * function id for the conj function
     */
    public static final int CONJ = 29;

    /**
     * function id for the log function
     */
    public static final int LOG = 30;
    /**
     * function id for the log2 function
     */
    public static final int LOG2 = 31;

    /**
     * function id for the real part function
     */
    public static final int RE = 32;

    /**
     * function id for the imaginary part function
     */
    public static final int IM = 33;

    /**
     * function id for the norm function
     */
    public static final int NORM = 34;

    /**
     * function id for the arg function
     */
    public static final int ARG = 35;

    /**
     * function id for the gamma function
     */
    public static final int GAMMA = 36;

    /**
     * function id for the fact function
     */
    public static final int FACT = 37;

    /**
     * function id for the absolute value real function
     */
    public static final int ABSRE = 38;

    /**
     * function id for the absolute value imaginary function
     */
    public static final int ABSIM = 39;

    /**
     * function id for the gaussian integer function
     */
    public static final int GI = 40;

    /**
     * function id for the reciprocal function
     */
    public static final int REC = 41;

    /**
     * function id for the flip function
     */
    public static final int FLIP = 42;

    /**
     * function id for the round function
     */
    public static final int ROUND = 43;

    /**
     * function id for the ceil function
     */
    public static final int CEIL = 44;

    /**
     * function id for the floor function
     */
    public static final int FLOOR = 45;

    /**
     * function id for the truncate function
     */
    public static final int TRUNC = 46;

    /**
     * function id for the error function
     */
    public static final int ERF = 47;

    /**
     * function id for the riemann zeta function
     */
    public static final int R_ZETA = 48;
    
    /**
     * function id for the versine function
     */
    public static final int VSIN = 49;
    
    /**
     * function id for the arc versine function
     */
    public static final int AVSIN = 50;
    
    /**
     * function id for the vercosine function
     */
    public static final int VCOS = 51;
    
    /**
     * function id for the arc vercosine function
     */
    public static final int AVCOS = 52;
    
    /**
     * function id for the coversine function
     */
    public static final int CVSIN = 53;
    
    /**
     * function id for the arc coversine function
     */
    public static final int ACVSIN = 54;
    
    /**
     * function id for the covercosine function
     */
    public static final int CVCOS = 55;
    
    /**
     * function id for the arc covercosine function
     */
    public static final int ACVCOS = 56;
    
    /**
     * function id for the haversine function
     */
    public static final int HVSIN = 57;
    
    /**
     * function id for the arc haversine function
     */
    public static final int AHVSIN = 58;
    
    /**
     * function id for the havercosine function
     */
    public static final int HVCOS = 59;
    
    /**
     * function id for the arc havercosine function
     */
    public static final int AHVCOS = 60;
    
    /**
     * function id for the hacoversine function
     */
    public static final int HCVSIN = 61;
    
    /**
     * function id for the arc hacoversine function
     */
    public static final int AHCVSIN = 62;
    
    /**
     * function id for the hacovercosine function
     */
    public static final int HCVCOS = 63;
    
    /**
     * function id for the arc hacovercosine function
     */
    public static final int AHCVCOS = 64;
    
    /**
     * function id for the exsecant function
     */
    public static final int EXSEC = 65;
    
    /**
     * function id for the arc exsecant function
     */
    public static final int AEXSEC = 66;
    
    /**
     * function id for the excosecant function
     */
    public static final int EXCSC = 67;
    
    /**
     * function id for the arc excosecant function
     */
    public static final int AEXCSC = 68;

    /**
     * the id of the function to apply to the argument
     */
    private int function;

    /**
     * the argument of the function
     */
    private ExpressionNode argument;

    /**
     * Construct a function by id and argument.
     *
     * @param function the id of the function to apply
     * @param argument the argument of the function
     */
    public FunctionExpressionNode(int function, ExpressionNode argument) {
        super();
        this.function = function;
        this.argument = argument;
    }

    /**
     * Returns the type of the node, in this case ExpressionNode.FUNCTION_NODE
     */
    public int getType() {
        return ExpressionNode.FUNCTION_NODE;
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
        if(str.equals("sin")) {
            return FunctionExpressionNode.SIN;
        }
        if(str.equals("sinh")) {
            return FunctionExpressionNode.SINH;
        }
        if(str.equals("asin")) {
            return FunctionExpressionNode.ASIN;
        }
        if(str.equals("asinh")) {
            return FunctionExpressionNode.ASINH;
        }

        if(str.equals("cos")) {
            return FunctionExpressionNode.COS;
        }
        if(str.equals("cosh")) {
            return FunctionExpressionNode.COSH;
        }
        if(str.equals("acos")) {
            return FunctionExpressionNode.ACOS;
        }
        if(str.equals("acosh")) {
            return FunctionExpressionNode.ACOSH;
        }

        if(str.equals("tan")) {
            return FunctionExpressionNode.TAN;
        }
        if(str.equals("tanh")) {
            return FunctionExpressionNode.TANH;
        }
        if(str.equals("atan")) {
            return FunctionExpressionNode.ATAN;
        }
        if(str.equals("atanh")) {
            return FunctionExpressionNode.ATANH;
        }

        if(str.equals("cot")) {
            return FunctionExpressionNode.COT;
        }
        if(str.equals("coth")) {
            return FunctionExpressionNode.COTH;
        }
        if(str.equals("acot")) {
            return FunctionExpressionNode.ACOT;
        }
        if(str.equals("acoth")) {
            return FunctionExpressionNode.ACOTH;
        }

        if(str.equals("sec")) {
            return FunctionExpressionNode.SEC;
        }
        if(str.equals("sech")) {
            return FunctionExpressionNode.SECH;
        }
        if(str.equals("asec")) {
            return FunctionExpressionNode.ASEC;
        }
        if(str.equals("asech")) {
            return FunctionExpressionNode.ASECH;
        }

        if(str.equals("csc")) {
            return FunctionExpressionNode.CSC;
        }
        if(str.equals("csch")) {
            return FunctionExpressionNode.CSCH;
        }
        if(str.equals("acsc")) {
            return FunctionExpressionNode.ACSC;
        }
        if(str.equals("acsch")) {
            return FunctionExpressionNode.ACSCH;
        }

        if(str.equals("sqrt")) {
            return FunctionExpressionNode.SQRT;
        }
        if(str.equals("exp")) {
            return FunctionExpressionNode.EXP;
        }
        if(str.equals("log")) {
            return FunctionExpressionNode.LN;
        }
        if(str.equals("abs")) {
            return FunctionExpressionNode.ABS;
        }
        if(str.equals("log10")) {
            return FunctionExpressionNode.LOG;
        }
        if(str.equals("log2")) {
            return FunctionExpressionNode.LOG2;
        }

        if(str.equals("conj")) {
            return FunctionExpressionNode.CONJ;
        }

        if(str.equals("re")) {
            return FunctionExpressionNode.RE;
        }
        if(str.equals("im")) {
            return FunctionExpressionNode.IM;
        }

        if(str.equals("norm")) {
            return FunctionExpressionNode.NORM;
        }

        if(str.equals("arg")) {
            return FunctionExpressionNode.ARG;
        }

        if(str.equals("gamma")) {
            return FunctionExpressionNode.GAMMA;
        }

        if(str.equals("fact")) {
            return FunctionExpressionNode.FACT;
        }

        if(str.equals("absre")) {
            return FunctionExpressionNode.ABSRE;
        }

        if(str.equals("absim")) {
            return FunctionExpressionNode.ABSIM;
        }

        if(str.equals("gi")) {
            return FunctionExpressionNode.GI;
        }

        if(str.equals("rec")) {
            return FunctionExpressionNode.REC;
        }

        if(str.equals("flip")) {
            return FunctionExpressionNode.FLIP;
        }

        if(str.equals("round")) {
            return FunctionExpressionNode.ROUND;
        }

        if(str.equals("ceil")) {
            return FunctionExpressionNode.CEIL;
        }

        if(str.equals("floor")) {
            return FunctionExpressionNode.FLOOR;
        }

        if(str.equals("trunc")) {
            return FunctionExpressionNode.TRUNC;
        }

        if(str.equals("erf")) {
            return FunctionExpressionNode.ERF;
        }

        if(str.equals("rzeta")) {
            return FunctionExpressionNode.R_ZETA;
        }
        
        if (str.equals("vsin")) {
            return FunctionExpressionNode.VSIN;
        }
        
        if (str.equals("avsin")) {
            return FunctionExpressionNode.AVSIN;
        }
        
        if (str.equals("vcos")) {
            return FunctionExpressionNode.VCOS;
        }
        
        if (str.equals("avcos")) {
            return FunctionExpressionNode.AVCOS;
        }
        
        if (str.equals("cvsin")) {
            return FunctionExpressionNode.CVSIN;
        }
        
        if (str.equals("acvsin")) {
            return FunctionExpressionNode.ACVSIN;
        }
        
        if (str.equals("cvcos")) {
            return FunctionExpressionNode.CVCOS;
        }
        
        if (str.equals("acvcos")) {
            return FunctionExpressionNode.ACVCOS;
        }
        
        if (str.equals("hvsin")) {
            return FunctionExpressionNode.HVSIN;
        }
        
        if (str.equals("ahvsin")) {
            return FunctionExpressionNode.AHVSIN;
        }
        
        if (str.equals("hvcos")) {
            return FunctionExpressionNode.HVCOS;
        }
        
        if (str.equals("ahvcos")) {
            return FunctionExpressionNode.AHVCOS;
        }
        
        if (str.equals("hcvsin")) {
            return FunctionExpressionNode.HCVSIN;
        }
        
        if (str.equals("ahcvsin")) {
            return FunctionExpressionNode.AHCVSIN;
        }
        
        if (str.equals("hcvcos")) {
            return FunctionExpressionNode.HCVCOS;
        }
        
        if (str.equals("ahcvcos")) {
            return FunctionExpressionNode.AHCVCOS;
        }
        
        if (str.equals("exsec")) {
            return FunctionExpressionNode.EXSEC;
        }
        
        if (str.equals("aexsec")) {
            return FunctionExpressionNode.AEXSEC;
        }
        
        if (str.equals("excsc")) {
            return FunctionExpressionNode.EXCSC;
        }
        
        if (str.equals("aexcsc")) {
            return FunctionExpressionNode.AEXCSC;
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
        return "sin|sinh|asin|asinh|cos|cosh|acos|acosh|tan|tanh|atan|atanh|cot|coth|acot|acoth|sec|sech|asec|asech|csc|csch|acsc|acsch|sqrt|exp|log|log10|log2|abs|conj|re|im|norm|arg|gamma|fact|absre|absim|gi|rec|flip|round|ceil|floor|trunc|erf|rzeta"
                + "|vsin|avsin|vcos|avcos|cvsin|acvsin|cvcos|acvcos|hvsin|ahvsin|hvcos|ahvcos|hcvsin|ahcvsin|hcvcos|ahcvcos|exsec|aexsec|excsc|aexcsc";
    }

    /**
     * Returns the value of the sub-expression that is rooted at this node.
     *
     * The argument is evaluated and then the function is applied to the
     * resulting value.
     */
    public Complex getValue() {
        switch (function) {
            case SIN:
                return argument.getValue().sin();
            case SINH:
                return argument.getValue().sinh();
            case ASIN:
                return argument.getValue().asin();
            case ASINH:
                return argument.getValue().asinh();

            case COS:
                return argument.getValue().cos();
            case COSH:
                return argument.getValue().cosh();
            case ACOS:
                return argument.getValue().acos();
            case ACOSH:
                return argument.getValue().acosh();

            case TAN:
                return argument.getValue().tan();
            case TANH:
                return argument.getValue().tanh();
            case ATAN:
                return argument.getValue().atan();
            case ATANH:
                return argument.getValue().atanh();

            case COT:
                return argument.getValue().cot();
            case COTH:
                return argument.getValue().coth();
            case ACOT:
                return argument.getValue().acot();
            case ACOTH:
                return argument.getValue().acoth();

            case SEC:
                return argument.getValue().sec();
            case SECH:
                return argument.getValue().sech();
            case ASEC:
                return argument.getValue().asec();
            case ASECH:
                return argument.getValue().asech();

            case CSC:
                return argument.getValue().csc();
            case CSCH:
                return argument.getValue().csch();
            case ACSC:
                return argument.getValue().acsc();
            case ACSCH:
                return argument.getValue().acsch();

            case SQRT:
                return argument.getValue().sqrt();
            case EXP:
                return argument.getValue().exp();
            case LN:
                return argument.getValue().log();
            case ABS:
                return argument.getValue().abs();
            case LOG:
                return argument.getValue().log().times(0.43429448190325182765);
            case LOG2:
                return argument.getValue().log().times(1.442695040888963407360);

            case CONJ:
                return argument.getValue().conjugate();

            case RE:
                return new Complex(argument.getValue().getRe(), 0);

            case IM:
                return new Complex(argument.getValue().getIm(), 0);

            case NORM:
                return new Complex(argument.getValue().norm(), 0);

            case ARG:
                return new Complex(argument.getValue().arg(), 0);

            case GAMMA:
                return argument.getValue().gamma_la();

            case FACT:
                return argument.getValue().factorial();

            case ABSRE:
                return argument.getValue().absre();

            case ABSIM:
                return argument.getValue().absim();

            case GI:
                return argument.getValue().gaussian_integer();

            case REC:
                return argument.getValue().reciprocal();

            case FLIP:
                return argument.getValue().flip();

            case ROUND:
                return argument.getValue().round();

            case CEIL:
                return argument.getValue().ceil();

            case FLOOR:
                return argument.getValue().floor();

            case TRUNC:
                return argument.getValue().trunc();

            case ERF:
                return argument.getValue().erf();

            case R_ZETA:
                return argument.getValue().riemann_zeta();
                
            case VSIN:
                return argument.getValue().vsin();
                
            case AVSIN:
                return argument.getValue().avsin();
                
            case VCOS:
                return argument.getValue().vcos();
                
            case AVCOS:
                return argument.getValue().avcos();
                
            case CVSIN:
                return argument.getValue().cvsin();
                
            case ACVSIN:
                return argument.getValue().acvsin();
                
            case CVCOS:
                return argument.getValue().cvcos();
                
            case ACVCOS:
                return argument.getValue().acvcos();
                
            case HVSIN:
                return argument.getValue().hvsin();
                
            case AHVSIN:
                return argument.getValue().ahvsin();
                
            case HVCOS:
                return argument.getValue().hvcos();
                
            case AHVCOS:
                return argument.getValue().ahvcos();
                
            case HCVSIN:
                return argument.getValue().hcvsin();
                
            case AHCVSIN:
                return argument.getValue().ahcvsin();
                
            case HCVCOS:
                return argument.getValue().hcvcos();
                
            case AHCVCOS:
                return argument.getValue().ahcvcos();
                
            case EXSEC:
                return argument.getValue().exsec();
                
            case AEXSEC:
                return argument.getValue().aexsec();
            
            case EXCSC:
                return argument.getValue().excsc();
                
            case AEXCSC:
                return argument.getValue().aexcsc();

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
