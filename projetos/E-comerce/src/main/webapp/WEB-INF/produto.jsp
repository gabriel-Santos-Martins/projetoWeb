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
        <h2 class="titulo-produto">O Melhor Para Seu Pet</h2>

        <div class="container">
            <div class="Produto">
                <img src="img2\coelhorosa.png" alt="Brinquedo de Pelúcia">
                <h3>Brinquedo de Pelúcia</h3>
                <p class="preco">R$39,99</p>
                <a href="comprar.jsp"><button>Comprar</button></a>
            </div>
            <div class="Produto">
                <img src="img2\flamingo.png" alt="Brinquedo de Pelúcia">
                <h3>Brinquedo de Pelúcia</h3>
                <p class="preco">R$89,90</p>
                <a href="comprar.jsp""><button>Comprar</button></a>
            </div>
            <div class="Produto">
                <img src="img2\rosquinha.png" alt="Brinquedo de Pelúcia">
                <h3>Brinquedo de Pelúcia</h3>
                <p class="preco">R$49,90</p>
                <a href="comprar.jsp""><button>Comprar</button></a>
            </div>
            <div class="Produto">
                <img src="img2\frango.png" alt="Brinquedo de Pelúcia">
                <h3>Brinquedo de Pelúcia</h3>
                <p class="preco">R$39,99</p>
                <a href="comprar.jsp""><button>Comprar</button></a>
            </div>
            <div class="Produto">
                <img src="img2\bolinha.png" alt="Bolinha Rosa">
                <h3>Bolinha Rosa</h3>
                <p class="preco">R$29,00</p>
                <a href="comprar.jsp""><button>Comprar</button></a>
            </div>
            <div class="Produto">
                <img src="img2\corda.png" alt="Corda">
                <h3>Corda</h3>
                <p class="preco">R$59,00</p>
                <a href="comprar.jsp""><button>Comprar</button></a>
            </div>
            <div class="Produto">
                <img src="img2\elefante.png" alt="Brinquedo de Pelúcia">
                <h3>Brinquedo de Pelúcia</h3>
                <p class="preco">R$49,00</p>
                <a href="comprar.jsp""><button>Comprar</button></a>
            </div>
            <div class="Produto">
                <img src="img2\bolinha2.png" alt="Bolinha Amarela">
                <h3>Bolinha Amarela</h3>
                <p class="preco">R$39,99</p>
                <a href="comprar.jsp""><button>Comprar</button></a>
            </div>
            <div class="Produto">
                <img src="img2\brinquedogato.png" alt="Brinquedo de Gato">
                <h3>Brinquedo de Gato</h3>
                <p class="preco">R$35,50</p>
                <a href="comprar.jsp""><button>Comprar</button></a>
            </div>
            <div class="Produto">
                <img src="img2\caminha.png" alt="Caminha">
                <h3>Caminha</h3>
                <p class="preco">R$159,00</p>
                <a href="comprar.jsp""><button>Comprar</button></a>
            </div>
            <div class="Produto">
                <img src="img2\caminha2.png" alt="Caminha">
                <h3>Caminha</h3>
                <p class="preco">R$145,99</p>
                <a href="comprar.jsp""><button>Comprar</button></a>
            </div>
            <div class="Produto">
                <img src="img2\caminha3.png" alt="Caminha">
                <h3>Caminha</h3>
                <p class="preco">R$139,99</p>
                <a href="comprar.jsp""><button>Comprar</button></a>
            </div>
        </div>        

    </main>
    <footer>
        <p>&copy; <%= java.time.Year.now() %> Mundo Dos Pets - Todos os direitos reservados.</p>
    </footer>
</body>
</html>