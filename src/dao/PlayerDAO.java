package dao;

import entity.Player;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PlayerDAO {

    private static final String INSERT_PLAYER_SQL = "INSERT INTO Player (fullName, email, username, PASSWORD) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_PLAYERS_SQL = "SELECT * FROM Player";
    private static final String UPDATE_PLAYER_SQL = "UPDATE Player SET fullName=?, email=?, PASSWORD=? WHERE id=?";
    private static final String UPDATE_MONEY_PLAYER_SQL = "UPDATE Player SET totalMoney=? WHERE id=?";
    private static final String DELETE_PLAYER_SQL = "DELETE FROM Player WHERE id=?";
    private static final String UPDATE_PASSWORD_PLAYER_SQL = "UPDATE Player SET password=? WHERE id=?";

    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();

        try (Connection connection = DbConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PLAYERS_SQL); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Player player = new Player();
                player.setId(resultSet.getInt("id"));
                player.setFullName(resultSet.getString("fullName"));
                player.setEmail(resultSet.getString("email"));
                player.setUsername(resultSet.getString("username"));
                player.setPassword(resultSet.getString("password"));
                player.setTotalMoney(resultSet.getString("totalMoney"));
                players.add(player);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return players;
    }

    public boolean addPlayer(Player player) {
        try (Connection connection = DbConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PLAYER_SQL)) {
            preparedStatement.setString(1, player.getFullName());
            preparedStatement.setString(2, player.getEmail());
            preparedStatement.setString(3, player.getUsername());
            preparedStatement.setString(4, player.getPassword());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePasswordOfPlayer(Player player) {
        try (Connection connection = DbConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PASSWORD_PLAYER_SQL)) {
            preparedStatement.setString(1, player.getPassword());
            preparedStatement.setInt(2, player.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateMoneyOfPlayer(Player player) {
        try (Connection connection = DbConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MONEY_PLAYER_SQL)) {
            preparedStatement.setString(1, player.getTotalMoney());
            preparedStatement.setInt(2, player.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePlayer(Player player) {
        try (Connection connection = DbConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PLAYER_SQL)) {
            preparedStatement.setString(1, player.getFullName());
            preparedStatement.setString(2, player.getEmail());
            preparedStatement.setString(3, player.getPassword());
            preparedStatement.setInt(4, player.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletePlayer(Integer id) {
        try (Connection connection = DbConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PLAYER_SQL)) {
            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
