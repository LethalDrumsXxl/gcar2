package beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import util.Mensaje;
import util.UserBean;
import dao.UserDAO;

@ManagedBean(name="loginBean")
@ViewScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 4068204024663087883L;
	private Mensaje mensaje;
	private String rut;
	private String pass;
	
	@PostConstruct
	public void init(){
		mensaje = new Mensaje();
		mensaje.setStyle("display:none");
		mensaje.setStyleClass("callout callout-danger");
	}
	
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}	
	public Mensaje getMensaje() {
		return mensaje;
	}
	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}
	
	public String login(){

		UserBean userBean = UserDAO.login(rut, pass);
		if(userBean.getTipo() == -1){
			mensaje = new Mensaje();
			mensaje.setContent(userBean.getNombre1());
			mensaje.setStyle("callout callout-success");
			mensaje.setStyleClass("display:block");
			return "login.xhtml";
		}else{
			System.out.println("Conectado!");
			return "login.xhtml";
		}

	}

}
