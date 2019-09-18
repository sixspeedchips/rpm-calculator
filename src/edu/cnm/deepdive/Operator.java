package edu.cnm.deepdive;

import java.util.LinkedList;

/**
 * Enumerated values representing operators in a postfix (RPN) calculator. Each operator has a token
 *  that is used to recognize the operator in an input string, and to represent the operator in an
 * output string.
 */
public enum Operator implements Operation {

  /** pops two values from stack, pushes sum of the two on to the stack */
  ADD("+", stack -> {
    Double operandOne = stack.pop();
    Double operandTwo = stack.pop();
    stack.push(operandOne + operandTwo);
  }),
  /** pops two values from stack, pushes the difference of the two on to the stack. */
  SUBTRACT("-", stack -> {
    Double operandOne = stack.pop();
    Double operandTwo = stack.pop();
    stack.push(operandTwo - operandOne);
  }),
  /** pops two values from the stack, pushes the multiplication of the two back on to the stack. */
  MULTIPLY("*", stack -> {
    Double operandOne = stack.pop();
    Double operandTwo = stack.pop();
    stack.push(operandOne * operandTwo);
  }),
  /** pops two values from the stack, pushes the division of the second by the first on to the stack */
  DIVIDE("/", stack -> {
    Double operandOne = stack.pop();
    Double operandTwo = stack.pop();
    stack.push(operandTwo / operandOne);
  }),
  /** pops a value off the stack, takes the square root and pushes it back on to the stack */
  SQUARE_ROOT("sqrt", stack -> {
    Double operandOne = stack.pop();
    stack.push(Math.sqrt(operandOne));
  }),
  /** pops two values off the stack, raises the second to power of the first, pushes the result back to the stack */
  POWER("^", stack -> {
    Double operandOne = stack.pop();
    Double operandTwo = stack.pop();
    stack.push(Math.pow(operandTwo, operandOne));
  }),
  /** pops two values off the stack, takes the modulo of the first by the second, pushes it back to the stack */
  MODULO("%", stack -> {
    Double operandOne = stack.pop();
    Double operandTwo = stack.pop();
    stack.push(operandTwo % operandOne);
  });

  private String token;
  private Operation operation;

  /**
   * @param token - the string representation of the token
   * @param operation - the operation the enum represents on the stack
   */
  Operator(String token, Operation operation) {
    this.token = token;
    this.operation = operation;
  }

  /**
   * Exercises the Operator enum by printing all of the enumerated values (as an array).
   * @param args command lines arguments ignored
   */
  public static void main(String[] args) {

  }


  @Override
  public String toString() {
    return super.toString() + "(" + token + ")";
  }

  /**
   * The operation method
   * @param stack - the stack the specific operation is applied to.
   */
  @Override
  public void calculate(LinkedList<Double> stack) {
    operation.calculate(stack);
  }
  //TODO add operate method with switch; later version will use @Override;

}
