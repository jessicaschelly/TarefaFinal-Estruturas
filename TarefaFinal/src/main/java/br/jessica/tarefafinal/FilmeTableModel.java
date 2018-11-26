/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jessica.tarefafinal;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jessica
 */
public class FilmeTableModel extends AbstractTableModel {

    private final ListaInvertidaFilme lista = new ListaInvertidaFilme();
    private Integer de;
    private Integer ate;
    private String titulo;
    private String genero;
    private Integer count = 0;

    public FilmeTableModel() {
    }
    
    public void adiciona(Filme filme){
        lista.adiciona(filme);
        count++;
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return lista.busca(de, ate, titulo, genero).size();
    }

    public void busca(Integer de, Integer ate,  String titulo, String genero) {
        this.de = de;
        this.ate = ate;
        this.titulo = titulo;
        this.genero = genero;
        fireTableDataChanged();
    }
     // Para pegar o total das colunas
    @Override
    public int getColumnCount() {
        return 6;
    }
    // Nomear as colunas
    @Override
   public String getColumnName(int col) { 
       String [] a = {"ID","Título","Gênero","Nota IMDb", "Diretor", "Ano"};
      return a[col]; 
   } 
    // Pegar o valor a partir do indice da linha e da coluna
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Filme filmes = lista.busca(de, ate, titulo, genero).get(rowIndex);
        switch (columnIndex) {
            case 0:
                return filmes.getId();
            case 1:
                return filmes.getTitulo();
            case 2:
                return filmes.getGenero();
            case 3:
                return filmes.getClassificao();
            case 4:
                return filmes.getDiretor();
            case 5:
                return filmes.getAno();
            default:
                return null;
                  
        }
    }

    Integer getCurrentId() {
        return count;
    }
    // Metodo para remover a linha selecionada pelo usuário
    void deletar(int selectedRow) {
        lista.deletar(de, ate, titulo, genero, selectedRow);
        fireTableDataChanged();
    }
}
