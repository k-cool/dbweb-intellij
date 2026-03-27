CREATE TABLE movie_test
(
    m_no    number(2) primary key,
    m_title varchar2(30 char)  not null,
    m_actor varchar2(30 char)  not null,
    m_img   varchar2(200 char) not null,
    m_story varchar2(500)      not null
);

CREATE SEQUENCE movie_test_seq;

INSERT INTO movie_test
VALUES (movie_test_seq.nextval, '매트릭스', '키아누', 'a.jpg', '가상세계 이야기~!');
INSERT INTO movie_test
VALUES (movie_test_seq.nextval, '인셉션', '레오나르도 디카프리오', 'b.jpg', '꿈 속의 꿈을 설계하는 이야기');
INSERT INTO movie_test
VALUES (movie_test_seq.nextval, '인터스텔라', '매튜 맥커너히', 'c.jpg', '우주를 넘어 인류를 구하는 여정');
INSERT INTO movie_test
VALUES (movie_test_seq.nextval, '어벤져스', '로버트 다우니 주니어', 'd.jpg', '히어로들이 힘을 합쳐 지구를 구한다');
INSERT INTO movie_test
VALUES (movie_test_seq.nextval, '타이타닉', '레오나르도 디카프리오', 'e.jpg', '침몰하는 배에서의 사랑 이야기');
INSERT INTO movie_test
VALUES (movie_test_seq.nextval, '조커', '호아킨 피닉스', 'f.jpg', '광기와 사회의 경계에 선 남자');
INSERT INTO movie_test
VALUES (movie_test_seq.nextval, '기생충', '송강호', 'g.jpg', '빈부격차를 그린 블랙코미디');
INSERT INTO movie_test
VALUES (movie_test_seq.nextval, '올드보이', '최민식', 'h.jpg', '15년 감금 후 복수를 시작한 남자');
INSERT INTO movie_test
VALUES (movie_test_seq.nextval, '라라랜드', '라이언 고슬링', 'i.jpg', '꿈과 사랑 사이의 이야기');
INSERT INTO movie_test
VALUES (movie_test_seq.nextval, '다크 나이트', '크리스찬 베일', 'j.jpg', '배트맨과 조커의 대결');
INSERT INTO movie_test
VALUES (movie_test_seq.nextval, '스파이더맨', '톰 홀랜드', 'k.jpg', '평범한 소년의 히어로 성장기');

SELECT *
FROM movie_test;

