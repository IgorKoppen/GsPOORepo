DROP SEQUENCE sensores_sequence;
DROP TRIGGER tr_insert_codveiculo_sensores;
DROP TABLE sensores;


CREATE TABLE sensores (
  id_sensor integer PRIMARY KEY NOT NULL,
  tanque NUMERIC(10,2) NOT NULL,
  temperatura NUMERIC(10,2) NOT NULL,
  peso NUMERIC(10,2) NOT NULL,
  umidade NUMERIC(10,2) NOT NULL,
  vibracao NUMERIC(10,2) NOT NULL,
  pressao   NUMERIC(10,2) NOT NULL
);

CREATE SEQUENCE sensores_sequence START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER tr_insert_id_seansor
BEFORE INSERT ON SENSORES FOR EACH ROW
BEGIN

SELECT sensores_sequence.NEXTVAL
INTO :NEW.id_sensor
FROM DUAL;
END;
/

COMMIT;