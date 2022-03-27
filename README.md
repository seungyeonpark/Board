# Board

## 사용 기술
- Java 11
- Spring Boot 2.6.4
- Spring Web
- Mybatis
- MySQL
- Thymeleaf

## CRUD
- 게시판 create, read, update, delete
### Validation
- 게시글 등록시 사용자 입력값 유효성 검증
### Paging
- 게시글 목록 조회시 페이징 지원
### Searching
- 제목/내용/글쓴이로 구분하여 사용자가 입력한 키워드로 검색 기능 지원
### File upload
- 파일 업로드 지원

## User
- 회원 가입
- 로그인
- 사용자 입력값 유효성 검증
- 인터셉터를 이용한 인증 체크

## Message
- 메시지 프로퍼티 파일로부터 메시지 내용 읽어와서 적용