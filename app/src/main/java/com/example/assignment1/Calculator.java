package com.example.assignment1;

import java.util.ArrayList;

public class Calculator {

    ArrayList<String> calculation = new ArrayList<>();
    int total=0;

    void push(String value) {

    }

    int calculate() {

        int f1=0;
        int f2=0;
        int operand=0;
        boolean flag;
        boolean flag2=true;

        while(calculation.size()!=0) {
            if(flag2){
                //Get first number
                flag=checkNumber();
                if(!flag) {
                    System.out.println("Not an operator");
                    break;
                }
                else {
                    f1 = Integer.parseInt(calculation.get(0));
                    calculation.remove(0);
                }

                //Get Operand
                operand=checkOperand();
                if(operand==0){
                    System.out.println("Not an operator");
                    break;
                }
                else {
                    calculation.remove(0);
                }

                //Get second number
                flag=checkNumber();
                if(!flag) {
                    System.out.println("Not an operator");
                    break;
                }
                else {
                    f2 = Integer.parseInt(calculation.get(0));
                    calculation.remove(0);
                }

                //Calculate Total
                total = calculateTotal(f1, operand, f2);
                flag2=false;
            }
            else {
                //Get operand
                operand=checkOperand();
                if(operand==0){
                    System.out.println("Not an operator");
                    break;
                }
                else {
                    calculation.remove(0);
                }

                //Get Number
                flag=checkNumber();
                if(!flag) {
                    System.out.println("Not an operator");
                    break;
                }
                else {
                    f2 = Integer.parseInt(calculation.get(0));
                    calculation.remove(0);
                }


            }
        }

        return 0;
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

            default:
                break;

        }

        return -1;

    }
    boolean checkNumber() {
        try {
            int number=Integer.parseInt(calculation.get(0));
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    int checkOperand() {
        switch(calculation.get(0)) {
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

            default:
                break;
        }

        return 0;
    }
}
