# IMPL_PLAN: Atualização tecnológica e refatoração estrutural

## Technical Context

- **Feature**: Atualização tecnológica e refatoração estrutural
- **Spec**: /specs/001-tech-update-model-refactor/spec.md
- **Branch**: 001-tech-update-model-refactor
- **Arquitetura**: Monolito Java 17, Spring Boot REST API, camadas Controller/Service/Model/Config, integração externa com NYTimes Top Stories API
- **Stack Atual**: Java 17, Spring Boot 2.7.5, Gradle, Lombok, JUnit 5
- **Mudanças propostas**:
  - Migrar para versões mais recentes e compatíveis de Gradle, Java, Spring Boot e dependências
  - Refatorar models (responses, requests) para records sempre que possível
  - Extrair lógica da NewsController para uma service dedicada
  - Padronizar auto-referência com `this.`
  - Externalizar URIs e API keys para application.yml (news.ny.url, news.ny.api-key)
  - Padronizar URLs/propriedades para múltiplos portais de notícias (inicialmente NYTimes)
- **Dependências**: NYTimes API, configuração de múltiplos portais, atualização de stack
- **Pontos de atenção**:
  - Garantir compatibilidade de código com novas versões
  - Testar integração com NYTimes após migração
  - Validar externalização de propriedades
  - Cobertura de testes para refatoração
- **NEEDS CLARIFICATION**:
  - Versões-alvo exatas para Java, Spring Boot, Gradle e dependências
  - Estratégia para múltiplos portais (estrutura de configuração, extensibilidade)
  - Impacto em testes existentes e necessidade de novos testes

## Constitution Check (Pre-Design)

- [ ] Princípios do projeto respeitados? (Test-First, Observabilidade, Simplicidade)
- [ ] Stack e padrões alinhados com TRD?
- [ ] Workflow e gates definidos?
- [ ] Justificativa para mudanças disruptivas?

## Gates

- [ ] Todos os pontos "NEEDS CLARIFICATION" resolvidos
- [ ] Alinhamento com TRD/FRD/Constitution
- [ ] Plano de rollback para migração tecnológica
- [ ] Cobertura de testes garantida

## Phase 0: Research Tasks

- [ ] Pesquisar versões estáveis/recomendadas para Java, Spring Boot, Gradle e dependências
- [ ] Levantar padrões para configuração de múltiplos portais de notícias
- [ ] Avaliar impacto da refatoração em testes existentes

## Phase 1: Design & Contracts

- [ ] Modelar records para responses/requests
- [ ] Definir estrutura de configuração para múltiplos portais
- [ ] Atualizar contratos de API se necessário
- [ ] Planejar quickstart para desenvolvedores

## Phase 2: Implementation Plan (to be detailed post-design)

- [ ] Sequência de migração tecnológica
- [ ] Refatoração de models/controllers/services
- [ ] Atualização de testes
- [ ] Validação e rollback

---

> Preencher seções de pesquisa e design conforme resultados das fases.
