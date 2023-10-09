package dao;

import entity.Price;
import entity.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PriceDAO {
     private static final String SELECT_ALL_PRICE = "SELECT id, price FROM Price";    
     
     
     public List<Price> getAllPrices() {
        List<Price> prices = new ArrayList<>();
        
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRICE);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                        Price price = new Price();
                        price.setId(resultSet.getInt("id"));
                        price.setPrice(resultSet.getString("price"));
                        prices.add(price);
                    }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prices;
    }
}
