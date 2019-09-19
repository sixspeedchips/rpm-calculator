package edu.cnm.deepdive;

import java.io.InputStream;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Calculator {


  public void process(InputStream in) throws NoSuchElementException{
    Deque<Double> operands = new LinkedList<>();
    try(Scanner scanner = new Scanner(in)){
      while (scanner.hasNextDouble()){
        if(scanner.hasNextDouble()){
          operands.push(scanner.nextDouble());
        }
      }
    } catch (Exception ignored) {
    } finally {
      System.out.println(operands);
      }
  }




  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    calculator.process(System.in);

  }


}
