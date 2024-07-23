package com.example.api_pratica.controllers;

import com.example.api_pratica.exceptions.UnsupportedMathOperationException;
import com.example.api_pratica.math.MathOperations;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import static com.example.api_pratica.numberConverter.NumberConverter.convertToDouble;
import static com.example.api_pratica.numberConverter.NumberConverter.isNumeric;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();
    private MathOperations math = new MathOperations();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Digite um valor numérico!");
        }

        return math.sum(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Digite um valor numérico!");
        }

        return math.subtraction(convertToDouble(numberOne), convertToDouble(numberTwo));    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Digite um valor numérico!");
        }

        return math.multiplication(convertToDouble(numberOne), convertToDouble(numberTwo));    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Digite um valor numérico!");
        }

        return math.division(convertToDouble(numberOne), convertToDouble(numberTwo));    }

    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mean(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Digite um valor numérico!");
        }

        return math.mean(convertToDouble(numberOne), convertToDouble(numberTwo));    }

    @RequestMapping(value = "/squareroot/{number}", method = RequestMethod.GET)
    public Double squareRoot(
            @PathVariable(value = "number") String number) throws Exception{

        if(!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Digite um valor numérico!");
        }

        return math.squareRoot(convertToDouble(number));    }
}
