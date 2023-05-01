package com.gradusinterview.stockmarket.controller;


import com.gradusinterview.stockmarket.model.Stock;
import com.gradusinterview.stockmarket.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ping")
public class PingController {

    @GetMapping
    public String ping() {
        return "pong";
    }

}
