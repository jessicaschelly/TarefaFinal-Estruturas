/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jessica.tarefafinal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Jessica
 */
public class ListaInvertidaFilme {

    ArrayList<Filme> filmes = new ArrayList();
    HashMap<Integer, List<Integer>> diretorioAno = new HashMap<>();
    HashMap<String, List<Integer>> diretorioTitulo = new HashMap<>();
    HashMap<String, List<Integer>> diretorioGenero = new HashMap<>();
    
    // Metodo que adiciona os filmes nos diretórios de acordo com as variáveis
    public void adiciona(Filme filme) {
        
        // Adiciona filme no diretório ano
        if (diretorioAno.containsKey(filme.getAno())) {
            List<Integer> valor = diretorioAno.get(filme.getAno());
            valor.add(filmes.size());
        } else {
            List<Integer> valor = new ArrayList<>();
            valor.add(filmes.size());
            diretorioAno.put(filme.getAno(), valor);
        }
        
          // Adiciona filme no diretório título
        if (diretorioTitulo.containsKey(filme.getTitulo())) {
            List<Integer> valor = diretorioTitulo.get(filme.getTitulo());
            valor.add(filmes.size());
        } else {
            List<Integer> valor = new ArrayList<>();
            valor.add(filmes.size());
            diretorioTitulo.put(filme.getTitulo(), valor);
        }
           
        // Adiciona filme no diretório genero
        if (diretorioGenero.containsKey(filme.getGenero())) {
            List<Integer> valor = diretorioGenero.get(filme.getGenero());
            valor.add(filmes.size());
        } else {
            List<Integer> valor = new ArrayList<>();
            valor.add(filmes.size());
            diretorioGenero.put(filme.getGenero(), valor);
        }

        filmes.add(filme);
    }
    // Metodo para buscar a interseção entre duas listas
    private List<Integer> intersection(List<Integer> a, List<Integer> b) {
        Set<Integer> s1 = new HashSet<Integer>(a);
        Set<Integer> s2 = new HashSet<Integer>(b);
        s1.retainAll(s2);
        Integer[] result = s1.toArray(new Integer[s1.size()]);

        return Arrays.asList(result);
    }
    
    public List<Filme> busca(Integer id) {

        return null;
    }

    public List<Filme> busca(Integer de, Integer ate, String titulo, String genero) {
        if (de == null && ate == null && titulo == null && genero == null) {
            return filmes;
        }

        if (de == null) {
            de = 0;
        }

        if (ate == null) {
            ate = 10000;
        }

        List<Integer> indices = null;

        // Busca ano dentro do diretório
        boolean contains = false;
        for (Integer i = de; i <= ate; i++) {

            if (diretorioAno.containsKey(i)) {
                contains = true;
                if (indices == null) {
                    indices = new ArrayList<>();
                }
                indices.addAll(diretorioAno.get(i));

            }

        }
        if (!contains) {
            return new ArrayList<>();
        }

        // Busca títulos dentro do diretório
        if (titulo != null) {
            if (diretorioTitulo.containsKey(titulo)) {
                if (indices == null) {
                    indices = diretorioTitulo.get(titulo);
                } else {
                    indices = intersection(indices, diretorioTitulo.get(titulo));
                }
            } else {
                return new ArrayList<>();
            }
        }

        // Busca gênero dentro do diretório
        if (genero != null) {
            if (diretorioGenero.containsKey(genero)) {
                if (indices == null) {
                    indices = diretorioGenero.get(genero);
                } else {
                    indices = intersection(indices, diretorioGenero.get(genero));
                }
            } else {
                return new ArrayList<>();
            }
        }

        return retornaFilmescomIndice(indices);
    }

    private List<Filme> retornaFilmescomIndice(List<Integer> list) {
        List<Filme> filmes = new ArrayList<>();
        for (int i : list) {
            filmes.add(this.filmes.get(i));
        }
        return filmes;

    }

    void deletar(Integer de, Integer ate, String titulo, String genero, int selectedRow) {
        Filme filme = busca(de, ate, titulo, genero).get(selectedRow);
        Integer indiceReal = filmes.indexOf(filme);
        filmes.remove(filme);
        
        // Deletar dentro do diretório ano
        if (diretorioAno.containsKey(filme.getAno())) {
            List<Integer> list = diretorioAno.get(filme.getAno());
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > indiceReal) {
                    list.set(i, list.get(i) - 1);
                }
            }
            list.remove((Integer) indiceReal);
        }
        
        // Deletar dentro do diretório titulo
        if (diretorioTitulo.containsKey(filme.getTitulo())) {
            List<Integer> list = diretorioTitulo.get(filme.getTitulo());
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > indiceReal) {
                    list.set(i, list.get(i) - 1);
                }
            }
            list.remove((Integer) indiceReal);
        }
        // Deletar dentro do diretorio genero
        if (diretorioGenero.containsKey(filme.getGenero())) {
            List<Integer> list = diretorioGenero.get(filme.getGenero());
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > indiceReal) {
                    list.set(i, list.get(i) - 1);
                }
            }
            // deleta da lista
            list.remove((Integer) indiceReal);
        }
    }
}
