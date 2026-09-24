/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Biblioteca.controller;

import Biblioteca.model.Livros;
import Biblioteca.dao.LivroDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import javax.servlet.http.Part;


/**
 *
 * @author Pedro Carmo
 */
@WebServlet(name = "LivroController", urlPatterns = {"/LivroController"})
@MultipartConfig
public class LivroController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            request.setCharacterEncoding("UTF-8");    
            String op = request.getParameter("op");


            if("SALVAR".equals(op)){
                
                System.out.println("CHEGOU NO SERVLET");
                
                String titulo = request.getParameter("titulo");
                String autor = request.getParameter("autor");
                String editora = request.getParameter("editora");
                String isbn = request.getParameter("isbn");
                String genero = request.getParameter("genero");
                int anoPublicacao = Integer.parseInt(request.getParameter("anoPublicacao"));
                int qtdPaginas = Integer.parseInt(request.getParameter("quantidadePaginas"));
                String idioma = request.getParameter("idioma");
                int qtdDisponivel = Integer.parseInt(request.getParameter("quantidadeDisponivel"));
                String descricao = request.getParameter("descricao");
                Part capa_url = request.getPart("capa_url");
                String Capas = getServletContext().getRealPath("/capas");
                
                String nomeArquivo = System.currentTimeMillis() + "_" + capa_url.getSubmittedFileName();
                File pasta = new File(Capas);

                if (!pasta.exists()) {
                    pasta.mkdirs();
                }
                capa_url.write(Capas + File.separator + nomeArquivo);
                String caminho_capa = "capas/" + nomeArquivo;

                System.out.println("Livro salvo!");
                System.out.println(titulo);
                
                Livros livro = new Livros();
                
                livro.setTitulo(titulo);
                livro.setAutor(autor);
                livro.setEditora(editora);
                livro.setIsbn(isbn);
                livro.setGenero(genero);
                livro.setAno_publicacao(anoPublicacao);
                livro.setQtd_paginas(qtdPaginas);
                livro.setIdioma(idioma);
                livro.setQtd_disponivel(qtdDisponivel);
                livro.setDescricao(descricao);
                livro.setCapa_url(caminho_capa);
                
                LivroDAO ldao = new LivroDAO();
                
                try {
                    
                    ldao.cadastrarLivro(livro);
                    
                    System.out.println("Livro salvo!");
                    
                    response.sendRedirect("ListarLivro");
                    
                } catch (Exception ex){
                        
                    System.out.println("Erro: " + ex.getMessage());
                }
                
            } else if ("EDITAR".equals(op)){
                
                int id_livro = Integer.parseInt(request.getParameter("id_livro"));
                String titulo = request.getParameter("titulo");
                String autor = request.getParameter("autor");
                String editora = request.getParameter("editora");
                String isbn = request.getParameter("isbn");
                String genero = request.getParameter("genero");
                int anoPublicacao = Integer.parseInt(request.getParameter("ano_publicacao"));
                int qtdPaginas = Integer.parseInt(request.getParameter("qtd_paginas"));
                String idioma = request.getParameter("idioma");
                int qtdDisponivel = Integer.parseInt(request.getParameter("qtd_disponivel"));
                String descricao = request.getParameter("descricao");
                Part capa_url = request.getPart("capa_url");
                String Capas = getServletContext().getRealPath("/capas");
                
                String nomeArquivo = System.currentTimeMillis() + "_" + capa_url.getSubmittedFileName();
                File pasta = new File(Capas);

                if (!pasta.exists()) {
                    pasta.mkdirs();
                }
                capa_url.write(Capas + File.separator + nomeArquivo);
                String caminho_capa = "capas/" + nomeArquivo;
                
                System.out.println("Livro salvo!");
                System.out.println(titulo);
                
                Livros livro = new Livros();
                
                livro.setId_livro(id_livro);
                livro.setTitulo(titulo);
                livro.setAutor(autor);
                livro.setEditora(editora);
                livro.setIsbn(isbn);
                livro.setGenero(genero);
                livro.setAno_publicacao(anoPublicacao);
                livro.setQtd_paginas(qtdPaginas);
                livro.setIdioma(idioma);
                livro.setQtd_disponivel(qtdDisponivel);
                livro.setDescricao(descricao);
                livro.setCapa_url(caminho_capa);
                
                LivroDAO ldao = new LivroDAO();
                
                try {
                    
                    ldao.editarLivro(livro);
                    
                    response.sendRedirect("ListarLivro");
                    
                } catch (Exception ex){
                    System.out.println("Erro: " + ex.getMessage());
                }
                
            } else {
                request.getRequestDispatcher("cadastro.jsp").forward(request, response);                
            }   
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
