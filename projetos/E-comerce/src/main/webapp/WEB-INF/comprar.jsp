<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mundo Dos Pets</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="icon" href="img2/pets.png" type="logo">
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
        <h2 class="titulo-compra">Finalize sua Compra</h2>

        <div class="carrinho">
            <h3>Produtos no Carrinho:</h3>
            <div class="produtos-carrinho" id="produtosCarrinho">
            </div>
            <div class="total">
                <h3>Total: <span id="totalCompra">R$0,00</span></h3>
            </div>
        </div>

        <h3>Preencha seus Dados</h3>
        <form id="formFinalizar" class="form-finalizar" onsubmit="event.preventDefault(); finalizarCompra();">
            <label for="nome">Nome Completo</label>
            <input type="text" id="nome" name="nome" required>

            <label for="endereco">Endereço</label>
            <input type="text" id="endereco" name="endereco" required>

            <label for="telefone">Telefone</label>
            <input type="tel" id="telefone" name="telefone" required>

            <label for="email">E-mail</label>
            <input type="email" id="email" name="email" required>

            <button type="submit">Finalizar Compra</button>

        </form>
        
        <div class="tela-confirmacao" id="telaConfirmacao" style="display: none;">
            <div class="modal">
                <h2>Compra Realizada com Sucesso!</h2>
                <p>Seu pedido foi realizado com sucesso. Em breve você receberá a confirmação.</p>
                <button class="voltar-btn" onclick="voltarPagina()">Voltar para a Página Inicial</button>
            </div>
        </div>

    </main>

    <footer>
        <p>&copy; <%= java.time.Year.now() %> Mundo Dos Pets - Todos os direitos reservados.</p>
    </footer>

    <script>
        // Carrinho de compras simulado
        let carrinho = [
            { nome: "Brinquedo de Pelúcia", preco: 39.99, imagem: "img2/coelhorosa.png" },
            { nome: "Caminha", preco: 59.99, imagem: "img2/caminha.png" }
        ];

        //exibir os produtos no carrinho
        function mostrarCarrinho() {
            const produtosCarrinho = document.getElementById('produtosCarrinho');
            const totalCompra = document.getElementById('totalCompra');
            produtosCarrinho.innerHTML = '';

            let total = 0;

            carrinho.forEach((produto, index) => {
                const divProduto = document.createElement('div');
                divProduto.classList.add('produto-item');
                divProduto.innerHTML = `
                    <img src="${produto.imagem}" alt="${produto.nome}" width="100">
                    <div>
                        <h4>${produto.nome}</h4>
                        <p class="preco">R$${produto.preco.toFixed(2)}</p>
                    </div>
                    <button onclick="removerProduto(${index})">Remover</button>
                `;
                produtosCarrinho.appendChild(divProduto);
                total += produto.preco;
            });

            totalCompra.textContent = `R$${total.toFixed(2)}`;
        }

        //remover um produto do carrinho
        function removerProduto(index) {
            carrinho.splice(index, 1); 
            mostrarCarrinho(); 
        }

         //exibir a tela de confirmação
         function exibirConfirmacao() {
            document.getElementById('telaConfirmacao').style.display = 'block';
        }

        function finalizarCompra() {
            exibirConfirmacao(); 
        }

        mostrarCarrinho();

        //voltar à página inicial
        function voltarPagina() {
            window.location.href = 'inicio.jsp';
        }
    </script>

</body>
</html>
