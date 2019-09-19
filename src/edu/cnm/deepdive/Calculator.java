package edu.cnm.deepdive;

import java.io.InputStream;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Calculator {


  public void process(InputStream in) {

    Deque<Double> operands = new LinkedList<>();

    try(Scanner scanner = new Scanner(in)){

      String pattern = Operator.tokenPattern();
      while (scanner.hasNext()) {
        if (scanner.hasNextDouble()){
            operands.push(scanner.nextDouble());
        } else if (scanner.hasNext(Operator.tokenPattern())){
          Operator.operate(scanner.next(pattern),operands);
        } else {

          throw new IllegalArgumentException(scanner.next());

        }
      }
    } catch (NoSuchElementException ignored) {
    } finally {
      System.out.println(operands);
      }
  }




  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    try {
      calculator.process(System.in);
    } catch (IllegalArgumentException ignored) {
    }

  }


}
