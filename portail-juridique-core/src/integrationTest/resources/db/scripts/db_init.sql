CREATE TABLE STATEMENT(
  statement_id NUMBER PRIMARY KEY,
  status VARCHAR(10) NOT NULL,
  last_activity_date DATETIME NOT NULL,
  has_no_artworks CHAR,
  program_id NUMBER NOT NULL,
  producer_owner_id NUMBER
);

CREATE TABLE RIGHT_HOLDER (
  right_holder_id NUMBER PRIMARY KEY,
  firstname VARCHAR (50),
  lastname VARCHAR (50),
  statement_id NUMBER,
  artwork_id NUMBER,
  partner_id NUMBER NOT NULL ,
  type VARCHAR(10) NOT NULL
);

CREATE TABLE RIGHT_HOLDER_ROLE(
  role_code VARCHAR(10) PRIMARY KEY,
  role_label VARCHAR(60)
);

CREATE TABLE RIGHT_HOLDER_HOLDER_ROLE(
  role_code VARCHAR(10),
  right_holder_id NUMBER
);

CREATE TABLE ARTWORK(
  artwork_id NUMBER PRIMARY KEY,
  title VARCHAR (50),
  genre_code VARCHAR (10),
  music_type VARCHAR(10),
  record_support_id NUMBER,
  statement_id NUMBER
);


CREATE TABLE  ART_GENRE(
  genre_code VARCHAR (10) PRIMARY KEY,
  genre_label VARCHAR (50) NOT NULL
);

CREATE TABLE ARTWORK_TIMECODE(
  timecode_id NUMBER PRIMARY KEY,
  timecode_in TIME,
  timecode_out TIME,
  duration TIME,
  artwork_id NUMBER NOT NULL
);

CREATE TABLE RECORD_SUPPORT(
  record_support_id NUMBER PRIMARY KEY,
  producer_name VARCHAR(50),
  support_label VARCHAR(50),
  support_number VARCHAR(50),
  support_identifier VARCHAR(10)
);

CREATE  TABLE PROGRAM(
  program_id NUMBER PRIMARY KEY,
  original_title VARCHAR(50),
  original_subtitle VARCHAR(50),
  contractual_title VARCHAR(50),
  contractual_subtitle VARCHAR(50),
  production_year NUMBER,
  episode_number NUMBER,
  duration NUMBER,
  arte_em_number VARCHAR(50),
  genre_code VARCHAR(50),
  isan VARCHAR(50)
);

ALTER TABLE STATEMENT ADD CONSTRAINT "FK_STATEMENT_PROGRAM" FOREIGN KEY  (program_id) REFERENCES PROGRAM(program_id);
ALTER TABLE PROGRAM ADD CONSTRAINT "FK_GENRE_PROGRAM" FOREIGN KEY  (genre_code) REFERENCES ART_GENRE(genre_code);

