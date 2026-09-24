<%-- 
    Document   : editar
    Created on : 30 de mai. de 2026, 00:36:01
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
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="style.css" />
  <title>Biblioteca - Java!</title>
</head>

<body>


  <!-- HEADER -->
  <div class="fundo">
    <header>

      <nav class="header-content container">

        <div class="header-icons">
          <a href="ListarLivro">
           <label class="header-botao">Voltar</label>
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
      <h2>Editar Livro</h2>
      <p>Atualize as informações do livro no acervo.</p>
    </div>

    <form action="LivroController" method="POST" enctype="multipart/form-data" class="form-livro">
      
      <div class="input-group">
        <label for="idLivro">ID do Livro (Não editável):</label>
        <input type="number" id="id_livro" name="id_livro" value="${livro.id_livro}" readonly style="background-color: #e9ecef; cursor: not-allowed;">
      </div>

      <div class="input-group">
        <label for="titulo">Título:</label>
        <input type="text" id="titulo" name="titulo" value="${livro.titulo}" required>
      </div>

      <div class="input-group">
        <label for="autor">Autor(a):</label>
        <input type="text" id="autor" name="autor" value="${livro.autor}" required>
      </div>

      <div class="input-group">
        <label for="editora">Editora:</label>
        <input type="text" id="editora" name="editora" value="${livro.editora}">
      </div>

      <div class="input-group">
        <label for="isbn">ISBN:</label>
        <input type="text" id="isbn" name="isbn" value="${livro.isbn}">
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
        <input type="number" id="ano_publicacao" name="ano_publicacao" value="${livro.ano_publicacao}">
      </div>

      <div class="input-group">
        <label for="quantidadePaginas">Quantidade de Páginas:</label>
        <input type="number" id="qtd_paginas" name="qtd_paginas" value="${livro.qtd_paginas}">
      </div>

      <div class="input-group">
        <label for="idioma">Idioma:</label>
        <input type="text" id="idioma" name="idioma" value="${livro.idioma}" required>
      </div>

      <div class="input-group">
        <label for="quantidadeDisponivel">Qtd. Disponível:</label>
        <input type="number" id="qtd_disponivel" name="qtd_disponivel" value="${livro.qtd_disponivel}" min="0" required>
      </div>


      <div class="input-group imagem-group">
        <label for="imagemCapa">Alterar Capa do Livro (Opcional):</label>
        <input type="file" id="imagemCapa" name="capa_url" accept=".png">
        <small style="color: #666; margin-top: 5px;">Deixe em branco para manter a imagem atual.</small>
      </div>

      <div class="input-group descricao-group">
        <label for="descricao">Descrição / Sinopse:</label>
        <input id="descricao" name="descricao" placeholder="Digite um breve resumo do livro...">
      </div>

      <div class="submit-group">
        <button type="submit" name="op" class="btn-salvar" value="EDITAR">Salvar Alterações</button>
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
