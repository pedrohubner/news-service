# Research: News Hub Integration

## 1. Autenticação e limites da API do The Guardian
- **Decisão**: Usar API Key pública, conforme documentação oficial do The Guardian Open Platform.
- **Racional**: A API exige chave de autenticação via query param `api-key`. Limites gratuitos: 12 req/s, 5.000 req/dia.
- **Alternativas**: OAuth (não aplicável para uso público), proxy intermediário (não necessário).

## 2. Diferenças de formato entre NY Times e The Guardian
- **Decisão**: Mapear campos obrigatórios do modelo NewsArticle a partir dos campos disponíveis em cada fonte. Omitir campos opcionais ausentes.
- **Racional**: O NY Times e The Guardian possuem estruturas distintas (ex: tags, imagens, autores). O mapeamento será feito em camada de serviço/facade.
- **Alternativas**: Persistir dados para normalização (não permitido), expor campos brutos (não desejado).

## 3. Estratégia de paginação para ambas integrações
- **Decisão**: Implementar paginação obrigatória na API unificada, traduzindo para os parâmetros de cada fonte. NY Times: não suporta paginação nativa, simular via slicing local. The Guardian: suporta paginação nativa via `page` e `page-size`.
- **Racional**: Garante experiência consistente ao consumidor, mesmo com limitações da fonte.
- **Alternativas**: Limitar apenas ao menor denominador comum (não desejado), paginação opcional (não permitido).

## 4. Enum de origem e taxonomia de tipos de conteúdo
- **Decisão**: Usar enum `NYTIMES` e `GUARDIAN` para o campo `source`. Padronizar campo `type` para "article", "opinion", "live" conforme taxonomia de cada fonte.
- **Racional**: Facilita integração e tratamento por clientes, reduz ambiguidade.
- **Alternativas**: Usar string livre (não recomendado), mapear todos tipos possíveis (complexidade desnecessária).

## 5. Melhores práticas para integração resiliente com múltiplas APIs externas em Spring Boot
- **Decisão**: Utilizar interfaces e facades para cada fonte, tratamento centralizado de erros, timeouts e retries configuráveis, logs estruturados.
- **Racional**: Garante desacoplamento, testabilidade e robustez.
- **Alternativas**: Implementação direta no controller (baixa manutenibilidade), sem retries (baixa resiliência).

---

> Todas as decisões acima seguem o contexto do projeto e padrões definidos em TRD/FRD. Dúvidas e alternativas documentadas para rastreabilidade.
