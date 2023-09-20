DROP TABLE ARTICLE_T;
CREATE TABLE ARTICLE_T (
    /* 기사번호  */    ARTICLE_NO    NUMBER              NOT NULL,
    /* 제목      */    TITLE         VARCHAR2(1000 BYTE) NOT NULL,
    /* 내용      */    CONTENT       CLOB,
    /* 작성자    */    EDITOR        VARCHAR2(1000 BYTE) NOT NULL,
    /* 조회수    */    HIT           NUMBER,
    /* 최종수정일*/    LASTMODIFIED  DATE,
    /* 최초작성일*/    CREATED       DATE,
    CONSTRAINT PK_ARTICLE PRIMARY KEY(ARTICLE_NO)
);

DROP SEQUENCE ARTICLE_SEQ;
CREATE SEQUENCE ARTICLE_SEQ NOCACHE;