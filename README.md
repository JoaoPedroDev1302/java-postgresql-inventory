# Sistema de Controle de Estoque

Projeto desenvolvido em **Java** com integração ao **PostgreSQL utilizando JDBC**, criado com o objetivo de praticar desenvolvimento backend, orientação a objetos, banco de dados e operações CRUD.

## Funcionalidades

O sistema permite realizar as seguintes operações pelo terminal:

- Cadastrar produtos
- Listar produtos cadastrados
- Atualizar produtos
- Excluir produtos
- Validar a existência do produto antes de atualizar ou excluir

## Tecnologias utilizadas

- Java
- PostgreSQL
- JDBC
- SQL
- Maven
- IntelliJ IDEA

## Conceitos aplicados

- Programação Orientada a Objetos
- Padrão DAO
- Operações CRUD
- PreparedStatement
- ResultSet
- Tratamento de exceções
- Integração entre Java e banco de dados
- Variáveis de ambiente para proteção de dados sensíveis

## Estrutura do projeto

```text
src/main/java/
├── app/
│   └── Main.java
├── conexao/
│   └── ConexaoFactory.java
├── dao/
│   └── ProdutoDAO.java
└── model/
    └── Produto.java
```

## Banco de dados

O projeto utiliza PostgreSQL.

A aplicação espera um banco chamado:

```text
jdbc_estudos
```

e uma tabela `produto` com a seguinte estrutura:

```sql
CREATE TABLE produto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco NUMERIC(10,2) NOT NULL,
    quantidade INTEGER NOT NULL
);
```

## Configuração da conexão

A senha do PostgreSQL não é armazenada diretamente no código.

Ela deve ser configurada através da variável de ambiente:

```text
DB_PASSWORD
```

A conexão utiliza:

```text
jdbc:postgresql://localhost:5432/jdbc_estudos
```

## Execução

Execute a classe:

```text
app.Main
```

O sistema exibirá o seguinte menu:

```text
==============================
      CONTROLE DE ESTOQUE
==============================
1 - Cadastrar produto
2 - Listar produtos
3 - Atualizar produto
4 - Excluir produto
0 - Sair
```

## Objetivo do projeto

Este projeto foi desenvolvido como parte dos meus estudos de **Java, SQL, PostgreSQL e JDBC**, buscando aplicar na prática conceitos de desenvolvimento de software e persistência de dados.