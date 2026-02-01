# Tasks: News Hub Integration

## Feature: News Hub Integration (NY Times + The Guardian)

---

### Phase 1: Setup
- [ ] T001 Create project structure for News Hub feature in src/main/java/com/pedrohubner/newsservice/
- [ ] T002 [P] Add The Guardian and NY Times API keys to src/main/resources/application.yml
- [ ] T003 [P] Add OpenAPI contract to specs/001-news-hub/contracts/openapi.yaml
- [ ] T004 [P] Document quickstart and usage examples in specs/001-news-hub/quickstart.md

### Phase 2: Foundational
- [ ] T005 Implement NewsSource enum in src/main/java/com/pedrohubner/newsservice/model/NewsSource.java
- [ ] T006 Implement NewsArticle model in src/main/java/com/pedrohubner/newsservice/model/NewsArticle.java
- [ ] T007 Implement ErrorResponse model in src/main/java/com/pedrohubner/newsservice/model/ErrorResponse.java
- [ ] T008 [P] Implement NewsApiException for error handling in src/main/java/com/pedrohubner/newsservice/exception/NewsApiException.java
- [ ] T009 [P] Implement global error handler in src/main/java/com/pedrohubner/newsservice/config/GlobalExceptionHandler.java

### Phase 3: [US1] Consultar notícias de múltiplos portais (P1)
- [ ] T010 [US1] Implement INewsProvider interface in src/main/java/com/pedrohubner/newsservice/service/INewsProvider.java
- [ ] T011 [P] [US1] Implement NYTimesNewsProvider in src/main/java/com/pedrohubner/newsservice/service/NYTimesNewsProvider.java
- [ ] T012 [P] [US1] Implement GuardianNewsProvider in src/main/java/com/pedrohubner/newsservice/service/GuardianNewsProvider.java
- [ ] T013 [US1] Implement NewsService facade in src/main/java/com/pedrohubner/newsservice/service/NewsService.java
- [ ] T014 [US1] Implement NewsController in src/main/java/com/pedrohubner/newsservice/controller/NewsController.java
- [ ] T015 [US1] Implement pagination logic in NewsService.java
- [ ] T016 [US1] Validate section and source parameters in NewsController.java
- [ ] T017 [US1] Integrate NewsService with both providers and unify response
- [ ] T018 [US1] Implement integration tests for NewsController in src/test/java/com/pedrohubner/newsservice/controller/NewsControllerTest.java

### Phase 4: [US2] Resposta padronizada e enum de origem (P2)
- [ ] T019 [US2] Ensure NewsArticle model includes source enum and all required fields in src/main/java/com/pedrohubner/newsservice/model/NewsArticle.java
- [ ] T020 [US2] Ensure NewsController returns standardized response for all sources in src/main/java/com/pedrohubner/newsservice/controller/NewsController.java
- [ ] T021 [US2] Implement tests for standardized response in src/test/java/com/pedrohubner/newsservice/controller/NewsControllerTest.java

### Phase 5: [US3] Tratamento de formatos distintos e erros (P3)
- [ ] T022 [US3] Implement error mapping and normalization in NewsService.java
- [ ] T023 [US3] Implement error response for invalid source in NewsController.java
- [ ] T024 [US3] Implement error response for invalid section in NewsController.java
- [ ] T025 [US3] Implement error response for external API failures in NewsService.java
- [ ] T026 [US3] Implement tests for error scenarios in src/test/java/com/pedrohubner/newsservice/controller/NewsControllerTest.java

### Final Phase: Polish & Cross-Cutting Concerns
- [ ] T027 [P] Refactor code for SOLID and maintainability in all News Hub files
- [ ] T028 [P] Update OpenAPI documentation in specs/001-news-hub/contracts/openapi.yaml
- [ ] T029 [P] Update user and developer documentation in specs/001-news-hub/quickstart.md
- [ ] T030 [P] Validate acceptance criteria and success metrics in specs/001-news-hub/spec.md

---

## Dependencies
- US1 (Phase 3) must be completed before US2 (Phase 4) and US3 (Phase 5)
- US2 and US3 can be developed in parallel after US1
- Polish phase can be executed after all user stories are complete

## Parallel Execution Examples
- T002, T003, T004 can be executed in parallel after T001
- T011 and T012 can be executed in parallel after T010
- T027, T028, T029 can be executed in parallel in the final phase

## Implementation Strategy
- MVP: Complete all tasks in Phase 3 ([US1]) for a functional unified news endpoint
- Incremental delivery: Each user story phase is independently testable and delivers value
- Tests are included for all controller and error scenarios as per spec

## Format Validation
- All tasks follow the strict checklist format: checkbox, sequential TaskID, [P] for parallel, [USx] for user story, and file path
- Each user story phase is independently testable and mapped to acceptance criteria
- Parallel opportunities are clearly marked
