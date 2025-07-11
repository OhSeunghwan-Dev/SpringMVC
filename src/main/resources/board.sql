-- 시퀀스 객체 생성
create sequence seq_board;
-- 시퀀스 삭제	( 필요시 사용 )
drop sequence seq_board;

create table tbl_board(
	bno number(10, 0),
	title varchar2(200) not null,
	content	varchar2(2000) not null,
	writer varchar2(50) not null,
	regdate date default sysdate,
	updatedate date default sysdate
); -- board 테이블 생성

select * from tbl_board;

alter table tbl_board add constraint pk_board primary key (bno);	-- tbl_board 구조 변경 : 기본키를 bno로 지정

-- 더미데이터 입력하기
insert into tbl_board(bno, title, content, writer) values(seq_board.nextval, '테스트제목1', '이 문구는 테스트용입니다1', 'user00');
insert into tbl_board(bno, title, content, writer) values(seq_board.nextval, '테스트제목2', '이 문구는 테스트용입니다2', 'user00');
insert into tbl_board(bno, title, content, writer) values(seq_board.nextval, '테스트제목3', '이 문구는 테스트용입니다3', 'user00');
insert into tbl_board(bno, title, content, writer) values(seq_board.nextval, '테스트제목4', '이 문구는 테스트용입니다4', 'user00');
insert into tbl_board(bno, title, content, writer) values(seq_board.nextval, '테스트제목5', '이 문구는 테스트용입니다5', 'user00');
insert into tbl_board(bno, title, content, writer) values(seq_board.nextval, '테스트제목6', '이 문구는 테스트용입니다6', 'user00');
insert into tbl_board(bno, title, content, writer) values(seq_board.nextval, '테스트제목7', '이 문구는 테스트용입니다7', 'user00');
insert into tbl_board(bno, title, content, writer) values(seq_board.nextval, '테스트제목8', '이 문구는 테스트용입니다8', 'user00');
