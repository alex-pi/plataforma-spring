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
-- Name: seguridad; Type: SCHEMA; Schema: -; Owner: pruebas
--

CREATE SCHEMA seguridad;


ALTER SCHEMA seguridad OWNER TO pruebas;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: acl_class; Type: TABLE; Schema: public; Owner: pruebas; Tablespace: 
--

CREATE TABLE acl_class (
    id integer NOT NULL,
    class character varying(100) NOT NULL
);


ALTER TABLE public.acl_class OWNER TO pruebas;

--
-- Name: acl_class_id_seq; Type: SEQUENCE; Schema: public; Owner: pruebas
--

CREATE SEQUENCE acl_class_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.acl_class_id_seq OWNER TO pruebas;

--
-- Name: acl_class_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: pruebas
--

ALTER SEQUENCE acl_class_id_seq OWNED BY acl_class.id;


--
-- Name: acl_class_id_seq; Type: SEQUENCE SET; Schema: public; Owner: pruebas
--

SELECT pg_catalog.setval('acl_class_id_seq', 1, false);


--
-- Name: acl_entry; Type: TABLE; Schema: public; Owner: pruebas; Tablespace: 
--

CREATE TABLE acl_entry (
    id integer NOT NULL,
    ace_order integer NOT NULL,
    audit_failure boolean NOT NULL,
    audit_success boolean NOT NULL,
    granting boolean NOT NULL,
    mask integer NOT NULL,
    acl_object_identity integer NOT NULL,
    sid integer NOT NULL
);


ALTER TABLE public.acl_entry OWNER TO pruebas;

--
-- Name: acl_entry_id_seq; Type: SEQUENCE; Schema: public; Owner: pruebas
--

CREATE SEQUENCE acl_entry_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.acl_entry_id_seq OWNER TO pruebas;

--
-- Name: acl_entry_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: pruebas
--

ALTER SEQUENCE acl_entry_id_seq OWNED BY acl_entry.id;


--
-- Name: acl_entry_id_seq; Type: SEQUENCE SET; Schema: public; Owner: pruebas
--

SELECT pg_catalog.setval('acl_entry_id_seq', 1, false);


--
-- Name: acl_object_identity; Type: TABLE; Schema: public; Owner: pruebas; Tablespace: 
--

CREATE TABLE acl_object_identity (
    id integer NOT NULL,
    entries_inheriting boolean NOT NULL,
    object_id_identity integer NOT NULL,
    object_id_class integer NOT NULL,
    parent_object integer,
    owner_sid integer
);


ALTER TABLE public.acl_object_identity OWNER TO pruebas;

--
-- Name: acl_object_identity_id_seq; Type: SEQUENCE; Schema: public; Owner: pruebas
--

CREATE SEQUENCE acl_object_identity_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.acl_object_identity_id_seq OWNER TO pruebas;

--
-- Name: acl_object_identity_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: pruebas
--

ALTER SEQUENCE acl_object_identity_id_seq OWNED BY acl_object_identity.id;


--
-- Name: acl_object_identity_id_seq; Type: SEQUENCE SET; Schema: public; Owner: pruebas
--

SELECT pg_catalog.setval('acl_object_identity_id_seq', 2, true);


--
-- Name: acl_sid; Type: TABLE; Schema: public; Owner: pruebas; Tablespace: 
--

CREATE TABLE acl_sid (
    id integer NOT NULL,
    principal boolean NOT NULL,
    sid character varying(100) NOT NULL
);


ALTER TABLE public.acl_sid OWNER TO pruebas;

--
-- Name: acl_sid_id_seq; Type: SEQUENCE; Schema: public; Owner: pruebas
--

CREATE SEQUENCE acl_sid_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;


ALTER TABLE public.acl_sid_id_seq OWNER TO pruebas;

--
-- Name: acl_sid_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: pruebas
--

ALTER SEQUENCE acl_sid_id_seq OWNED BY acl_sid.id;


--
-- Name: acl_sid_id_seq; Type: SEQUENCE SET; Schema: public; Owner: pruebas
--

SELECT pg_catalog.setval('acl_sid_id_seq', 1, false);


SET search_path = seguridad, pg_catalog;

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

SET search_path = public, pg_catalog;

--
-- Name: id; Type: DEFAULT; Schema: public; Owner: pruebas
--

ALTER TABLE ONLY acl_class ALTER COLUMN id SET DEFAULT nextval('acl_class_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: pruebas
--

ALTER TABLE ONLY acl_entry ALTER COLUMN id SET DEFAULT nextval('acl_entry_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: pruebas
--

ALTER TABLE ONLY acl_object_identity ALTER COLUMN id SET DEFAULT nextval('acl_object_identity_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: pruebas
--

ALTER TABLE ONLY acl_sid ALTER COLUMN id SET DEFAULT nextval('acl_sid_id_seq'::regclass);


--
-- Data for Name: acl_class; Type: TABLE DATA; Schema: public; Owner: pruebas
--

INSERT INTO acl_class VALUES (1, 'mx.sep.seguridad.modelo.ModuloMenu');
INSERT INTO acl_class VALUES (2, 'mx.sep.seguridad.modelo.OpcionMenu');


--
-- Data for Name: acl_entry; Type: TABLE DATA; Schema: public; Owner: pruebas
--

INSERT INTO acl_entry VALUES (1, 1, true, true, true, 1, 1, 3);
INSERT INTO acl_entry VALUES (2, 1, true, true, true, 1, 2, 3);
INSERT INTO acl_entry VALUES (3, 1, true, true, true, 1, 3, 3);
INSERT INTO acl_entry VALUES (4, 2, true, true, true, 1, 1, 1);
INSERT INTO acl_entry VALUES (5, 2, true, true, true, 1, 2, 1);
INSERT INTO acl_entry VALUES (6, 2, true, true, false, 1, 3, 1);
INSERT INTO acl_entry VALUES (7, 3, true, true, false, 1, 1, 2);
INSERT INTO acl_entry VALUES (8, 3, true, true, true, 1, 2, 2);
INSERT INTO acl_entry VALUES (9, 3, true, true, false, 1, 3, 2);


--
-- Data for Name: acl_object_identity; Type: TABLE DATA; Schema: public; Owner: pruebas
--

INSERT INTO acl_object_identity VALUES (1, false, 6, 1, NULL, 3);
INSERT INTO acl_object_identity VALUES (3, true, 11, 1, NULL, 3);
INSERT INTO acl_object_identity VALUES (2, true, 10, 1, NULL, 3);


--
-- Data for Name: acl_sid; Type: TABLE DATA; Schema: public; Owner: pruebas
--

INSERT INTO acl_sid VALUES (1, false, 'ROLE_USUARIO');
INSERT INTO acl_sid VALUES (2, false, 'ROLE_USUARIO2');
INSERT INTO acl_sid VALUES (3, false, 'ROLE_ADMINISTRADOR');


SET search_path = seguridad, pg_catalog;

--
-- Data for Name: t_opcion_menu; Type: TABLE DATA; Schema: seguridad; Owner: pruebas
--

INSERT INTO t_opcion_menu VALUES (2, 'Creación de módulo', 'Creación de módulo', 'ejemplos/modulo', 1);
INSERT INTO t_opcion_menu VALUES (4, 'Ejemplos intermedios', 'Ejemplos intermedios', NULL, 6);
INSERT INTO t_opcion_menu VALUES (1, 'Ejemplos simples', 'Ejemplos simples', NULL, 6);
INSERT INTO t_opcion_menu VALUES (3, 'Manejo de Tabs', 'Manejo de Tabs', ' ', 1);
INSERT INTO t_opcion_menu VALUES (8, 'Usuarios y roles', 'Usuarios y roles', ' ', 7);
INSERT INTO t_opcion_menu VALUES (9, 'Control de accesos', 'Control de accesos', ' ', 7);
INSERT INTO t_opcion_menu VALUES (10, 'Ejercicios SmartSol', 'Ejercicios SmartSol', NULL, NULL);
INSERT INTO t_opcion_menu VALUES (11, 'Configuraciones', 'Configuraciones', NULL, NULL);
INSERT INTO t_opcion_menu VALUES (7, 'Seguridad', 'Seguridad', NULL, 11);
INSERT INTO t_opcion_menu VALUES (12, 'Resolución de contenido', 'Resolución de contenido', 'ejemplos/controllerJsp', 1);
INSERT INTO t_opcion_menu VALUES (13, 'Carga de archivo', 'Carga de archivo', 'ejemplos/cargaArchivos', 4);
INSERT INTO t_opcion_menu VALUES (14, 'Manejo de errores', 'Manejo de errores', 'ejemplos/manejoErrores', 1);
INSERT INTO t_opcion_menu VALUES (6, 'Ejemplos SmartSol', 'Ejemplos SmartSol', NULL, NULL);
INSERT INTO t_opcion_menu VALUES (15, 'Formulario', 'Formulario', 'ejemplos/formulario', 1);
INSERT INTO t_opcion_menu VALUES (16, 'Descarga archivo', 'Descarga archivo', 'ejemplos/descargaArchivo', 4);
INSERT INTO t_opcion_menu VALUES (5, 'Grid simple', 'Grid simple', 'ejemplos/gridSimple', 4);
INSERT INTO t_opcion_menu VALUES (17, 'Grid paginado', 'Grid paginado', 'ejemplos/gridPaginado', 4);


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

INSERT INTO t_rol_seguridad VALUES (2, 'ROLE_USUARIO2', true);
INSERT INTO t_rol_seguridad VALUES (3, 'ROLE_ADMINISTRADOR', true);
INSERT INTO t_rol_seguridad VALUES (1, 'ROLE_USUARIO', true);


--
-- Data for Name: t_usuario_seguridad; Type: TABLE DATA; Schema: seguridad; Owner: pruebas
--

INSERT INTO t_usuario_seguridad VALUES (1, 'pi', 'pipo', 'Alejandro Pimentel', true);
INSERT INTO t_usuario_seguridad VALUES (2, 'brian', 'briantu', 'Brian Hernandez', true);
INSERT INTO t_usuario_seguridad VALUES (3, 'carlos', 'freeman', 'Carlos Urbina', true);


SET search_path = public, pg_catalog;

--
-- Name: acl_class_class_key; Type: CONSTRAINT; Schema: public; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY acl_class
    ADD CONSTRAINT acl_class_class_key UNIQUE (class);


--
-- Name: acl_class_pkey; Type: CONSTRAINT; Schema: public; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY acl_class
    ADD CONSTRAINT acl_class_pkey PRIMARY KEY (id);


--
-- Name: acl_entry_acl_object_identity_key; Type: CONSTRAINT; Schema: public; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY acl_entry
    ADD CONSTRAINT acl_entry_acl_object_identity_key UNIQUE (acl_object_identity, ace_order);


--
-- Name: acl_entry_pkey; Type: CONSTRAINT; Schema: public; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY acl_entry
    ADD CONSTRAINT acl_entry_pkey PRIMARY KEY (id);


--
-- Name: acl_object_identity_object_id_class_key; Type: CONSTRAINT; Schema: public; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY acl_object_identity
    ADD CONSTRAINT acl_object_identity_object_id_class_key UNIQUE (object_id_class, object_id_identity);


--
-- Name: acl_object_identity_pkey; Type: CONSTRAINT; Schema: public; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY acl_object_identity
    ADD CONSTRAINT acl_object_identity_pkey PRIMARY KEY (id);


--
-- Name: acl_sid_pkey; Type: CONSTRAINT; Schema: public; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY acl_sid
    ADD CONSTRAINT acl_sid_pkey PRIMARY KEY (id);


--
-- Name: acl_sid_sid_key; Type: CONSTRAINT; Schema: public; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY acl_sid
    ADD CONSTRAINT acl_sid_sid_key UNIQUE (sid, principal);


SET search_path = seguridad, pg_catalog;

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


SET search_path = public, pg_catalog;

--
-- Name: fk_acl_entry_acl_object_identity; Type: FK CONSTRAINT; Schema: public; Owner: pruebas
--

ALTER TABLE ONLY acl_entry
    ADD CONSTRAINT fk_acl_entry_acl_object_identity FOREIGN KEY (acl_object_identity) REFERENCES acl_object_identity(id);


--
-- Name: fk_acl_entry_acl_sid; Type: FK CONSTRAINT; Schema: public; Owner: pruebas
--

ALTER TABLE ONLY acl_entry
    ADD CONSTRAINT fk_acl_entry_acl_sid FOREIGN KEY (sid) REFERENCES acl_sid(id);


--
-- Name: fk_acl_object_identity_acl_class; Type: FK CONSTRAINT; Schema: public; Owner: pruebas
--

ALTER TABLE ONLY acl_object_identity
    ADD CONSTRAINT fk_acl_object_identity_acl_class FOREIGN KEY (object_id_class) REFERENCES acl_class(id);


--
-- Name: fk_acl_object_identity_acl_sid; Type: FK CONSTRAINT; Schema: public; Owner: pruebas
--

ALTER TABLE ONLY acl_object_identity
    ADD CONSTRAINT fk_acl_object_identity_acl_sid FOREIGN KEY (owner_sid) REFERENCES acl_sid(id);


SET search_path = seguridad, pg_catalog;

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

