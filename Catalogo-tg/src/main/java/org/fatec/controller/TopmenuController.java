package org.fatec.controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class TopmenuController {

	
	public void cadastrarAluno() throws IOException{
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		FacesContext.getCurrentInstance().getExternalContext().redirect(context.getRequestContextPath() + "/aplicacao/aluno/cadastro_aluno.xhtml");
	}
	
	public void listarAlunos() throws IOException{
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		FacesContext.getCurrentInstance().getExternalContext().redirect(context.getRequestContextPath() + "/aplicacao/aluno/listar_aluno.xhtml");
	}
	
}