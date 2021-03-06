package com.transactionandstatistics.application.controller;

import com.transactionandstatistics.application.model.Statistics;
import com.transactionandstatistics.application.model.Transaction;
import com.transactionandstatistics.application.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    private TransactionService service;

    public TransactionController(@Autowired TransactionService service) {
        this.service = service;
    }

    @RequestMapping(path = "/transaction", method = RequestMethod.POST)
    public @ResponseStatus
    HttpStatus transaction(@RequestBody Transaction transaction) {
        return service.performTransaction(transaction);
    }

    @RequestMapping(path = "/statistics", method = RequestMethod.GET)
    public @ResponseBody
    Statistics statistics() {
        return service.retrieveStatistics();
    }
}
