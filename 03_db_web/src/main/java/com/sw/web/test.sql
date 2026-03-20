CREATE TABLE member_test
(
    m_no   number(3) primary key,
    m_name varchar2(20 char) not null,
    m_age  number(3)         not null
);


CREATE SEQUENCE member_test_seq;


INSERT INTO member_test
VALUES (member_test_seq.nextval, 'user1', 10);
INSERT INTO member_test
VALUES (member_test_seq.nextval, 'user2', 20);
INSERT INTO member_test
VALUES (member_test_seq.nextval, 'user3', 30);

SELECT *
FROM member_test;

DELETE MEMBER_TEST
WHERE M_NO = 4;
DELETE MEMBER_TEST
WHERE M_NO = 5;



