package com.CalulRPNSwagger.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class StackService {
    @Autowired
    private RPNStack rpnStack;

    public StackService(RPNStack rpnStack){
        this.rpnStack=rpnStack;
    }
    public int calculateService(String expression){
        return rpnStack.calculate(expression);
    }
    public Stack<Integer> getCalculatedStack(){
        return  rpnStack.getStack();
    }

}
