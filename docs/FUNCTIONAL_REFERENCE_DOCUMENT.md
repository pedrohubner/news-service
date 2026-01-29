# FUNCTIONAL_REFERENCE_DOCUMENT.md

## 1. Visão Geral
- Sistema: news-service
- Objetivo: disponibilizar notícias de diferentes seções do NYTimes via API REST
- Escopo: consulta de notícias por seção; fora do escopo: cadastro, edição ou persistência local de notícias

## 2. Stakeholders e Atores
- Usuário consumidor da API (aplicações internas ou externas)
- Administrador (responsável por manter a chave de API e ambiente)

## 3. Fluxos Funcionais Principais
- Receber requisição GET `/v1?section=<nome>`
- Buscar notícias na NYTimes API usando a seção informada
- Retornar lista de notícias formatada

## 4. Regras de Negócio
- Obrigatório informar parâmetro `section`
- Chave de API obrigatória para integração externa
- Apenas leitura de dados

## 5. Casos de Uso
### Caso: Consultar notícias por seção
- Ator: Usuário consumidor
- Pré-condição: API key válida, seção existente
- Fluxo principal: requisitar endpoint, receber lista de notícias
- Fluxo alternativo: seção inválida (erro), API key inválida (erro)
- Pós-condição: resposta JSON com notícias ou erro

## 6. Exceções e Cenários de Erro
- Seção inexistente: erro da NYTimes API
- API key inválida: erro de autenticação
- Falha de comunicação: erro genérico

## 7. Requisitos Não Funcionais (visão funcional)
- Disponibilidade: 24/7
- Usabilidade: interface REST simples
- Observabilidade: logs de requisições e erros

## 8. Limitações e Premissas
- Não armazena dados localmente
- Depende da disponibilidade da NYTimes API
- Chave de API deve ser mantida segura
