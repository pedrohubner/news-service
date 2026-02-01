# Data Model: NewsArticle (Padronizado)

## Entidade: NewsArticle

| Campo        | Tipo      | Obrigatório | Descrição                                                    |
|--------------|-----------|-------------|--------------------------------------------------------------|
| id           | string    | Sim         | Identificador único da notícia (prefixado por fonte)         |
| title        | string    | Sim         | Título da notícia                                            |
| summary      | string    | Sim         | Resumo/subtítulo                                             |
| url          | string    | Sim         | URL canônica da notícia                                      |
| publishedAt  | datetime  | Sim         | Data/hora de publicação (ISO 8601 UTC)                       |
| source       | enum      | Sim         | Origem da notícia: NYTIMES ou GUARDIAN                      |
| section      | string    | Sim         | Seção/categoria                                              |
| type         | string    | Sim         | Tipo de conteúdo ("article", "opinion", "live")           |
| author       | string    | Não         | Nome(s) do(s) autor(es), se disponível                       |
| imageUrl     | string    | Não         | URL da imagem principal, se disponível                       |
| tags         | string[]  | Não         | Lista de tags/palavras-chave, se disponível                  |

## Regras de Validação
- Todos os campos obrigatórios devem estar presentes.
- O campo `id` deve ser único por fonte, prefixado (ex: "nyt-", "guardian-").
- O campo `source` deve ser um dos valores do enum.
- O campo `publishedAt` deve ser convertido para UTC ISO 8601.
- Campos opcionais devem ser omitidos se não disponíveis.
- O campo `type` deve ser padronizado conforme taxonomia da fonte.

## Relacionamentos
- Não há relacionamentos entre entidades neste modelo (flat response).

## Exemplo
```json
{
  "id": "nyt-20260130-abc123",
  "title": "Eleições 2026: Resultados Parciais",
  "summary": "Veja os principais destaques das eleições.",
  "url": "https://nytimes.com/2026/01/30/politics/eleicoes.html",
  "publishedAt": "2026-01-30T12:34:56Z",
  "source": "NYTIMES",
  "section": "politics",
  "type": "article",
  "author": "Jane Doe",
  "imageUrl": "https://nytimes.com/images/eleicoes.jpg",
  "tags": ["eleições", "política"]
}
```

---

> Modelo padronizado conforme especificação. Atualizar se novas fontes forem integradas.
