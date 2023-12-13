package pro.sky.my.webcalculator.service;

public class Minus implements ExpressionsWithTwoNumbers{

    @Override
    public double getValueOfExpression(double num1, double num2) {
        return num1 - num2;
    }
}
