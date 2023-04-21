package br.ucsal.atividade.ted.domain;

import java.util.ArrayList;
import java.util.List;


public class Coordenador {

    private Long id;

    private String nome;

    private List<String> cursos = new ArrayList<>();
    
	private List<Periodo> horarios = new ArrayList<>();

	public Coordenador() {
    }

    public Coordenador(String nome, List<String> cursos, List<Periodo> horarios) {
        this.setNome(nome);
        this.cursos = cursos;
        this.setHorarios(horarios);
    }

	public String getCursosComoTexto() {
		var cursoTexto = new StringBuilder();
		for (String curso : cursos) {
			cursoTexto.append(curso).append("\n");
		}
		return cursoTexto.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<String> getCursos() {
		return cursos;
	}

	public void setCursos(List<String> cursos) {
		this.cursos = cursos;
	}

	public List<Periodo> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Periodo> horarios) {
		this.horarios = horarios;
	}


}

