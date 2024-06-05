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

>이 프로젝트에 대해 궁금한 점이 있거나 기여를 원하시면, 언제든지 이슈를 남기거나 풀 리퀘스트를 보내주세요. 
프로젝트에 대한 여러분의 관심과 기여를 환영합니다! 🚀