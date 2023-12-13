package pro.sky.my.webcalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.my.webcalculator.service.Minus;
import pro.sky.my.webcalculator.service.Multiply;
import pro.sky.my.webcalculator.service.Plus;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    Plus plus;
    Minus minus;
    Multiply multiply;

    public CalculatorController(Plus plus, Minus minus, Multiply multiply) {
        this.plus = plus;
        this.minus = minus;
        this.multiply = multiply;
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


}

