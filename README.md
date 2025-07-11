# Sistema Ágil Simplificado

Este projeto é um sistema simples de **caixa e estoque** desenvolvido em **Java com MySQL**, utilizando **Swing** para interface gráfica e seguindo boas práticas de organização de código.

---

## 💡 Funcionalidades

- Cadastro de produtos (nome, preço, quantidade)
- Listagem dos produtos cadastrados
- Realização de vendas no caixa (com atualização do estoque)

---

## 🧱 Tecnologias Utilizadas

- Java 17
- MySQL 8+
- JDBC
- Swing (interface gráfica)
- VS Code + Extensão Java

---

## 🎯 Objetivo do Projeto

Este sistema foi desenvolvido com o objetivo de aprendizagem e portfólio, simulando uma aplicação real de controle de vendas e estoque com banco de dados integrado.

---

## 🛠️ Como Executar

### Pré-requisitos:

- Java JDK 17
- MySQL Server instalado e rodando
- VS Code com extensões Java (Red Hat)
- Driver JDBC do MySQL (`mysql-connector-j-9.3.0.jar`) na pasta `lib`

### 1. Clonar o repositório (se estiver no GitHub):
```bash
https://github.com/seu-usuario/sistema-agil-simplificado.git
```

### 2. Criar o banco de dados
Abra o **MySQL Workbench** e execute:
```sql
CREATE DATABASE IF NOT EXISTS sistema_agil_simplificado;
USE sistema_agil_simplificado;

CREATE TABLE IF NOT EXISTS produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    quantidade INT NOT NULL
);
```

### 3. Executar no VS Code

- Certifique-se de que o `.jar` do MySQL está na pasta `lib`
- O arquivo `settings.json` deve conter:
```json
"java.project.referencedLibraries": [
  "lib/mysql-connector-j-9.3.0.jar"
]
```
- Clique com o botão direito no `Main.java` e escolha **"Executar Arquivo Java"**

---

## 👩‍💻 Autoria
Projeto acadêmico desenvolvido por Mayra Helena da Silva Oliveira, estudante de Análise e Desenvolvimento de Sistemas.

📬 Contato: may.helenaoliveira@gmail.com

---

## 📝 Licença
Este projeto é de uso livre para fins de estudo e demonstração em portfólio.
