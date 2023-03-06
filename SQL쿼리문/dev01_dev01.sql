--이용자 테이블 생성
create table usersTable(
            usernum number NOT NULL
          , userid VARCHAR2(20)
          , username VARCHAR2(20)
          , email VARCHAR2(100)
          , password VARCHAR2(30)
          , create_at DATE DEFAULT SYSDATE
          , address VARCHAR2(1000)
          , CONSTRAINT PK_USERTABLE PRIMARY KEY (usernum)
);
--이용자 테이블 조회
select * from usersTable;

--이용자 추가(회원가입)
insert into USERSTABLE values(1, 'admin', '관리자', 'admin@example.com', 'admin', default, '주소입력란');