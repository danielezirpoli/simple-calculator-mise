package com.danzir.calculator.controller;

import com.danzir.calculator.dto.SumBody;
import com.danzir.calculator.dto.SumResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calculator")
public class CalculatorApi {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorApi.class);

    @PostMapping("/sum")
    public ResponseEntity<SumResponse> sum(@RequestBody SumBody body){
        List<Double> factors = body.getFactors();
        Double result = factors.stream().mapToDouble(Double::doubleValue).sum();

        logger.info("sum: {} = {}", factors, result);
        return ResponseEntity.ok(new SumResponse(result));
    }

    @GetMapping("/check")
    public ResponseEntity<String> check(){
        return ResponseEntity.ok("ciao");
    }

}
