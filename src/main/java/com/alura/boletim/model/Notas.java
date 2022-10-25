package com.alura.boletim.model;

import javax.persistence.*;

@Entity
@Table(name = "T_NOTAS")
@SequenceGenerator(name = "seqNotas", sequenceName = "SQ_NOTAS" , allocationSize = 1)
public class Notas {
    @Id
    @Column(name = "ID_NOTA")
    @GeneratedValue(generator = "seqNotas" , strategy = GenerationType.SEQUENCE)
    private Long idNota;

    @Column(name = "ID_ALUNO")
    private Long idAluno;

    @Column(name = "NM_MATERIA" , length = 50)
    private String materia;

    @Column(name = "NM_NOTA_CP1" , precision = 3, scale = 3)
    private int cp1;

    @Column(name = "NM_NOTA_CP2" , precision = 3, scale = 3)
    private int cp2;

    @Column(name = "NM_NOTA_CP3" , precision = 3, scale = 3)
    private int cp3;

    @Column(name = "NM_NOTA_CP4" , precision = 3, scale = 3)
    private int cp4;

    @Column(name = "NM_NOTA_CP5" , precision = 3, scale = 3)
    private int cp5;

    @Column(name = "NM_NOTA_CP6" , precision = 3, scale = 3)
    private int cp6;

    @Column(name = "NM_CHALLENGER_1" , precision = 3, scale = 3)
    private int ch1;

    @Column(name = "NM_CHALLENGER_2" , precision = 3, scale = 3)
    private int ch2;

    @Column(name = "NM_CHALLENGER_3" , precision = 3, scale = 3)
    private int ch3;

    @Column(name = "NM_CHALLENGER_4" , precision = 3, scale = 3)
    private int ch4;

    @Column(name = "NM_NOTA_GS1" , precision = 3, scale = 3)
    private int gs1;

    @Column(name = "NM_NOTA_GS2" , precision = 3, scale = 3)
    private int gs2;

    public Notas() {
    }

    public Notas(Long idAluno, String materia, int cp1, int cp2, int cp3, int cp4, int cp5, int cp6, int ch1, int ch2, int ch3, int ch4, int gs1, int gs2) {
        this.idAluno = idAluno;
        this.materia = materia;
        this.cp1 = cp1;
        this.cp2 = cp2;
        this.cp3 = cp3;
        this.cp4 = cp4;
        this.cp5 = cp5;
        this.cp6 = cp6;
        this.ch1 = ch1;
        this.ch2 = ch2;
        this.ch3 = ch3;
        this.ch4 = ch4;
        this.gs1 = gs1;
        this.gs2 = gs2;
    }

    public Long getIdNota() {
        return idNota;
    }

    public void setIdNota(Long idNota) {
        this.idNota = idNota;
    }

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getCp1() {
        return cp1;
    }

    public void setCp1(int cp1) {
        this.cp1 = cp1;
    }

    public int getCp2() {
        return cp2;
    }

    public void setCp2(int cp2) {
        this.cp2 = cp2;
    }

    public int getCp3() {
        return cp3;
    }

    public void setCp3(int cp3) {
        this.cp3 = cp3;
    }

    public int getCp4() {
        return cp4;
    }

    public void setCp4(int cp4) {
        this.cp4 = cp4;
    }

    public int getCp5() {
        return cp5;
    }

    public void setCp5(int cp5) {
        this.cp5 = cp5;
    }

    public int getCp6() {
        return cp6;
    }

    public void setCp6(int cp6) {
        this.cp6 = cp6;
    }

    public int getCh1() {
        return ch1;
    }

    public void setCh1(int ch1) {
        this.ch1 = ch1;
    }

    public int getCh2() {
        return ch2;
    }

    public void setCh2(int ch2) {
        this.ch2 = ch2;
    }

    public int getCh3() {
        return ch3;
    }

    public void setCh3(int ch3) {
        this.ch3 = ch3;
    }

    public int getCh4() {
        return ch4;
    }

    public void setCh4(int ch4) {
        this.ch4 = ch4;
    }

    public int getGs1() {
        return gs1;
    }

    public void setGs1(int gs1) {
        this.gs1 = gs1;
    }

    public int getGs2() {
        return gs2;
    }

    public void setGs2(int gs2) {
        this.gs2 = gs2;
    }
}
