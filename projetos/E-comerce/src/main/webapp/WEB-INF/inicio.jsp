<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mundo Dos Pets</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="icon" href="img2\pets.png"" type="logo">
</head>
<body>
    <header>
        <h1>Mundo Dos Pets</h1>
        <nav>
            <ul>
                <li><a href="inicio.jsp">Início</a></li>
                <li><a href="produto.jsp">Produtos</a></li>
                <li><a href="contato.jsp">Contato</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <h2>Mundo<span style="font-size: 43px; position: relative; top: -10px;">ᴰᵒˢ</span>Pets</h2>
        <p>Produtos de qualidade para seu melhor amigo!</p>
        <a href="produto.jsp" class="btn">Ver Produtos</a>
        <img class="pets" src="img2\pets.png" alt="pets">
    </main>
    <footer>
        <p>&copy; <%= java.time.Year.now() %> Mundo Dos Pets - Todos os direitos reservados.</p>
    </footer>
</body>
</html>