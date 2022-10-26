package com.alura.boletim.model;

import javax.persistence.*;

@Entity
@Table(name = "T_ALUNOS")
@SequenceGenerator(name = "seqAluno", sequenceName = "SQ_ALUNOS" , allocationSize = 1)
public class Alunos {

    @Id
    @Column(name = "ID_ALUNO")
    @GeneratedValue(generator = "seqAluno" , strategy = GenerationType.SEQUENCE)
    private Long idAluno;

    @Column(name = "NM_NOME" , length = 80)
    private String nome;

    @Column(name = "NM_NOME_CURSO" , length = 80)
    private String curso;

    @Column(name = "nm_turma" , length = 10)
    private String turma;

    public Alunos() {
    }

    public Alunos(String nome, String curso, String turma) {
        this.nome = nome;
        this.curso = curso;
        this.turma = turma;
    }

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "ALUNOS [idAluno = "+idAluno+" ,Nome = "+nome+" ,Curso = "+curso+" , Turma = "+turma+"   ]";
    }
}
