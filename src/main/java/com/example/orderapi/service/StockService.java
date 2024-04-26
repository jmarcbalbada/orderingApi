package com.example.orderapi.service;
import com.example.orderapi.entity.Stock;
import com.example.orderapi.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public Stock modifyStock(int productId, int quantityChange) {
        Optional<Stock> existingStock = stockRepository.findById(productId);
        if (existingStock.isPresent()) {
            Stock stock = existingStock.get();
            stock.setQuantity(stock.getQuantity() + quantityChange);
            return stockRepository.save(stock);
        } else {
            throw new RuntimeException("Stock for product ID " + productId + " not found");
        }
    }

    public Stock selectStockItem(int productId) {
        Optional<Stock> stock = stockRepository.findById(productId);
        return stock.orElse(null);
    }

    public Iterable<Stock> getAllStocks() {
        return stockRepository.findAll();
    }
}