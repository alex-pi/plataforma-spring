--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.6
-- Dumped by pg_dump version 9.1.6
-- Started on 2012-11-05 15:41:51 CST

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 166 (class 3079 OID 11681)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1917 (class 0 OID 0)
-- Dependencies: 166
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- TOC entry 161 (class 1259 OID 210893)
-- Dependencies: 6
-- Name: t_archivo_seq; Type: SEQUENCE; Schema: public; Owner: pruebas
--

CREATE SEQUENCE t_archivo_seq
    START WITH 3
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.t_archivo_seq OWNER TO pruebas;

--
-- TOC entry 1918 (class 0 OID 0)
-- Dependencies: 161
-- Name: t_archivo_seq; Type: SEQUENCE SET; Schema: public; Owner: pruebas
--

SELECT pg_catalog.setval('t_archivo_seq', 19, true);


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 162 (class 1259 OID 210895)
-- Dependencies: 1900 6
-- Name: t_archivo; Type: TABLE; Schema: public; Owner: pruebas; Tablespace: 
--

CREATE TABLE t_archivo (
    id_t_archivo integer DEFAULT nextval('t_archivo_seq'::regclass) NOT NULL,
    v_nombre character varying(120) NOT NULL,
    v_datos bytea NOT NULL,
    v_ruta character varying(200) NOT NULL
);


ALTER TABLE public.t_archivo OWNER TO pruebas;

--
-- TOC entry 165 (class 1259 OID 211022)
-- Dependencies: 6
-- Name: t_escuela; Type: TABLE; Schema: public; Owner: pruebas; Tablespace: 
--

CREATE TABLE t_escuela (
    id_t_escuela bigint NOT NULL,
    v_nombre character varying(70),
    v_antiguedad integer
);


ALTER TABLE public.t_escuela OWNER TO pruebas;

--
-- TOC entry 163 (class 1259 OID 210902)
-- Dependencies: 6
-- Name: t_usuario; Type: TABLE; Schema: public; Owner: pruebas; Tablespace: 
--

CREATE TABLE t_usuario (
    id_t_usuario integer NOT NULL,
    v_nombre character varying(120) NOT NULL,
    v_apellido_pat character varying(120) NOT NULL,
    v_correo character varying(120) NOT NULL,
    v_password character varying(120) NOT NULL,
    v_telefono character varying(120)
);


ALTER TABLE public.t_usuario OWNER TO pruebas;

--
-- TOC entry 164 (class 1259 OID 210908)
-- Dependencies: 6
-- Name: t_usuario_seq; Type: SEQUENCE; Schema: public; Owner: pruebas
--

CREATE SEQUENCE t_usuario_seq
    START WITH 16
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.t_usuario_seq OWNER TO pruebas;

--
-- TOC entry 1919 (class 0 OID 0)
-- Dependencies: 164
-- Name: t_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: pruebas
--

SELECT pg_catalog.setval('t_usuario_seq', 91, true);


--
-- TOC entry 1907 (class 0 OID 210895)
-- Dependencies: 162 1910
-- Data for Name: t_archivo; Type: TABLE DATA; Schema: public; Owner: pruebas
--

INSERT INTO t_archivo VALUES (3, 'komodo-edit-7.desktop', '\x5b4465736b746f7020456e7472795d5c303132456e636f64696e673d5554462d385c3031324e616d653d4b6f6d6f646f204564697420375c30313247656e657269634e616d653d456469746f725c303132436f6d6d656e743d46726565206d756c74692d706c6174666f726d20656469746f722074686174206d616b6573206974206561737920746f207772697465207175616c69747920636f64652e5c303132457865633d2f686f6d652f70692f50726f6772616d732f4b6f6d6f646f2d456469742d372f6c69622f6d6f7a696c6c612f6b6f6d6f646f2025465c30313249636f6e3d2f686f6d652f70692f50726f6772616d732f4b6f6d6f646f2d456469742d372f73686172652f69636f6e732f6b6f6d6f646f34382e706e675c3031325465726d696e616c3d66616c73655c303132547970653d4170706c69636174696f6e5c3031324d696d65547970653d746578742f706c61696e3b5c30313243617465676f726965733d41637469766553746174653b4170706c69636174696f6e3b446576656c6f706d656e743b456469746f723b5574696c6974793b54657874456469746f723b5c303132', 'file:/tmp/sajja/juicios/abiertos/');
INSERT INTO t_archivo VALUES (4, 'komodo-edit-7.desktop', '\x5b4465736b746f7020456e7472795d5c303132456e636f64696e673d5554462d385c3031324e616d653d4b6f6d6f646f204564697420375c30313247656e657269634e616d653d456469746f725c303132436f6d6d656e743d46726565206d756c74692d706c6174666f726d20656469746f722074686174206d616b6573206974206561737920746f207772697465207175616c69747920636f64652e5c303132457865633d2f686f6d652f70692f50726f6772616d732f4b6f6d6f646f2d456469742d372f6c69622f6d6f7a696c6c612f6b6f6d6f646f2025465c30313249636f6e3d2f686f6d652f70692f50726f6772616d732f4b6f6d6f646f2d456469742d372f73686172652f69636f6e732f6b6f6d6f646f34382e706e675c3031325465726d696e616c3d66616c73655c303132547970653d4170706c69636174696f6e5c3031324d696d65547970653d746578742f706c61696e3b5c30313243617465676f726965733d41637469766553746174653b4170706c69636174696f6e3b446576656c6f706d656e743b456469746f723b5574696c6974793b54657874456469746f723b5c303132', 'file:/tmp/sajja/juicios/abiertos/');


--
-- TOC entry 1909 (class 0 OID 211022)
-- Dependencies: 165 1910
-- Data for Name: t_escuela; Type: TABLE DATA; Schema: public; Owner: pruebas
--

INSERT INTO t_escuela VALUES (1, 'Escuela Primaria Benito Juárez', 32);
INSERT INTO t_escuela VALUES (2, 'Escuela Secundaria No. 99', 30);


--
-- TOC entry 1908 (class 0 OID 210902)
-- Dependencies: 163 1910
-- Data for Name: t_usuario; Type: TABLE DATA; Schema: public; Owner: pruebas
--

INSERT INTO t_usuario VALUES (1, 'brian', 'Hernandez', 'b@b.com', '12345', '56548287');
INSERT INTO t_usuario VALUES (20, 'Alex', 'Pimentel', 'alexpi@gmail.com', '123', '56895633');
INSERT INTO t_usuario VALUES (35, 'Chio', 'Ventura', 'chio@gmail.com', '123', '(55) 5789-5003');


--
-- TOC entry 1906 (class 2606 OID 211026)
-- Dependencies: 165 165 1911
-- Name: id_t_escuela_pk; Type: CONSTRAINT; Schema: public; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY t_escuela
    ADD CONSTRAINT id_t_escuela_pk PRIMARY KEY (id_t_escuela);


--
-- TOC entry 1902 (class 2606 OID 210911)
-- Dependencies: 162 162 1911
-- Name: t_archivo_pkey; Type: CONSTRAINT; Schema: public; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY t_archivo
    ADD CONSTRAINT t_archivo_pkey PRIMARY KEY (id_t_archivo);


--
-- TOC entry 1904 (class 2606 OID 210913)
-- Dependencies: 163 163 1911
-- Name: t_formulario_pkey; Type: CONSTRAINT; Schema: public; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY t_usuario
    ADD CONSTRAINT t_formulario_pkey PRIMARY KEY (id_t_usuario);


--
-- TOC entry 1916 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2012-11-05 15:41:51 CST

--
-- PostgreSQL database dump complete
--

