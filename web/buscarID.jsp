<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Biblioteca - Livros!</title>
    
</head>
<body>

  <!-- HEADER -->
  <div class="fundo">
    <header>

      <nav class="header-content container">
        <div class="header-icons">
          <a href="index.html">
           <label class="header-botao">Voltar</label>
          </a>

        </div>
        

        <div class="header-logo-livro">
        
          <a href="index.html">
            <img
              src="image/cabeçario.png"
              alt="Logo da Biblioteca"
            />
          </a>
        </div>

        <div>

          
        </div>

      </nav>
    </header>
  </div>
<section class="servicos-banco container">
    <div class="servicos-header">
      <h2>Buscar livros</h2>
      <p>Navegue pelos nossos livros</p><br>
    </div>
    
    <div class="pesquisa-container">
        <form class="form-pesquisa" action="BuscarLivro" method="GET">
            <input type="text" name="pesquisa" placeholder="Pesquisar por ID ou nome..." class="barra-pesquisa">
            <button type="submit" class="btn-pesquisa">Buscar</button>
        </form>
    </div>


    <div class="grid-servicos">

    <c:forEach var="livro" items="${listaLivros}">

        <div class="card-servico">

            <img src="${livro.capa_url}" alt="${livro.titulo}">

            <div class="card-info">
                <h3>${livro.titulo}</h3>
                <p>${livro.descricao}</p>
                <p>ID Livro: ${livro.id_livro}</p>
                <div class="card-acoes">
                    <button class="btn-editar"
                        onclick="window.location.href='EditarLivro?id=${livro.id_livro}'">
                        Editar
                    </button>

                    <button class="btn-deletar"
                        onclick="window.location.href='DeletarLivro?id=${livro.id_livro}'">
                        Deletar
                    </button>
                </div>
            </div>

        </div>

    </c:forEach>

</div>
  </section>
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