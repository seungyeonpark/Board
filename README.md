# Board
📑 게시판 프로젝트

## 1. 사용 기술
- Java 11
- Spring Boot 2.6.4
- Gradle
- Spring Web
- Mybatis
- MySQL 8.0.27
- Thymeleaf

<br/>

## 2. ERD
![erd](/src/main/resources/img/board_erd.png)

<br/>

## 3. 핵심 기능
### CRUD
- 게시글 생성, 읽기, 수정, 삭제
### Paging
- 게시글 목록 조회시 페이징 지원
### Searching
- 제목/내용/글쓴이로 구분하여 사용자가 입력한 키워드로 검색 기능 지원
### File upload
- 파일 업로드 지원
### Login
- 세션 기반 로그인
- 인터셉터를 이용한 인증 체크
### Validation
- 게시글 등록시 사용자 입력값 유효성 검증
- 회원가입, 로그인시 사용자 입력값 유효성 검증
### Message
- 메시지 프로퍼티 파일로부터 메시지 내용 읽어와서 적용

<br/>

## 4. 트러블 슈팅
✔ [@ModelAttribute 바인딩 문제](https://siaayeon.tistory.com/19) <br/>
✔ [리다이렉션 관련 이슈](https://siaayeon.tistory.com/20) <br/>
✔ [db 정보 숨기기](https://siaayeon.tistory.com/21) <br/>
