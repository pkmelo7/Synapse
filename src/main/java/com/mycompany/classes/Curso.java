//@author pkmelo7

package com.mycompany.classes;

public class Curso 
{
    private int codigo;
    private String nomecurso;
    private String autorcurso;
    private float notacurso;
    private int avaliacoes;
    private float tempocurso;
    private String nivelcurso;
    private float valorcurso;
    private String categoriacurso;
    
    public Curso() {
    }

    public Curso(String nomecurso, String autorcurso, float tempocurso, String nivelcurso, float valorcurso, String categoriacurso) {
        this.nomecurso = nomecurso;
        this.autorcurso = autorcurso;
        this.tempocurso = tempocurso;
        this.nivelcurso = nivelcurso;
        this.valorcurso = valorcurso;
        this.categoriacurso = categoriacurso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomecurso() {
        return nomecurso;
    }

    public void setNomecurso(String nomecurso) {
        this.nomecurso = nomecurso;
    }

    public String getAutorcurso() {
        return autorcurso;
    }

    public void setAutorcurso(String autorcurso) {
        this.autorcurso = autorcurso;
    }

    public float getNotacurso() {
        return notacurso;
    }

    public void setNotacurso(float notacurso) {
        this.notacurso = notacurso;
    }

    public int getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(int avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public float getTempocurso() {
        return tempocurso;
    }

    public void setTempocurso(float tempocurso) {
        this.tempocurso = tempocurso;
    }

    public String getNivelcurso() {
        return nivelcurso;
    }

    public void setNivelcurso(String nivelcurso) {
        this.nivelcurso = nivelcurso;
    }

    public float getValorcurso() {
        return valorcurso;
    }

    public void setValorcurso(float valorcurso) {
        this.valorcurso = valorcurso;
    }

    public String getCategoriacurso() {
        return categoriacurso;
    }

    public void setCategoriacurso(String categoriacurso) {
        this.categoriacurso = categoriacurso;
    }
    
}
