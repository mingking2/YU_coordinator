# 🎓 YU_Coodinator

## 📚 프로젝트 개요

이 프로젝트는 웹 크롤링을 통해 학교의 대외활동 정보를 제공하고, 사용자가 로그인하여 학교 정보들을 확인하고 게시판 기능을 이용할 수 있는 웹 애플리케이션입니다.

---

## 🛠 개발환경

- **IDE**: 인텔리제이
- **프레임워크**: Spring Boot 3
- **JDK**: 21
- **데이터베이스**: MySQL
- **ORM**: Spring Data JPA
- **템플릿 엔진**: Thymeleaf
- **웹 크롤링**: JSOUP
- **보안**: Spring Security

---

## 🚀 주요기능

- **🕸 웹 크롤링 기능**: 학교 홈페이지의 정보를 자동으로 수집 및 업데이트
- **🔐 인증 및 인가 기능**: 사용자의 로그인 및 권한 관리
- **📝 게시판 기능**: 게시물 작성/수정/삭제/조회

---

## 📂 폴더구조

```plaintext
├── java
│   └── com
│       └── project
│           └── yucoordinator
│               ├── YuCoordinatorApplication.java
│               ├── config
│               │   └── SecurityConfig.java
│               └── domain
│                   ├── board
│                   │   ├── controller
│                   │   │   └── BoardController.java
│                   │   ├── dto
│                   │   │   ├── BoardDTO.java
│                   │   │   ├── CreateReq.java
│                   │   │   └── UpdateReq.java
│                   │   ├── entity
│                   │   │   └── BoardEntity.java
│                   │   ├── repository
│                   │   │   └── BoardRepository.java
│                   │   └── service
│                   │       └── BoardService.java
│                   ├── common
│                   │   ├── BaseEntity.java
│                   │   └── HomeController.java
│                   ├── info
│                   │   ├── component
│                   │   │   └── ApplicationStartupRunner.java
│                   │   ├── dto
│                   │   │   └── InfoDTO.java
│                   │   ├── entity
│                   │   │   ├── CSEInfoEntity.java
│                   │   │   └── YUInfoEntity.java
│                   │   ├── repository
│                   │   │   ├── CSEInfoRepository.java
│                   │   │   └── YUInfoRepository.java
│                   │   └── service
│                   │       └── InfoService.java
│                   └── user
│                       ├── controller
│                       │   └── UserController.java
│                       ├── dto
│                       │   ├── LoginForm.java
│                       │   └── SignupForm.java
│                       ├── entity
│                       │   ├── RoleType.java
│                       │   ├── UserDetail.java
│                       │   └── UserEntity.java
│                       ├── repository
│                       │   └── UserRepository.java
│                       └── service
│                           ├── UserDetailService.java
│                           └── UserService.java
└── resources
    ├── application.properties
    ├── static
    │   ├── createStyle.css
    │   ├── detailStyle.css
    │   ├── homeStyle.css
    │   ├── listStyle.css
    │   ├── loginStyle.css
    │   ├── path.js
    │   ├── signupStyle.css
    │   └── updateStyle.css
    └── templates
        ├── create.html
        ├── detail.html
        ├── home.html
        ├── list.html
        ├── login.html
        ├── signup.html
        └── update.html
```

---

## 🌐 WebSite URL

[YU coordinator](http://ec2-43-202-42-188.ap-northeast-2.compute.amazonaws.com:8080)

---

## 🗂 GitHub Repository

[GitHub Repository Link](https://github.com/mingking2/YU_coordinator)

---

# 설정 및 실행 가이드

이 문서는 YU_Coodinator 프로젝트를 다른 컴퓨터에서 설정하고 JAR 파일을 실행하는 방법에 대해 설명합니다. 이 프로젝트는 MySQL 데이터베이스를 사용하므로, MySQL 설정도 포함되어 있습니다.

## 📋 사전 준비

1. **Java 설치**
    - Java Development Kit (JDK) 21이 설치되어 있어야 합니다. [JDK 21 다운로드](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html)

2. **MySQL 설치**
    - MySQL 서버와 클라이언트를 설치해야 합니다. [MySQL 다운로드](https://dev.mysql.com/downloads/mysql/)

## 📦 프로젝트 설정

### 1. MySQL 설정

1. MySQL 서버를 시작합니다.
2. 데이터베이스와 유저를 생성합니다.

```sql
CREATE DATABASE yucoordinator;
CREATE USER 'user'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON yucoordinator.* TO 'user'@'localhost';
FLUSH PRIVILEGES;
```

### 2. 애플리케이션 설정 파일

프로젝트의 `application.properties` 파일을 설정합니다. 이 파일은 JAR 파일과 같은 디렉토리에 있어야 합니다.

```properties
# application.properties 파일 내용

# MySQL 설정
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/yucoordinator
spring.datasource.username=user
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

```

### 3. JAR 파일 생성

1. 인텔리제이에서 프로젝트를 엽니다.
2. `build.gradle` 파일을 열고 다음과 같은 플러그인이 포함되어 있는지 확인합니다.

```groovy
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.2.5'
    id 'io.spring.dependency-management' version '1.1.4'
}

group = 'project'
version = '0.0.1-SNAPSHOT'

java {
    sourceCompatibility = '21'
}

configurations {
    compileOnly {
        extendsFrom annotationProcessor
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'mysql:mysql-connector-java:8.0.32'
    implementation 'org.springframework.boot:spring-boot-starter-security'
    implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity6'
    compileOnly 'org.projectlombok:lombok'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testImplementation 'org.springframework.security:spring-security-test'
    implementation 'org.jsoup:jsoup:1.14.2'
    implementation 'org.springframework.boot:spring-boot-starter-validation'
}


```

3. 터미널(명령 프롬프트)을 열고 프로젝트 루트 디렉토리로 이동합니다.
4. 다음 명령어를 실행하여 JAR 파일을 생성합니다.

```bash
./gradlew clean build
```

5. `build/libs` 디렉토리 안에 `YU-coordinator-0.0.1-SNAPSHOT.jar` 파일이 생성됩니다.

### 4. JAR 파일 실행

1. 터미널(명령 프롬프트)을 열고 JAR 파일이 있는 디렉토리로 이동합니다.
2. 다음 명령어를 실행하여 애플리케이션을 시작합니다.

```bash
java -jar YU-coordinator-0.0.1-SNAPSHOT.jar
```

애플리케이션이 성공적으로 시작되면, 다음과 같은 메시지가 나타납니다:

```plaintext
Started YuCoordinatorApplication in 5.123 seconds (JVM running for 5.567)
```

### 5. 애플리케이션 접속

브라우저를 열고 다음 URL로 접속합니다:

```
http://localhost:8080
```
---

## ❗️ 주의사항
- JAR 파일이 실행되지 않음: JDK 21이 올바르게 설치되었는지 확인하고, 환경 변수 JAVA_HOME이 올바르게 설정되었는지 확인하세요.
- 베이스 연결 오류: application.properties 파일의 데이터베이스 설정이 올바른지 확인하세요. 특히, URL, 사용자 이름, 비밀번호가 정확한지 확인하세요.

---

> 이 프로젝트에 대해 궁금한 점이 있거나 기여를 원하시면, 언제든지 이슈를 남기거나 풀 리퀘스트를 보내주세요. 프로젝트에 대한 여러분의 관심과 기여를 환영합니다! 🚀