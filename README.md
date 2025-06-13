
# Sistema de Verificação de Atendentes

** Projeto da Disciplina de Sistemas Distribuídos e Mobile**
Solução para golpes de falso atendente bancário.

## 🛠️ Tecnologias
- Java
- Spring Boot 3.x
- MySQL
- Docker

## 👥 Integrantes 
- Rodrigo Ferraz Sousa
- Thomas Almeida Ferreira



## Este projeto é composto por múltiplos serviços:

- **auth-service**: serviço de autenticação com JWT que se econtra no repositório : https://github.com/thmsAF/auth-service
- **verifica-contato-service**: serviço principal de verificação de números oficiais de atendimento
- **banco de dados**: instância MySQL compartilhada entre os serviços

##Observação:
O banco de dados criado é populado com dados fictícios ! 




## ▶️ Como Executar
1.
  ``` bash
   git clone https://github.com/rodrigousousa/projeto-a3-anti-golpes.git
   ```

2 .
```bash
docker-compose up --build
```


## A aplicação estará acessível em:

http://localhost:8080 – Serviço de autenticação e cadastro

http://localhost:8082 – Serviço de verificação de números oficiais

## 🔐 Autenticação
A API utiliza autenticação via JWT, fornecida pelo auth-service.
Para acessar endpoints protegidos do serviço principal:

Faça login no auth-service:

POST /api/login

Utilize o token JWT retornado no header Authorization como:

css
Copiar
Editar
Authorization: Bearer {token}
## 📮 Endpoints da API
## 🔐 Microsserviço de Login (auth-service - porta 8080)
POST /api/usuarios – Criar novo usuário

```
{
  "nome": "string",
  "email": "string",
  "senha": "string"
}
```
POST /api/login – Autenticar usuário

```
{
  "email": "string",
  "senha": "string"
}
```
Retorna um token JWT com validade de 24h.

## ☎️ Microsserviço de Verificação (verifica-contato-service - porta 8082)
GET /api/contato/verificar?numero=
Verifica se o número informado pertence a algum banco oficial cadastrado.

GET /api/bancos/numeros?nome={nomeDoBanco}
Retorna todos os números oficiais associados ao banco informado por nome.

GET /api/bancos/{codigo}/numeros
Retorna todos os números oficiais associados ao código do banco informado.

## 📌 Observações

Inserts e tabelas se encontram no arquivo init.sql

Banco MySQL padrão:

Usuário: root

Senha: admin

Banco: verificacontato

JWT e outras configurações podem ser ajustadas via application.properties.
