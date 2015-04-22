package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import util.UserBean;
import dao.Database;

public class UserDAO {
	
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement cs = null;
	
	public static UserBean login(String rut, String pass) {
		try {
			String query = "SELECT * FROM usuarios WHERE rut = ? AND pass = ?";
			con = Database.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1,rut);
			ps.setString(2,pass);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				UserBean userBean = new UserBean();
				userBean.setRut(rs.getString(1));
				userBean.setPass(rs.getString(2));
				userBean.setNombre1(rs.getString(3));
				userBean.setNombre2(rs.getString(4));
				userBean.setPaterno(rs.getString(5));
				userBean.setMaterno(rs.getString(6));
				userBean.setMail(rs.getString(7));
				userBean.setTipo(rs.getInt(8));
				
				if(userBean.getTipo() == 1){
					query = "SELECT * FROM profesores WHERE rut = ?";
					ps = con.prepareStatement(query);
					ps.setString(1,userBean.getRut());
					rs = ps.executeQuery();
					
					if(rs.next()){
						userBean.setAño(rs.getString(2));
						return userBean;
					}else{
						userBean.setTipo(-1);
						userBean.setNombre1("Error al cargar los datos del profesor");
						return userBean;
					}
					
				}else if(userBean.getTipo() == 2){
					query = "SELECT * FROM alumnos  WHERE rut = ?";
					ps = con.prepareStatement(query);
					ps.setString(1,userBean.getRut());
					rs.close();
					rs = ps.executeQuery();
					
					if(rs.next()){
						userBean.setAño(rs.getString(2));
						userBean.setVezCursando(rs.getString(3));
						userBean.setEdad(rs.getString(4));
						return userBean;
					}else{
						userBean.setTipo(-1);
						userBean.setNombre1("Error al cargar los datos del alumno");
						return userBean;
					}
					
				}else{
					userBean.setTipo(-1);
					userBean.setNombre1("Error al cargarlos datos del usuario");
					return userBean;
				}
				
			}else{
				UserBean userBean = new UserBean();
				userBean.setTipo(-1);
				userBean.setNombre1("El rut o la contraseña son incorrectas");
				return userBean;
			}
			
		}catch(Exception ex){
			System.out.println("Error en UserDAO.login(): " + ex.getMessage());
			return null;
		}finally{
			Database.close(con);
		}
	}

}
