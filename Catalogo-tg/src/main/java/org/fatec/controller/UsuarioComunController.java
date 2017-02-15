package org.fatec.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.fatec.impl.UsuarioDAOImplementation;
import org.fatec.model.TipoUsuario;
import org.fatec.model.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioComunController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3343167883012369239L;
	
	private Usuario usuario = new Usuario();

	private UsuarioDAOImplementation dao = new UsuarioDAOImplementation();
	
	private FacesContext facesContext;
	private FacesContext Context;
	
	private String mensagem;
	

	
	public void grava(){
		
		try{
			
			System.out.println(usuario.getSenha() + " " + usuario.getConfirmaSenha());
			
			/*if(usuario.getSenha().equals(usuario.getConfirmaSenha())){*/
				
				usuario.setTipoUsuario(TipoUsuario.ADMINISTRADOR);
				if (!dao.existeEmail(usuario)) {
					dao.save(usuario);
					System.out.println("1");
					
				} else {
					facesContext = FacesContext.getCurrentInstance();
					FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um problema, tente novamente!", "E-mail j� cadastrado! Tente novamente.w");
		            facesContext.addMessage("register-form:validaUsuario", message);
		            System.out.println("2");
					//return "/login.xhtml?faces-redirect=false";
				}
				facesContext = FacesContext.getCurrentInstance();
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Cadastro concluido com sucesso!");
		        facesContext.addMessage("register-form:validaUsuario", message);
		        System.out.println("3");
		        /*}else{
				facesContext = FacesContext.getCurrentInstance();
	            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senhas n�o batem...", "As senhas informadas n�o s�o iguais! Tente novamente");
	            facesContext.addMessage("register-form:validaUsuario", message);
	            
	            System.out.println("4");
	            
			}*/
			
		}catch(Exception e){
			e.printStackTrace();
		}
		//return "/login.xhtml?faces-redirect=false";
	}
	
	
	
	
	public void teste(AjaxBehaviorEvent event){
		mensagem = usuario.getEmail();
	}
	
	
	

	
	
	
	public String cancela() {
		return "index.xhtml?faces-redirect=true";

	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}




	public String getMensagem() {
		return mensagem;
	}




	public void setmMnsagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
