insert into jpa.users(user_id, nickname, email, phone_number, age)
values (1, 'CodingToastBread', 'dailycode@velog.io', '010-0000-0000', 24),
       (2, 'CodingChicken', 'jonLee@velog.io', '010-1111-1111', 28)
;

alter sequence jpa.users_id_seq restart with 3;

select * from jpa.users;

insert into jpa.blog(blog_id, blog_name, blog_create_date, user_id)
values (1, 'DailyLifeCoding Blog', '2022-10-10', 1),
       (2, 'ToastBread''s Hobby Blog', '2023-01-01', 1),
       (3, 'Jon''s Tech Blog', '2021-12-01', 2),
       (4, 'Jon''s Gaming Blog', '2020-11-20', 2);

alter sequence jpa.blog_id_seq restart with 5;

select * from jpa.blog;

insert into jpa.menu(menu_id, menu_name, menu_order, parent_menu_id, blog_id)
VALUES (1, 'programming', 0, null, 1),
       (2, 'C++', 0, 1, 1),
       (3, 'Python', 1, 1, 1),
       (4, 'Java', 2, 1, 1),
       (5, 'Computer Science', 1, null, 3),
       (6, 'Operating System', 0, 5, 3),
       (7, 'Computer Structure', 1, 5, 3);

alter sequence jpa.menu_id_seq restart with 8;

select * from jpa.menu;

insert into jpa.post(post_id, menu_id, subject, content, writer_id)
values (1, 2, 'What is C++?', 'C++ Content...', 1),
       (2, 3, 'What is Python?', 'Python Content...', 1),
       (3, 4, 'What is Java?', 'Java Content...', 1),
       (4, 6, 'Let''s Talk About Thread', 'Thread Bla Bla Bla', 2),
       (5, 6, 'Why Asynchronous Client Is Important?', 'Async Bla bla bla', 2),
       (6, 7, 'Why Do We Need To Learn Computer Science', 'Because...', 2);

alter sequence jpa.post_id_seq restart with 7;



