package edu.cnm.deepdive;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Calculator {


  private Scanner scanner;
  private Deque<Double> operands;

  public Calculator(Scanner scanner) {
    this.scanner = scanner;
    operands = new LinkedList<>();

  }

  public void process(){
    try {
      while (scanner.hasNextDouble()){
        if(scanner.hasNextDouble()){
          operands.push(scanner.nextDouble());
        }
      }
    } catch (NoSuchElementException ignored) {
    }finally {
      System.out.println(operands);
    }


  }


  public static void main(String[] args) {
    Calculator calculator = new Calculator(new Scanner(System.in));
    calculator.process();
  }


}
