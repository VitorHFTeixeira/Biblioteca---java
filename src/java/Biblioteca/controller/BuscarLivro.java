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
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Pedro Carmo
 */
@WebServlet("/BuscarLivro")
public class BuscarLivro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String pesquisa = request.getParameter("pesquisa");

        LivroDAO dao = new LivroDAO();
        List<Livros> lista = new ArrayList<>();

        try {
            // tenta converter pra ID
            int id = Integer.parseInt(pesquisa);

            Livros livro = new Livros();
            livro.setId_livro(id);

            livro = dao.buscarLivro(livro);

            if (livro.getTitulo() != null) {
                lista.add(livro);
            }

        } catch (NumberFormatException e) {
            // se não for número, pode listar tudo ou ignorar
            lista = dao.listarLivros();
        }

        request.setAttribute("listaLivros", lista);

        request.getRequestDispatcher("buscarID.jsp").forward(request, response);
    }
}
