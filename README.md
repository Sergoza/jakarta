# Практическая работа №3 — RESTful веб-сервис

## Тема: Конный клуб

## Технологии
Spring Boot 3, Spring REST, Spring Data JPA, PostgreSQL, Jackson (JSON/XML), XSLT.

## Реализованный функционал
- **REST API**: Разработаны контроллеры для сущностей `Horse` и `Rider` (CRUD операции).
- **DTO**: Для передачи данных используются классы `HorseDTO` и `RiderDTO` (отделяют структуру БД от API).
- **JSON и XML**: API поддерживает как прием, так и отдачу данных в форматах JSON и XML (через заголовок `Accept` и `Content-Type`).
- **XSLT-преобразование**: Разработан файл `style.xsl`, который превращает XML-ответ в HTML-таблицу.
- **Автовставка XSL**: Настроен `ResponseBodyAdvice`, который автоматически добавляет тег `<?xml-stylesheet?>` в начало XML-ответа.

## Проверка
1. Запустить приложение (`Application.java`).
2. **JSON**: `GET http://localhost:8080/api/horses` (или `/api/riders`).
3. **XML с XSL (в браузере)**: Открыть `http://localhost:8080/api/horses`. Браузер отрисует HTML-таблицу.
4. **POST/DELETE (через Postman)**:
   - POST `http://localhost:8080/api/horses` (Body: JSON с полями name, breed, age, weight).
   - DELETE `http://localhost:8080/api/horses/{id}`.
