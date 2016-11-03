
--------------------------------------------------------
--  DDL for Table ART_GENRE
--------------------------------------------------------

CREATE TABLE ART_GENRE
(	"GENRE_CODE" VARCHAR2(255 CHAR),
   "GENRE_LABEL" VARCHAR2(255 CHAR)
);
--------------------------------------------------------
--  DDL for Table ARTWORK
--------------------------------------------------------

CREATE TABLE ARTWORK
(	"ARTWORK_ID" NUMBER(19,0),
   "MUSIC_TYPE" VARCHAR2(255 CHAR),
   "STATEMENT_ID" NUMBER(19,0),
   "TITLE" VARCHAR2(255 CHAR),
   "GENRE_CODE" VARCHAR2(255 CHAR),
   "RECORD_SUPPORT_ID" NUMBER(19,0)
) ;
--------------------------------------------------------
--  DDL for Table ARTWORK_TIMECODE
--------------------------------------------------------

CREATE TABLE ARTWORK_TIMECODE
(	"TIMECODE_ID" NUMBER(19,0),
   "ARTWORK_ID" NUMBER(19,0),
   "DURATION" NUMBER(19,0),
   "TIMECODE_IN" NUMBER(19,0),
   "TIMECODE_OUT" NUMBER(19,0)
);
--------------------------------------------------------
--  DDL for Table PROGRAM
--------------------------------------------------------

CREATE TABLE PROGRAM
(	"PROGRAM_ID" NUMBER(19,0),
   "ARTE_EM_NUMBER" VARCHAR2(255 CHAR),
   "CONTRACTUAL_SUBTITLE" VARCHAR2(255 CHAR),
   "CONTRACTUAL_TITLE" VARCHAR2(255 CHAR),
   "DURATION" NUMBER(19,0),
   "EPISODE_NUMBER" NUMBER(10,0),
   "ISAN" VARCHAR2(255 CHAR),
   "ORIGINAL_SUBTITLE" VARCHAR2(255 CHAR),
   "ORIGINAL_TITLE" VARCHAR2(255 CHAR),
   "PRODUCTION_YEAR" NUMBER(10,0),
   "GENRE_CODE" VARCHAR2(255 CHAR)
);
--------------------------------------------------------
--  DDL for Table RECORD_SUPPORT
--------------------------------------------------------

CREATE TABLE RECORD_SUPPORT
(	"RECORD_SUPPORT_ID" NUMBER(19,0),
   "PRODUCER_NAME" VARCHAR2(255 CHAR),
   "SUPPORT_IDENTIFIER" VARCHAR2(255 CHAR),
   "SUPPORT_LABEL" VARCHAR2(255 CHAR),
   "SUPPORT_NUMBER" VARCHAR2(255 CHAR)
);
--------------------------------------------------------
--  DDL for Table RIGHT_HOLDER
--------------------------------------------------------

CREATE TABLE RIGHT_HOLDER
(	"TYPE" VARCHAR2(31 CHAR),
   "RIGHT_HOLDER_ID" NUMBER(19,0),
   "FIRSTNAME" VARCHAR2(255 CHAR),
   "LASTNAME" VARCHAR2(255 CHAR),
   "ARTWORK_ID" NUMBER(19,0),
   "PARTNER_ID" NUMBER(19,0),
   "STATEMENT_ID" NUMBER(19,0)
);
--------------------------------------------------------
--  DDL for Table RIGHT_HOLDER_HOLDER_ROLE
--------------------------------------------------------

CREATE TABLE RIGHT_HOLDER_HOLDER_ROLE
(	"RIGHT_HOLDER_ID" NUMBER(19,0),
   "ROLE_CODE" VARCHAR2(255 CHAR)
);
--------------------------------------------------------
--  DDL for Table RIGHT_HOLDER_ROLE
--------------------------------------------------------

CREATE TABLE RIGHT_HOLDER_ROLE
(	"ROLE_CODE" VARCHAR2(255 CHAR),
   "ROLE_LABEL" VARCHAR2(255 CHAR)
);
--------------------------------------------------------
--  DDL for Table STATEMENT
--------------------------------------------------------

CREATE TABLE STATEMENT
(	"STATEMENT_ID" NUMBER(19,0),
   "HAS_NO_ARTWORKS" NUMBER(1,0),
   "LAST_ACTIVITY_DATE" DATE,
   "PRODUCER_OWNER_ID" NUMBER(19,0),
   "STATUS" VARCHAR2(255 CHAR),
   "PROGRAM_ID" NUMBER(19,0)
);

--------------------------------------------------------
--  Constraints for Table ART_GENRE
--------------------------------------------------------

ALTER TABLE "ART_GENRE" ADD PRIMARY KEY ("GENRE_CODE");
ALTER TABLE "ART_GENRE" MODIFY ("GENRE_CODE" NOT NULL );
--------------------------------------------------------
--  Constraints for Table ARTWORK
--------------------------------------------------------

ALTER TABLE "ARTWORK" ADD PRIMARY KEY ("ARTWORK_ID");
ALTER TABLE "ARTWORK" MODIFY ("ARTWORK_ID" NOT NULL );
--------------------------------------------------------
--  Constraints for Table ARTWORK_TIMECODE
--------------------------------------------------------

ALTER TABLE "ARTWORK_TIMECODE" ADD PRIMARY KEY ("TIMECODE_ID");
ALTER TABLE "ARTWORK_TIMECODE" MODIFY ("TIMECODE_ID" NOT NULL );
--------------------------------------------------------
--  Constraints for Table PROGRAM
--------------------------------------------------------

ALTER TABLE "PROGRAM" ADD PRIMARY KEY ("PROGRAM_ID");
ALTER TABLE "PROGRAM" MODIFY ("PROGRAM_ID" NOT NULL );
--------------------------------------------------------
--  Constraints for Table RECORD_SUPPORT
--------------------------------------------------------

ALTER TABLE "RECORD_SUPPORT" ADD PRIMARY KEY ("RECORD_SUPPORT_ID");
ALTER TABLE "RECORD_SUPPORT" MODIFY ("RECORD_SUPPORT_ID" NOT NULL );
--------------------------------------------------------
--  Constraints for Table RIGHT_HOLDER
--------------------------------------------------------

ALTER TABLE "RIGHT_HOLDER" ADD PRIMARY KEY ("RIGHT_HOLDER_ID");
ALTER TABLE "RIGHT_HOLDER" MODIFY ("RIGHT_HOLDER_ID" NOT NULL );
ALTER TABLE "RIGHT_HOLDER" MODIFY ("TYPE" NOT NULL );
--------------------------------------------------------
--  Constraints for Table RIGHT_HOLDER_HOLDER_ROLE
--------------------------------------------------------

ALTER TABLE "RIGHT_HOLDER_HOLDER_ROLE" MODIFY ("ROLE_CODE" NOT NULL );
ALTER TABLE "RIGHT_HOLDER_HOLDER_ROLE" MODIFY ("RIGHT_HOLDER_ID" NOT NULL );
--------------------------------------------------------
--  Constraints for Table RIGHT_HOLDER_ROLE
--------------------------------------------------------

ALTER TABLE "RIGHT_HOLDER_ROLE" ADD PRIMARY KEY ("ROLE_CODE");
ALTER TABLE "RIGHT_HOLDER_ROLE" MODIFY ("ROLE_CODE" NOT NULL );
--------------------------------------------------------
--  Constraints for Table STATEMENT
--------------------------------------------------------

ALTER TABLE "STATEMENT" ADD PRIMARY KEY ("STATEMENT_ID");
ALTER TABLE "STATEMENT" MODIFY ("PROGRAM_ID" NOT NULL );
ALTER TABLE "STATEMENT" MODIFY ("STATUS" NOT NULL );
ALTER TABLE "STATEMENT" MODIFY ("PRODUCER_OWNER_ID" NOT NULL );
ALTER TABLE "STATEMENT" MODIFY ("LAST_ACTIVITY_DATE" NOT NULL );
ALTER TABLE "STATEMENT" MODIFY ("STATEMENT_ID" NOT NULL );
--------------------------------------------------------
--  Ref Constraints for Table ARTWORK
--------------------------------------------------------

ALTER TABLE "ARTWORK" ADD CONSTRAINT "FK_ARTWORK_STATEMENT" FOREIGN KEY ("STATEMENT_ID")
REFERENCES "STATEMENT" ("STATEMENT_ID") ;
ALTER TABLE "ARTWORK" ADD CONSTRAINT "FK_ARTWORK_GENRE" FOREIGN KEY ("GENRE_CODE")
REFERENCES "ART_GENRE" ("GENRE_CODE") ;
ALTER TABLE "ARTWORK" ADD CONSTRAINT "FK_ARTWORK_RECORD_SUPPORT" FOREIGN KEY ("RECORD_SUPPORT_ID")
REFERENCES "RECORD_SUPPORT" ("RECORD_SUPPORT_ID") ;
--------------------------------------------------------
--  Ref Constraints for Table ARTWORK_TIMECODE
--------------------------------------------------------

ALTER TABLE "ARTWORK_TIMECODE" ADD CONSTRAINT "FK_ARTWORK_TIMECODE_ARTWORK" FOREIGN KEY ("ARTWORK_ID")
REFERENCES "ARTWORK" ("ARTWORK_ID") ;
--------------------------------------------------------
--  Ref Constraints for Table PROGRAM
--------------------------------------------------------

ALTER TABLE "PROGRAM" ADD CONSTRAINT "FK_PROGRAM_GENRE" FOREIGN KEY ("GENRE_CODE")
REFERENCES "ART_GENRE" ("GENRE_CODE") ;
--------------------------------------------------------
--  Ref Constraints for Table RIGHT_HOLDER
--------------------------------------------------------

ALTER TABLE "RIGHT_HOLDER" ADD CONSTRAINT "FK_RIGHT_HOLDER_STATEMENT" FOREIGN KEY ("STATEMENT_ID")
REFERENCES "STATEMENT" ("STATEMENT_ID") ;
ALTER TABLE "RIGHT_HOLDER" ADD CONSTRAINT "FK_RIGHT_HOLDER_ARTWORK" FOREIGN KEY ("ARTWORK_ID")
REFERENCES "ARTWORK" ("ARTWORK_ID") ;
--------------------------------------------------------
--  Ref Constraints for Table RIGHT_HOLDER_HOLDER_ROLE
--------------------------------------------------------

ALTER TABLE "RIGHT_HOLDER_HOLDER_ROLE" ADD CONSTRAINT "FK_RIGHT_HOLDER_ROLE" FOREIGN KEY ("ROLE_CODE")
REFERENCES "RIGHT_HOLDER_ROLE" ("ROLE_CODE") ;
ALTER TABLE "RIGHT_HOLDER_HOLDER_ROLE" ADD CONSTRAINT "FK_RIGHT_HOLDER" FOREIGN KEY ("RIGHT_HOLDER_ID")
REFERENCES "RIGHT_HOLDER" ("RIGHT_HOLDER_ID") ;

--------------------------------------------------------
--  Ref Constraints for Table STATEMENT
--------------------------------------------------------

ALTER TABLE "STATEMENT" ADD CONSTRAINT "FKSTATEMENT_PROGRAM" FOREIGN KEY ("PROGRAM_ID")
REFERENCES "PROGRAM" ("PROGRAM_ID") ;

--------------------------------------------------------
--  Public synonymes and Grant privileges
--------------------------------------------------------

CREATE PUBLIC SYNONYM ART_GENRE FOR DAJ.ART_GENRE;
GRANT INSERT, SELECT, UPDATE, DELETE ON ART_GENRE TO DAJ_MODIF;
GRANT SELECT ON ART_GENRE TO DAJ_VISU;

CREATE PUBLIC SYNONYM ARTWORK FOR DAJ.ARTWORK;
GRANT INSERT, SELECT, UPDATE, DELETE ON ARTWORK TO DAJ_MODIF;
GRANT SELECT ON ARTWORK TO DAJ_VISU;

CREATE PUBLIC SYNONYM ARTWORK_TIMECODE FOR DAJ.ARTWORK_TIMECODE;
GRANT INSERT, SELECT, UPDATE, DELETE ON ARTWORK_TIMECODE TO DAJ_MODIF;
GRANT SELECT ON ARTWORK_TIMECODE TO DAJ_VISU;

CREATE PUBLIC SYNONYM PROGRAM FOR DAJ.PROGRAM;
GRANT INSERT, SELECT, UPDATE, DELETE ON PROGRAM TO DAJ_MODIF;
GRANT SELECT ON PROGRAM TO DAJ_VISU;

CREATE PUBLIC SYNONYM RECORD_SUPPORT FOR DAJ.RECORD_SUPPORT;
GRANT INSERT, SELECT, UPDATE, DELETE ON RECORD_SUPPORT TO DAJ_MODIF;
GRANT SELECT ON RECORD_SUPPORT TO DAJ_VISU;

CREATE PUBLIC SYNONYM RIGHT_HOLDER FOR DAJ.RIGHT_HOLDER;
GRANT INSERT, SELECT, UPDATE, DELETE ON RIGHT_HOLDER TO DAJ_MODIF;
GRANT SELECT ON RIGHT_HOLDER TO DAJ_VISU;

CREATE PUBLIC SYNONYM RIGHT_HOLDER_HOLDER_ROLE FOR DAJ.RIGHT_HOLDER_HOLDER_ROLE;
GRANT INSERT, SELECT, UPDATE, DELETE ON RIGHT_HOLDER_HOLDER_ROLE TO DAJ_MODIF;
GRANT SELECT ON ART_GENRE TO RIGHT_HOLDER_HOLDER_ROLE;

CREATE PUBLIC SYNONYM STATEMENT FOR DAJ.STATEMENT;
GRANT INSERT, SELECT, UPDATE, DELETE ON STATEMENT TO DAJ_MODIF;
GRANT SELECT ON STATEMENT TO DAJ_VISU;

CREATE PUBLIC SYNONYM RIGHT_HOLDER_ROLE FOR DAJ.RIGHT_HOLDER_ROLE;
GRANT INSERT, SELECT, UPDATE, DELETE ON RIGHT_HOLDER_ROLE TO DAJ_MODIF;
GRANT SELECT ON RIGHT_HOLDER_ROLE TO DAJ_VISU;

--------------------------------------------------------
--  Sequence création
--------------------------------------------------------

CREATE SEQUENCE DAJ_ID_SEQU
START WITH     1
INCREMENT BY   1
NOCACHE
NOCYCLE;

CREATE OR REPLACE PUBLIC SYNONYM DAJ_ID_SEQU FOR DAJ.DAJ_ID_SEQU;
GRANT SELECT ON DAJ_ID_SEQU TO DAJ_VISU, DAJ_MODIF;

