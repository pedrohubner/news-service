# TECHNICAL_REFERENCE_DOCUMENT.md

## 1. Visão Geral Técnica
- Projeto Spring Boot REST API para consulta de notícias do NYTimes

## 2. Escopo Técnico
- Expor endpoint GET `/v1?section=<nome>`
- Integração externa com NYTimes Top Stories API

## 3. Arquitetura
- Monolito Java 17
- Camadas: Controller, Config, Model
- Componentes: NewsController, Properties, RestTemplateConfig, ErrorHandler

## 4. Stack Tecnológica
- Java 17
- Spring Boot 2.7.5
- Gradle
- Lombok
- JUnit 5

## 5. Contratos Técnicos
- Endpoint: `/v1?section=<section>`
- Método: GET
- Parâmetro: section (string)
- Resposta: JSON (NewsResponse)
- Integração: https://api.nytimes.com/svc/topstories/v2/{section}.json?api-key={api-key}

## 6. Fluxos Técnicos
- Síncrono: requisição REST -> consulta NYTimes -> resposta
- Assíncrono: não aplicável

## 7. Persistência
- Não há persistência local

## 8. Observabilidade
- Logs padrão Spring Boot
- Erros tratados por RestTemplateErrorHandler

## 9. Segurança
- API key sensível em `application.properties`
- Sem autenticação/autorização local

## 10. Resiliência e Performance
- Timeout e retries: padrão RestTemplate
- Erros propagados via ExceptionUtils

## 11. Build, Testes e Qualidade
- Build: `./gradlew build`
- Testes: `./gradlew test` (JUnit 5)
- Qualidade: não há linting/coverage obrigatório

## 12. Deploy e Operação
- Deploy manual/local
- Porta padrão: 9000
- Context path: /news

## 13. Limitações e Riscos Técnicos
- Dependência total da NYTimes API
- Falta de autenticação local
- Não há cache

## 14. Decisões Técnicas Registradas (ADR resumo)
- Uso de RestTemplate para integração externa
- Lombok para reduzir boilerplate
- Error handling customizado para respostas HTTP externas
