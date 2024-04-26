package com.example.orderapi.controller;

import com.example.orderapi.entity.Stock;
import com.example.orderapi.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping
    public Stock addStock(@RequestBody Stock stock) {
        return stockService.addStock(stock);
    }

//    @PutMapping("/{productId}")
//    public Stock modifyStock(@PathVariable int productId, @RequestParam(required = true) int quantityChange) {
//        return stockService.modifyStock(productId, quantityChange);
//    }

//    @GetMapping("/{productId}")
//    public Stock selectStockItem(@PathVariable int productId) {
//        return stockService.selectStockItem(productId);
//    }

    @GetMapping
    public Iterable<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }
}
