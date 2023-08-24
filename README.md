## 1. Simple Blog Web ERD

![blog_website_ERD.drawio.svg](README-IMG/blog_website_ERD.drawio.svg)


> 자세한 스키마 정보는 제가 작성한 DDL 을 보면서 참고하시기 바랍니다. ([링크 참고](src/main/resources/META-INF/sql/blog_web/blog_web_ddl.sql))


### 1-1. 도메인 한글명

USER: 사용자
BLOG: 블로그
MENU: 메뉴
POST: 게시물
COMMENT: 댓글
POST_TAG: "게시물 <-> 태그" 중간 테이블, N:N 관계 때문에 생성
TAG: 태그

<br><br>

### 1-2. 비즈니스 규칙

사용자(USER)
- 사용자는 가입만 하고, 블로그는 개설하지 않을 수도 있다.
- 사용자는 여러 개의 블로그를 개설할 수 있다.(최대 5개까지)
- 사용자는 자신이 생성한 블로그를 지울 수 있다.

<br>

블로그(BLOG)
- 블로그는 여러 메뉴를 갖을 수 있다.
- 블로그는 메뉴를 지울 수도 있다.
- 만약에 메뉴에 Level 이 2 depth 이상이고, parent 메뉴를 지우면, 하단의 메뉴도 모두 지워진다.

<br>

메뉴(MENU)
- 메뉴는 자식 메뉴를 갖을 수 있으며, 부모에서 자식 메뉴까지 더해서 총 3 depth 까지 사용이 가능하다.
- 메뉴는 생성 순서가 아닌, 사용자의 편의에 의해서 화면에 표출되는 순서를 지정할 수 있다.(menu_order 사용해서 정렬)

<br>

게시물(POST)
- 게시물 하나에 여러 댓글이 달릴 수 있다.
- 게시물 하나에 여러 태그를 생성할 수 있다.

<br>

댓글(COMMENT)
- 생략

<br>

태그(TAG)
- 생략

<br><br>
