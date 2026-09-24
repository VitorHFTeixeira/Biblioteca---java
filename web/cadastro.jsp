<%-- 
    Document   : cadastro
    Created on : 29 de mai. de 2026, 22:20:02
    Author     : Pedro Carmo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Adicionar-Livro!</title>
</head>
    <body>
        <div class="fundo">
    <header>

      <nav class="header-content container">

        <div class="header-icons">
          <a href="index.html">
           <label class="header-botao" onclick="window.location.href='index.html'">Voltar</label>
          </a>
        </div>

        <div class="header-logo-adicionar" >
          <a href="index.html">
            <img
              src="image/cabeçario.png"
              alt="Logo da Biblioteca"
            />
          </a>
        </div>

      </nav>

     

    </header>
  </div>

  <main class="cadastro-section container">
    <div class="cadastro-header">
      <h2>Cadastrar Novo Livro</h2>
      <p>Preencha os dados abaixo para inserir um novo título no acervo.</p>
    </div>

    <form action="LivroController" method="POST" enctype="multipart/form-data" class="form-livro">
      


      <div class="input-group">
        <label for="titulo">Título:</label>
        <input type="text" id="titulo" name="titulo" placeholder="Nome completo do livro" required>
      </div>

      <div class="input-group">
        <label for="autor">Autor(a):</label>
        <input type="text" id="autor" name="autor" placeholder="Nome do autor principal" required>
      </div>

      <div class="input-group">
        <label for="editora">Editora:</label>
        <input type="text" id="editora" name="editora" placeholder="Ex: Companhia das Letras">
      </div>

      <div class="input-group">
        <label for="isbn">ISBN:</label>
        <input type="text" id="isbn" name="isbn" placeholder="Ex: 978-85-359-0277-8">
      </div>

      <div class="input-group">
                <label for="genero">Gênero:</label>
                <select id="genero" name="genero" required>
                    <option value="" disabled selected>Selecione um gênero...</option>
                    <option value="Ficção">Ficção</option>
                    <option value="Tecnologia">Tecnologia</option>
                    <option value="Romance">Romance</option>
                    <option value="Fantasia">Fantasia</option>
                    <option value="Terror/Suspense">Terror / Suspense</option>
                    <option value="Biografia">Biografia</option>
                    <option value="História">História</option>
                    <option value="Ciência">Ciência</option>
                    <option value="Didático">Didático</option>
                    <option value="Outros">Outros</option>
                </select>
            </div>

      <div class="input-group">
        <label for="anoPublicacao">Ano de Publicação:</label>
        <input type="number" id="anoPublicacao" name="anoPublicacao" placeholder="Ex: 2023">
      </div>

      <div class="input-group">
        <label for="quantidadePaginas">Quantidade de Páginas:</label>
        <input type="number" id="quantidadePaginas" name="quantidadePaginas" placeholder="Ex: 350">
      </div>

      <div class="input-group">
        <label for="idioma">Idioma:</label>
        <input type="text" id="idioma" name="idioma" value="Português" required>
      </div>

      <div class="input-group">
        <label for="quantidadeDisponivel">Qtd. Disponível:</label>
        <input type="number" id="quantidadeDisponivel" name="quantidadeDisponivel" value="1" min="0" required>
      </div>


      <div class="input-group imagem-group">
        <label for="capa_url">Capa do Livro (Apenas PNG sem fundo):</label>
        <input type="file" id="capa_url" name="capa_url" accept=".png" required>
      </div>

      <div class="input-group descricao-group">
        <label for="descricao">Descrição / Sinopse:</label>
        <input id="descricao" name="descricao" placeholder="Digite um breve resumo do livro...">
      </div>

      <div class="submit-group">
        <button type="submit" name="op" class="btn-salvar" value = "SALVAR">Salvar Livro no Sistema</button>
      </div>

    </form>
  </main>
  <footer class="footer">
    <div>
      <img class="footer-img"
        src="image/cabeçario.png"
        alt="Logo biblioteca"
      />
    </div>

    <p>
      Copyright 2026 | Dev - Vitor Texeira e Pedro Carmo | Todos direitos reservados.
    </p>

  </footer>
</body>
</html>
