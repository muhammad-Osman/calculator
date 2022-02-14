package com.self.calculator.controller;

import com.self.calculator.model.PostRequest;
import com.self.calculator.model.PostResponse;
import com.self.calculator.model.SquareRootRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalController {

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public PostResponse Calculator(@RequestBody PostRequest inputPayload) {
        PostResponse response = new PostResponse();
        double result;
        try {
            if (inputPayload.getOperator().isEmpty() || inputPayload.getOperator() == null) {
                response.setId(401);
                response.setError("Operator cannot be empty!");
                return response;
            } else if (inputPayload.getFirstValue().isEmpty() || inputPayload.getFirstValue() == null) {
                response.setId(401);
                response.setError("First Operand cannot be empty!");
                return response;
            } else if (inputPayload.getSecondValue().isEmpty() || inputPayload.getSecondValue() == null) {
                response.setId(401);
                response.setError("Second Operand cannot be empty!");
                return response;
            }

            String operator = inputPayload.getOperator();
            switch (operator) {
                case "+":
                    result = Double.parseDouble(inputPayload.getFirstValue())
                            + Double.parseDouble(inputPayload.getSecondValue());
                    response.setId(200);
                    response.setMessage(Double.toString(result));
                    return response;
                case "-":
                    result = Double.parseDouble(inputPayload.getFirstValue())
                            - Double.parseDouble(inputPayload.getSecondValue());
                    response.setId(200);
                    response.setMessage(Double.toString(result));
                    return response;
                case "÷":
                    result = Double.parseDouble(inputPayload.getFirstValue())
                            / Double.parseDouble(inputPayload.getSecondValue());
                    response.setId(200);
                    response.setMessage(Double.toString(result));
                    return response;
                case "x":
                    result = Double.parseDouble(inputPayload.getFirstValue())
                            * Double.parseDouble(inputPayload.getSecondValue());
                    response.setId(200);
                    response.setMessage(Double.toString(result));
                    return response;
                default:
                    result = 0;
                    response.setId(999);
                    response.setError("Operator passsed in not valid");
                    return response;
            }
        } catch (Exception ex) {
            ex.getStackTrace();
            response.setId(401);
            response.setError("Fatal error occured!");
            return response;
        }
    }

    @RequestMapping(value = "/squareroot", method = RequestMethod.POST)
    public PostResponse SquareRoot(@RequestBody SquareRootRequest inputPayload) {
        PostResponse response = new PostResponse();
        try {

            // Validate the input values
            if (inputPayload.getSquareRootOperand().isEmpty() || inputPayload.getSquareRootOperand() == null) {
                response.setId(401);
                response.setError("Square root operand cannot be empty!");
                return response;
            }

            // Perform calculation
            double squareRootValue = Math.sqrt(Double.parseDouble(inputPayload.getSquareRootOperand()));
            response.setId(200);
            response.setMessage(Double.toString(squareRootValue));
        } catch (Exception ex) {
            ex.getStackTrace();
            response.setId(401);
            response.setError("Fatal error occured!");
        }
        return response;
    }

    @RequestMapping(value = "/cos", method = RequestMethod.POST)
    public ResponseEntity<?> cos(@RequestBody double cosValue) {
        double radians = Math.toRadians(cosValue);
        double cosValueResult = Math.cos(radians);
        return new ResponseEntity<>(cosValueResult, HttpStatus.OK);
    }

    @RequestMapping(value = "/sin", method = RequestMethod.POST)
    public ResponseEntity<?> sin(@RequestBody double sinValue) {
        double radians = Math.toRadians(sinValue);
        double sinValueResult = Math.sin(radians);
        return new ResponseEntity<>(sinValueResult, HttpStatus.OK);
    }

}
