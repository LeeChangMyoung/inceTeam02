
--delete from pmember where name = 'ㅇㅇㅇㅇㅇ';
select * from pmember;
create table pmember(
    no number primary key,
    id varchar2 (20 char),
    name varchar2 (10 char),
    pass varchar2 (20 char),
    email varchar2 (30 char),
    mobile varchar2 (15 char),
    zipcode varchar2 (10 char),
    addr1 varchar2 (70 char),
    addr2 varchar2 (40 char)
    );
drop table pmember; 
drop sequence pmember_seq;
CREATE SEQUENCE pmember_seq
MAXVALUE 9999999
      INCREMENT BY 1      
      NOCACHE
      NOORDER
      NOCYCLE;

insert into pmember values(pmember_seq.NEXTVAL,'geneis', '주민철', '1234', 'abcd@naver.com', '010-2034-9087',
    '43323', '경기 부천시 오정구 수주로 18', '미도아파트 1-305');
insert into pmember values(pmember_seq.NEXTVAL,'abcdef', '이창명', '1234', 'bbbb@naver.com', '010-6567-9522',
    '11123', '경기 인천시 송내구 1123 18', '동원아파트 103-301');
insert into pmember values(pmember_seq.NEXTVAL,'ojh123', '오주화', '1234', 'ojh123@daum.net', '010-6443-5343',
    '34556', '경기 세종시 세종구 가택로 18', '세종빌라 1-305');

commit;
select * from pmember;
    



    