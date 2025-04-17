
CREATE TABLE TB_CART (
    C_IDX INT AUTO_INCREMENT PRIMARY KEY,
    U_ID VARCHAR(50),
    P_IDX INT,
    CONSTRAINT FK_CART_USER FOREIGN KEY (U_ID) REFERENCES TB_USER(U_ID),
    CONSTRAINT FK_CART_PRODUCT FOREIGN KEY (P_IDX) REFERENCES TB_PRODUCT(P_IDX)
);

CREATE TABLE test (
  p_idx INT AUTO_INCREMENT PRIMARY KEY,
  p_name VARCHAR(100),
  price INT,
  p_status TEXT,
  p_ownership INT,
  p_img1 VARCHAR(255),
  p_img2 VARCHAR(255),
  p_img3 VARCHAR(255)
);

INSERT INTO test (p_name, price, p_status, p_ownership, p_img1, p_img2, p_img3)
VALUES ('테스트폰', 100000, '상태 좋음', 1, 'url1', 'url2', 'url3');

select * from test; 

drop table test;

delete from TB_CART;

DELETE FROM TB_USER;

ALTER TABLE TB_USER
ADD COLUMN EMAIL VARCHAR(100) AFTER PHONE;

ALTER TABLE TB_PRODUCT
ADD COLUMN COLOR VARCHAR(50) COMMENT '제품 색상';


select * from TB_USER; 				/*회원정보*/
select * from TB_PRODUCT;			/*보유제품*/
select * from TB_ORDER;				/*주문정보*/
select * from TB_ORDER_DETAILS;		/*주문상세*/
select * from TB_REVIEW;			/* 리뷰 */
select * from TB_REQUEST;			/* 요청 */
select * from TB_CART;				/*장바구니*/

select * from TB_PRODUCT;

select * from TB_CART where U_ID = "test";


ALTER TABLE TB_PRODUCT DROP COLUMN P_IMG3;

ALTER TABLE TB_PRODUCT ADD COLUMN P_IMG3 VARCHAR(1000) COMMENT '사진3';
