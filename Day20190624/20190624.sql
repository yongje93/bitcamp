CREATE TABLE student(
	no number(3)	primary key,
	age varchar2(100),
	name varchar2(100),
	hakbun varchar2(100)
);

INSERT INTO student(no, age, name, hakbun) VALUES(1, '23', 'ȫ�浿', '2019');

SELECT * FROM student;

CREATE TABLE professor (
	no number(3)	primary key,
	age varchar2(100),
	name varchar2(100),
	subject varchar2(100)
);

INSERT INTO professor(no, age, name, subject) VALUES(1,'56','�豳��','�ڹ�');

SELECT * FROM professor;

CREATE TABLE manager(
	no number(3)	primary key,
	age varchar2(100),
	name varchar2(100),
	part varchar2(100)
);

INSERT INTO manager(no, age, name, part) VALUES(1, '67', '�����', '���ߺ�');

SELECT * FROM manager;

