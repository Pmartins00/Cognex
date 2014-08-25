package br.com.cognex.bean;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cognex.dao.UsuarioDAO;
import br.com.cognex.model.Usuario;

@SessionScoped
@Named("loginBean")
public class LoginBean implements Serializable {
	
	Usuario usuario = new Usuario();
	
	@Inject
	private UsuarioDAO dao;
	
	public String autentica() {
		
		boolean aut = dao.autentica(this.usuario);
		
		if (aut) {
			System.out.println("sim");
			return "index?faces-redirect=true";
		} else {
			return "login?faces-redirect=true";
		}
		
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public boolean isLogado() {
		return this.usuario.getLogin() != null;
	}
	
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "login?faces-redirect=true";
	}

}
