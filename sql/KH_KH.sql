DROP TABLE TEST_MEMBER CASCADE CONSTRAINTS;
CREATE TABLE TEST_MEMBER(
 ID VARCHAR2(15 BYTE),
 PASSWD VARCHAR2(15 BYTE) NOT NULL,
 NAME VARCHAR2(20 BYTE) NOT NULL,
 EMAIL VARCHAR2(30 BYTE),
 CONSTRAINT PK_MEMBER PRIMARY KEY (ID)
);
INSERT ALL
INTO TEST_MEMBER VALUES('admin','admin', '관리자','admin@test.or.kr')
INTO TEST_MEMBER VALUES('user11','pass11','사용자1','user11@test.or.kr')
INTO TEST_MEMBER VALUES('user22','pass22','사용자2','user22@test.or.kr')
SELECT * FROM DUAL;
COMMIT;



INSERT INTO TEST_MEMBER VALUES('user3','user3','사용자3','user3@test.or.kr');
select * from test_member;
commit;

INSERT INTO TEST_MEMBER VALUES('user4','user4','사용자4','user4@test.or.kr');
select * from test_member;
INSERT INTO TEST_MEMBER VALUES('user5','user5','사용자5','user5@test.or.kr');
commit;

delete from test_member where id='user5';



-- 로그인 성공여부만 알아오기
select count(*) from test_member where id='user3' and passwd='user2';
-- 로그인 계정 정보도 알아오기 
select id, name, email from test_member where id='user3' and passwd='user2';

select passwd from test_member where id="user3";



CREATE TABLE BOARD (
BOARD_NUM NUMBER, -- 게시글 번호
BOARD_TITLE VARCHAR2(50), -- 게시글 제목
BOARD_WRITER VARCHAR2(15), -- 게시글 작성자
BOARD_CONTENT VARCHAR2(2000), -- 게시글 내용
BOARD_ORIGINAL_FILENAME VARCHAR2(100), -- 업로드한 원래 파일명
BOARD_RENAME_FILENAME VARCHAR2(100), -- 바뀐 파일명
BOARD_DATE DATE DEFAULT SYSDATE,-- 게시글 올린 날짜
BOARD_LEVEL NUMBER DEFAULT 0,-- 글레벨 : 원글 0, 원글의 답글 1, 답글의답글 2
BOARD_REF NUMBER, -- 원글일때는 자기번호, 답글일 때 참조하는 원글 번호
BOARD_REPLY_SEQ NUMBER DEFAULT 0, -- 답글의 순번
BOARD_READCOUNT NUMBER DEFAULT 0, -- 조회수
CONSTRAINT PK_BOARD PRIMARY KEY (BOARD_NUM),
CONSTRAINT FK_BOARD_WRITER FOREIGN KEY (BOARD_WRITER) REFERENCES TEST_MEMBER (ID) ON DELETE SET NULL,
CONSTRAINT FK_BOARD_REF FOREIGN KEY (BOARD_REF) REFERENCES BOARD (BOARD_NUM) ON DELETE CASCADE
);