create table board (
	no	number(3)	primary key,
	title	varchar2(100),
	content	varchar2(500),
	author	varchar2(100),
	day		varchar2(20),
	readcount	number(3)
);

drop table board;

select no, title, content, author, day, readcount from BOARD;