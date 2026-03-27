CREATE TABLE review_test
(
    r_no    number(2) primary key,
    r_title varchar2(50 char)  not null,
    r_txt   varchar2(300 char) not null,
    r_date  date               not null
);

CREATE SEQUENCE review_test_seq;

INSERT INTO review_test
VALUES (review_test_seq.nextval, 'title1', 'text!~~', SYSDATE);
INSERT INTO review_test
VALUES (review_test_seq.nextval, 'title2', 'text!~~', SYSDATE);
INSERT INTO review_test
VALUES (review_test_seq.nextval, 'title3', 'text!~~', SYSDATE);


SELECT *
FROM review_test
ORDER BY R_DATE;