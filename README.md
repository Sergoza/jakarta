# Практическая работа №2 — Приложение на Spring

## Тема: Конный клуб

## Технологии
Spring Boot 3, Spring MVC, Spring Data JPA (Hibernate), PostgreSQL, Thymeleaf, Maven.

## Архитектура (3 слоя)
- **Данные**: JPA-сущности `Horse`, `Rider` (используются примитивы int/double).
- **Логика**: `HorseService`, `RiderService` и интерфейсы репозиториев.
- **Представление**: `HorseController`, `RiderController` и HTML-шаблоны Thymeleaf.

## Как запустить
1. Убедиться, что PostgreSQL запущен, база данных `javahorse` существует.
2. В `src/main/resources/application.properties` указать свой пароль от БД.
3. Запустить класс `Application.java`.
4. Открыть в браузере: http://localhost:8080

## Реализовано (CRUD)
Добавление, просмотр, редактирование и удаление лошадей и наездников.
