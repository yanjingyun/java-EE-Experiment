CREATE TABLE user(
  id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(30),
  passwd varchar(30),
  PRIMARY KEY (id)
);

insert into user(username,passwd) values('admin', 'admin');
insert into user(username,passwd) values('aa', 'aa');


select * from user;