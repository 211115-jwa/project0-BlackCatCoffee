package com.revature.data.postgres;

import java.util.HashSet;
import java.util.Set;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.Bike;
import com.revature.data.BikeDAO;
import com.revature.utils.ConnectionUtil;

public class BikePostgres implements BikeDAO {
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public int create(Bike dataToAdd) {
		int generatedId = 0;

		try (Connection conn = connUtil.getConnection()) {

			conn.setAutoCommit(false);

			String sql = "insert into bike (id, bike_model, bike_type, manufacturer, frame_weight, price) "
					+ "values (default, ?, ?, ?, ?, ?)";
			String[] keys = { "id" };
			PreparedStatement pStmt = conn.prepareStatement(sql, keys);
			pStmt.setString(1, dataToAdd.getBikeModel());
			pStmt.setString(2, dataToAdd.getBikeType());
			pStmt.setString(3, dataToAdd.getManufacturer());
			pStmt.setInt(4, dataToAdd.getFrameWeight());
			pStmt.setInt(5, dataToAdd.getPrice());
			pStmt.executeUpdate();
			ResultSet resultSet = pStmt.getGeneratedKeys();

			if (resultSet.next()) {
				generatedId = resultSet.getInt("id");
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return generatedId;
	}

	@Override
	public Bike getById(int id) {
		Bike bike = null;
		try (Connection conn = connUtil.getConnection()) {
			String sql = "select * from bike where id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);

			ResultSet resultSet = pStmt.executeQuery();
			if (resultSet.next()) {
				bike = new Bike();
				bike.setId(id);
				bike.setBikeModel(resultSet.getString("bike_model"));
				bike.setBikeType(resultSet.getString("bike_type"));
				bike.setManufacturer(resultSet.getString("manufacturer"));
				bike.setFrameWeight(resultSet.getInt("frame_weight"));
				bike.setPrice(resultSet.getInt("price"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bike;
	}

	@Override
	public Set<Bike> getAll() {
		Set<Bike> allBikes = new HashSet<>();

		try (Connection conn = connUtil.getConnection()) {
			String sql = "select * from bike";
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);

			while (resultSet.next()) {
				Bike bike = new Bike();

				bike.setId(resultSet.getInt("id"));
				bike.setBikeModel(resultSet.getString("bike_model"));
				bike.setBikeType(resultSet.getString("bike_type"));
				bike.setManufacturer(resultSet.getString("manufacturer"));
				bike.setFrameWeight(resultSet.getInt("frame_weight"));
				bike.setPrice(resultSet.getInt("price"));

				allBikes.add(bike);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allBikes;
	}

	@Override
	public void update(Bike dataToUpdate) {
		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);

			String sql = "update bike set " + "bike_model=?,bike_type=?,manufacturer=?,frame_weight=?,price=? "
					+ "where id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, dataToUpdate.getBikeModel());
			pStmt.setString(2, dataToUpdate.getBikeType());
			pStmt.setString(3, dataToUpdate.getManufacturer());
			pStmt.setInt(4, dataToUpdate.getFrameWeight());
			pStmt.setInt(5, dataToUpdate.getPrice());
			pStmt.setInt(6, dataToUpdate.getId());

			int rowsAffected = pStmt.executeUpdate();

			if (rowsAffected == 1) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Bike dataToDelete) {
		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);

			String sql = "delete from bike " + "where id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, dataToDelete.getId());

			int rowsAffected = pStmt.executeUpdate();

			if (rowsAffected <= 1) 
				conn.commit();
			else 
				
				conn.rollback();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Set<Bike> getByBikeManufacturer(String Manufacturer) {
		Set<Bike> byManufacturer = new HashSet<>();

		try (Connection conn = connUtil.getConnection()) {
			String sql = "select * from bike where manufacturer=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, sql);

			ResultSet resultSet = pStmt.executeQuery();

			while (resultSet.next()) {
				Bike bike = new Bike();
				bike.setId(resultSet.getInt("id"));
				bike.setBikeModel(resultSet.getString("bike_model"));
				bike.setBikeType(resultSet.getString("bike_type"));
				bike.setManufacturer(resultSet.getString("manufacturer"));
				bike.setFrameWeight(resultSet.getInt("frame_weight"));
				bike.setPrice(resultSet.getInt("price"));

				byManufacturer.add(bike);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return byManufacturer;
	}

	@Override
	public Set<Bike> getByBikeModel(String bikeModel) {
		Set<Bike> byModel = new HashSet<>();

		try (Connection conn = connUtil.getConnection()) {
			String sql = "select * from bike where bike_model=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, sql);

			ResultSet resultSet = pStmt.executeQuery();

			while (resultSet.next()) {
				Bike bike = new Bike();
				bike.setId(resultSet.getInt("id"));
				bike.setBikeModel(resultSet.getString("bike_model"));
				bike.setBikeType(resultSet.getString("bike_type"));
				bike.setManufacturer(resultSet.getString("manufacturer"));
				bike.setFrameWeight(resultSet.getInt("frame_weight"));
				bike.setPrice(resultSet.getInt("price"));

				byModel.add(bike);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return byModel;
	}

}
