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

		
	   
	

	public void cadastrarAluno(){
		try{
			aluno.setNome(aluno.getNome().toUpperCase());
			if(!dao.existeAluno(aluno)){
				dao.save(aluno);
			}else{
				facesContext = FacesContext.getCurrentInstance();
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um problema, tente novamente!", "Registro j� cadastrado! Tente novamente!");
				facesContext.addMessage("form_aluno:cadAluno", message);
			}
			facesContext = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Cadastro concluido com sucesso!");
	        facesContext.addMessage("form_aluno:cadAluno", message);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void excluirAluno(int id){
		try{
			dao.excluiAluno(id);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void init() {
		alunos = dao.getAllAlunos();
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
	
	
	
	
	
	
	
	
	 public void destroyWorld() {
	        addMessage("System Error", "Please try again later.");
	    }
	     
	    public void addMessage(String summary, String detail) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
