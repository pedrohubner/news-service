# AGENTS.md

## 1. Reference Documents
- FRD (Functional Reference Document): requisitos funcionais do sistema
- TRD (Technical Reference Document): arquitetura, integrações, decisões técnicas
- Consulte FRD para entender o que o sistema faz, TRD para como é implementado

## 2. Dev Environment Tips
- Build: `./gradlew build`
- Testes: `./gradlew test`
- Java 17 obrigatório
- IDE recomendada: IntelliJ IDEA (importar como projeto Gradle)
- Dependências: gerenciadas via Gradle
- Estrutura padrão Spring Boot
- Configuração sensível: `api-key` em `application.properties`

## 3. Testing Instructions
- Testes em `src/test/java`
- Rodar todos: `./gradlew test`
- Framework: JUnit 5
- CI/CD: não configurado explicitamente
- Coverage mínimo: não definido

## 4. PR Instructions
- Título: descritivo e objetivo
- Checklist: build e testes locais
- Lint/format: padrão IDE
- Branch: `feature/<nome>`, `fix/<nome>`
- Merge: squash recomendado

## 5. Code Patterns & Conventions
- Spring Boot REST API
- Controllers em `controller/`, models em `model/`, configs em `config/`
- Lombok para boilerplate
- Error handling customizado via `RestTemplateErrorHandler`

## 6. Common Commands
- Build: `./gradlew build`
- Test: `./gradlew test`
- Run: `./gradlew bootRun`

## 7. Gotchas & Common Mistakes
- `api-key` ausente: falha nas requisições externas
- Portas ocupadas: ajuste `server.port` em `application.properties`
- Dependências do Gradle desatualizadas

## 8. Project-Specific Context
- Integração com NYTimes Top Stories API
- Domínio: notícias por seção
- Termos: section, article, multimedia

## 9. Quick Reference
| Comando                | Descrição                |
|------------------------|-------------------------|
| ./gradlew build        | Build do projeto        |
| ./gradlew test         | Executa testes          |
| ./gradlew bootRun      | Sobe aplicação local    |

- Contato: mantenedor do repositório
