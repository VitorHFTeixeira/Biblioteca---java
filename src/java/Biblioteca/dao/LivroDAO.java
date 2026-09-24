/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca.dao;

import Biblioteca.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Biblioteca.model.Livros;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Pedro Carmo
 */
public class LivroDAO {
    
    Connection conn;
    
    public void cadastrarLivro(Livros livro){

    String sql = "insert into livros(titulo, autor, editora, isbn, genero, ano_publicacao, qtd_paginas, idioma, qtd_disponivel, capa_url, descricao) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    conn = Conexao.conectar();

    try {
        PreparedStatement cadastro = conn.prepareStatement(sql);

        cadastro.setString(1, livro.getTitulo());
        cadastro.setString(2, livro.getAutor());
        cadastro.setString(3, livro.getEditora());
        cadastro.setString(4, livro.getIsbn());
        cadastro.setString(5, livro.getGenero());
        cadastro.setInt(6, livro.getAno_publicacao());
        cadastro.setInt(7, livro.getQtd_paginas());
        cadastro.setString(8, livro.getIdioma());
        cadastro.setInt(9, livro.getQtd_disponivel());
        cadastro.setString(10, livro.getCapa_url());
        cadastro.setString(11, livro.getDescricao());

        int linhas = cadastro.executeUpdate();

        System.out.println("Linhas inseridas: " + linhas);

        cadastro.close();

    } catch (Exception ex){
        System.out.println("Erro: " + ex.getMessage());
    }
}
    
    public void deletarLivro(Livros livro){
        
        String sql = "delete from livros where id_livro = ?";
        
        conn = Conexao.conectar();
        
        try {
            PreparedStatement excluir = conn.prepareStatement(sql);
            
            excluir.setInt(1, livro.getId_livro());
            
            excluir.execute();
            excluir.close();
            
        } catch (Exception ex){
            System.out.println("Erro: " + ex.getMessage());
        }
    }
    
    public void editarLivro(Livros livro){
        
        String sql = "update livros set titulo = ?, autor = ?, editora = ?, isbn = ?, genero = ?, ano_publicacao = ?, qtd_paginas = ?, idioma = ?, qtd_disponivel = ?, capa_url = ?, descricao = ? where id_livro = ?";
        
        conn = Conexao.conectar();
        
        try{
            PreparedStatement editar = conn.prepareStatement(sql);
            
            editar.setString(1, livro.getTitulo());
            editar.setString(2, livro.getAutor());
            editar.setString(3, livro.getEditora());
            editar.setString(4, livro.getIsbn());
            editar.setString(5, livro.getGenero());
            editar.setInt(6, livro.getAno_publicacao());
            editar.setInt(7, livro.getQtd_paginas());
            editar.setString(8, livro.getIdioma());
            editar.setInt(9, livro.getQtd_disponivel());
            editar.setString(10, livro.getCapa_url());
            editar.setString(11, livro.getDescricao());
            editar.setInt(12, livro.getId_livro());
            
            editar.executeUpdate();
            
        } catch(Exception ex){
            System.out.println("Erro: " + ex.getMessage());
        }
    }
    
    public List<Livros> listarLivros(){
        
        List<Livros> lista = new ArrayList<>();
        
        String sql = "select id_livro, titulo, capa_url, descricao from livros";
        
        conn = Conexao.conectar();
        
        try{
            PreparedStatement listando = conn.prepareStatement(sql);
            
            ResultSet rs = listando.executeQuery();
            
            while(rs.next()){
                
                Livros l = new Livros();
                
                l.setId_livro(rs.getInt("id_livro"));
                l.setTitulo(rs.getString("titulo"));
                l.setCapa_url(rs.getString("capa_url"));
                l.setDescricao(rs.getString("descricao"));
                
                lista.add(l);
            }
            
        } catch (Exception ex){
            System.out.println("Erro: " + ex.getMessage());
        }
        
        return lista;
    }

    
    public Livros buscarLivro(Livros livro){
               
        String sql = "select * from livros where id_livro = ?";
        
        conn = Conexao.conectar();
        
        try{
            
            PreparedStatement busca = conn.prepareStatement(sql);
            
            busca.setInt(1, livro.getId_livro());
            
            ResultSet rs = busca.executeQuery();
            
            if(rs.next()){      
                
            livro.setTitulo(rs.getString("titulo"));
            livro.setAutor(rs.getString("autor"));
            livro.setEditora(rs.getString("editora"));
            livro.setIsbn(rs.getString("isbn"));
            livro.setGenero(rs.getString("genero"));
            livro.setAno_publicacao(rs.getInt("ano_publicacao"));
            livro.setQtd_paginas(rs.getInt("qtd_paginas"));
            livro.setIdioma(rs.getString("idioma"));
            livro.setQtd_disponivel(rs.getInt("qtd_disponivel"));
            livro.setDescricao(rs.getString("descricao"));
            livro.setCapa_url(rs.getString("capa_url"));  
            
            }
            
        } catch (Exception ex){
            System.out.println("Erro: " + ex.getMessage());
        }
        return livro;
    }
    
}