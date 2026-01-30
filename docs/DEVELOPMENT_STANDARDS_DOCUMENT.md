# DEVELOPMENT_STANDARDS_DOCUMENT.md

## 1. Objetivo

Este documento estabelece **padrões obrigatórios** para escrita, revisão, teste e aceitação de código no projeto. Todos os artefatos de código DEVEM atender a estas regras. Código que viole estes padrões DEVE ser rejeitado em revisão.

---

## 2. Princípios Gerais de Qualidade

### 2.1 Clareza Acima de Tudo
- O código DEVE ser autoexplicativo
- A intenção DEVE ser clara sem necessidade de documentação externa
- Nomes DEVEM revelar propósito, não implementação

### 2.2 Simplicidade
- A solução mais simples que funciona É OBRIGATÓRIA
- Complexidade desnecessária DEVE ser eliminada
- Abstrações prematuras SÃO PROIBIDAS

### 2.3 Consistência
- Padrões estabelecidos DEVEM ser seguidos em todo o código
- Exceções DEVEM ser justificadas explicitamente
- Código novo DEVE seguir o estilo do código existente

### 2.4 Manutenibilidade
- Alterações futuras DEVEM ser previstas
- Dependências DEVEM ser minimizadas
- Acoplamento DEVE ser baixo

---

## 3. Padrões de Escrita e Organização

### 3.1 Nomenclatura

#### Regras Universais
- Nomes DEVEM ser pronunciáveis
- Nomes DEVEM ser pesquisáveis
- Abreviações SÃO PROIBIDAS exceto convenções universais (HTTP, URL, ID)
- Nomes de uma letra SÃO PROIBIDOS exceto variáveis de loop com escopo < 5 linhas

#### Especificidades
- Classes/Tipos: substantivos descritivos
- Funções/Métodos: verbos que indicam ação
- Booleanos: DEVEM iniciar com is/has/can/should
- Constantes: DEVEM usar convenção da linguagem
- Variáveis: DEVEM expressar o dado que armazenam

### 3.2 Estrutura de Arquivos
- Um conceito principal por arquivo
- Dependências DEVEM estar no topo
- Ordem de declaração: público → protegido → privado

### 3.3 Funções e Métodos

#### Tamanho
- Funções DEVEM ter <= 12 linhas
- Funções com >= 12 linhas DEVEM ser refatoradas
- Blocos aninhados DEVEM ter ≤ 3 níveis

#### Responsabilidade
- Uma função DEVE fazer uma coisa
- Parâmetros DEVEM ser ≤ 5
- Funções com > 5 parâmetros DEVEM usar objetos de configuração

#### Retorno
- Retornos múltiplos SÃO PERMITIDOS para guard clauses
- Retornos no meio do código DEVEM melhorar legibilidade
- Funções NÃO DEVEM retornar null sem justificativa explícita

### 3.4 Comentários

#### O Que Comentar
- Decisões não óbvias DEVEM ser comentadas
- Limitações conhecidas DEVEM ser documentadas
- Workarounds DEVEM incluir justificativa e ticket de rastreamento

#### O Que NÃO Comentar
- Código óbvio NÃO DEVE ter comentários
- Comentários que repetem o código SÃO PROIBIDOS
- Código comentado DEVE ser removido

#### Formato
- Comentários DEVEM estar na linha anterior ao código
- TODO DEVE incluir responsável e prazo ou ticket
- FIXME DEVE incluir descrição do problema e ticket

---

## 4. Complexidade e Legibilidade

### 4.1 Complexidade Ciclomática
- Funções DEVEM ter complexidade ≤ 10
- Complexidade > 10 DEVE ser refatorada
- Complexidade > 15 DEVE ser rejeitada

### 4.2 Condicionais
- Priorizar funções/métodos para as condicionais, proporcionando a LEITURA do que está sendo validado
- Condições complexas DEVEM ser extraídas para funções nomeadas
- Ternários aninhados SÃO PROIBIDOS
- Condições NÃO DEVEM ter > 3 operadores lógicos

### 4.3 Loops
- Loops aninhados DEVEM ter ≤ 2 níveis
- Loops com > 2 níveis DEVEM ser refatorados
- Corpo do loop DEVE ter < 20 linhas

### 4.4 Indentação e Formatação
- Indentação DEVE seguir padrão da linguagem
- Linhas DEVEM ter ≤ 120 caracteres
- Formatador automático É OBRIGATÓRIO

---

## 5. Tratamento de Erros e Exceções

### 5.1 Princípios
- Erros DEVEM ser tratados explicitamente
- Silenciar erros É PROIBIDO
- Catch genérico DEVE ser justificado

### 5.2 Estratégias

#### Fail Fast
- Validações DEVEM ocorrer no início das funções
- Dados inválidos DEVEM causar falha imediata
- Estado inválido NÃO DEVE ser tolerado

#### Propagação
- Erros NÃO recuperáveis DEVEM ser propagados
- Contexto DEVE ser adicionado ao propagar
- Stack trace DEVE ser preservado

#### Recuperação
- Recuperação DEVE ser explícita e documentada
- Fallback DEVE ter comportamento previsível
- Retry DEVE ter limite e backoff

### 5.3 Mensagens de Erro
- Mensagens DEVEM ser acionáveis
- Mensagens DEVEM incluir contexto relevante
- Mensagens NÃO DEVEM expor detalhes sensíveis
- Mensagens DEVEM ser escritas para o usuário final

### 5.4 Exceções Customizadas
- Exceções customizadas DEVEM adicionar valor semântico
- Hierarquia DEVE ser lógica
- Exceções genéricas SÃO PROIBIDAS sem justificativa

---

## 6. Logging, Observabilidade e Diagnósticos

### 6.1 Níveis de Log

#### ERROR
- Falhas que impedem operação normal
- Requerem ação imediata
- DEVEM incluir contexto completo

#### WARN
- Situações anormais não críticas
- Degradação de funcionalidade
- Potenciais problemas futuros

#### INFO
- Eventos importantes do ciclo de vida
- Início/fim de operações significativas
- Mudanças de estado do sistema

#### DEBUG
- Informações detalhadas para diagnóstico
- NÃO DEVE estar ativo em produção por padrão
- DEVE ser ativável dinamicamente

### 6.2 Conteúdo dos Logs
- Logs DEVEM ser estruturados
- Logs DEVEM incluir identificadores de correlação
- Logs NÃO DEVEM conter dados sensíveis
- Timestamps DEVEM estar em UTC

### 6.3 Observabilidade
- Métricas de negócio DEVEM ser coletadas
- Latência de operações críticas DEVE ser medida
- Taxa de erro DEVE ser monitorada
- Recursos DEVEM ser rastreáveis

### 6.4 Diagnósticos
- Operações longas DEVEM ser rastreáveis
- Falhas DEVEM ter identificador único
- Contexto DEVE permitir reprodução

---

## 7. Testes

### 7.1 Tipos e Escopo

#### Testes Unitários
- OBRIGATÓRIOS para toda lógica de negócio
- DEVEM testar um componente isolado
- DEVEM executar em < 100ms cada
- DEVEM ser determinísticos
- Cobertura mínima: 80% das linhas de lógica

#### Testes de Integração
- OBRIGATÓRIOS para integrações externas
- DEVEM validar contratos
- DEVEM usar mocks/stubs para dependências externas
- PODEM ser mais lentos (< 5s cada)

#### Testes de Contrato
- OBRIGATÓRIOS para APIs públicas
- DEVEM validar compatibilidade
- DEVEM falhar em breaking changes

### 7.2 Estrutura de Testes

#### Stubs
- Para os stubs devem ser criados métodos estáticos em classes stubs para aquele tipo específico
- Ao invés de SEMPRE criar stubs, busque reaproveitar os que já existem no projeto

#### Padrão AAA (Arrange-Act-Assert)
- Arrange: preparar contexto e dados
- Act: executar operação sendo testada
- Assert: validar resultado

#### Nomenclatura
- Nome DEVE descrever cenário sendo testado
- Formato: `<método>_<cenário>_<resultadoEsperado>`
- Exemplo: `calculateDiscount_whenVipCustomer_shouldApply20Percent`

### 7.3 Boas Práticas
- Testes DEVEM ser independentes
- Testes NÃO DEVEM depender de ordem de execução
- Testes DEVEM limpar estado após execução
- Setup compartilhado DEVE ser mínimo
- Cada teste DEVE validar um comportamento

### 7.4 Cobertura
- Cobertura DEVE ser medida
- Novos códigos DEVEM ter ≥ 80% de cobertura
- Cobertura < 80% DEVE ser justificada
- Branches críticos DEVEM ter 100% de cobertura

### 7.5 Testes de Cenários
- Happy path É OBRIGATÓRIO
- Casos de borda DEVEM ser testados
- Cenários de erro DEVEM ser testados
- Validações DEVEM ser testadas

---

## 8. Segurança e Boas Práticas Transversais

### 8.1 Validação de Entrada
- TODA entrada externa DEVE ser validada
- Validação DEVE ocorrer na camada de entrada
- Whitelist É PREFERÍVEL a blacklist
- Sanitização DEVE ser aplicada

### 8.2 Dados Sensíveis
- Credenciais NÃO DEVEM estar em código
- Segredos DEVEM usar gerenciamento apropriado
- Logs NÃO DEVEM conter senhas, tokens, PII
- Dados sensíveis DEVEM ser criptografados

### 8.3 Dependências
- Dependências DEVEM ser auditadas
- Versões DEVEM ser fixadas
- Vulnerabilidades conhecidas DEVEM ser corrigidas
- Dependências não utilizadas DEVEM ser removidas

### 8.4 Concorrência
- Estado compartilhado DEVE ser sincronizado
- Deadlocks DEVEM ser prevenidos
- Imutabilidade É PREFERÍVEL

### 8.5 Recursos
- Recursos DEVEM ser liberados explicitamente
- Timeouts DEVEM ser configurados
- Limites DEVEM ser respeitados
- Memory leaks DEVEM ser prevenidos

---

## 9. Automação de Qualidade

### 9.1 Análise Estática
- Linter É OBRIGATÓRIO
- Build DEVE falhar em violações
- Warnings DEVEM ser tratados como erros
- Regras DEVEM estar versionadas

### 9.2 Integração Contínua
- Testes DEVEM executar em cada commit
- Build DEVE ser automatizado
- Feedback DEVE ser < 10 minutos
- Pipeline falhando DEVE bloquear merge

### 9.3 Análise de Código
- Code smells DEVEM ser identificados
- Duplicação DEVE ser detectada
- Complexidade DEVE ser medida
- Tendências DEVEM ser monitoradas

### 9.4 Verificações Obrigatórias
- Formatação
- Linting
- Testes unitários
- Cobertura de código
- Análise de segurança
- Auditoria de dependências

---

## 10. Pull Requests e Code Review

### 10.1 Tamanho do PR
- PRs DEVEM ter < 400 linhas alteradas
- PRs > 400 linhas DEVEM ser justificados
- Mudanças grandes DEVEM ser divididas

### 10.2 Descrição
- Título DEVE ser descritivo
- Descrição DEVE incluir:
  - O que mudou
  - Por que mudou
  - Como testar
  - Impacto esperado
- Screenshots DEVEM ser incluídos para mudanças visuais
- Links para tickets DEVEM estar presentes

### 10.3 Checklist do Autor
- [ ] Código compila sem erros
- [ ] Testes passam localmente
- [ ] Novos testes foram adicionados
- [ ] Documentação foi atualizada
- [ ] Não há código comentado
- [ ] Não há logs de debug
- [ ] Variáveis de ambiente documentadas

### 10.4 Responsabilidades do Revisor
- Revisor DEVE validar lógica de negócio
- Revisor DEVE verificar conformidade com padrões
- Revisor DEVE questionar decisões não óbvias
- Revisor DEVE sugerir melhorias
- Feedback DEVE ser construtivo e específico

### 10.5 Aprovação
- Pelo menos 1 aprovação É OBRIGATÓRIA
- Mudanças críticas REQUEREM 2 aprovações
- Autor NÃO PODE aprovar próprio PR
- Aprovação implica responsabilidade compartilhada

---

## 11. Critérios de Aceite e Reprovação

### 11.1 Aceite Automático (Obrigatório)
- ✅ Build sucesso
- ✅ Todos os testes passando
- ✅ Cobertura ≥ 80%
- ✅ Sem violações de linter
- ✅ Sem vulnerabilidades críticas

### 11.2 Reprovação Automática
- ❌ Build falha
- ❌ Testes falhando
- ❌ Cobertura < 80% em código novo
- ❌ Violações de segurança
- ❌ Dependências vulneráveis

### 11.3 Reprovação Manual (Deve Reprovar)
- ❌ Lógica incorreta
- ❌ Falta de testes para cenários críticos
- ❌ Código duplicado sem justificativa
- ❌ Violação de princípios SOLID
- ❌ Complexidade excessiva
- ❌ Nomenclatura inadequada
- ❌ Tratamento inadequado de erros
- ❌ Falta de logs em operações críticas
- ❌ Exposição de dados sensíveis
- ❌ Quebra de contrato de API sem versionamento

### 11.4 Situações que Requerem Discussão
- ⚠️ Mudança arquitetural significativa
- ⚠️ Introdução de nova dependência
- ⚠️ Refatoração de código legado
- ⚠️ Trade-offs de performance
- ⚠️ Exceções aos padrões estabelecidos

---

## 12. Antipadrões Explícitos

### 12.1 PROIBIDO: God Objects
- Classes com múltiplas responsabilidades
- Objetos com > 500 linhas
- Componentes que conhecem tudo

### 12.2 PROIBIDO: Magic Numbers
- Números literais sem significado
- Valores hardcoded sem constante
- Configurações não externalizadas

### 12.3 PROIBIDO: Code Smells Clássicos
- Duplicação de código
- Funções muito longas
- Classes muito grandes
- Listas de parâmetros extensas
- Feature envy
- Shotgun surgery

### 12.4 PROIBIDO: Má Gestão de Estado
- Variáveis globais mutáveis
- Singletons com estado
- Estado compartilhado sem sincronização

### 12.5 PROIBIDO: Erro Handling Inadequado
- Empty catch blocks
- Catch de Exception genérico sem justificativa
- Silenciar erros
- Retornar null em vez de Optional/Result

### 12.6 PROIBIDO: Testes Inadequados
- Testes que não testam nada (sempre passam)
- Testes dependentes de ordem
- Testes com sleeps/timeouts arbitrários
- Testes que modificam estado global

### 12.7 PROIBIDO: Segurança
- Credenciais em código
- SQL/Command injection vulnerável
- Logs com dados sensíveis
- Comunicação não criptografada para dados sensíveis

### 12.8 PROIBIDO: Práticas de Código
- Commits diretos em branch principal
- Código comentado no commit final
- TODOs sem tracking
- Formatação inconsistente

---

## 13. Responsabilidades

### 13.1 Desenvolvedor
- DEVE seguir todos os padrões deste documento
- DEVE executar verificações locais antes de commit
- DEVE responder a feedback de revisão
- DEVE manter código e testes sincronizados

### 13.2 Revisor
- DEVE reprovar código que viole padrões
- DEVE fornecer feedback construtivo
- DEVE validar testes adequados
- DEVE garantir clareza e manutenibilidade

### 13.3 Time
- DEVE manter documento atualizado
- DEVE revisar padrões periodicamente
- DEVE adicionar padrões quando surgem novos cenários
- DEVE garantir que automação reflita padrões

---

## 14. Exceções

Exceções aos padrões DEVEM:
- Ser raras e bem justificadas
- Ser documentadas no código
- Ser discutidas em revisão
- Ter aprovação de pelo menos 2 revisores
- Incluir plano de remediação quando aplicável

Justificativas válidas:
- Integração com código legado
- Limitações técnicas documentadas
- Performance crítica com evidências
- Casos de borda extremamente raros

Justificativas inválidas:
- "Não tive tempo"
- "É só temporário"
- "Funciona assim em outro projeto"
- "Sempre fiz assim"

---

## 15. Aplicação e Evolução

### 15.1 Aplicação
- Este documento É OBRIGATÓRIO
- Violações DEVEM ser corrigidas
- Dúvidas DEVEM ser escaladas
- Melhorias DEVEM ser propostas via PR

### 15.2 Evolução
- Documento DEVE ser versionado
- Mudanças DEVEM ser revisadas pelo time
- Mudanças DEVEM ter período de adaptação quando necessário
- Histórico DEVE ser mantido

### 15.3 Revisão
- Revisão trimestral É OBRIGATÓRIA
- Feedback do time DEVE ser coletado
- Métricas de qualidade DEVEM ser analisadas
- Padrões obsoletos DEVEM ser removidos

---

## 15. Java

- Ao codificar, busque sempre utilizar as features mais recentes da linguagem, desde que compatível com o projeto.
- Prefira utilizar as APIs da biblioteca padrão do Java ao invés de bibliotecas externas, a menos que haja uma justificativa clara para tal.
- Utilize Optional para representar valores que podem estar ausentes, evitando o uso de null sempre que possível.
- Prefira o uso de Streams e Lambdas para operações em coleções, promovendo um estilo funcional e declarativo.
- Utilize var para declaração de variáveis locais quando o tipo puder ser inferido claramente, melhorando a legibilidade do código.
- Ao trabalhar com datas e horas, utilize a API java.time (Java 8+) ao invés das classes legadas como Date e Calendar.
- Prefira o uso de enums para representar conjuntos fixos de constantes ao invés de constantes estáticas.
- Utilize try-with-resources para gerenciar recursos que precisam ser fechados, garantindo o fechamento automático.
- Ao lançar exceções, prefira exceções específicas ao invés de genéricas para fornecer mais contexto sobre o erro.
- Utilize registros (records) para representar classes de dados imutáveis, quando aplicável, para reduzir boilerplate.

---

**Data de Última Atualização:** 2026-01-29  
**Versão:** 1.0.0  
**Status:** Ativo
