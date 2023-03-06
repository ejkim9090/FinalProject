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







--게시글 테이블
CREATE TABLE POSTTABLE(
       POSTID NUMBER PRIMARY KEY NOT NULL
     , POSTNAME VARCHAR2(50 char) NOT NULL
     , userid VARCHAR2(20 char) NOT NULL                        
     , username VARCHAR2(20 char) NOT NULL			        
     , FOODNAME VARCHAR2(50 char) NOT NULL
     , NOWDATE TIMESTAMP DEFAULT(systimestamp) NOT NULL
     , CUISINE VARCHAR2(2000 char) NOT NULL
     , CONSTRAINT FK_USERID_POST FOREIGN KEY(userid) REFERENCES usersTable(userid)
);


--재료 테이블
CREATE TABLE INGTABLE(
     POSTID NUMBER
    , INGREDIENT VARCHAR2(30 char) NOT NULL
    , AMT VARCHAR2(30 char)
    , CONSTRAINT FK_PID_ING FOREIGN KEY(POSTID) REFERENCES POSTTABLE(POSTID)
    , CONSTRAINT PK_ING PRIMARY KEY(POSTID, INGREDIENT)
);


--이미지 테이블(수정필요)
CREATE TABLE IMGTABLE(
    IMGNAME VARCHAR2(50 char) NOT NULL
    , POSTID NUMBER NOT NULL
    , CONSTRAINT FK_PID_IMG FOREIGN KEY(POSTID) REFERENCES POSTTABLE(POSTID)
);


--해쉬태그 태이블
CREATE TABLE HTGTABLE(
    HASHTAG VARCHAR2(50 char) NOT NULL
    , POSTID NUMBER NOT NULL
    , CONSTRAINT FK_PID_HTG FOREIGN KEY(POSTID) REFERENCES POSTTABLE(POSTID)
    , CONSTRAINT PK_HTG PRIMARY KEY(HASHTAG, POSTID)
);



