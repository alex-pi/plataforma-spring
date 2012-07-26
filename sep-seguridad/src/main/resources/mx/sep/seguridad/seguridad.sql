--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- Name: seguridad; Type: DATABASE; Schema: -; Owner: pruebas
--

CREATE DATABASE seguridad WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';


ALTER DATABASE seguridad OWNER TO pruebas;

\connect seguridad

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- Name: seguridad; Type: SCHEMA; Schema: -; Owner: pruebas
--

CREATE SCHEMA seguridad;


ALTER SCHEMA seguridad OWNER TO pruebas;

SET search_path = seguridad, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: t_opcion_menu; Type: TABLE; Schema: seguridad; Owner: pruebas; Tablespace: 
--

CREATE TABLE t_opcion_menu (
    id_t_opcion integer NOT NULL,
    v_descripcion character varying(120) NOT NULL,
    v_opcion character varying(80) NOT NULL,
    v_url character varying(200),
    id_t_opcion_padre integer
);


ALTER TABLE seguridad.t_opcion_menu OWNER TO pruebas;

--
-- Name: t_r_usuario_rol; Type: TABLE; Schema: seguridad; Owner: pruebas; Tablespace: 
--

CREATE TABLE t_r_usuario_rol (
    id_tr_usuario integer NOT NULL,
    id_tr_rol integer NOT NULL
);


ALTER TABLE seguridad.t_r_usuario_rol OWNER TO pruebas;

--
-- Name: t_rol_seguridad; Type: TABLE; Schema: seguridad; Owner: pruebas; Tablespace: 
--

CREATE TABLE t_rol_seguridad (
    id_t_rol integer NOT NULL,
    v_rol character varying(30) NOT NULL,
    l_rol_activo boolean DEFAULT true NOT NULL
);


ALTER TABLE seguridad.t_rol_seguridad OWNER TO pruebas;

--
-- Name: t_usuario_seguridad; Type: TABLE; Schema: seguridad; Owner: pruebas; Tablespace: 
--

CREATE TABLE t_usuario_seguridad (
    id_t_usuario integer NOT NULL,
    v_username character varying(50) NOT NULL,
    v_password character varying(25) NOT NULL,
    v_nombre_usuario character varying(100) NOT NULL,
    l_usuario_activo boolean DEFAULT true NOT NULL
);


ALTER TABLE seguridad.t_usuario_seguridad OWNER TO pruebas;

--
-- Data for Name: t_opcion_menu; Type: TABLE DATA; Schema: seguridad; Owner: pruebas
--

INSERT INTO t_opcion_menu VALUES (2, 'Creación de módulo', 'Creación de módulo', 'ejemplos/modulo', 1);
INSERT INTO t_opcion_menu VALUES (4, 'Ejemplos intermedios', 'Ejemplos intermedios', NULL, 6);
INSERT INTO t_opcion_menu VALUES (1, 'Ejemplos simples', 'Ejemplos simples', NULL, 6);
INSERT INTO t_opcion_menu VALUES (3, 'Manejo de Tabs', 'Manejo de Tabs', ' ', 1);
INSERT INTO t_opcion_menu VALUES (5, 'Grid simple', 'Grid simple', ' ', 4);
INSERT INTO t_opcion_menu VALUES (8, 'Usuarios y roles', 'Usuarios y roles', ' ', 7);
INSERT INTO t_opcion_menu VALUES (9, 'Control de accesos', 'Control de accesos', ' ', 7);
INSERT INTO t_opcion_menu VALUES (10, 'Ejercicios Qtx', 'Ejercicios Qtx', NULL, NULL);
INSERT INTO t_opcion_menu VALUES (11, 'Configuraciones', 'Configuraciones', NULL, NULL);
INSERT INTO t_opcion_menu VALUES (7, 'Seguridad', 'Seguridad', NULL, 11);
INSERT INTO t_opcion_menu VALUES (12, 'Resolución de contenido', 'Resolución de contenido', 'ejemplos/controllerJsp', 1);
INSERT INTO t_opcion_menu VALUES (6, 'Ejemplos', 'Ejemplos Dojo', NULL, NULL);
INSERT INTO t_opcion_menu VALUES (13, 'Carga de archivo', 'Carga de archivo', 'ejemplos/cargaArchivos', 4);


--
-- Data for Name: t_r_usuario_rol; Type: TABLE DATA; Schema: seguridad; Owner: pruebas
--

INSERT INTO t_r_usuario_rol VALUES (1, 3);
INSERT INTO t_r_usuario_rol VALUES (3, 2);
INSERT INTO t_r_usuario_rol VALUES (2, 1);
INSERT INTO t_r_usuario_rol VALUES (2, 2);


--
-- Data for Name: t_rol_seguridad; Type: TABLE DATA; Schema: seguridad; Owner: pruebas
--

INSERT INTO t_rol_seguridad VALUES (1, 'ROL_USUARIO', true);
INSERT INTO t_rol_seguridad VALUES (2, 'ROL_USUARIO2', true);
INSERT INTO t_rol_seguridad VALUES (3, 'ROL_ADMIN', true);


--
-- Data for Name: t_usuario_seguridad; Type: TABLE DATA; Schema: seguridad; Owner: pruebas
--

INSERT INTO t_usuario_seguridad VALUES (1, 'pi', 'pipo', 'Alejandro Pimentel', true);
INSERT INTO t_usuario_seguridad VALUES (2, 'brian', 'briantu', 'Brian Hernandez', true);
INSERT INTO t_usuario_seguridad VALUES (3, 'carlos', 'freeman', 'Carlos Urbina', true);


--
-- Name: t_opcion_pkey; Type: CONSTRAINT; Schema: seguridad; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY t_opcion_menu
    ADD CONSTRAINT t_opcion_pkey PRIMARY KEY (id_t_opcion);


--
-- Name: t_r_usuario_rol_pkey; Type: CONSTRAINT; Schema: seguridad; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY t_r_usuario_rol
    ADD CONSTRAINT t_r_usuario_rol_pkey PRIMARY KEY (id_tr_usuario, id_tr_rol);


--
-- Name: t_rol_seguridad_pkey; Type: CONSTRAINT; Schema: seguridad; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY t_rol_seguridad
    ADD CONSTRAINT t_rol_seguridad_pkey PRIMARY KEY (id_t_rol);


--
-- Name: t_rol_seguridad_v_rol_key; Type: CONSTRAINT; Schema: seguridad; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY t_rol_seguridad
    ADD CONSTRAINT t_rol_seguridad_v_rol_key UNIQUE (v_rol);


--
-- Name: t_usuario_seguridad_pkey; Type: CONSTRAINT; Schema: seguridad; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY t_usuario_seguridad
    ADD CONSTRAINT t_usuario_seguridad_pkey PRIMARY KEY (id_t_usuario);


--
-- Name: t_usuario_seguridad_v_username_key; Type: CONSTRAINT; Schema: seguridad; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY t_usuario_seguridad
    ADD CONSTRAINT t_usuario_seguridad_v_username_key UNIQUE (v_username);


--
-- Name: fki_t_opcion_padre; Type: INDEX; Schema: seguridad; Owner: pruebas; Tablespace: 
--

CREATE INDEX fki_t_opcion_padre ON t_opcion_menu USING btree (id_t_opcion);


--
-- Name: fk_t_opcion_padre; Type: FK CONSTRAINT; Schema: seguridad; Owner: pruebas
--

ALTER TABLE ONLY t_opcion_menu
    ADD CONSTRAINT fk_t_opcion_padre FOREIGN KEY (id_t_opcion) REFERENCES t_opcion_menu(id_t_opcion);


--
-- Name: t_r_usuario_rol_id_tr_rol_fkey; Type: FK CONSTRAINT; Schema: seguridad; Owner: pruebas
--

ALTER TABLE ONLY t_r_usuario_rol
    ADD CONSTRAINT t_r_usuario_rol_id_tr_rol_fkey FOREIGN KEY (id_tr_rol) REFERENCES t_rol_seguridad(id_t_rol);


--
-- Name: t_r_usuario_rol_id_tr_usuario_fkey; Type: FK CONSTRAINT; Schema: seguridad; Owner: pruebas
--

ALTER TABLE ONLY t_r_usuario_rol
    ADD CONSTRAINT t_r_usuario_rol_id_tr_usuario_fkey FOREIGN KEY (id_tr_usuario) REFERENCES t_usuario_seguridad(id_t_usuario);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

