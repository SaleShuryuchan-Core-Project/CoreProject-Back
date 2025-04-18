-- Member에 대한 테이블 생성!
create table Member(
	email varchar(100) not null,
	pw varchar(50) not null,
	tel varchar(50) not null,
	address varchar(100) not null,
	primary key(email)
);

select * from Member;

-- Board 게시판 생성 --
create table Board(
	num int not null auto_increment,
	title varchar(100) not null,
	writer varchar(100) not null,
	filename varchar(100),
	content varchar(300) not null,
	b_date datetime default now(),
	primary key(num)
);

select * from Board;