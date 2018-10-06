package com.example.restFull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlienRepository {

	Connection con;
	
	public AlienRepository() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aliens", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Alien> getAliens(){
		List<Alien> aliens = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			String query = "select * from alien";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				aliens.add(new Alien(rs.getInt(1),rs.getString(2),rs.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aliens;
	}
	
	public Alien getAlien(int id) {
		try {
			Statement st = con.createStatement();
			String query = "select * from alien where id = "+id;
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				return new Alien(rs.getInt(1),rs.getString(2),rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void createAlien(Alien a1) {
		try {
			String query = "insert into alien values(?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, a1.getId());
			st.setString(2, a1.getName());
			st.setInt(3, a1.getPoints());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateAlien(Alien a1) {
		try {
			String query = "update alien set name=?,points=? where id=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, a1.getName());
			st.setInt(2, a1.getPoints());
			st.setInt(3, a1.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteAlien(int id) {
		try {
			String query = "delete from alien where id=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
