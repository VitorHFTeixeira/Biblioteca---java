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
import Biblioteca.dao.LivroDAO;
import Biblioteca.model.Livros;

/**
 *
 * @author Pedro Carmo
 */
@WebServlet("/EditarLivro")
public class EditarLivro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8"); // Tratando os dados para entrar no banco
        
        Livros livro = new Livros();

        livro.setId_livro(Integer.parseInt(request.getParameter("id")));

        LivroDAO dao = new LivroDAO();

        livro = dao.buscarLivro(livro);

        request.setAttribute("livro", livro);

        request.getRequestDispatcher("editar.jsp").forward(request, response);
    }
}