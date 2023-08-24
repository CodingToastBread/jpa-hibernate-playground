drop table if exists jpa.user cascade;
drop table if exists jpa.blog cascade;
drop table if exists jpa.menu cascade;
drop table if exists jpa.post cascade;

create table jpa.user(
    user_id bigint not null,
    email varchar(255) not null,
    phone_number varchar(30) not null,
    age smallint not null check ( age > 0 and age <= 140 ),
    constraint jpa_user_pk primary key (user_id)
);

comment on table jpa.user is '블로그_웹사이트_사용자_테이블';
comment on column jpa.user.user_id is '사용자_아이디';
comment on column jpa.user.email is '사용자_이메일';
comment on column jpa.user.phone_number is '사용자_전화번호';
comment on column jpa.user.age is '사용자_나이';

create table jpa.blog (
    blog_id bigint not null,
    blog_name varchar(255) not null,
    blog_create_date date not null default current_date,
    user_id bigint not null,
    constraint jpa_blog_pk primary key (blog_id),
    constraint jpa_blog_to_user_fk foreign key (user_id) references jpa.user(user_id)
);

comment on table jpa.blog is '블로그_테이블';
comment on column jpa.blog.blog_id is '블로그_식별_아이디';
comment on column jpa.blog.blog_name is '블로그_명칭';
comment on column jpa.blog.blog_create_date is '블로그_생성일자';
comment on column jpa.blog.user_id is '블로그_생성자_아이디';


create table jpa.menu (
    menu_id bigint not null,
    menu_name varchar(255) not null,
    menu_order smallint default 0,
    child_menu_id bigint not null,
    blog_id bigint not null,
    constraint jpa_menu_id primary key (menu_id),
    constraint jpa_menu_to_blog_fk foreign key (blog_id) references jpa.blog(blog_id),
    constraint jpa_self_join_fk foreign key (child_menu_id) references jpa.menu(menu_id)
);


comment on table jpa.menu is '메뉴_테이블';
comment on column jpa.menu.menu_id is '메뉴_아이디';
comment on column jpa.menu.menu_name is '메뉴_이름';
comment on column jpa.menu.menu_order is '메뉴_표출_순서';
comment on column jpa.menu.child_menu_id is '자식_메뉴_아이디';
comment on column jpa.menu.blog_id is '소속된_블로그_아이디';


create table jpa.post (
    post_id bigint not null,
    menu_id bigint not null,
    subject varchar(255) not null,
    content varchar (1000) not null,
    writer_id bigint not null,
    constraint jpa_post_pk primary key (post_id),
    constraint jpa_post_to_menu_fk foreign key (menu_id) references jpa.menu(menu_id)
);

comment on table jpa.post is '게시물_테이블';
comment on column jpa.post.post_id is '게시물_아이디';
comment on column jpa.post.menu_id is '소속_메뉴_아이디';
comment on column jpa.post.subject is '제목';
comment on column jpa.post.content is '내용';
comment on column jpa.post.writer_id is '작성자_아이디';

create table jpa.comment (
    comment_id bigint not null,
    post_id bigint not null,
    content varchar(500),
    writer_id bigint,
    constraint jpa_comment_pk primary key (comment_id),
    constraint jpa_comment_to_post_fk foreign key (post_id) references jpa.post(post_id)
);

comment on table jpa.comment is '댓글_테이블';
comment on column jpa.comment.comment_id is '댓글_아이디';
comment on column jpa.comment.post_id is '소속_게시물_아이디';
comment on column jpa.comment.content is '내용';
comment on column jpa.comment.writer_id is '작성자_아이디';


create table jpa.tag (
    tag_id bigint not null,
    tag_name varchar(255) not null,
    constraint jpa_tag_id primary key (tag_id)
);

comment on table jpa.tag is '태그_테이블';
comment on column jpa.tag.tag_id is '태그_아이디';
comment on column jpa.tag.tag_name is '태그_명칭';

create table jpa.post_tag (
    post_id bigint not null,
    tag_id bigint not null,
    constraint jpa_post_tag_middle_to_post_fk foreign key (post_id) references jpa.post(post_id),
    constraint jpa_post_tag_middle_to_tag_id_fk foreign key (tag_id) references jpa.tag(tag_id)
);

comment on table jpa.post_tag is '게시물_태그_중간_테이블';
comment on column jpa.post_tag.post_id is '게시물_아이디';
comment on column jpa.post_tag.tag_id is '태그_아이디';


SELECT * FROM JPA.USER;
SELECT * FROM JPA.BLOG;

