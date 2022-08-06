CREATE SEQUENCE PATIENT_SEQ START WITH 1000 INCREMENT BY 1;
--PATIENT
CREATE TABLE PATIENT
(
    ID         INTEGER,
    FIRST_NAME VARCHAR(64),
    MID_NAME   VARCHAR(64),
    LAST_NAME  VARCHAR(64),
    GENDER_ID  SMALLINT,
    BIRTHDAY   DATE,
    PHONE      VARCHAR(64),
    EMAIL      VARCHAR(64),
    ADDRESS    VARCHAR(128)
);

ALTER TABLE PATIENT
    ADD CONSTRAINT PATIENT_ID_PK PRIMARY KEY (ID);

CREATE INDEX PATIENT_PK_IDX ON PATIENT (ID);

DO $$
    DECLARE
        v_patient_id integer;
    BEGIN
        SELECT NEXTVAL('patient_seq') INTO v_patient_id;
        INSERT INTO PATIENT(ID, FIRST_NAME, MID_NAME, LAST_NAME, GENDER_ID,
                            BIRTHDAY, PHONE, EMAIL, ADDRESS)
        VALUES (v_patient_id, 'Ivan', 'Alexey', 'Ivanov', 1, '15-10-1995', '+7(952)-111-11-11', 'ivanov@gmail.com',
                'Lisukova 76 kv 66');
    END
$$;
