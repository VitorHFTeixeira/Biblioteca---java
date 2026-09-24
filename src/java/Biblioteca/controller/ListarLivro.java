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
import java.util.List;
import Biblioteca.dao.LivroDAO;
import Biblioteca.model.Livros;

/**
 *
 * @author Pedro Carmo
 */
@WebServlet(name = "ListarLivro", urlPatterns = {"/ListarLivro"})
public class ListarLivro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); 
        
        LivroDAO dao = new LivroDAO();
        List<Livros> lista = dao.listarLivros();

        request.setAttribute("listaLivros", lista);

        request.getRequestDispatcher("/livros.jsp").forward(request, response);
    }
}