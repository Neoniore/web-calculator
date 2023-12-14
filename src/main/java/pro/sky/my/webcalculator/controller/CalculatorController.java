package pro.sky.my.webcalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.my.webcalculator.service.Divide;
import pro.sky.my.webcalculator.service.Minus;
import pro.sky.my.webcalculator.service.Multiply;
import pro.sky.my.webcalculator.service.Plus;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final Plus plus;
    private final Minus minus;
    private final Multiply multiply;
    private final Divide divide;

    public CalculatorController(Plus plus, Minus minus, Multiply multiply, Divide divide) {
        this.plus = plus;
        this.minus = minus;
        this.multiply = multiply;
        this.divide = divide;
    }

    @GetMapping
    public String welcomeCalculator() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam double num1, @RequestParam double num2) {
        return String.format("%f + %f = %.2f\n", num1, num2, plus.getValueOfExpression(num1, num2));
    }

    @GetMapping("/minus")
    public String minus(@RequestParam double num1, @RequestParam double num2) {
        return String.format("%f - %f = %.2f\n", num1, num2, minus.getValueOfExpression(num1, num2));
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam double num1, @RequestParam double num2) {
        return String.format("%f * %f = %.2f\n", num1, num2, multiply.getValueOfExpression(num1, num2));
    }

    @GetMapping("/divide")
    public String divide(@RequestParam double num1, @RequestParam double num2) {
        try {
            return String.format("%f / %f = %.2f\n", num1, num2, divide.getValueOfExpression(num1, num2));
        } catch (IllegalArgumentException e) {
            return "На 0 делить нельзя!";
        }

    }
}

