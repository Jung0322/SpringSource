create table spring_board(
	bno number(10,0),                  -- �۹�ȣ
	title varchar2(200) not null,	   -- ����
	content varchar2(200) not null,	   -- ����
	writer varchar2(50) not null,	   -- �ۼ���
	regdate date default sysdate, 	   -- �ۼ���¥
	updatedate date default sysdate	   -- ������¥
);

alter table spring_board add constraint pk_spring_board primary key(bno);

create sequence seq_board;

select * from SPRING_BOARD;

delete from spring_board where bno = 2;