//@author pkmelo7

package com.mycompany.classes;

import java.util.List;

public class Categoria {
    private String nome;
    private List<Curso> cursos;

    public Categoria(String nome, List<Curso> cursos) {
        this.nome = nome;
        this.cursos = cursos;
    }  
    
    public String getNome() {
        return nome;
    }

    public List<Curso> getCursos() {
        return cursos;
    }
}
