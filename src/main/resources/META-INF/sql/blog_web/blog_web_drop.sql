set client_min_messages = warning;

drop sequence if exists blog.users_id_seq cascade;

drop sequence if exists blog.blog_id_seq cascade;

drop sequence if exists blog.menu_id_seq cascade;

drop sequence if exists blog.post_id_seq cascade;

drop sequence if exists blog.comment_id_seq cascade;

drop sequence if exists blog.tag_id_seq cascade;

drop sequence if exists blog.post_tag_id_seq cascade;

drop table if exists blog.comment cascade;

drop table if exists blog.post_tag cascade;

drop table if exists blog.post cascade;

drop table if exists blog.menu cascade;

drop table if exists blog.blog cascade;

drop table if exists blog.users cascade;

drop table if exists blog.tag cascade;

set client_min_messages = default;
