set client_min_messages = warning; -- stop showing "already exists, skipping" message

create sequence if not exists jpa.member_seq /* start with 1 increment by 10*/;

create table if not exists jpa.member
(
    id          bigint       not null default nextval('jpa.member_seq'),
    name        varchar(255) not null,
    age         integer,
    signup_date date not null,
    role_type   varchar(255) not null check (role_type in ('USER', 'MANAGER', 'ADMIN')),
    constraint jpa_member_pk primary key (id)
);

set client_min_messages = notice;
