package com.unicauca.Parcial.Service;

import com.unicauca.Parcial.Model.Stock;
import com.unicauca.Parcial.Model.User;
import com.unicauca.Parcial.Repository.IStockRepository;
import com.unicauca.Parcial.Repository.IUserRepository;
import com.unicauca.Parcial.Repository.StockRepository;
import com.unicauca.Parcial.Repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Data
@Service
public class QueryService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IStockRepository stockRepository;

    public QueryService(){
        userRepository = new UserRepository();
        stockRepository = new StockRepository();
    }

    /**
     * @return List of all users
     */
    public List<Stock> getStocks(int idUser) {
        User userAux = userRepository.findById(idUser);
        if(userAux != null){
            return userAux.getStocks();
        }
        return null;
    }
    /**
     * @param idUser User id to search
     * @param idStock Stock id to search
     * @return Stock if found, null if not found
     */
    public Stock getStock(int idUser, int idStock) {
        User userAux = userRepository.findById(idUser);
        if(userAux != null){
            return userAux.getStockById(idStock);
        }
        return null;
    }

    /**
     * @param idUser User id to search
     * @param idStock Stock id to update
     * @param upperThreshold New upper threshold
     * @return true if stock was found and updated, false if not found
     */
    public boolean updateUpperThreshold(int idUser, int idStock, double upperThreshold) {
        User userAux = userRepository.findById(idUser);
        if(userAux != null){
            return userAux.updateUpperThreshold(idStock, upperThreshold);
        }
        return false;
    }

    /**
     * @param idUser User id to search
     * @param idStock Stock id to update
     * @param lowerThreshold New upper threshold
     * @return true if stock was found and updated, false if not found
     */
    public boolean updateLowerThreshold(int idUser, int idStock, double lowerThreshold) {
        User userAux = userRepository.findById(idUser);
        if(userAux != null){
            return userAux.updateLowerThreshold(idStock, lowerThreshold);
        }
        return false;
    }

    /**
     * @param idUser User id to search
     * @param idStock Stock id to search
     * @return true if stock was found and deleted, false if not found
     */
    public boolean addStock(int idUser, int idStock) {
        User userAux = userRepository.findById(idUser);
        Stock stockAux = stockRepository.findById(idStock);
        if(userAux != null && stockAux != null){
            userAux.addStock(stockAux);
            return true;
        }
        return false;
    }

    /**
     * @param idUser User id to search
     * @param idStock Stock id to search
     * @return true if stock was found and deleted, false if not found
     */
    public boolean removeStock(int idUser, int idStock) {
        User userAux = userRepository.findById(idUser);
        Stock stockAux = stockRepository.findById(idStock);
        if(userAux != null && stockAux != null){
            userAux.removeStock(stockAux);
            return true;
        }
        return false;
    }
}
