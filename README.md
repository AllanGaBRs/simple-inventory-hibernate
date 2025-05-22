# Sistema de Gerenciamento de Fornecedores e Produtos

Este projeto é um sistema simples de cadastro e gerenciamento de fornecedores e produtos, desenvolvido utilizando **Java com Hibernate (apenas Hibernate, sem frameworks adicionais)** para persistência de dados em banco de dados relacional.

## 📜 Funcionalidades

O sistema é baseado em um menu no terminal, com as seguintes opções:

- **Cadastrar Fornecedor:** Insere um novo fornecedor no banco de dados.
  
- **Cadastrar Produto:** Insere um novo produto no banco de dados, associado a um fornecedor.
- **Listar Fornecedores:** Exibe todos os fornecedores cadastrados.
- **Listar Produtos:** Exibe todos os produtos cadastrados, incluindo seus respectivos fornecedores.
- **Atualizar Produto:** Permite alterar os dados de um produto existente.
- **Atualizar Fornecedor:** Permite alterar os dados de um fornecedor existente.
- **Excluir Produto:** Remove um produto do banco de dados.
- **Excluir Fornecedor:** Remove um fornecedor do banco de dados (atenção: é necessário remover os produtos associados antes).

## 🏗️ Tecnologias utilizadas

- Java
- Hibernate ORM
- MySQL
- Maven

### 🧩 Entidades

Este projeto foi feito de forma simples, as classes são simples, apenas para fins de demonstração e conforme solicitado no trabalho.


### 💡 Relacionamento

- Um **Fornecedor** pode estar relacionado a **muitos Produtos**.
- Um **Produto** pertence a **um único Fornecedor**.

## 🔧 Configuração do Banco de Dados

O sistema realiza a **criação automática do banco de dados e das tabelas**
Usuário: root
Senha: 123456

