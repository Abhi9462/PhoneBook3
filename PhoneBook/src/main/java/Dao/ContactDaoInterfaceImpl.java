package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Contact;
import Util.ConnectionProvider;

public class ContactDaoInterfaceImpl implements ContactDaoInterface {
	Connection con = null;
	PreparedStatement pstmt = null;
	String query = null;
	Contact contact = null;

	public boolean createContact(Contact contact) {
		con = ConnectionProvider.createConnection();
		try {
			query = "insert into contacts(userID,contactName,contactEmail,contactAddress,contactPhone) values(?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, contact.getUserID());
			pstmt.setString(2, contact.getContactName());
			pstmt.setString(3, contact.getContactEmail());
			pstmt.setString(4, contact.getContactAddress());
			pstmt.setString(5, contact.getContactPhone());

			if (pstmt.executeUpdate() != 0)
				return true;

		} catch (Exception e) {
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return false;
	}

	public Contact searchContact(int id) {
		con = ConnectionProvider.createConnection();
		query = "select * from contacts where contactID=?";
		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				contact = new Contact();
				contact.setContactID(rs.getInt(1));
				contact.setUserID(rs.getString(2));
				contact.setContactName(rs.getString(3));
				contact.setContactEmail(rs.getString(4));
				contact.setContactAddress(rs.getString(5));
				contact.setContactPhone(rs.getString(6));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return contact;
	}

	public ArrayList<Contact> contactList(int id) {
		ArrayList<Contact> al = new ArrayList<Contact>();
		con = ConnectionProvider.createConnection();
		query = "select * from contacts where userID=?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			

			while (rs.next()) {
				contact = new Contact();
				contact.setContactID(rs.getInt(1));
				contact.setUserID(rs.getString(2));
				contact.setContactName(rs.getString(3));
				contact.setContactEmail(rs.getString(4));
				contact.setContactAddress(rs.getString(5));
				contact.setContactPhone(rs.getString(6));
				al.add(contact);
			}
        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return al;
	}

	public boolean deleteContact(int id) {
		
		con = ConnectionProvider.createConnection();
		try {
			System.out.println("DAO "+id);
			query = "delete from contacts where contactID=?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			if (pstmt.executeUpdate() != 0)
				return true;
			return false;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public boolean updateContact(Contact contact) {
		con = ConnectionProvider.createConnection();
		try {
			query = "update contacts set contactName=?,contactEmail=?,contactAddress=?,contactPhone=? where contactID=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, contact.getContactName());
			pstmt.setString(2, contact.getContactEmail());
			pstmt.setString(3, contact.getContactAddress());
			pstmt.setString(4, contact.getContactPhone());
			pstmt.setInt(5, contact.getContactID());

			if (pstmt.executeUpdate() != 0)
				return true;
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}

}
