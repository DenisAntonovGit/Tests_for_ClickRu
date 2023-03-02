# Проект по автоматизации тестирования для Click.ru
<a target="_blank" href="https://click.ru">Веб-сайт Click.ru</a>

## :scroll: Содержание:

* <a href="#stack">Используемые технологии</a>
* <a href="#verifications">Реализованные проверки</a>
* <a href="#jenkins-build">Параметры сборки в Jenkins</a>
* <a href="#terminal-run">Запуск тестов из терминала</a>
* <a href="#allure-report">Allure отчет</a>
* <a href="#allure-TestOps">Интеграция с Allure TestOps</a>
* <a href="#jira">Интеграция с Jira TestOps</a>  
* <a href="#telegram-notification">Отчет в Telegram</a>
* <a href="#selenoid-video">Видео примеры прохождения тестов</a>

<a id="stack"></a>
## 🔧 Используемые технологии:

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="ProjectMedia/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="ProjectMedia/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="ProjectMedia/Github.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="ProjectMedia/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="ProjectMedia/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="ProjectMedia/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="ProjectMedia/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="ProjectMedia/Allure_Report.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="ProjectMedia/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://qameta.io/"><img src="ProjectMedia/allureTestOps.svg" width="50" height="50"  alt="Allure TestOps"/></a>
<a href="https://www.java.com"><img src="ProjectMedia/java-logo.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://www.atlassian.com/ru/software/jira"><img src="ProjectMedia/jira-logo.svg" width="50" height="50"  alt="Jira"/></a>
<a href="https://rest-assured.io/"><img src="ProjectMedia/rest-assured-logo.svg" width="50" height="50"  alt="Rest-assured"/></a>
</p>

<a id="verifications"></a>
## :clipboard: Реализованные проверки:

# Web UI
- ✓ Проверка элементов главного меню.
- ✓ Проверка элементов меню в футере страницы.
- ✓ Проверка работы кнопки регистрации на главной странице.
- ✓ Проверка переключения на раздел Демо в модальном окне регистрации.
- ✓ Проверка переключения на раздел авторизации в модальном окне регистрации.
- ✓ Проверка работы калькулятора экономии на главной странице.
- ✓ Проверка работы калькулятора партнёрского вознаграждения.

## API
- ✓ Проверка получения списка всех USERS Master-аккаунта.
- ✓ Проверка возможности создания нового USER.
- ✓ Проверка получения инфорамции о Master-аккаунте.
- ✓ Проверка получения списка созданных маркетинговых аккаунтов у конкретного пользователя.
- ✓ Проверка создания группы маркетинговых аккаунтов у конкретного пользователя.
- ✓ Проверка удаления группы маркетинговых аккаунтов у конкретного пользователя.


## <img src="ProjectMedia/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a> Jenkins job
<a target="_blank" href="https://jenkins.autotests.cloud/job/С16-Denis_Antonov_0_0-projectForClickRu/">Сборка в Jenkins</a>
<p align="center">
<a href="https://jenkins.autotests.cloud/job/С16-Denis_Antonov_0_0-projectForClickRu/"><img src="ProjectMedia/Jenkins_mainpage_build.png" alt="Jenkins"/></a>
</p>

<a id="jenkins-build"></a>
### Параметры сборки в Jenkins:

- Локальный запуск
- Удаленный запуск

<a id="terminal-run"></a>
## :computer: Запуск тестов из терминала

Локальный запуск:
```bash
gradle clean test -Denv=local
```

Удаленный запуск в Jenkins:
```bash
gradle clean test -Denv=remote
```

<a id="allure-report"></a>
## <img src="ProjectMedia/Allure_Report.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/https://jenkins.autotests.cloud/job/С16-Denis_Antonov_0_0-projectForClickRu/16/allure/#">Allure report</a>

### Основное окно

<p align="center">
<img title="Allure Overview Dashboard" src="ProjectMedia/Allure_report_overview.png">
</p>

### Тесты

<p align="center">
<img title="Allure Tests" src="ProjectMedia/Allure_report_tests.png">
</p>

### Графики

<p align="center">
<img title="Allure Graphics" src="ProjectMedia/Allure_report_grafics.png">
</p>


<a id="allure-TestOps"></a>
## <img src="ProjectMedia/allureTestOps.svg" width="25" height="25"  alt="Allure TestOps"/></a> Интеграция с Allure TestOps

<p align="center">
<img title="Allure TestOps" src="ProjectMedia/Telegram_notification.png">
</p>

<a id="telegram-notification"></a>
## <img src="ProjectMedia/Telegram.svg" width="25" height="25"  alt="Telegram"/></a> Уведомление в Telegram

<p align="center">
<img title="Telegram" src="ProjectMedia/Telegram_notification.png">
</p>

<a id="selenoid-video"></a>
### <img src="ProjectMedia/Selenoid.svg" width="25" height="25"  alt="Selenoid video"/></a> Видео о прохождении тестов

<p align="center">
<img title="Selenoid Video" src="ProjectMedia/VideoAttachClickRu.gif" width="700" height="500"  alt="video"> 
</p>