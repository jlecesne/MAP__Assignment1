package com.example.assignment1;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.Math.*;
import java.lang.*;



public class Calculator {

    ArrayList<String> calculation;
    int total;

    public Calculator() {
        total = -433;
        calculation= new ArrayList<String>();
    }
    void push(String value) {
        if(!value.isEmpty()) {
            calculation = new ArrayList<String>(Arrays.asList(value.split(" ")));
        }

        System.out.println(calculation);

    }

    int calculate() {

        int f1=0;
        int f2=0;
        int operand=0;
        boolean flag;
        boolean flag2=true;
        total = -433;

        if(calculation.isEmpty()) {
            Log.d("TESTING", "MOMOMO");
            return total;
        } else {
            while (!calculation.isEmpty()) {
                System.out.println(calculation);
                if (flag2) {
                    //Get first number
                    flag = checkNumber();
                    if (!flag) {
                        System.out.println("Not an operator");
                        total = -433;
                        break;
                    } else {
                        f1 = Integer.parseInt(calculation.get(0));
                        calculation.remove(0);
                    }

                    //Get Operand
                    operand = checkOperand();
                    if (operand == 0) {
                        System.out.println("Not an operator");
                        total = -433;
                        break;
                    }

                    //Get second number
                    flag = checkNumber();
                    if (!flag) {
                        System.out.println("Not an operator");
                        total = -433;
                        break;
                    } else {
                        f2 = Integer.parseInt(calculation.get(0));
                        calculation.remove(0);
                    }

                    //Calculate Total
                    total = calculateTotal(f1, operand, f2);
                    flag2 = false;
                } else {
                    //Get operand
                    operand = checkOperand();
                    if (operand == 0) {
                        System.out.println("Not an operator");
                        total = -433;
                        break;
                    }


                    //Get Number
                    flag = checkNumber();
                    if (!flag) {
                        System.out.println("Not an operator");
                        total = -433;
                        break;
                    } else {
                        f2 = Integer.parseInt(calculation.get(0));
                        calculation.remove(0);
                    }

                    total=calculateTotal(total, operand, f2);
                    flag2=false;

                }

                f1=0;
                f2=0;
                operand=0;
            }

            return total;
        }


    }

    int calculateTotal(int f1, int operand, int f2) {
        switch (operand) {
            case 1:
                return f1+f2;

            case 2:
                return f1-f2;

            case 3:
                return f1*f2;

            case 4:
                return f1/f2;

            case 5:
                return f1%f2;

            case 6:
                return (int) Math.pow(f1, f2);

            case 7:
                return Math.max(f1, f2);

            case 8:
                return Math.min(f1, f2);

            default:
                break;

        }

        return -1;

    }
    boolean checkNumber() {
        if(calculation.isEmpty()) {
            return false;
        }
        else {
            try {
                int number=Integer.parseInt(calculation.get(0));
            } catch (NumberFormatException nfe) {
                return false;
            }
        }
        return true;
    }

    int checkOperand() {
        if(calculation.isEmpty()) {
            return 0;
        }
        else {
            switch (calculation.get(0)) {
                case "+":
                    calculation.remove(0);
                    return 1;


                case "-":
                    calculation.remove(0);
                    return 2;

                case "*":
                    calculation.remove(0);
                    return 3;


                case "/":
                    calculation.remove(0);
                    return 4;

                case "%":
                    calculation.remove(0);
                    return 5;

                case "pow":
                    calculation.remove(0);
                    return 6;

                case "max":
                    calculation.remove(0);
                    return 7;

                case "min":
                    calculation.remove(0);
                    return 8;


                default:
                    break;
            }
        }
        return 0;
    }
}
