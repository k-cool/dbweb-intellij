CREATE TABLE restaurant_test
(
    r_no    number(3) primary key,
    r_name  varchar2(30 char)  not null,
    r_place varchar2(30 char)  not null,
    r_img   varchar2(200 char) not null
);

CREATE SEQUENCE RESTAURANT_TEST_SEQ;


INSERT INTO restaurant_test
VALUES (RESTAURANT_TEST_SEQ.nextval, 'res01', 'jongro', 'a.jpg');

INSERT INTO restaurant_test
VALUES (RESTAURANT_TEST_SEQ.nextval, 'res02', 'jongro2ga', 'b.jpg');

INSERT INTO restaurant_test
VALUES (RESTAURANT_TEST_SEQ.nextval, 'res03', 'jongro3ga', 'c.jpg');


SELECT *
FROM restaurant_test;

DELETE RESTAURANT_TEST
WHERE r_no = 1;
DELETE RESTAURANT_TEST
WHERE r_no = 2;
DELETE RESTAURANT_TEST
WHERE r_no = 3;
