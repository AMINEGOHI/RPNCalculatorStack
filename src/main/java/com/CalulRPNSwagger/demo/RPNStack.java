package com.CalulRPNSwagger.demo;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Stack;
@Component
public class RPNStack {
    @Getter
    private Stack<Integer> stack;

    public RPNStack(){
        this.stack=new Stack<>();
    }
    //can use stream
    private boolean inNum(String sequence){
        try {
            Integer.parseInt(sequence);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public int CalculateLastTwoOperand( int RightOperand,int LeftOperand,String Operator){
        //we have 4 cases: "+","-","*",("d" or "/")
        switch (Operator) {
            case "+":
                return  LeftOperand + RightOperand;
            case "-":
                return  LeftOperand - RightOperand;
            case "*":
                return  LeftOperand * RightOperand;
            case "d":
                return  LeftOperand / RightOperand;
        }
        //throwException
        return 0;
    }

    public int calculate(String expression){
        calculateOrPushToStack(expression);
        return  stack.pop();
    }

    public void calculateOrPushToStack(String expression){
        for (String sequence :expression.split(" ")){
            if (inNum(sequence)){
                stack.push(Integer.parseInt(sequence));
            }else if(stack.size()>=2) {
                //DoTheMath
                stack.push(CalculateLastTwoOperand(stack.pop(),stack.pop(),sequence));
            }else {
                System.out.println("invalid stack size");
            }
        }

    }




}
