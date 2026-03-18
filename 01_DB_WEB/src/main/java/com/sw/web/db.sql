CREATE TABLE name_age_test
(
    n_name varchar2(20 char) not null,
    n_age  number(3)         not null
);

INSERT INTO name_age_test
VALUES ('person1', 10);
INSERT INTO name_age_test
VALUES ('person2', 20);
INSERT INTO name_age_test
VALUES ('person3', 30);

SELECT *
FROM name_age_test;