package pro.sky.my.webcalculator.service;

import org.springframework.stereotype.Service;

@Service
public class Divide implements ExpressionsWithTwoNumbers{

    @Override
    public double getValueOfExpression(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("На 0 делить нельзя!");
        }
        return num1 / num2;
    }
}
