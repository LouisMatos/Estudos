package org.fatec.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.PostLoad;

import org.fatec.impl.AlunoDAOImplementation;
import org.fatec.model.Aluno;

@ManagedBean
@SessionScoped
public class AlunoController {
	
	private Aluno aluno = new Aluno();
	
	private AlunoDAOImplementation dao = new AlunoDAOImplementation();
	
	private FacesContext facesContext;
	
	
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();;

		
	    public void init() {
	        alunos = dao.getAllAlunos();
	        System.out.println("teste init");
	    }
	
	 
	
	 public void destroi(){
		 alunos = null;
		 System.out.println("teste destroi");
	    
	 }

	public void cadastrarAluno(){
		try{
			if(!dao.existeAluno(aluno)){
				dao.save(aluno);
			}else{
				facesContext = FacesContext.getCurrentInstance();
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um problema, tente novamente!", "Registro já cadastrado! Tente novamente!");
				facesContext.addMessage("form_aluno:cadAluno", message);
			}
			facesContext = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Cadastro concluido com sucesso!");
	        facesContext.addMessage("form_aluno:cadAluno", message);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}


	public void cancelar(){
		System.out.println("teste");
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
	
}
