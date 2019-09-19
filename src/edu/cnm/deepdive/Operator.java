package edu.cnm.deepdive;

import java.util.Deque;

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
  SQUARE_ROOT("sqrt"){
    protected boolean needsEscape(){
      return false;
    }
  },
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
    assert token.equals("*");
  }

  protected boolean needsEscape(){
    return true;
  }

  @Override
  public String toString() {
    return token;
  }


  public static void operate(String token, Deque<Double> operands){

    Operator operator = null;
    for (Operator compare : values()) {
      if(compare.token.equals(token)){
        operator = compare;
        break;
      }
    }
    double operand = operands.pop();
    double result;
    switch (operator){
      case ADD:
        result = operands.pop() + operand;
        break;
      case SUBTRACT:
        result = operands.pop() - operand;
        break;
      case POWER:
        result = Math.pow(operands.pop(),operand);
        break;
      case DIVIDE:
        result = operands.pop() / operand;
        break;
      case MODULO:
        result = operands.pop() % operand;
        break;
      case MULTIPLY:
        result = operands.pop() * operand;
        break;
      case SQUARE_ROOT:
        result = Math.sqrt(operand);
        break;
      default:
        result = 0;
    }
    operands.push(result);

  }

  public static String tokenPattern(){

    StringBuilder sb = new StringBuilder();
    for (Operator value : values()) {
      sb.append(value.needsEscape() ? "\\" : "").append(value.token).append("|");
    }
    sb.deleteCharAt(sb.length()-1);
    return String.format("(?<=^|\\s)%s(?=\\s|$)", sb.toString()) ;
  }
}
