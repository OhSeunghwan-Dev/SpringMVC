create user book_ex identified by book_ex
default tablespace users temporary tablespace temp;

grant connect, dba to book_ex;

select dbms_xdb.gethttpport() from dual;	-- 오라클 포트 확인
exec dbms_xdb.sethttpport(9999);	-- cmd에서 실행하기

drop user book_ex cascade;