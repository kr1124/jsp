select * from tab;
purge recyclebin;

create table visit(
no number not null,
writer varchar2(20) not null,
memo varchar2(4000) not null,
regdate date not null,
constraint VISIT_PK primary key(no)
);

--시퀀스
create sequence visit_seq 
start with 1 
increment by 1 
nomaxvalue
nocache
nocycle;