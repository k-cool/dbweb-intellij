CREATE TABLE login_test
(
    l_id   varchar2(20 char) not null,
    l_pw   varchar2(20 char) not null,
    l_name varchar2(20 char) not null
);

INSERT INTO login_test
VALUES ('mz', 'mz1004', 'mzmz');
INSERT INTO login_test
VALUES ('sw', 'sw1004', 'swsw');
INSERT INTO login_test
VALUES ('ky', 'ky1004', 'kyky');

SELECT *
FROM login_test;