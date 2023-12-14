package pro.sky.my.webcalculator.service;

import org.springframework.stereotype.Service;

@Service
public class Plus implements ExpressionsWithTwoNumbers {

    @Override
    public double getValueOfExpression(double num1, double num2) {
        return num1 + num2;
    }
}
