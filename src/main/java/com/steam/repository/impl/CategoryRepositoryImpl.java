package com.steam.repository.impl;

import com.steam.model.Category;
import com.steam.repository.CategoryRepository;
import com.steam.util.DBConnection;

import java.sql.*;
import java.util.*;

public class CategoryRepositoryImpl implements CategoryRepository {

    @Override
    public Category saveCategory(Category category) {
        if (category.getCategoryId() > 0) {
            return updateCategory(category);
        }
        return insertCategory(category);
    }

    private Category insertCategory(Category category) {
        String sql = "INSERT INTO CATEGORY (category_name) VALUES (?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, category.getCategoryName());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        category.setCategoryId(rs.getInt(1));
                    }
                }
                return category;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Category updateCategory(Category category) {
        String sql = "UPDATE CATEGORY SET category_name = ? WHERE category_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, category.getCategoryName());
            stmt.setInt(2, category.getCategoryId());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                return category;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Category findById(int categoryId) {
        String sql = "SELECT * FROM CATEGORY WHERE category_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, categoryId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToCategory(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteById(int categoryId) {
        String sql = "DELETE FROM CATEGORY WHERE category_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, categoryId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Category findByName(String categoryName) {
        String sql = "SELECT * FROM CATEGORY WHERE Category_name = ?";
        Connection con = DBConnection.getConnection();
        try (
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, categoryName);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToCategory(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Category mapResultSetToCategory(ResultSet rs) throws SQLException {
        return new Category(
                rs.getInt("Category_id"),
                rs.getString("Category_name")
        );
    }
    @Override
    public List<Category> findByNameContaining(String inputString){
        String sql = "SELECT * FROM CATEGORY as c " +
                "WHERE c.Category_name LIKE ?";
        ArrayList<Category> listCategory = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        try(
            PreparedStatement stmt = con.prepareStatement(sql)
        ){
            stmt.setString(1, "%" + inputString.toLowerCase() + "%");
            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    listCategory.add(new Category(rs.getInt("Category_id"), rs.getString("Category_name")));
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return listCategory;
    }
}
