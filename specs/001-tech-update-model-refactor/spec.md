# Feature Specification: Atualização tecnológica e refatoração estrutural

**Feature Branch**: `001-tech-update-model-refactor`  
**Created**: 2026-01-29  
**Status**: Draft  
**Input**: User description: "Atualização tecnológica, refatoração de models para records, extração de lógica para service, padronização de self-call com 'this.', externalização de URIs e API keys para properties. Contexto: - Migrar versões desatualizadas de Gradle, Java, Spring Boot e dependências para as mais recentes e compatíveis. - Refatorar models (responses, requests) para records sempre que possível. - Extrair lógica da NewsController para uma service dedicada, conforme arquitetura em TRD. - Garantir que métodos chamados na mesma classe usem 'this.' para auto-referência. - Mover a URI da NYTimes API e a api-key para application.yml, usando as chaves news.ny.url e news.ny.api-key. - Padronizar URLs e propriedades para múltiplos portais de notícias, começando por NYTimes. Referências: - ./docs/TECHNICAL_REFERENCE_DOCUMENT.md - ./docs/FUNCTIONAL_REFERENCE_DOCUMENT.md - ./docs/AGENTS.md Gerar especificação detalhada para a feature, cobrindo requisitos técnicos, funcionais, critérios de aceitação e estratégia de testes."

## User Scenarios & Testing *(mandatory)*

<!--
  IMPORTANT: User stories should be PRIORITIZED as user journeys ordered by importance.
  Each user story/journey must be INDEPENDENTLY TESTABLE - meaning if you implement just ONE of them,
  you should still have a viable MVP (Minimum Viable Product) that delivers value.
  
  Assign priorities (P1, P2, P3, etc.) to each story, where P1 is the most critical.
  Think of each story as a standalone slice of functionality that can be:
  - Developed independently
  - Tested independently
  - Deployed independently
  - Demonstrated to users independently
-->

### User Story 1 - Consumidor consulta notícias por seção (Priority: P1)

Como consumidor da API, desejo consultar notícias de uma seção específica do NYTimes, para obter informações atualizadas de forma confiável.

**Why this priority**: É o fluxo principal do serviço, atendendo ao objetivo central do sistema.

**Independent Test**: Realizar uma requisição GET para `/v1?section=world` e receber uma lista de notícias formatada corretamente.

**Acceptance Scenarios**:

1. **Given** uma seção válida e API key configurada, **When** o consumidor requisita `/v1?section=world`, **Then** recebe uma lista de notícias da seção "world".
2. **Given** uma seção inválida, **When** o consumidor requisita `/v1?section=invalid`, **Then** recebe mensagem de erro informativa.
3. **Given** ausência ou erro na API key, **When** o consumidor requisita qualquer seção, **Then** recebe erro de autenticação.

---

### User Story 2 - Administrador atualiza configurações de integração (Priority: P2)

Como administrador, desejo atualizar a URI e a API key dos portais de notícias via arquivo de configuração, para facilitar manutenção e segurança.

**Why this priority**: Garante flexibilidade e segurança operacional, reduzindo riscos de exposição de dados sensíveis.

**Independent Test**: Alterar valores em `application.yml` e validar que a aplicação utiliza as novas configurações sem necessidade de recompilar.

**Acceptance Scenarios**:

1. **Given** nova URI e API key no arquivo de configuração, **When** a aplicação é reiniciada, **Then** utiliza os novos valores para integração.
2. **Given** múltiplos portais configurados, **When** um novo portal é adicionado, **Then** a aplicação reconhece e utiliza a configuração correspondente.

---

### User Story 3 - Desenvolvedor mantém e evolui o sistema (Priority: P3)

Como desenvolvedor, desejo que o código siga padrões modernos (records, services, auto-referência explícita), para facilitar manutenção, testes e evolução futura.

**Why this priority**: Melhora a qualidade do código, reduz erros e acelera futuras implementações.

**Independent Test**: Revisar o código e verificar uso de records, extração de lógica para services, e auto-referência com `this.`.

**Acceptance Scenarios**:

1. **Given** um model de resposta, **When** revisado, **Then** está implementado como record.
2. **Given** lógica de negócio no controller, **When** revisada, **Then** foi extraída para uma service dedicada.
3. **Given** métodos chamados internamente, **When** revisados, **Then** utilizam `this.` para auto-referência.

---

### Edge Cases

<!--
  ACTION REQUIRED: The content in this section represents placeholders.
  Fill them out with the right edge cases.
-->

- O que acontece se a NYTimes API estiver fora do ar? (Erro de comunicação tratado e mensagem amigável)
- Como o sistema lida com múltiplos portais com configurações ausentes? (Erro claro e logs informativos)
- O que ocorre se a configuração de API key estiver ausente ou inválida? (Erro de autenticação e log de segurança)

## Requirements *(mandatory)*

<!--
  ACTION REQUIRED: The content in this section represents placeholders.
  Fill them out with the right functional requirements.
-->

### Functional Requirements

- **FR-001**: O sistema DEVE migrar para as versões mais recentes e compatíveis de Gradle, Java e Spring Boot.
- **FR-002**: O sistema DEVE refatorar todos os models (responses, requests) para records, exceto onde não for possível.
- **FR-003**: O sistema DEVE extrair toda lógica de negócio do NewsController para uma service dedicada, conforme arquitetura definida no TRD.
- **FR-004**: O sistema DEVE garantir que métodos chamados na mesma classe utilizem `this.` para auto-referência.
- **FR-005**: O sistema DEVE mover URIs e API keys dos portais de notícias para o arquivo de configuração `application.yml`, usando as chaves `news.<portal>.url` e `news.<portal>.api-key`.
- **FR-006**: O sistema DEVE permitir configuração de múltiplos portais de notícias, começando por NYTimes, de forma padronizada.
- **FR-007**: O sistema DEVE manter compatibilidade com os fluxos e contratos atuais descritos no FRD e TRD.

### Key Entities

- **NewsResponse**: Representa a resposta formatada de notícias, atributos principais: lista de artigos, seção, data de atualização.
- **NewsRequest**: Representa a requisição de consulta, atributo principal: seção.
- **PortalConfig**: Representa as configurações de integração de cada portal (URI, API key).

## Success Criteria *(mandatory)*

<!--
  ACTION REQUIRED: Define measurable success criteria.
  These must be technology-agnostic and measurable.
-->

### Measurable Outcomes

- **SC-001**: 100% dos models de resposta/refatorados como records, exceto onde tecnicamente inviável.
- **SC-002**: 100% da lógica de negócio extraída dos controllers para services.
- **SC-003**: 100% das URIs e API keys externalizadas para `application.yml`.
- **SC-004**: Sistema permite adicionar novos portais de notícias apenas editando o arquivo de configuração.
- **SC-005**: Todos os fluxos principais e alternativos descritos nos user stories são cobertos por testes automatizados.
- **SC-006**: Nenhuma informação sensível (API key) permanece hardcoded no código-fonte.
- **SC-007**: Sistema permanece compatível com os contratos de integração e resposta atuais.

## Assumptions

- Não há persistência local de dados.
- Não há autenticação/autorização local.
- O padrão de externalização de propriedades será seguido para todos os portais futuros.
- O sistema continuará sendo monolito Spring Boot.
- Testes automatizados serão implementados para todos os fluxos principais e alternativos.
