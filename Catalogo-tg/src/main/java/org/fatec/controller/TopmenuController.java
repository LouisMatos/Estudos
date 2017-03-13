package org.fatec.controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.fatec.impl.UsuarioDAOImplementation;
import org.fatec.model.Usuario;
import org.fatec.session.SessionContext;
import org.jboss.logging.Logger;

@ManagedBean
@SessionScoped
public class TopmenuController {
	
	private ExternalContext context;

	private static final Logger logger = Logger.getLogger(TopmenuController.class);
	
	Usuario usuarioLogado;
	
	public void cadastrarAluno() throws IOException{
		context = FacesContext.getCurrentInstance().getExternalContext();
		FacesContext.getCurrentInstance().getExternalContext().redirect(context.getRequestContextPath() + "/aplicacao/aluno/cadastro_aluno.xhtml");
		usuarioLogado = (Usuario) SessionContext.getInstance().getAttribute("info_user");
		logger.info("O usuário " + usuarioLogado.getId() + "acessou a pagina cadastro_aluno");
	}
	
	public void listarAlunos() throws IOException{
		context = FacesContext.getCurrentInstance().getExternalContext();
		FacesContext.getCurrentInstance().getExternalContext().redirect(context.getRequestContextPath() + "/aplicacao/aluno/listar_aluno.xhtml");
	}
	
	public void cursoTeste() throws IOException{
		context = FacesContext.getCurrentInstance().getExternalContext();
		FacesContext.getCurrentInstance().getExternalContext().redirect(context.getRequestContextPath() + "/aplicacao/curso/teste.xhtml");
	}
	
}
