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
        <h2 class="titulo-contato">Entre em Contato Conosco</h2>
        <form>
            <h1>Formulário de Contato</h1>
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" required>
    
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
    
            <label for="mensagem">Mensagem:</label>
            <textarea id="mensagem" name="mensagem" rows="5" required></textarea>
    
            <button type="submit">Enviar</button>
        </form>
    </main>
    
    <footer>
        <p>&copy; <%= java.time.Year.now() %> Mundo Dos Pets - Todos os direitos reservados.</p>
    </footer>
</body>
</html>