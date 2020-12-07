package com.mathjazz.calc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    public class CalculatorController {
        
        @Autowired
        private CalculatorService calculatorService;
        @Autowired
        private FractionsService fractionsService;
                        
        @RequestMapping("/")
        public String home() {
            return "home";
        }
        
        @RequestMapping("/calculator")
        public String calculator() { return "calculator"; }
        
        @RequestMapping("/advanced")
        public String advancedHome() {
            return "advancedCalculator";
        }
        
        @RequestMapping("/fractions")
        public String fractions() {
            return "fractionsCalculator";
        }
        
        @RequestMapping("/contact")
        public String contact() {
            return "contact";
        }
        
        @RequestMapping("/logging")
        public String logging() {
            return "logging";
        }    
        
        @RequestMapping("/registration")
        public String registration() {
            return "registration";
        }
        
        @PostMapping("/calculator")
        public String doCalculation(Model model, CalculatorForm form, BindingResult binding) {
            if ((binding.hasErrors()) || ((form.getX()==null) || (form.getY()==null))) {
                return "calculator";
            }
            
            double result=0;
            switch(form.getOperation()) {
                case "+":
                    result=calculatorService.add(form.getX(), form.getY());
                    break;
                case "-":
                    result=calculatorService.subtract(form.getX(), form.getY());
                    break;
                case "*":
                    result=calculatorService.multiply(form.getX(), form.getY());
                    break;
                case "/":
                    if(form.getY()==0) {
                        return "calculator";
                    }
                    else
                    result=calculatorService.division(form.getX(), form.getY());
                    break;
            }
                      
            model.addAttribute("form", form);
            model.addAttribute("result", result);
            
            return "calculator";
        }
        
        @PostMapping("/advanced")
        public String doAdvancedCalculation(Model model, CalculatorForm form, BindingResult binding) {
            if (binding.hasErrors() || form.getX()==null) {
                return "advancedCalculator";
            }
            double result=0;
            switch(form.getOperation()) {
                case "sqrt":
                    result=calculatorService.sqrt2(form.getX());
                    break;
                case "^2":
                    result=calculatorService.secondPower(form.getX());
                    break;
                case "%":
                    result=calculatorService.percent(form.getX());
                    break;
                case "!":
                    result=(double)calculatorService.factorials(form.getX().intValue());
                    break;
                case "sin":
                    result=calculatorService.sine(form.getX());
                    break;
                case "cos":
                    result=calculatorService.cosine(form.getX());
                    break;
                case "tg":
                    result=calculatorService.tangent(form.getX());
                    break;
                case "ln":
                    result=calculatorService.logarithm(form.getX());
                    break;
                   
            }
            
            model.addAttribute("form", form);
            model.addAttribute("result", result);
            
            return "advancedCalculator";
        
        }
        
        @PostMapping("/fractions")
        public String doFractionsCalculation(Model model, FractionsForm form, BindingResult binding, String myError) {
            int resultWhoNum, resultNum, resultDen;
            myError=null;
            if (binding.hasErrors()) {
                return "fractionsCalculator";
            }
            else {
                switch(form.getOperation()) {
                    case "+":
                        fractionsService.add(form.getA(), form.getB(), form.getC(), form.getX(), form.getY(), form.getZ());
                        break;
                    case "-":
                        fractionsService.subtract(form.getA(), form.getB(), form.getC(), form.getX(), form.getY(), form.getZ());
                        break;
                    case "*":
                        fractionsService.multiply(form.getA(), form.getB(), form.getC(), form.getX(), form.getY(), form.getZ());
                        break;
                    case "/":
                        fractionsService.division(form.getA(), form.getB(), form.getC(), form.getX(), form.getY(), form.getZ());
                        break;
                }
            }
            resultWhoNum=fractionsService.wholeNumber;
            resultNum=fractionsService.numerator;
            resultDen=fractionsService.denominator;
            myError=fractionsService.myError;
            
            model.addAttribute("form", form);
            model.addAttribute("resultWhoNum", resultWhoNum);
            model.addAttribute("resultNum", resultNum);
            model.addAttribute("resultDen", resultDen);
            model.addAttribute("myError", myError);
            
                        
            return "fractionsCalculator";
        }    
        
        @GetMapping("/calculator")
        public String doCalculation(CalculatorForm form) {
            return "calculator";
        }

        @GetMapping("/advanced")
        public String doAdvancedCalculation(CalculatorForm form) {
            return "advancedCalculator";
        }
        
        @GetMapping("/fractions")
        public String doFractionsCalculation(FractionsForm form) {
            return "fractionsCalculator";
        }
    }