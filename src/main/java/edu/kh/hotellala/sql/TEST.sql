-- 예약 목록 조회
SELECT PAYMENT_DT, MEMBER_NM, ROOM_NO, CHECK_IN, CHECK_OUT
FROM RESERVATION R
JOIN PAYMENT USING(REQUEST_NO)
JOIN MEMBER M ON(R.MEMBER_NO = M.MEMBER_NO)
WHERE RESERVATION_FL = 'Y';


-- 검색 목록 조회








-- 예약 정보 조회
SELECT REQUEST_NO, TO_CHAR(PAYMENT_DT, 'YYYY-MM-DD') PAYMENT_DT, ROOM_NO, 
    TO_CHAR(CHECK_IN, 'YYYY-MM-DD') CHECK_IN, DATE_RANGE, ROOM_TYPE,
    RESERVED_NUM_A, RESERVED_NUM_C, MEMBER_NM, MEMBER_TEL, MEMBER_BR, MEMBER_ADDR, EXTRA_REQUEST, RESERVATION_FL 
FROM RESERVATION R
JOIN PAYMENT USING(REQUEST_NO)
JOIN MEMBER M ON(R.MEMBER_NO = M.MEMBER_NO)
WHERE REQUEST_NO = 'OR202206110925140';


-- 예약 상태 조회
SELECT RESERVATION_FL, REFUND_FL
FROM RESERVATION
JOIN PAYMENT USING(REQUEST_NO)
JOIN REFUND USING(PAYMENT_NO)
WHERE REQUEST_NO = ?; 


-- 결제 정보 조회
SELECT ROOM_RATES, OPTION_TYPE, PAYTYPE, PAYMENT_AMOUNT
FROM RESERVATION
JOIN PAYMENT USING(REQUEST_NO)
JOIN OPTION_ORDER USING(REQUEST_NO)
JOIN OPTION_TB USING(OPTION_CD)
JOIN ROOM_TB USING(ROOM_TYPE)
WHERE REQUEST_NO =?;













-- 층별 객실 조회
SELECT ROOM_NO, MEMBER_NM, CHECK_IN, DATE_RANGE
FROM RESERVATION
JOIN PAYMENT USING(REQUEST_NO)
JOIN MEMBER M ON(R.MEMBER_NO = M.MEMBER_NO);













-- 환불 목록 조회
SELECT REFUND_NO, MEMBER_NM, ROOM_NO,
    TO_CHAR(PAYMENT_DT, 'YYYY-MM-DD') PAYMENT_DT,
    TO_CHAR(REFUND_DT, 'YYYY-MM-DD') REFUND_DT,
    REFUND_FL
FROM RESERVATION_CHECK
JOIN PAYMENT P USING(PAYMENT_NO)
JOIN REFUND R ON(P.PAYMENT_NO = R.PAYMENT_NO);


-- 예약 된 방
SELECT REQUEST_NO, CHECK_IN, CHECK_OUT, DATE_RANGE, ROOM_NO
FROM RESERVATION
WHERE TO_DATE('2022-07-02', 'YYYY-MM-DD') BETWEEN CHECK_IN AND CHECK_OUT
AND ROOM_TYPE = 'STANDARD';