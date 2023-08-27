set client_min_messages = warning;

create schema if not exists blog;
comment on schema blog is '블로그 사이트를 위한 스키마';

create sequence if not exists blog.users_id_seq;
create sequence if not exists blog.blog_id_seq;
create sequence if not exists blog.menu_id_seq;
create sequence if not exists blog.post_id_seq;
create sequence if not exists blog.comment_id_seq;
create sequence if not exists blog.tag_id_seq;
create sequence if not exists blog.post_tag_id_seq;

comment on sequence blog.users_id_seq is '사용자_테이블_시퀀스';
comment on sequence blog.blog_id_seq is '블로그_테이블_시퀀스';
comment on sequence blog.menu_id_seq is '메뉴_테이블_시퀀스';
comment on sequence blog.post_id_seq is '게시물_테이블_시퀀스';
comment on sequence blog.comment_id_seq is '댓글_테이블_시퀀스';
comment on sequence blog.tag_id_seq is '태그_테이블_시퀀스';
comment on sequence blog.post_tag_id_seq is '게시물_테그_테이블_시퀀스';

create table if not exists blog.users (
    user_id bigint not null default nextval('blog.users_id_seq'),
    nickname varchar(255) not null,
    email varchar(255) not null,
    phone_number varchar(30) not null,
    age smallint not null check ( age > 0 and age <= 140 ),
    constraint blog_user_pk primary key (user_id),
    constraint users_nick_name_unique unique (nickname)
);

comment on table blog.users is '블로그_웹사이트_사용자_테이블';
comment on column blog.users.user_id is '사용자_아이디';
comment on column blog.users.nickname is '사용자_닉네임';
comment on column blog.users.email is '사용자_이메일';
comment on column blog.users.phone_number is '사용자_전화번호';
comment on column blog.users.age is '사용자_나이';

create table if not exists blog.blog (
    blog_id bigint not null default nextval('blog.blog_id_seq'),
    user_id bigint not null,
    blog_name varchar(255) not null,
    blog_create_date date not null default current_date,
    constraint blog_blog_pk primary key (blog_id),
    constraint blog_blog_to_user_fk foreign key (user_id) references blog.users(user_id)
);

comment on table blog.blog is '블로그_테이블';
comment on column blog.blog.blog_id is '블로그_식별_아이디';
comment on column blog.blog.blog_name is '블로그_명칭';
comment on column blog.blog.blog_create_date is '블로그_생성일자';
comment on column blog.blog.user_id is '블로그_생성자_아이디';


create table if not exists blog.menu (
    menu_id bigint not null default nextval('blog.menu_id_seq'),
    blog_id bigint not null,
    menu_name varchar(255) not null,
    menu_order smallint default 0,
    parent_menu_id bigint,
    constraint blog_menu_id primary key (menu_id),
    constraint blog_menu_name_unique unique (menu_name),
    constraint blog_menu_to_blog_fk foreign key (blog_id) references blog.blog(blog_id),
    constraint blog_self_join_fk foreign key (parent_menu_id) references blog.menu(menu_id)
);


comment on table blog.menu is '메뉴_테이블';
comment on column blog.menu.menu_id is '메뉴_아이디';
comment on column blog.menu.menu_name is '메뉴_이름';
comment on column blog.menu.menu_order is '메뉴_표출_순서';
comment on column blog.menu.parent_menu_id is '자식_메뉴_아이디';
comment on column blog.menu.blog_id is '소속된_블로그_아이디';


create table if not exists blog.post (
    post_id bigint not null default nextval('blog.post_id_seq'),
    menu_id bigint not null,
    subject varchar(255) not null,
    content varchar (1000) not null,
    writer_id bigint not null,
    constraint blog_post_pk primary key (post_id),
    constraint blog_post_to_menu_fk foreign key (menu_id) references blog.menu(menu_id)
);

comment on table blog.post is '게시물_테이블';
comment on column blog.post.post_id is '게시물_아이디';
comment on column blog.post.menu_id is '소속_메뉴_아이디';
comment on column blog.post.subject is '제목';
comment on column blog.post.content is '내용';
comment on column blog.post.writer_id is '작성자_아이디';

create table if not exists blog.comment (
    comment_id bigint not null default nextval('blog.comment_id_seq'),
    post_id bigint not null,
    content varchar(500) not null,
    writer_id bigint not null,
    constraint blog_comment_pk primary key (comment_id),
    constraint blog_comment_to_post_fk foreign key (post_id) references blog.post(post_id)
);

comment on table blog.comment is '댓글_테이블';
comment on column blog.comment.comment_id is '댓글_아이디';
comment on column blog.comment.post_id is '소속_게시물_아이디';
comment on column blog.comment.content is '내용';
comment on column blog.comment.writer_id is '작성자_아이디';


create table if not exists blog.tag (
    tag_id bigint not null default nextval('blog.tag_id_seq'),
    tag_name varchar(255) not null,
    constraint blog_tag_id primary key (tag_id)
);

comment on table blog.tag is '태그_테이블';
comment on column blog.tag.tag_id is '태그_아이디';
comment on column blog.tag.tag_name is '태그_명칭';

create table if not exists blog.post_tag (
    post_tag_id bigint  default nextval('blog.post_tag_id_seq') not null,
    post_id bigint not null,
    tag_id bigint not null,
    constraint blog_post_tag_middle_to_post_fk foreign key (post_id) references blog.post(post_id),
    constraint blog_post_tag_middle_to_tag_id_fk foreign key (tag_id) references blog.tag(tag_id)
);

comment on table blog.post_tag is '게시물_태그_중간_테이블';
comment on column blog.post_tag.post_id is '게시물_아이디';
comment on column blog.post_tag.tag_id is '태그_아이디';

set client_min_messages = default;
