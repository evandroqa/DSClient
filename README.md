# DSClient - Curso Dev Superior
DEVSuperior - DESAFIO: CRUD de clientes

Capítulo: API REST, camadas, CRUD, exceções, validações

Projeto desenvolvido com Spring Boot contendo um CRUD completo de web services REST para acessar um recurso de clientes. 

Contendo as cinco operações básicas aprendidas no capítulo:
> Busca paginada de recursos <br>
Busca de recurso por id <br>
Inserir novo recurso <br>
Atualizar recurso <br>
Deletar recurso <br>

Utilizado o Spring Boot com Java e banco de dados H2.
O **H2 é um banco de dados em memória** que executa todas as operações do CRUD, permitindo assim que possamos testar nossa aplicação mesmo sem um banco de dados já definido.<br>

+ Para criar o projeto foi utilizado o Spring Initializr: 👉https://start.spring.io/ <br>
+ A versão 21 LTS do java.<br><br>
![image](https://github.com/user-attachments/assets/e931c76a-5b9b-4656-982c-2aeb4d0b4a70)


+ O Projeto foi implementado no modelo conceitual com um seeding na base de dados - import.sql (10 clientes com dados SIGNIFICATIVOS)- para povoamento da tabela Client.<br><br>
![image](https://github.com/user-attachments/assets/7a15d308-d637-463b-866b-9332b10deb24)


Baixe o projeto deste repositório, start o aplicativo pela sua IDE favorita e depois. <br> 
Faça as consultas no endereço: http://localhost:8080/h2-console <br>

SELECT (Transact-SQL) para teste do seeding.
~~~javascript
-- Linhas de código em DML, todos os clientes.

SELECT * FROM tb_client ORDER BY id

~~~

URI para teste no **Postman**
~~~javascript
-- GET client by id - from 1 to 10
http://localhost:8080/api/clients/1

-- GET all clients - paged search
http://localhost:8080/api/clients/1

-- POST client (insert)
http://localhost:8080/api/clients/1
{
    "name": "Maria Silva",
    "cpf": "61064458009",
    "income": 6500.0,
    "birthDate": "1994-07-20",
    "children": 2
}

-- PUT client (update)
http://localhost:8080/api/clients/1
{
    "name": "Maria Silvaaa",
    "cpf": "01055005005",
    "income": 6500.0,
    "birthDate": "1994-07-20",
    "children": 2
}

-- DEL client (delete)
http://localhost:8080/api/clients/1
~~~
