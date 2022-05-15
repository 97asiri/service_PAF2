package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;


import com.jersy.dbconnect.dbConnection;



import com.jersy.dbconnect.dbConnection;




public class ServiceDao {

	// Insert
	public static String insertservice(String packageID,String packageType, String PackageInstruction,String services, String packageUnitPrice) {

		//DB connection

		Connection con = dbConnection.connect();

		try {
			//catching the package ID  in table
			PreparedStatement ps1 = con.prepareStatement("select packageID from servicemanagement where packageID=?");
			ps1.setInt(1, Integer.parseInt(packageID));
			ResultSet rrs = ps1.executeQuery();

			if (rrs.next()) {
				return "Already Exist";
			} else {

				//Inserting query
				PreparedStatement ps = con.prepareStatement("insert into servicemanagement values(?,?,?,?,?)");
				ps.setInt(1, Integer.parseInt(packageID));
				ps.setString(2, packageType);
				ps.setFloat(3, Float.parseFloat(packageID));
				ps.setString(4, PackageInstruction);
				ps.setString(5, services);
				
				
				int i = ps.executeUpdate();
				//System.out.println("hellooo");

				if (i > 0) {
					return "success";
				} else {
					return "failed";
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return "fail";

	}
	
	public static boolean checkeservID(String packageID) {

		Connection con = dbConnection.connect();

		try {

			//check the Query statement 
			PreparedStatement ps = con.prepareStatement("select * from servicemanagement where packageID=?");
			ps.setInt(1, Integer.parseInt(packageID));
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}
	//Update details according to the packageID 
	public static boolean changeservDetails(String packageID,String packageType, String PackageInstruction,String services, String packageUnitPrice) {

		Connection con =  dbConnection.connect();

		try {

					PreparedStatement ps = con.prepareStatement("update servicemanagement set packageType=? , packageUnitPrice=? , PackageInstruction=? , services=? where packageID=?");
					ps.setInt(1, Integer.parseInt(packageID));
					ps.setString(2, packageType);
					ps.setFloat(3, Float.parseFloat(packageUnitPrice));
					ps.setString(4, PackageInstruction);
					ps.setString(5, services);
					
					int i = ps.executeUpdate();
		
					if (i > 0) {
						return true;
					} else {
						return false;
					}
			
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}
	public String readCard() {
		String output = "";
		try {
			Connection con = dbConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>package ID</th><th>package type</th><th>Package Unit Price</th><th>package instruction</th><th>service</th>" + "<th>package ID</th>"
					+ "<th>package type</th>" + "<th>Package Unit Price</th>" + "<th>PackageInstruction</th>"+"<th>service</th>"+" <th>Update</th><th>Remove</th></tr>";
			String query = "select * from user_new";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String packageID = Integer.toString(rs.getInt(1));
				String packageType = rs.getString(2);
				String packageUnitPrice = Float.toString(rs.getInt(3));
				String PackageInstruction = rs.getString(4);
				String service = rs.getString(5);
				

				// Add into the html table
				output += "<tr><td><input id='hidIDUpdate'" + " name='hidIDUpdate' " + " type='hidden' value='" + packageID
						+ "'>" + packageType + "</td>";
				output += "<td>" + packageUnitPrice + "</td>";
				output += "<td>" + PackageInstruction + "</td>";
				output += "<td>" + service + "</td>";
				

				// buttons
//				output += "<td><input name='btnUpdate'" + " type='button' value='Update'"
//						+ "class='btnUpdate btn btn-secondary'></td>" + "<td> <input name='btnRemove'"
//						+ "type='button' value='Remove'" + " class='btnRemove btn btn-danger'" + " data-itemid='"
//						+ email + "'>" + "</td></tr>";

				output += "<td><input name='btnUpdate' type='button' value='Update' class=' btnUpdate btn btn-secondary'></td> "
						+ "<td><form method='post' action='insertServices.jsp'> " + "<input name='btnRemove' type='submit' "
						+ "value='Remove' class='btn btn-danger'> " + "<input name='hidItemIDDelete' type='hidden' "
						+ "value='" + packageID + "'>" + "</form></td></tr>";

			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the card details.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
