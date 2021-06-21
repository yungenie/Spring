CREATE TABLE board (
    id number(10,0) NOT NULL,
    title varchar2(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE SEQUENCE board_seq START WITH 1 INCREMENT BY 50;