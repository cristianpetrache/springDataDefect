insert into user (user_id, name) values ('user1', 'user 1');

insert into language (language_id, description) values ('lang1', 'language 1');
insert into language (language_id, description) values ('lang2', 'language 2');


insert into contact (user_id, type, description) values ('user1', 'type 1', 'description 1');
insert into contact (user_id, type, description) values ('user1', 'type 2', 'description 2');
insert into contact (user_id, type, description) values ('user1', 'type 3', 'description 3');


insert into user_languages (user_id, language_id, language_order) values ('user1', 'lang1', 1);
insert into user_languages (user_id, language_id, language_order) values ('user1', 'lang2', 2);
