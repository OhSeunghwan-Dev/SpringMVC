-- 시퀀스 객체 생성
create sequence bno_seq;
-- 시퀀스 삭제	( 필요시 사용 )
drop sequence bno_seq;

create table board(
	bno number(10, 0),
	title varchar2(200) not null,
	content	varchar2(2000) not null,
	writer varchar2(50) not null,
	regdate date default sysdate,
	updatedate date default sysdate
); -- board 테이블 생성

select * from board;

alter table board add constraint pk_board primary key (bno);	-- tbl_board 구조 변경 : 기본키를 bno로 지정

insert into board(bno, title, content, writer) values(bno_seq.nextval, '테스트제목1', '이 문구는 테스트용입니다1', 'user00');
insert into board(bno, title, content, writer) values(bno_seq.nextval, '테스트제목2', '이 문구는 테스트용입니다2', 'user00');
insert into board(bno, title, content, writer) values(bno_seq.nextval, '테스트제목3', '이 문구는 테스트용입니다3', 'user00');
insert into board(bno, title, content, writer) values(bno_seq.nextval, '테스트제목4', '이 문구는 테스트용입니다4', 'user00');
insert into board(bno, title, content, writer) values(bno_seq.nextval, '테스트제목5', '이 문구는 테스트용입니다5', 'user00');
insert into board(bno, title, content, writer) values(bno_seq.nextval, '테스트제목6', '이 문구는 테스트용입니다6', 'user00');
insert into board(bno, title, content, writer) values(bno_seq.nextval, '테스트제목7', '이 문구는 테스트용입니다7', 'user00');
insert into board(bno, title, content, writer) values(bno_seq.nextval, '테스트제목8', '이 문구는 테스트용입니다8', 'user00');
