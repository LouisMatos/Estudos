package org.fatec.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.fatec.model.Aluno;

@ManagedBean
@SessionScoped
public class AlunoController {
	
	private Aluno aluno = new Aluno();

	public void cadastrarAluno(){
		
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
