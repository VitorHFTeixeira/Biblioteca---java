/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Biblioteca.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Biblioteca.model.Livros;
import Biblioteca.dao.LivroDAO;

/**
 *
 * @author Pedro Carmo
 */
@WebServlet("/DeletarLivro")
public class DeletarLivro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        request.setCharacterEncoding("UTF-8"); // Tratando os dados para entrar no banco
        
        int id = Integer.parseInt(request.getParameter("id"));

        Livros livro = new Livros();
        livro.setId_livro(id);

        LivroDAO dao = new LivroDAO();
        dao.deletarLivro(livro);

        response.sendRedirect("ListarLivro");
    }
}