package uk.co.cogitolearning.cogpar.functions;

import uk.co.cogitolearning.cogpar.Complex;

public class FibonacciFunction  extends AbstractOneArgumentFunction {

    public FibonacciFunction() {

        super();

    }

    @Override
    public Complex evaluate(Complex argument) {

        return argument.fibonacci();

    }
}
