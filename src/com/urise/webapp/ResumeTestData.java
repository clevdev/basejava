package com.urise.webapp;

import com.urise.webapp.model.*;

import java.util.Arrays;

public class ResumeTestData {

    public static void main(String[] args) {
        Resume resume;
        resume = new Resume("Григорий Кислин");
        resume.setContact(ContactType.EMAIL, "gkislin@yandex.ru");
        resume.setContact(ContactType.GITHUB, "https://github.com/gkislin");
        resume.setContact(ContactType.HOMEPAGE, "http://gkislin.ru/");
        resume.setContact(ContactType.LINCKEDIN, "https://www.linkedin.com/in/gkislin");
        resume.setContact(ContactType.PHONE, "+7(921) 855-0482");
        resume.setContact(ContactType.SKYPE, "grigory.kislin");
        resume.setContact(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/548473/gkislin");

        resume.setSections(SectionType.PERSONAL, new SimpleTextSection("Аналитический склад ума, сильная логика," +
                " креативность, инициативность. Пурист кода и архитектуры."));

        ListSection<String> achievSections =
                new ListSection<>(Arrays.asList("С 2013 года: разработка проектов \"Разработка Web приложения\",\" Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.",
                        "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.",
                        "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.",
                        "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.",
                        "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).",
                        "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."
                ));

        resume.setSections(SectionType.ACHIEVEMENT, achievSections);

        ListSection<EducationCourses> educationListSection =
                new ListSection<>(Arrays.asList(
                        new EducationCourses(
                                new WebLink("Coursera", "https://www.coursera.org/learn/progfun1"),
                                new Course[]{new Course("03/2013 - 05/2013", "Functional Programming Principles in Scala\" by Martin Odersky")}),
                        new EducationCourses(
                                new WebLink("Luxoft", "https://www.luxoft-training.ru/kurs/obektno-orientirovannyy__analiz_is_kontseptualnoe_modelirovanie_na_uml_dlya_sistemnyh_analitikov_.html"),
                                new Course[]{new Course("03/2011 - 04/2011", "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"")}),
                        new EducationCourses(
                                new WebLink("Siemens AG", "https://new.siemens.com"),
                                new Course[]{new Course("01/2005 - 04/2005", "3 месяца обучения мобильным IN сетям (Берлин)")}),
                        new EducationCourses(
                                new WebLink("Alcatel", "http://www.alcatel.ru/"),
                                new Course[]{new Course("09/1997 - 03/1998", "6 месяцев обучения цифровым телефонным сетям (Москва)")}),
                        new EducationCourses(
                                new WebLink("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "http://www.ifmo.ru/ru/"),
                                new Course[]{new Course("09/1993 - 07/1996", "Аспирантура (программист С, С++)"),
                                        new Course("09/1987 - 07/1993", "Инженер (программист Fortran, C)")}),
                        new EducationCourses(
                                new WebLink("Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/"),
                                new Course[]{new Course("09/1984 - 06/1987", "6 месяцев обучения цифровым телефонным сетям (Москва)")})

                ));
        resume.setSections(SectionType.EDUCATION, educationListSection);

        ListSection<WorkExperience> experienceListSection =
                new ListSection<>(Arrays.asList(
                        new WorkExperience(new WebLink("Java Online Projects", "https://www.coursera.org/learn/progfun1"), "10/2013 - Сейчас", "Автор проекта", "Создание, организация и проведение Java онлайн проектов и стажировок."),
                        new WorkExperience(new WebLink("Wrike", "d"), "10/2014 - 01/2016", "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."),
                        new WorkExperience(new WebLink("RIT Center", "d"), "04/2012 - 10/2014", "Java архитектор", "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"),
                        new WorkExperience(new WebLink("Luxoft (Deutsche Bank)", "d"), "12/2010 - 04/2012", "Ведущий программист", "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5."),
                        new WorkExperience(new WebLink("Yota", "d"), "06/2008 - 12/2010", "Ведущий специалист", "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)"),
                        new WorkExperience(new WebLink("Enkata", "d"), "03/2007 - 06/2008", "Разработчик ПО", "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)."),
                        new WorkExperience(new WebLink("Siemens AG", "d"), "01/2005 - 02/2007", "Разработчик ПО", "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)."),
                        new WorkExperience(new WebLink("Alcatel", "d"), "09/1997 - 01/2005", "Инженер по аппаратному и программному тестированию", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).")
                ));

        resume.setSections(SectionType.EXPERIENCE, experienceListSection);
        resume.setSections(SectionType.OBJECTIVE, new SimpleTextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));

        ListSection<String> qualifSections =
                new ListSection<>(Arrays.asList(
                        "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                        "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                        "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB",
                        "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy, XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,",
                        "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).",
                        "Python: Django.",
                        "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js",
                        "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka",
                        "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.",
                        "Инструменты: Maven + plugin development, Gradle, настройка Ngnix,",
                        "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.",
                        "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования",
                        "Родной русский, английский \"upper intermediate\""
                ));
        resume.setSections(SectionType.QUALIFICATIONS, qualifSections);

        System.out.println(resume.getFullName());
        for (ContactType type : ContactType.values()
        ) {
            System.out.println(type.getTitle());
            System.out.println(resume.getContact(type));
        }

        for (SectionType type : SectionType.values()
        ) {
            System.out.println(type.getTitle());
            System.out.println(resume.getSections(type));
        }

    }
}
