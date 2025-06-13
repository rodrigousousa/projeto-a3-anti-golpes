# Sistema de Verificação de Atendentes

**Projeto da Disciplina de Sistemas Distribuídos e Mobile**
Solução para golpes de falso atendente bancário.

##🛠️ Tecnologias
- Java
- Spring Boot 3.x
- MySQL
- Docker

##👥 Integrantes 
- Rodrigo Ferraz Sousa
- Thomas Almeida Ferreira



Este projeto é composto por múltiplos serviços:

- **auth-service**: serviço de autenticação com JWT que se econtra no repositório : https://github.com/thmsAF/auth-service
- **verifica-contato-service**: serviço principal de verificação de números oficiais de atendimento
- **banco de dados**: instância MySQL compartilhada entre os serviços

##Observação:
O banco de dados criado no container não esta populado com dados ! 

##▶️ Como Executar
1. '''bash git clone https://github.com/rodrigousousa/projeto-a3-anti-golpes.git

2 . '''docker-compose up --build

