Gerenciamento de Pedidos - API REST

Esta é uma API REST desenvolvida em Java 21 e Spring Framework 4.0 (Spring Boot 3) para o gerenciamento de pedidos. 
O projeto integra mensageria assíncrona com RabbitMQ, documentação interativa via Swagger/OpenAPI, persistência de dados com PostgreSQL 
(rodando em container Docker) e ferramentas de apoio para banco de dados e testes.

Tecnologias Utilizadas
Java 21

Spring Framework 4.0 (Spring Boot 3)

RabbitMQ (Mensageria e processamento assíncrono)

PostgreSQL (Banco de dados relacional)

Docker (Orquestração do container do banco de dados)

Springdoc OpenAPI / Swagger (Documentação da API)

Postman (Testes de requisições HTTP)

DBeaver (Gerenciamento e inspeção do banco de dados)

Mensageria com RabbitMQ
O fluxo de pedidos conta com processamento assíncrono utilizando o RabbitMQ. Quando um pedido é criado ou atualizado na API, 
uma mensagem é publicada em uma fila específica para processamento em background (como notificações, faturamento ou integração com estoque), 
desacoplando as regras de negócio críticas.

