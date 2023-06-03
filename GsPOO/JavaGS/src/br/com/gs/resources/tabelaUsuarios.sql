DROP SEQUENCE usuario_sequence;
DROP TRIGGER tr_insert_id_usuario;
DROP TABLE usuarios;


CREATE TABLE usuarios (
  id integer PRIMARY KEY NOT NULL,
  nome varchar(45) NOT NULL,
  senha varchar(45) NOT NULL,
  email varchar(200) NOT NULL,
  data Date NOT NULL
);

CREATE SEQUENCE usuario_sequence START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER tr_insert_id_usuario
BEFORE INSERT ON USUARIOS FOR EACH ROW
BEGIN

SELECT usuario_sequence.NEXTVAL
INTO :NEW.id
FROM DUAL;
END;
/

COMMIT;

INSERT INTO usuarios (nome, senha, email, data) VALUES ('admin', '123', 'admin@gmail.com', TO_DATE('23/06/2023', 'DD/MM/YYYY'));