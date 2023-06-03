DROP SEQUENCE veiculos_sequence;
DROP TRIGGER tr_insert_codveiculo_veiculos;
DROP TABLE veiculos;


CREATE TABLE veiculos (
  codveiculo integer PRIMARY KEY NOT NULL,
  tipoVeiculo varchar(40) NOT NULL,
  refrigerado char(10) NOT NULL,
  proprietario varchar(45) NOT NULL,
  marca varchar(45) NOT NULL,
  modelo varchar(45) NOT NULL,
  data_entrada  DATE NOT NULL,
  tipo_combustivel varchar(45) NOT NULL,
  carga_max NUMBER(6,2) NOT NULL,
  tanque_max NUMBER(6,2) NOT NULL
);

CREATE SEQUENCE veiculos_sequence START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER tr_insert_codveiculo
BEFORE INSERT ON VEICULOS FOR EACH ROW
BEGIN

SELECT veiculos_sequence.NEXTVAL
INTO :NEW.codveiculo
FROM DUAL;
END;
/

COMMIT;