package org.fatec.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.fatec.impl.UsuarioDAOImplementation;
import org.fatec.model.TipoUsuario;
import org.fatec.model.Usuario;
import org.fatec.session.SessionContext;
import org.jboss.logging.Logger;

@ManagedBean

public class LoginController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UsuarioLogadoController usuarioLogadoController = new UsuarioLogadoController();
	
	private Usuario usuario = new Usuario();
	
	private FacesContext facesContext;
	
	private UsuarioDAOImplementation dao = new UsuarioDAOImplementation();
	
	private Logger log;
	
	public void efetuarLogin() throws IOException{
		Usuario user = new Usuario();
		
		user = dao.existeUsuario(usuario);
		
	
	
		if(user != null && user.getEmail().equals(usuario.getEmail()) && user.getSenha().equals(usuario.getSenha()) ){
			// colocar usuario na sessão, refazer
			usuarioLogadoController.logar(user);
			
			SessionContext.getInstance().setAttribute("info_user", user);
			
			if(user.getTipoUsuario() == TipoUsuario.ADMINISTRADOR){	
				FacesContext.getCurrentInstance().getExternalContext().redirect("aplicacao/aluno/aluno.xhtml");
				//return "/aplicacao.aluno.aluno?faces-redirect=true";
			}else{
				FacesContext.getCurrentInstance().getExternalContext().redirect("aplicacao/pesquisa/pesquisa.xhtml");
			}
		}else{
			facesContext = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fails", " - Usuário ou senha inválidos! Tente novamente.");
	        facesContext.addMessage("login-form:erroLogin", message);
		}
		
	}
	
	
	public boolean isLogdo(){
		return usuario != null;
	}

	public void doEfetuarLogout() throws IOException {
		SessionContext.getInstance().encerrarSessao();
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("../../index.xhtml");
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
}
