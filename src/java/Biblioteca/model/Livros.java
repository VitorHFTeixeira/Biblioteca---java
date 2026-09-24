/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca.model;

/**
 *
 * @author Pedro Carmo
 */
public class Livros {
    private int id_livro;
    private String titulo;
    private String autor;
    private String editora;
    private String isbn;
    private String genero;
    private int ano_publicacao;
    private int qtd_paginas;
    private String idioma;
    private int qtd_disponivel;
    private String capa_url;
    private String descricao;
    
    
    public Livros(){
        
    }

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAno_publicacao() {
        return ano_publicacao;
    }

    public void setAno_publicacao(int ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }

    public int getQtd_paginas() {
        return qtd_paginas;
    }

    public void setQtd_paginas(int qtd_paginas) {
        this.qtd_paginas = qtd_paginas;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getQtd_disponivel() {
        return qtd_disponivel;
    }

    public void setQtd_disponivel(int qtd_disponivel) {
        this.qtd_disponivel = qtd_disponivel;
    }

    public String getCapa_url() {
        return capa_url;
    }

    public void setCapa_url(String capa_url) {
        this.capa_url = capa_url;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return descricao;
    }
}
