--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

--
-- Name: t_archivo_seq; Type: SEQUENCE; Schema: public; Owner: pruebas
--

CREATE SEQUENCE t_archivo_seq
    START WITH 3
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.t_archivo_seq OWNER TO pruebas;

SET default_tablespace = '';

SET default_with_oids = false;

--
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
-- Name: t_usuario_seq; Type: SEQUENCE; Schema: public; Owner: pruebas
--

CREATE SEQUENCE t_usuario_seq
    START WITH 16
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.t_usuario_seq OWNER TO pruebas;

--
-- Name: t_archivo_pkey; Type: CONSTRAINT; Schema: public; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY t_archivo
    ADD CONSTRAINT t_archivo_pkey PRIMARY KEY (id_t_archivo);


--
-- Name: t_formulario_pkey; Type: CONSTRAINT; Schema: public; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY t_usuario
    ADD CONSTRAINT t_formulario_pkey PRIMARY KEY (id_t_usuario);


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

