package edu.cnm.deepdive;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Enumerated values representing operators in a postfix (RPN) calculator. Each operator has a token
 *  that is used to recognize the operator in an input string, and to represent the operator in an
 * output string.
 */
public enum Operator {

  /** pops two values from stack, pushes sum of the two on to the stack */
  ADD("+"),
  /** pops two values from stack, pushes the difference of the two on to the stack. */
  SUBTRACT("-"),
  /** pops two values from the stack, pushes the multiplication of the two back on to the stack. */
  MULTIPLY("*"),
  /** pops two values from the stack, pushes the division of the second by the first on to the stack */
  DIVIDE("/"),
  /** pops a value off the stack, takes the square root and pushes it back on to the stack */
  SQUARE_ROOT("sqrt"),
  /** pops two values off the stack, raises the second to power of the first, pushes the result back to the stack */
  POWER("^"),
  /** pops two values off the stack, takes the modulo of the first by the second, pushes it back to the stack */
  MODULO("%");

  private String token;
  /**
   * @param token - the string representation of the token
   */
  Operator(String token) {
    this.token = token;
  }

  /**
   * Exercises the Operator enum by printing all of the enumerated values (as an array).
   * @param args command lines arguments ignored
   */
  public static void main(String[] args) {
    System.out.println(Arrays.toString(Operator.values()));
  }


  @Override
  public String toString() {
    return  token;
  }

  /**
   * The operation method
   * @param stack - the stack the specific operation is applied to.
   */
  //TODO add operate method with switch; later version will use @Override;

}
