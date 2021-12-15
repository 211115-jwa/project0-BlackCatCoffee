package com.revature.data.postgres;

import java.util.Set;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Bike;
import com.revature.data.BikeDAO;
import com.revature.utils.ConnectionUtil;

public class BikePostgres implements BikeDAO {
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();
	
	@Override
	public int create(Bike dataToAdd) {
		int generatedId = 0;
		
		try(Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);
			String sql = "insert into bike (id, bike_model, bike_type, manufacturer, frame_weight, price) "
					+ "values (default, ?, ?, ?, ?, ?)";
			String[] keys = {"id"};
			PreparedStatement pStmt = conn.prepareStatement(sql,keys);
			pStmt.setString(1, dataToAdd.getBikeModel());
			pStmt.setString(2, dataToAdd.getBikeType());
			pStmt.setString(3, dataToAdd.getManufacturer());
			pStmt.setDouble(4, dataToAdd.getFrameWeight());
			pStmt.setDouble(5, dataToAdd.getPrice());
			pStmt.executeUpdate();
			ResultSet resultSet = pStmt.getGeneratedKeys();
			
			if (resultSet.next()) {
				generatedId = resultSet.getInt("id");
				conn.commit();
			}else {
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
			String sql = "select * from pet where id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,id);
			
			ResultSet resultSet = pStmt.executeQuery();
			if (resultSet.next()) {
				bike = new Bike();
				bike.setId(id);
				bike.setBikeModel(resultSet.getString("bike_model"));
				bike.setManufacturer(resultSet.getString("manufacturer"));
				bike.setFrameWeight(resultSet.getDouble("frame_weight"));
				bike.setPrice(resultSet.getDouble("price"));

			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return bike;
	}

	@Override
	public Set<Bike> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Bike dataToUpdate) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Bike dataToDelete) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<Bike> getByBikeManufacturer(String Manufacturer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Bike> getByBikeModel(String bikeModel) {
		// TODO Auto-generated method stub
		return null;
	}

}
