create database jumblr;

use jumblr;

create table login(
	id VARCHAR(50) PRIMARY KEY, 
    name VARCHAR(50), 
    pass VARCHAR(50));

create table words(
	levelNo INT default 1, 
    word VARCHAR(100));

create table progress(
	id VARCHAR(50),
    levelNo INT default 1, 
    coins INT default 100, 
    FOREIGN KEY (id) REFERENCES login(id)); 

show tables;
-- drop database jumblr; 

desc login;
desc progress;

CREATE TRIGGER add_progress AFTER INSERT ON login
FOR EACH ROW
  INSERT INTO progress (id, levelNo, coins)
  VALUES (NEW.id, 1, 100);

-- CREATE TRIGGER delete_user after DELETE ON progress
-- FOR EACH ROW
-- 	DELETE FROM login
--     WHERE id = NEW.id;

-- INSERT INTO login VALUES ('testId','Test Name','test');

Select * from login;
Select * from progress;


SELECT levelNo FROM progress WHERE id = 'krth1k';

-- drop table words;

-- delete test users
DELETE FROM login WHERE id like 'test%';
DELETE FROM progress WHERE id like 'test%';

