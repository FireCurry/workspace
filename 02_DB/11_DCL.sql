/* 계정(사용자)

* 관리자 계정 : 데이터베이스의 생성과 관리를 담당하는 계정.
                모든 권한과 책임을 가지는 계정.
                ex) sys(최고관리자), system(sys에서 권한 몇개 제외된 관리자)


* 사용자 계정 : 데이터베이스에 대하여 질의, 갱신, 보고서 작성 등의
                작업을 수행할 수 있는 계정으로
                업무에 필요한 최소한의 권한만을 가지는 것을 원칙으로 한다.
                ex) bdh계정(각자 이니셜 계정), updown, workbook 등
*/

/* DCL(Data Control Language) : 계정에 DB, DB객체에 대한 접근 권한을 부여하고 회수하는 언어

- GRANT : 권한 부여
- REVOKE : 권한 회수

* 권한의 종류

1) 시스템 권한 : DB접속, 객체 생성 권한

CREATE SESSION   : 데이터베이스 접속 권한
CREATE TABLE     : 테이블 생성 권한
CREATE VIEW      : 뷰 생성 권한
CREATE SEQUENCE  : 시퀀스 생성 권한
CREATE PROCEDURE : 함수(프로시져) 생성 권한
CREATE USER      : 사용자(계정) 생성 권한
DROP USER        : 사용자(계정) 삭제 권한
DROP ANY TABLE   : 임의 테이블 삭제 권한


2) 객체 권한 : 특정 객체를 조작할 수 있는 권한

  권한 종류                 설정 객체
    SELECT              TABLE, VIEW, SEQUENCE
    INSERT              TABLE, VIEW
    UPDATE              TABLE, VIEW
    DELETE              TABLE, VIEW
    ALTER               TABLE, SEQUENCE
    REFERENCES          TABLE
    INDEX               TABLE
    EXECUTE             PROCEDURE

*/

----------------- [관리자 계정] -----------------

-- SESSION : 서버에 사용자 접속했을 경우 생성되는 객체
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
--> 오라클 SQL을 예전 방식으로 쉽게 작성하도록 하겠다
--> 관리자 계정 접속할 때 마다 수행

-- 계정 생성
CREATE USER a230830_kms_seok IDENTIFIED BY "123456789";
--> 생성 후 DB 접속 방법 추가
-- ORA-01045: 사용자 A230830_KMS_SEOK는 CREATE SESSION 권한을 가지고있지 않음; 로그온이 거절되었습니다
---> 접속 권한 없음

/* 접속 권한 부여(GRANT) */
GRANT CREATE SESSION TO a230830_kms_seok;

------------- [테스트 사용자 계정] -------------
-- 테이블 생성
CREATE TABLE TB_MEMBER(
	MEMBER_NO NUMBER PRIMARY KEY,
	MEMBER_ID VARCHAR2(30) NOT NULL,
	MEMBER_PW VARCHAR2(30) NOT NULL
);
-- ORA-01031: 권한이 불충분합니다
--> 테이블 생성 권한(CREATE TABLE)이 없어서 생성 불가
--> + TABLESPACE(테이블 생성 공간(용량))도 없어서 생성 불가

----------------- [관리자 계정] -----------------
-- 테이블 생성 권한, TABLESPACE 할당
GRANT CREATE TABLE TO a230830_kms_seok;

ALTER USER a230830_kms_seok DEFAULT TABLESPACE "A230724"
QUOTA 10M ON "A230724";

------------- [테스트 사용자 계정] -------------
CREATE TABLE TB_MEMBER(
	MEMBER_NO NUMBER PRIMARY KEY,
	MEMBER_ID VARCHAR2(30) NOT NULL,
	MEMBER_PW VARCHAR2(30) NOT NULL
);

SELECT * FROM TB_MEMBER;
-------------------------------------------------
----------------- [관리자 계정] -----------------
/* ROLE(역할 == 권한의 묶음, 권한명 단순화)
 * 
 * CONNECT : DB 접속 권한 (CREATE SESSION)
 * RESOURCE : DB 기본 객체 8개 생성 권한
 *  */

-- SYS 계정으로 ROLE 확인하기
SELECT * FROM ROLE_SYS_PRIVS
WHERE ROLE = 'RESOURCE';

-- 테스트 사용자 계정에 접속, 기본 객체 8개, VIEW 생성 권한 부여하기
GRANT CONNECT, RESOURCE, CREATE VIEW TO a230830_kms_seok;

--------------------------------------------------------
------------- [테스트 사용자 계정] -------------
-- 객체 권한 

SELECT * FROM TB_MEMBER;

COMMIT;

INSERT INTO TB_MEMBER
VALUES(182, 'MIN_SEOK', '123456789');

-- A230830_BDH
GRANT SELECT, INSERT ON TB_MEMBER TO A230830_BDH;

-- 다른 계정의 TB_MEMBER 테이블 조회

SELECT * FROM A230830_BDH.TB_MEMBER;

INSERT INTO A230830_BDH.TB_MEMBER
VALUES(777, 'INSERT_TEST', '123456789');

COMMIT;

-- 권한 회수
REVOKE SELECT, INSERT ON TB_MEMBER FROM A230830_BDH;

-- 권한 회수 확인
SELECT * FROM A230830_BDH.TB_MEMBER;


