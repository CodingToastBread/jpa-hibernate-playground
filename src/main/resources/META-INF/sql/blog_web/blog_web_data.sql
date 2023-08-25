insert into blog.users(user_id, nickname, email, phone_number, age)
values (1, 'CodingToastBread', 'dailycode@velog.io', '010-0000-0000', 24),
       (2, 'CodingChicken', 'jonLee@velog.io', '010-1111-1111', 28)
;

alter sequence blog.users_id_seq restart with 3;

select * from blog.users;

insert into blog.blog(blog_id, blog_name, blog_create_date, user_id)
values (1, 'DailyLifeCoding Blog', '2022-10-10', 1),
       (2, 'ToastBread''s Hobby Blog', '2023-01-01', 1),
       (3, 'Jon''s Tech Blog', '2021-12-01', 2),
       (4, 'Jon''s Gaming Blog', '2020-11-20', 2);

alter sequence blog.blog_id_seq restart with 5;

select * from blog.blog;

insert into blog.menu(menu_id, menu_name, menu_order, parent_menu_id, blog_id)
VALUES (1, 'programming', 0, null, 1),
       (2, 'C++', 0, 1, 1),
       (3, 'Python', 1, 1, 1),
       (4, 'Java', 2, 1, 1),
       (5, 'Computer Science', 1, null, 3),
       (6, 'Operating System', 0, 5, 3),
       (7, 'Computer Structure', 1, 5, 3);

alter sequence blog.menu_id_seq restart with 8;

select * from blog.menu;

insert into blog.post(post_id, menu_id, subject, content, writer_id)
values (1, 2, 'What is C++?', 'C++ Content...', 1),
       (2, 3, 'What is Python?', 'Python Content...', 1),
       (3, 4, 'What is Java?', 'Java Content...', 1),
       (4, 6, 'Let''s Talk About Thread', 'Thread Bla Bla Bla', 2),
       (5, 6, 'Why Asynchronous Client Is Important?', 'Async Bla bla bla', 2),
       (6, 7, 'Why Do We Need To Learn Computer Science', 'Because...', 2);

alter sequence blog.post_id_seq restart with 7;

insert into blog.tag(tag_id, tag_name)
values (1, 'Programming'),
       (2, 'CS');

alter sequence blog.tag_id_seq restart with 3;

insert into blog.post_tag(post_id, tag_id)
values (1, 1),
       (2, 1),
       (3, 1),
       (4, 2),
       (5, 2),
       (6, 2);


insert into blog.comment (comment_id, post_id, content, writer_id)
values (1, 1, 'C++ Reply...1', 2),
       (2, 1, 'C++ Reply...2', 2),
       (3, 2, 'Python Reply...1', 2),
       (4, 2, 'Python Reply...2', 2),
       (5, 3, 'Java Reply...1', 2),
       (6, 3, 'Java Reply...2', 2);

insert into blog.comment (comment_id, post_id, content, writer_id)
values (7, 4, 'About Thread Reply...1', 2),
       (8, 4, 'About Thread Reply...2', 2),
       (9, 4, 'About Thread Reply...3', 2),
       (10, 5, 'Why Async - Reply...1', 2),
       (11, 5, 'Why Async - Reply...1', 2),
       (12, 6, 'CS Reply...1', 2);

alter sequence blog.comment_id_seq restart with 13;
