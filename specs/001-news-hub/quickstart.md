# Quickstart: News Hub API

## Pré-requisitos
- Java 17
- Gradle
- API Key do NY Times e The Guardian (configurar em `application.yml`)

## Como rodar localmente
```sh
./gradlew bootRun
```

## Exemplo de requisição
```http
GET /v1/news?section=politics&source=guardian&page=1&pageSize=10
```

## Parâmetros suportados
- `section` (obrigatório): seção/categoria da notícia
- `source` (opcional): `nytimes` (padrão) ou `guardian`
- `page` (opcional): inteiro >= 1 (padrão: 1)
- `pageSize` (opcional): inteiro 1-50 (padrão: 20)

## Exemplo de resposta
```json
{
  "articles": [
    {
      "id": "guardian-20260130-xyz789",
      "title": "Eleições 2026: Resultados Parciais",
      "summary": "Veja os principais destaques das eleições.",
      "url": "https://theguardian.com/2026/01/30/politics/eleicoes.html",
      "publishedAt": "2026-01-30T12:34:56Z",
      "source": "GUARDIAN",
      "section": "politics",
      "type": "article"
    }
  ],
  "page": 1,
  "pageSize": 10,
  "total": 100
}
```

## Tratamento de erros
- Parâmetro inválido: HTTP 400 + mensagem clara
- Seção inexistente: HTTP 404 + mensagem
- Falha externa: HTTP 503 + mensagem padronizada

## Documentação OpenAPI
- Ver arquivo: `specs/001-news-hub/contracts/openapi.yaml`

---

> Consulte a documentação para detalhes de integração e exemplos completos.
