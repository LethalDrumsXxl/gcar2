package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	
	private static String db;
	private static String user;
	private static String pass;

	public static Connection getConnection(){
		
		db = "jdbc:postgresql://localhost:5432/tesis";
		user = "postgres";
		pass= "admin";
		
		try{
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(db,user,pass);
			return con;
		} catch (Exception ex) {
			System.out.println("Error en Database.getConnection():  " + ex.getMessage());
			return null;
		}
	}
	
	public static void close(Connection con){
		try {
            con.close();
        }catch(Exception ex){
        	System.out.println("Error en Database.close(): " + ex.getMessage());
        }
	}
	
}
