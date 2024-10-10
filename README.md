
  
# Projeto de Gerenciamento de Jogadores e Pagamentos ⚽

Este projeto é uma API RESTful desenvolvida em Java para gerenciar jogadores e seus pagamentos mensais. Ele foi desenvolvido com o objetivo de fornecer funcionalidades CRUD (Criar, Ler, Atualizar e Excluir) tanto para jogadores quanto para pagamentos.

Desenvolvido pelos alunos Kainã, Otávio e Wendell para a disciplina de Desenvolvimento Web.
## Tecnologias Utilizadas 🛠️

-   **Java 11+**
-   **Spring Boot**: Framework para criar a aplicação REST.
-   **Maven**: Gerenciamento de dependências.
-   **PostgreSQL**: Banco de dados para persistência dos dados.

## Funcionalidades 🌟

### Gerenciamento de Jogadores

-   **Criar um Jogador**: Adiciona um novo jogador ao sistema.
-   **Buscar um Jogador**: Permite encontrar jogadores pelo ID ou pelo nome.
-   **Listar todos os Jogadores**: Retorna uma lista de todos os jogadores cadastrados.
-   **Atualizar Jogador**: Atualiza as informações de um jogador existente.
-   **Excluir Jogador**: Remove um jogador do sistema.

### Gerenciamento de Pagamentos

-   **Criar um Pagamento**: Registra um novo pagamento para um jogador.
-   **Buscar um Pagamento**: Retorna as informações de um pagamento específico pelo ID.
-   **Listar todos os Pagamentos**: Retorna uma lista de todos os pagamentos.
-   **Atualizar Pagamento**: Atualiza as informações de um pagamento existente.
-   **Excluir Pagamento**: Remove um pagamento do sistema.

## Endpoints 📋

### Rotas de Jogadores

### 1. Listar Jogadores

- **GET**  `/jogador/`
    - Descrição: Retorna uma lista de todos os jogadores ou jogadores cujo nome contém o valor da string passada como parâmetro.
    - Parâmetro **(opcional)**: `nome` (string)
    - Exemplo de requisição: `GET http://localhost:8000/futebol/jogador/`
    - Respostas:
        - `200 OK`: Sucesso, retorna a lista de jogadores.
        - `204 NO CONTENT`: Nenhum jogador encontrado.
        - `500 INTERNAL SERVER ERROR`: Erro ao processar a requisição.

### 2. Obter Jogador por ID

- **GET** `/jogador/{id}`
    - Descrição: Retorna os dados de um jogador específico baseado no seu ID.
    - Parâmetro: `id` (long)
    - Exemplo de requisição: `GET http://localhost:8000/futebol/jogador/1`
    - Respostas:
        - `200 OK`: Jogador encontrado.
        - `404 NOT FOUND`: Jogador não encontrado.
        - `500 INTERNAL SERVER ERROR`: Erro ao processar a requisição.

### 3. Criar Jogador

- **POST** `/jogador/`
    - Descrição: Cria um novo jogador.
    - Corpo da requisição (JSON):
            
	        {
		        "nome": "Leo",   
		        "email": "Leo@gmail.com",   
		        "datanasc": "yyyy-MM-dd"
	        }
    - Exemplo de requisição: `POST http://localhost:8000/futebol/jogador/`
    - Respostas:
        - `201 CREATED`: Jogador criado com sucesso.
        - `500 INTERNAL SERVER ERROR`: Erro ao processar a requisição.

### 4. Atualizar Jogador

- **PUT** `/jogador/{id}`
    - Descrição: Atualiza os dados de um jogador existente 
    - Observação: Obrigatório passar todos os campos para atualizar o jogador
    - Parâmetro: `id` (long)
    - Corpo da requisição (JSON):
    
  		    {
	  		    "nome": "Leonardo",   
	  		    "email": "Leonardo@gmail.com",   
	  		    "datanasc": "yyyy-MM-dd"
  		    }    	    
    - Exemplo de requisição: `PUT http://localhost:8000/futebol/jogador/1`
    - Respostas:
        - `200 OK`: Jogador atualizado com sucesso.
        - `404 NOT FOUND`: Jogador não encontrado.
        - `500 INTERNAL SERVER ERROR`: Erro ao processar a requisição.
### 5. Atualizar Jogador

- **PATCH** `/jogador/{id}`
    - Descrição: Atualiza parcialmente os dados de um jogador existente.
    - Observação: Atualiza os dados apenas com os campos passados no corpo da requisição
    - Parâmetro: `id` (long)
    - Corpo da requisição (JSON):
    
  		    {
	  		    "nome": "Leonardo",   
  		    }    	    
    - Exemplo de requisição: `PATCH http://localhost:8000/futebol/jogador/1`
    - Respostas:
        - `200 OK`: Jogador atualizado com sucesso.
        - `404 NOT FOUND`: Jogador não encontrado.
        - `500 INTERNAL SERVER ERROR`: Erro ao processar a requisição.
### 6. Deletar Jogador por ID

- **DELETE** `/jogador/{id}`
    - Descrição: Deleta um jogador com base no seu ID.
    - Parâmetro: `id` (long)
    - Exemplo de requisição: `DELETE http://localhost:8000/futebol/jogador/1`
    - Respostas:
        - `204 NO CONTENT`: Jogador deletado com sucesso.
        - `404 NOT FOUND`: Jogador não encontrado.
        - `500 INTERNAL SERVER ERROR`: Erro ao processar a requisição.
    
### Rotas de Pagamentos

### 1. Listar Todos os Pagamentos

- **GET** `/pagamento/`
    - Descrição: Retorna a lista de todos os pagamentos registrados no sistema.
    - Exemplo de requisição: `GET http://localhost:8000/futebol/pagamento/`
    - Respostas:
        - `200 OK`: Lista de pagamentos retornada com sucesso.
        - `204 NO CONTENT`: Nenhum pagamento encontrado.
        - `500 INTERNAL SERVER ERROR`: Erro ao processar a requisição.

### 2. Obter Pagamento por ID

- **GET** `/pagamento/{id}`
    - Descrição: Retorna os detalhes de um pagamento específico com base no ID.
    - Parâmetro: `id` (long)
    - Exemplo de requisição: `GET http://localhost:8000/futebol/pagamento/1`
    - Respostas:
        - `200 OK`: Pagamento encontrado.
        - `404 NOT FOUND`: Pagamento não encontrado.
        - `500 INTERNAL SERVER ERROR`: Erro ao processar a requisição.

### 3. Criar Pagamento

- **POST** `/pagamento/`
    - Descrição: Cria um novo pagamento para um jogador.
    - Corpo da requisição (JSON):
                
	      {   
	        "ano": 2034,   
	        "mes": 12,   
	        "valor": 1200.0,   
	        "jogador": 
            {
	            "cod_jogador": 1,     
	            "nome": "Leonardo"   
            } 
          }
     
  
- Exemplo de requisição: `POST http://localhost:8000/futebol/pagamento/`
- Respostas:
    - `201 CREATED`: Pagamento criado com sucesso.
    - `400 BAD REQUEST`: Dados do jogador inválidos ou incompletos.
    - `404 NOT FOUND`: Jogador não encontrado.
    - `500 INTERNAL SERVER ERROR`: Erro ao processar a requisição.

### 4. Atualizar Pagamento

- **PUT** `/pagamento/{id}`
    - Descrição: Atualiza os detalhes de um pagamento existente.
    - Parâmetro: `id` (long)
    - Corpo da requisição (JSON):
        
	      {   
	        "ano": 2036,   
	        "mes": 12,   
	        "valor": 1800.0,   
	        "jogador": 
            {
	            "cod_jogador": 1,      
            } 
          }
      
    - Exemplo de requisição: `PUT http://localhost:8000/futebol/pagamento/1`
    - Respostas:
        - `200 OK`: Pagamento atualizado com sucesso.
        - `404 NOT FOUND`: Pagamento ou jogador não encontrado.
        - `500 INTERNAL SERVER ERROR`: Erro ao processar a requisição.

### 5. Deletar Pagamento por ID

- **DELETE** `/pagamento/{id}`
    - Descrição: Deleta um pagamento específico com base no ID.
    - Parâmetro: `id` (long)
    - Exemplo de requisição: `DELETE http://localhost:8000/futebol/pagamento/1`
    - Respostas:
        - `204 NO CONTENT`: Pagamento deletado com sucesso.
        - `404 NOT FOUND`: Pagamento não encontrado.
        - `500 INTERNAL SERVER ERROR`: Erro ao processar a requisição.

### 6. Deletar Todos os Pagamentos

- **DELETE** `/pagamento/`
    - Descrição: Deleta todos os pagamentos registrados no sistema.
    - Exemplo de requisição: `DELETE http://localhost:8000/futebol/pagamento/`
    - Respostas:
        - `204 NO CONTENT`: Todos os pagamentos deletados com sucesso.
        - `500 INTERNAL SERVER ERROR`: Erro ao processar a requisição.
