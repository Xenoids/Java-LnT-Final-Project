package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Vector;

import javax.management.ConstructorParameters;
import javax.swing.JOptionPane;

import Database.koneksi;

public class CustDAO {
	String fix;
	Connection connection;
	
	public CustDAO() {
		// TODO Auto-generated constructor stub
		try {
			createconnection();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createconnection() throws SQLException
	{
		connection=koneksi.connect();
		
		if (connection==null) {
			throw new SQLException("connection");
		}
	}
	
	public Vector<Vector<String>> getCustData(){
		Vector<Vector<String>> data = new Vector<>();
		try {
			Statement stmt = connection.createStatement();
			String sql = "select * from menu";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Vector<String> rows = new Vector<>();
				rows.add(rs.getString(1));
				rows.add(rs.getString(2));
				rows.add(rs.getString(3));
				rows.add(rs.getString(4));
				data.add(rows);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public void insertData() {
		try {
			Statement stmt=connection.createStatement();
			String sql="Insert into menu Values('BC-005','Ayam','15','5')";
			
			
			stmt.executeUpdate(sql);//masukkin data,update data, hapus data
			System.out.println("Sukses Insert Data");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void InsertData(String nama, String harga, String stok) {
		try {
			Statement stmt = connection.createStatement();
			fix = CreateIDS();
			
			String sql = "Insert into menu values('"+fix+"', '"+nama+"', '"+harga+"', '"+stok+"')";
			
			stmt.executeUpdate(sql);
			
			JOptionPane.showMessageDialog(null, "Kode Boba : "+fix+"\nBerhasil diinput!","Confirmed",JOptionPane.INFORMATION_MESSAGE);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void UpdateData(String kode, String harga, String stok)
	{
			String sql = "Update menu SET Harga_Menu = ?, " + "Stok_Menu = ? " + "WHERE Kode_Menu = ? ";
			try {
				// preparing
				PreparedStatement pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, harga);
				pstmt.setString(2, stok);
				pstmt.setString(3, kode);
				
				// Update
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
	}
	
	public void DeleteData(String kode) {
		String sql = "Delete from menu WHERE Kode_Menu = ?";
		try {
			// Preparing
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, kode);
			
			// Update
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public String CreateID() {
		String id = "";
		String newId ="";
		try {
			Statement stmt = connection.createStatement();
			String sql = "SELECT Kode_Menu from menu ORDER BY Kode_Menu DESC LIMIT 1";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				id = rs.getString(1);
			}
			int latestId = Integer.parseInt(id.replaceAll("^[0-9]", ""));
			newId = "BC-" + String.format("%03d",latestId + 1);
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return newId;
	}
	
	public String CreateIDS() {
		Random random = new Random();
		String idkosong = "";
		String kode ="BC-";
		Integer x;
		String angka = Integer.toString(random.nextInt(900)+100);
		idkosong = kode.concat(angka);
		return idkosong;
	}
	
	
}
