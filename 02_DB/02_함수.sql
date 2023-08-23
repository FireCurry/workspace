-- 함수 : 컬럼값 | 지정된 값을 읽어 연산한 결과를 반환하는 것

-- 단일 행 함수 : N개의 행의 컬럼 값을 전달하여 N개의 결과가 반환

-- 그룹 함수 : N개의 행의 컬럼 값을 전달하여 1개의 결과가 반환
--				(그룹의 수가 늘어나면 그룹의 수 만큼 결과를 반환)

-- 함수는 SELECT절, WHERE절, ORDER BY절
--		GROUP BY절, HAVING절에서 사용 가능

/******************************** 단일 행 함수 ********************************/

-- <문자열 관련 함수>

-- LENGTH(문자열 | 컬럼명) : 문자열의 길이 반환
SELECT 'HELLO WORLD', LENGTH('HELLO WORLD') FROM DUAL;

-- EMPLOYEE 테이블에서
-- 사원명, 이메일, 이메일 길이 조회
-- 단, 이메일 길이가 12 이하인 행만 조회
-- 이메일 길이 오름차순 조회
/* 3 */SELECT EMP_NAME "사원명", EMAIL "이메일", LENGTH(EMAIL) "이메일 길이"
/* 1 */FROM EMPLOYEE
/* 2 */WHERE LENGTH(EMAIL) <= 12
/* 4 */ORDER BY "이메일 길이" /*LENGTH(EMAIL)*/;

--------------------------------------------------------------------------------

-- INSTR(문자열 | 컬럼명, '찾을 문자열' [, 찾을 시작 위치 [, 순번]])
-- 찾을 시작 위치부터 지정된 순번째 찾은 문자열의 시작 위치를 반환

-- 문자열에서 맨 앞에 있는 'B'의 위치를 조회
SELECT 'AABAACAABBAA', INSTR('AABAACAABBAA', 'B')
FROM DUAL; -- 3

-- 문자열 검색을 5번부터 시작해서 처음 나오는 'B'의 위치를 조회
SELECT 'AABAACAABBAA', INSTR('AABAACAABBAA', 'B', 5) "B의 위치"
FROM DUAL; -- 9

-- 문자열 검색을 5번부터 시작해서 두 번째 나오는 'B'의 위치를 조회
SELECT 'AABAACAABBAA', INSTR('AABAACAABBAA', 'B', 5, 2) "B의 위치"
FROM DUAL; -- 10

--------------------------------------------------------------------------------

-- SUBSTR(문자열 | 컬럼명, 시작위치 [, 길이])
-- 문자열을 시작 위치부터 지정된 길이 만큼 잘라내서 반환
-- 길이 미작성 시 시작 위치부터 끝까지 잘라내서 반환
SELECT SUBSTR('ABCDEFG', 3, 3) FROM DUAL; -- CDE
SELECT SUBSTR('ABCDEFG', 3) FROM DUAL; -- CDEFG

-- EMPLOYEE 테이블에서
-- 사원명, 이메일 아이디 (@ 앞에까지 문자열)을
-- 이메일 아이디 오름차순 조회
SELECT EMP_NAME, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@') - 1) "아이디"
FROM EMPLOYEE e 
ORDER BY 아이디;

--------------------------------------------------------------------------------

-- TRIM([ [옵션] 문자열 | 컬럼명 FROM ] 문자열 | 컬럼명)
-- 주어진 문자열의 앞쪽|뒤쪽|양쪽에 존재하는 지정된 문자열을 제거

-- 옵션 : LEADING(앞쪽), TRAILING(뒤쪽), BOTH(양쪽, 기본값)

-- 문자열 공백 제거
SELECT '   K   H   ',
	TRIM(LEADING ' ' FROM '   K   H   '),
	TRIM(TRAILING ' ' FROM '   K   H   '),
	TRIM(BOTH ' ' FROM '   K   H   ')
FROM DUAL;

SELECT '###K   H###',
	TRIM(LEADING '#' FROM '###K   H###'),
	TRIM(TRAILING '#' FROM '###K   H###'),
	TRIM(BOTH '#' FROM '###K   H###')
FROM DUAL;

-------------------------------------------------------------------------------

-- REPLACE(문자열 | 컬럼명, 찾을 문자열, 바꿀 문자열)
SELECT REPLACE(NATIONAL_NAME, '한국', '대한민국')
FROM NATIONAL;

-------------------------------------------------------------------------------
-------------------------------------------------------------------------------

-- <숫자 관련 함수>

-- MOD(숫자 | 컬럼명, 나눌 값) : 나머지 
SELECT MOD(105, 100) FROM DUAL;

-- ABS(숫자 | 컬럼명) : 절대값
SELECT ABS(10), ABS(-10) FROM DUAL;

-- CEIL(숫자 | 컬럼명) : 올림
-- FLOOR(숫자 | 컬럼명) : 내림
SELECT 1.1, CEIL(1.1), FLOOR(1.1) FROM DUAL;

-- ROUND(숫자 | 컬럼명 [, 소수점 위치]) : 반올림
-- 소수점 위치 지정 X : 소수점 첫 째 자리에서 반올림 -> 정수 표현
-- 소수점 위치 지정 O
 -- 1) 양수 : 지정된 위치의 소수점 자리까지 표현
 -- 2) 음수 : 지정된 위치의 정수 자리까지 표현
SELECT 123.456,
	ROUND(123.456), -- 123
	ROUND(123.456, 1), -- 123.5
	ROUND(123.456, 2), -- 123.46
	ROUND(123.456, -1) -- 120
FROM DUAL;

------------------------------------------------------------------------------

-- TRUNC(숫자 | 컬럼명 [, 소수점 위치]) : 버림(잘라내기)
SELECT -123.5,
	TRUNC(-123.5), -- -123 (.5 버림)
	FLOOR(-123.5), -- -124 (.5 내림)
	TRUNC(2.5), FLOOR(2.5), -- 2
	TRUNC(-123.5)
FROM DUAL;

------------------------------------------------------------------------------
-- <날짜 관련 함수>

-- SYSDATE : 현재 시간
-- SYSTIMESTAMP : 현재 시간 (ms 포함, 표준시간대)
SELECT SYSDATE, SYSTIMESTAMP FROM DUAL;

-- MONTH_BETWEEN(날짜, 날짜) : 두 날짜 사이의 개월 수를 반환
SELECT MONTHS_BETWEEN('2023-12-26', SYSDATE) FROM DUAL;

-- EMPLOYEE 테이블에서
-- 모든 사원의 사번, 이름, 입사일, N년차
SELECT EMP_ID, EMP_NAME, HIRE_DATE,
	CEIL( MONTHS_BETWEEN(SYSDATE, HIRE_DATE)/12) "N년차"
FROM EMPLOYEE e ;

-- 날짜 + 숫자 : 일 단위로 연산 (윤년 계산이 안 됨)
-- MONTHS_BETWEEN() : 윤년 계산이 알아서 포함되어 있음

-- ADD_MONTHS(날짜, 숫자) : 날짜를 숫자만큼의 개월 수를 더하여 반환
SELECT ADD_MONTHS(SYSDATE, -1), SYSDATE, ADD_MONTHS(SYSDATE, 1) FROM DUAL;

-- LAST_DAY(날짜) : 해당 월의 마지막 날짜를 반환
SELECT LAST_DAY(SYSDATE) FROM DUAL;

SELECT LAST_DAY(ADD_MONTHS(SYSDATE, -1)) + 1 "시작일",
	LAST_DAY(SYSDATE) "종료일"
FROM DUAL;

-- EXTRACT(YEAR | MONTH | DAY FROM 날짜)
-- 지정된 날짜의 년 | 월 | 일을 추출하여 정수로 반환
SELECT EXTRACT(YEAR FROM SYSDATE) || '년',
	EXTRACT(MONTH FROM SYSDATE) || '월',
	EXTRACT(DAY FROM SYSDATE) || '일'
FROM DUAL;

-- EMPLOYEE 테이블에서 2000년도에 입사한 사원의
-- 사번, 이름, 입사일을 이름 오름차순으로 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE e 
WHERE EXTRACT(YEAR FROM HIRE_DATE) = 2000
ORDER BY EMP_NAME;

-----------------------------------------------------------------------------

-- <형변환(Parsing) 함수>

-- 문자열(CHAR, VARCHAR2) <-> 숫자(NUMBER)
-- 문자열(CHAR, VARCHAR2) <-> 날짜(DATE)
-- 숫자(NUMBER) <-> 날짜(DATE)

/* TO_CHAR(날짜 | 숫자 [, 포맷]) : 문자열로 변환
 * 
 * 숫자 -> 문자열
 * 포맷 
 * 1) 9 : 숫자 한 칸을 의미, 오른쪽 정렬
 * 2) 0 : 숫자 한 칸을 의미, 오른쪽 정렬, 빈 칸에 0을 추가
 * 3) L : 현재 시스템이나 DB에 설정된 나라의 화폐 기호
 * 4) , : 숫자의 자릿수 구분
 * */

SELECT 1234, TO_CHAR(1234) FROM DUAL;

-- 9 : 숫자 한 칸을 의미, 오른쪽 정렬 (빈칸은 띄어쓰기)
SELECT 1234, TO_CHAR(1234, '999999999') FROM DUAL;

-- 0 : 숫자 한 칸을 의미, 오른쪽 정렬, 빈 칸에 0을 추가
SELECT 1234, TO_CHAR(1234, '000000000') FROM DUAL;

--> 숫자의 칸 수보다 패턴의 칸 수가 작을 때
--> 값이 제대로 표현될 수 없어서 ####이 반환됨
SELECT 123456789, TO_CHAR(123456789, '000') FROM DUAL;

-- 화폐기호 + 자릿수 구분
SELECT TO_CHAR(1234567),
		TO_CHAR(1234567, 'L9999999'),
		TO_CHAR(1234567, 'L9,999,999'),
		TO_CHAR(1234567, '$9,999,999')
FROM DUAL;

-- EMPLOYEE 테이블에서
-- 사번, 이름, 연봉 조회(W100,000,000 형식)
SELECT EMP_ID, EMP_NAME, TO_CHAR(SALARY * 12, 'L999,999,999') 연봉
FROM EMPLOYEE;

-------------------------------------------------------------------

/* 날짜 -> 문자열
 * YY    : 년도(짧게) EX) 23
 * YYYY  : 년도(길게) EX) 2023
 * 
 * RR    : 년도(짧게) EX) 23
 * RRRR  : 년도(길게) EX) 2023
 * 
 * MM : 월
 * DD : 일
 * 
 * AM/PM : 오전/오후
 * 
 * HH   : 시간 (12시간)
 * HH24 : 시간 (24시간)
 * MI   : 분
 * SS   : 초
 * 
 * DAY : 요일(전체) EX) 월요일, MONDAY
 * DY  : 요일(짧게) EX) 월, MON
 * */

-- 2023/08/22
SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD') FROM DUAL;

-- 2023-08-22 화요일
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD DAY') FROM DUAL;

-- 20230822 14:32:27 (화)
SELECT TO_CHAR(SYSDATE, 'YYYYMMDD HH24:MI:SS (DY)') FROM DUAL;

-- 2023년 08월 22일 화요일 오후 2시 35분 45초
SELECT TO_CHAR(SYSDATE, 'YYYY"년" MM"월" DD"일" DAY PM HH"시" MI"분" SS"초"')
FROM DUAL;

-- ORA-00821 : 날짜 형식이 부적합합니다
--> 년, 월, 일, 시 , 분, 초는 오라클에서 지정한 시간 관련 패턴이 아니다!
	--> 패턴 인식이 아닌 있는 그대로 출력함을 나타내는 ""(쌍따옴표) 사용
	--> 년, 월, 일, 시, 분, 초 -> "년", "월", "일", "시", "분", "초"

-------------------------------------------------------------------------------------------

-- TO_DATE(문자열 | 숫자 [, 포맷])

-- 문자열 또는 숫자를 날짜 형식으로 변환

-- 포맷의 역할 : 문자열 또는 숫자의 패턴이
--				날짜의 어떤 부분을 가리키고 있는지 나타냄

SELECT TO_DATE('22-08-2023', 'DD-MM-YYYY') FROM DUAL; -- 2023-08-22 00:00:00.000

SELECT TO_DATE('22일 화요일 15:07:30', 'DD"일" DAY HH24:MI:SS') FROM DUAL;

-- 숫자 -> 날짜
SELECT TO_DATE(20231226, 'YYYYMMDD') FROM DUAL;

/******* 연도 패턴 Y, R 차이점 *******/
-- 연도 표기 시 두 자리만 작성되어 있는 경우
-- 50 미만 : Y, R 둘 다 누락된 연도 앞 부분에 현재 세기(21C == 2000년대) 추가
-- 50 이상 : Y는 현재 세기(2000년대) 추가
--		   : R은 이전 세기(1900년대) 추가

SELECT TO_DATE('49-11-25', 'YY-MM-DD') "YY",
	   TO_DATE('49-11-25', 'RR-MM-DD') "RR"
FROM DUAL;

SELECT TO_DATE('50-11-25', 'YY-MM-DD') "YY",
	   TO_DATE('50-11-25', 'RR-MM-DD') "RR"
FROM DUAL;

--------------------------------------------------------------------------------------------

-- TO_NUMBER(문자열 [, 패턴]) : 문자열 -> 숫자 변환

SELECT TO_NUMBER('$1,500', '$9,999') FROM DUAL;

---------------------------------------------------------------------------------------------

-- <NULL 처리 함수>

-- (NULL 처리 연산 : IS NULL, IS NOT NULL)

-- NVL(컬럼명, 컬럼 값이 NULL일 경우 변경할 값)

-- EMPLOYEE 테이블에서
-- 사번, 이름, 전화번호 조회
-- 단, 전화번호가 없으면(NULL) '없음'으로 조회
SELECT EMP_ID, EMP_NAME, NVL(PHONE, '없음')
FROM EMPLOYEE e ;

-- EMPLOYEE 테이블에서
-- 이름, 급여, 보너스 조회
-- 보너스가 없으면 0으로 조회
SELECT EMP_NAME, SALARY, NVL(BONUS, 0)
FROM EMPLOYEE e ;

-- EMPLOYEE 테이블에서
-- 이름, 연봉, 인센티브(연봉 * 보너스)를 조회
-- 단, 인센티브가 없으면 0으로 표시
-- 연봉 내림차순으로 조회
-- NULL의 산술연산 결과는 항상 NULL
SELECT EMP_NAME, SALARY * 12, NVL(SALARY * 12 * BONUS, 0)
FROM EMPLOYEE e 
ORDER BY SALARY * 12 DESC;

---------------------------------------------------------------------------------------------

-- NVL2(컬럼명, NULL이 아닌 경우 변경할 값, NULL인 경우 변경할 값)

-- EMPLOYEE 테이블에서
-- 사번, 이름, 전화번호 조회
-- 전화번호가 없으면 '없음'
-- 전화번호가 있으면 '010********' 변경해서 조회
SELECT EMP_ID, EMP_NAME, NVL2(PHONE, SUBSTR(PHONE,1,3) || '********', '없음')
FROM EMPLOYEE e ;

SELECT EMP_ID, EMP_NAME, 
   NVL2(PHONE,
   RPAD(SUBSTR(PHONE,1,3), LENGTH(PHONE), '*') ,
   '없음')
FROM EMPLOYEE;

---------------------------------------------------------------------------------------------

-- <선택 함수>
-- 여러 가지 경우에 따라 알맞은 결과를 선택하는 함수
-- (IF, SWITCH문과 비슷)

-- DECODE(컬럼명 | 계산식, 조건1, 결과1, 조건2, 결과2, ... [, 아무것도 만족 X])

-- 컬럼명 | 계산식의 값이 일치하는 조건이 있으면
-- 해당 조건 오른쪽에 작성된 결과가 반환된다.
-- 모든 조건을 만족하지 못 하면 [, 아무것도 만족 X]가 반환됨.

-- EMPLOYEE 테이블에서 모든 사원의 이름, 주민등록번호, 성별 조회
SELECT EMP_NAME , EMP_NO , DECODE(SUBSTR(EMP_NO, 8, 1), 1, '남자', 2, '여자')
FROM EMPLOYEE e ;

-- EMPLOYEE 테이블에서
-- 직급코드가 'J7'인 직원은 급여 + 급여의 10%
-- 직급코드가 'J6'인 직원은 급여 + 급여의 15%
-- 직급코드가 'J5'인 직원은 급여 + 급여의 20%
-- 나머지 직급코드의 직원은 급여 + 급여의 5%  지급
-- 사원명, 직급코드, 기존급여, 지급급여 조회
SELECT EMP_NAME, JOB_CODE, SALARY 기존급여,
	DECODE(JOB_CODE, 'J7', SALARY * 1.1, 
					 'J6', SALARY * 1.15, 
					 'J5', SALARY * 1.2, 
					 	   SALARY * 1.05) 지급급여
FROM EMPLOYEE e
ORDER BY JOB_CODE DESC;

------------------------------------------------------------------------------------

-- CASE 
--     WHEN 조건1 THEN 결과1
--     WHEN 조건2 THEN 결과2
--     WHEN 조건3 THEN 결과3
--     ELSE 결과
-- END

-- DECODE는 계산식|컬럼 값이 딱 떨어지는 경우에만 사용 가능.
-- CASE는 계산식|컬럼 값을 범위로 지정할 수 있다. 

-- EMPLOYEE 테이블에서 사번, 이름, 급여, 구분을 조회
-- 구분은 받는 급여에 따라 초급, 중급, 고급으로 조회
-- 급여 500만 이상 = '고급'
-- 급여 300만 이상 ~ 500만 미만 = '중급'
-- 급여 300미만 = '초급'

-- 단, 부서코드가 D6, D9인 사원만 직급코드 오름차순으로 조회
SELECT EMP_ID, EMP_NAME, SALARY, 
	CASE
		WHEN SALARY >= 5000000 THEN '고급'
		WHEN SALARY >= 3000000 AND SALARY < 5000000 THEN '중급'
		ELSE '초급'
	END 구분
FROM EMPLOYEE e 
WHERE DEPT_CODE IN ('D6', 'D9')
ORDER BY JOB_CODE /*ASC 생략 가능*/;

--------------------------------------------------------------------------------------

/************************* 그룹 함수 ************************/

-- N개의 행의 컬럼 값을 전달하여 1개의 결과가 반환
-- (그룹의 수가 늘어나면 그룹의 수 만큼 결과를 반환)

-- SUM(숫자가 기록된 컬럼) : 그룹의 합계를 반환
-- 모든 사원의 급여 합
SELECT SUM(SALARY) FROM EMPLOYEE;

-- 부서 코드가 'D6'인 사원들의 급여 합
/* 3 */SELECT SUM(SALARY)		  -- 3) 모인 행들의 급여 합을 조회
/* 1 */FROM EMPLOYEE e            -- 1) EMPLOYEE 테이블에서
/* 2 */WHERE DEPT_CODE = 'D6';    -- 2) DEPT_CODE가 'D6'인 행들만 모아서

-- 2000년 이후 입사자들의 급여 합
SELECT SUM(SALARY)
FROM EMPLOYEE e 
WHERE HIRE_DATE >= '2000-01-01'; -- EXTRACT(YEAR FROM HIRE_DATE) >= 2000;

---------------------------------------------------------------------------------------

-- AVG(숫자만 기록된 컬럼) : 그룹의 평균

-- 모든 사원의 급여 평균
SELECT AVG(SALARY)
FROM EMPLOYEE e ;

-- 모든 사원의 급여 평균 (소수점 반올림 처리)
SELECT ROUND(AVG(SALARY)) 급여평균
FROM EMPLOYEE e ;

-- * 그룹 함수는 동시에 여러 개 작성 가능 *
SELECT SUM(SALARY) 합계, AVG(SALARY) 평균
FROM EMPLOYEE;

---------------------------------------------------------------------------------------

-- MAX(컬럼명) : 최댓값
-- MIN(컬럼명) : 최솟값

-- 날짜 대소 비교 : 과거 < 미래
-- 문자열 대소 비교 : 유니코드순서 (문자열 순서 A < Z)

-- 모든 사원의 급여 합계, 평균, 최댓값, 최솟값 조회
SELECT SUM(SALARY) 합계, AVG(SALARY) 평균, MAX(SALARY) 최댓값, MIN(SALARY) 최솟값
FROM EMPLOYEE;

-- 모든 사원 중
-- 가장 빠른 입사일, 최근 입사일
-- 이름 오름차순에서 제일 먼저 작성되는 이름, 마지막에 작성되는 이름
SELECT MIN(HIRE_DATE), MAX(HIRE_DATE), MIN(EMP_NAME), MAX(EMP_NAME)
FROM EMPLOYEE;

----------------------------------------------------------------------------------------

-- COUNT(* | [DINSTINCT] 컬럼명) : 조회된 행의 개수를 반환

-- COUNT(*) : 조회된 모든 행의 개수를 반환

-- COUNT(컬럼명) : 지정된 컬럼값이 NULL이 아닌 행의 개수를 반환
-- 					(NULL인 행 미포함)

-- COUNT(DISTINCT 컬럼명) : 
	-- 지정된 컬럼에서 중복 값을 제외한 행의 개수를 반환
	-- EX) A A B C D D D E : 5개 (중복은 한 번만 카운트)

SELECT COUNT(*) FROM EMPLOYEE; -- 23(행)
SELECT COUNT(*) FROM EMPLOYEE e WHERE DEPT_CODE = 'D6'; -- 3(행)

-- 전화 번호가 있는 사원은 몇 명인지 조회
SELECT COUNT(PHONE) FROM EMPLOYEE; -- 20
SELECT COUNT(*) FROM EMPLOYEE WHERE PHONE IS NOT NULL; -- PHONE 컬럼에 NULL이 아닌 행만 카운트

-- EMPLOYEE 테이블에 존재하는 부서코드의 수를 조회
-- (EMPLOYEE 테이블에 부서코드가 몇 종류?)
SELECT COUNT(DISTINCT DEPT_CODE) FROM EMPLOYEE;



-- EMPLOYEE 테이블에 존재하는 여자 사원의 수
SELECT COUNT(*)
FROM EMPLOYEE e 
WHERE SUBSTR(EMP_NO, 8, 1) = 2;

-- EMPLOYEE 테이블에 존재하는 남자 사원의 수
SELECT COUNT(*)
FROM EMPLOYEE e 
WHERE SUBSTR(EMP_NO, 8, 1) = 1;

-- EMPLOYEE 테이블에 존재하는 남자, 여자 사원의 수
SELECT COUNT( DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남자', NULL) ) 남자, 
	   COUNT( DECODE(SUBSTR(EMP_NO, 8, 1), '2', '여자', NULL) ) 여자
FROM EMPLOYEE e ;

SELECT SUM(DECODE(SUBSTR(EMP_NO, 8, 1), '1', 1, 0)) 남자,
	SUM(DECODE(SUBSTR(EMP_NO, 8, 1), '2', 1, 0)) 여자
FROM EMPLOYEE;

