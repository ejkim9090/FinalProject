--이용자 테이블 삭제
drop table usersTable;

--이용자 테이블 생성
create table usersTable(
            usernum number NOT NULL
          , userid VARCHAR2(20)
          , username VARCHAR2(20)
          , usernickname VARCHAR2(45) unique
          , email VARCHAR2(100)
          , password VARCHAR2(30)
          , create_at DATE DEFAULT SYSDATE
          , address VARCHAR2(1000)
          , CONSTRAINT PK_USERTABLE PRIMARY KEY (userid)
);
--이용자 테이블 조회
select * from usersTable;

--이용자 추가(회원가입)
select NVL(max(userid), 0)+1 from USERSTABLE;
insert into USERSTABLE values((select NVL(max(usernum), 0)+1 from USERSTABLE)
        , 'admin', '관리자', '모두의레시피관리자', 'admin@example.com', 'admin', default, '주소입력란');

insert into USERSTABLE values((select NVL(max(usernum), 0)+1 from USERSTABLE)
        , '&userid', '&name', '&nickname', '&email', '&password', default, '&address');

--회원탈퇴
delete from USERSTABLE where userid='user1';

--회원정보 수정
update USERSTABLE set username='사용자11', USERNICKNAME='이용자11', EMAIL='user11@example.com'
                    , password = 'user11', address='서울시 강남구 학동' where userid='user1';

update USERSTABLE set username='&name', USERNICKNAME='&nickname', EMAIL='&email'
                    , password = '&password', address='&address' where userid='&userid';

