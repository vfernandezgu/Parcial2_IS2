package com.unicauca.Parcial.Controller;

import com.unicauca.Parcial.Model.Stock;
import com.unicauca.Parcial.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jose David Chilito Cometa, Valentina Fernandez Guerrero, Juan Esteban Yepez Rodriguez
 */

@RestController
public class StockController {
    private StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/stock")
    public List<Stock> findAll() {
        return stockService.findAll();
    }
}
