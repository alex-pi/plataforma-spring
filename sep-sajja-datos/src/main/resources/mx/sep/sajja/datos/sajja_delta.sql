BEGIN;

-- Sequence: sajja.t_archivo_seq

DROP SEQUENCE sajja.t_archivo_seq;

CREATE SEQUENCE sajja.t_archivo_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 3
  CACHE 1;
ALTER TABLE sajja.t_archivo_seq
  OWNER TO pruebas;


-- Table: sajja.t_archivo

--DROP TABLE sajja.t_archivo;

CREATE TABLE sajja.t_archivo
(
  id_t_archivo integer NOT NULL DEFAULT nextval('sajja.t_archivo_seq'::regclass),
  v_nombre character varying(120) NOT NULL,
  v_datos bytea NOT NULL,
  v_ruta character varying(200) NOT NULL,
  CONSTRAINT t_archivo_pkey PRIMARY KEY (id_t_archivo )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE sajja.t_archivo
  OWNER TO pruebas;


 -- Sequence: sajja.t_formulario_seq

--DROP SEQUENCE sajja.t_formulario_seq;

CREATE SEQUENCE sajja.t_formulario_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 16
  CACHE 1;
ALTER TABLE sajja.t_formulario_seq
  OWNER TO pruebas;

 -- Table: sajja.t_formulario

--DROP TABLE sajja.t_formulario;

CREATE TABLE sajja.t_formulario
(
  id_t_formulario integer NOT NULL DEFAULT nextval('sajja.t_formulario_seq'::regclass),
  v_nombre character varying(120) NOT NULL,
  v_apellido_pat character varying(120) NOT NULL,
  v_correo character varying(120) NOT NULL,
  v_password character varying(120) NOT NULL,
  v_telefono character varying(120),
  CONSTRAINT t_formulario_pkey PRIMARY KEY (id_t_formulario )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE sajja.t_formulario
  OWNER TO pruebas;
  
	
COMMIT;

