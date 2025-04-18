create table test(
	id varchar(100),
	pw varchar(50),
	primary key(id)
);

insert into test values('admin', '12345');

drop table test;

select * from TB_USER; 

select * from TB_ORDER;

select * from TB_PRODUCT; 

select * from TB_REQUEST;

select * from TB_ORDER_DETAILS;

ALTER TABLE TB_REQUEST
ADD COLUMN `REQ_MODEL` VARCHAR(50) NOT NULL COMMENT '요청 모델';

DELETE FROM TB_REQUEST WHERE REQ_IDX = 4;

INSERT INTO TB_ORDER_DETAILS (
    DETAIL_IDX,
    ORDER_IDX,
    P_IDX,
    CNT,
    ORDER_STATUS
)
VALUES (
    1,
    1,
    1,
    1,
    '배송준비중'
);


ALTER TABLE TB_ORDER_DETAILS
ADD COLUMN `ORDER_STATUS` VARCHAR(20) NOT NULL COMMENT '주문 상태';

INSERT INTO TB_ORDER (
    U_ID,
    TOTAL_AMOUNT,
    DISCOUNT_AMOUNT,
    PAY_AMOUNT,
    PAY_METHOD,
    PAID_AMOUNT,
    ORDER_STATUS,
    DELIVERY_COMPANY,
    ORDER_MSG,
    CREATED_AT
)
VALUES (
    'test',         -- 주문자 아이디
    1000000,        -- 주문 총금액
    0,              -- 할인 금액 (0원)
    1000000,        -- 결제 대상금액
    '신용카드',     -- 결제 수단
    1000000,        -- 결제 금액
    '배송준비중',   -- 주문 상태
    '한진택배',     -- 택배사
    '테스트 주문',  -- 주문 메시지
    NOW()           -- 주문 일자 (현재 시간)
);

DELETE FROM TB_USER;

ALTER TABLE TB_USER
ADD COLUMN EMAIL VARCHAR(100) AFTER PHONE;

