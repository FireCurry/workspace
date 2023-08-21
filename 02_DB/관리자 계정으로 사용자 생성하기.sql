-- 한 줄 주석 Ctrl + /
/* 범위 주석 Ctrl + Shiht + / */

-- SQL 한 줄 실행 : Ctrl + Enter

-- 오라클 쌍따옴표의 의미 : 대문자/소문자를 구분하는 문자열

-- 예전 버전(11g 이전 버전) 오라클 구문 사용하기
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

CREATE USER a230724_kms_seok IDENTIFIED BY "01094292386";

GRANT CONNECT, RESOURCE, CREATE VIEW TO a230724_kms_seok;

ALTER USER a230724_kms_seok DEFAULT TABLESPACE "A230724"
QUOTA 20M ON "A230724";