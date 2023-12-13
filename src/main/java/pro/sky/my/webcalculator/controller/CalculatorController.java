package pro.sky.my.webcalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.my.webcalculator.service.Plus;

@RestController
public class CalculatorController {

    Plus plus;

    public CalculatorController(Plus plus) {
        this.plus = plus;
    }

    @GetMapping("/calculator")
    public String welcomeCalculator() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/calculator/plus")
    public String plus(@RequestParam double num1, @RequestParam double num2) {
        return String.format("%f + %f = %.2f\n", num1, num2, plus.getValueOfExpression(num1, num2));
    }

    @GetMapping("/calculator/minus")
    public String minus(@RequestParam double num1, @RequestParam double num2) {

    }
}

