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
				PreparedStatement ps = con.prepareStatement("insert into servicemanagement values(?,?,?,?,?,?)");
				ps.setInt(1, Integer.parseInt(packageID));
				ps.setString(2, packageType);
				ps.setFloat(1, Float.parseFloat(packageID));
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


}
