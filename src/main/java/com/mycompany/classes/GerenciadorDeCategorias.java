package com.mycompany.classes;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GerenciadorDeCategorias {

    private ProdutoCurso produtoCurso;

    public GerenciadorDeCategorias() {
        produtoCurso = new ProdutoCurso();
    }

    public void listarCursosPorCategoria(JFrame tela, java.lang.String categoriaEscolhida, JPanel panelPrincipal, JScrollPane scrollPane) throws SQLException {
        Curso cursoDAO = new Curso();
        List<Curso> cursos = cursoDAO.buscarCursosPorCategoria(categoriaEscolhida);

        // Limpar o painel para exibir apenas os cursos da categoria selecionada
        panelPrincipal.removeAll();

        // Adicionar cada curso no painel
        for (Curso curso : cursos) {
            Curso c = curso;
            produtoCurso.addProduto(tela, panelPrincipal, scrollPane, curso.getId());
        }

        // Atualizar o painel
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }
}
