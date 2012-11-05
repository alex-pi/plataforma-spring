--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.6
-- Dumped by pg_dump version 9.1.6
-- Started on 2012-11-05 15:42:56 CST

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 6 (class 2615 OID 210914)
-- Name: seguridad; Type: SCHEMA; Schema: -; Owner: pruebas
--

CREATE SCHEMA seguridad;


ALTER SCHEMA seguridad OWNER TO pruebas;

--
-- TOC entry 174 (class 3079 OID 11681)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1980 (class 0 OID 0)
-- Dependencies: 174
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 162 (class 1259 OID 210915)
-- Dependencies: 7
-- Name: acl_class; Type: TABLE; Schema: public; Owner: pruebas; Tablespace: 
--

CREATE TABLE acl_class (
    id integer NOT NULL,
    class character varying(100) NOT NULL
);


ALTER TABLE public.acl_class OWNER TO pruebas;

--
-- TOC entry 163 (class 1259 OID 210918)
-- Dependencies: 7 162
-- Name: acl_class_id_seq; Type: SEQUENCE; Schema: public; Owner: pruebas
--

CREATE SEQUENCE acl_class_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.acl_class_id_seq OWNER TO pruebas;

--
-- TOC entry 1981 (class 0 OID 0)
-- Dependencies: 163
-- Name: acl_class_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: pruebas
--

ALTER SEQUENCE acl_class_id_seq OWNED BY acl_class.id;


--
-- TOC entry 1982 (class 0 OID 0)
-- Dependencies: 163
-- Name: acl_class_id_seq; Type: SEQUENCE SET; Schema: public; Owner: pruebas
--

SELECT pg_catalog.setval('acl_class_id_seq', 1, false);


--
-- TOC entry 164 (class 1259 OID 210920)
-- Dependencies: 7
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
-- TOC entry 165 (class 1259 OID 210923)
-- Dependencies: 164 7
-- Name: acl_entry_id_seq; Type: SEQUENCE; Schema: public; Owner: pruebas
--

CREATE SEQUENCE acl_entry_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.acl_entry_id_seq OWNER TO pruebas;

--
-- TOC entry 1983 (class 0 OID 0)
-- Dependencies: 165
-- Name: acl_entry_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: pruebas
--

ALTER SEQUENCE acl_entry_id_seq OWNED BY acl_entry.id;


--
-- TOC entry 1984 (class 0 OID 0)
-- Dependencies: 165
-- Name: acl_entry_id_seq; Type: SEQUENCE SET; Schema: public; Owner: pruebas
--

SELECT pg_catalog.setval('acl_entry_id_seq', 1, false);


--
-- TOC entry 166 (class 1259 OID 210925)
-- Dependencies: 7
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
-- TOC entry 167 (class 1259 OID 210928)
-- Dependencies: 166 7
-- Name: acl_object_identity_id_seq; Type: SEQUENCE; Schema: public; Owner: pruebas
--

CREATE SEQUENCE acl_object_identity_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.acl_object_identity_id_seq OWNER TO pruebas;

--
-- TOC entry 1985 (class 0 OID 0)
-- Dependencies: 167
-- Name: acl_object_identity_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: pruebas
--

ALTER SEQUENCE acl_object_identity_id_seq OWNED BY acl_object_identity.id;


--
-- TOC entry 1986 (class 0 OID 0)
-- Dependencies: 167
-- Name: acl_object_identity_id_seq; Type: SEQUENCE SET; Schema: public; Owner: pruebas
--

SELECT pg_catalog.setval('acl_object_identity_id_seq', 2, true);


--
-- TOC entry 168 (class 1259 OID 210930)
-- Dependencies: 7
-- Name: acl_sid; Type: TABLE; Schema: public; Owner: pruebas; Tablespace: 
--

CREATE TABLE acl_sid (
    id integer NOT NULL,
    principal boolean NOT NULL,
    sid character varying(100) NOT NULL
);


ALTER TABLE public.acl_sid OWNER TO pruebas;

--
-- TOC entry 169 (class 1259 OID 210933)
-- Dependencies: 168 7
-- Name: acl_sid_id_seq; Type: SEQUENCE; Schema: public; Owner: pruebas
--

CREATE SEQUENCE acl_sid_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.acl_sid_id_seq OWNER TO pruebas;

--
-- TOC entry 1987 (class 0 OID 0)
-- Dependencies: 169
-- Name: acl_sid_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: pruebas
--

ALTER SEQUENCE acl_sid_id_seq OWNED BY acl_sid.id;


--
-- TOC entry 1988 (class 0 OID 0)
-- Dependencies: 169
-- Name: acl_sid_id_seq; Type: SEQUENCE SET; Schema: public; Owner: pruebas
--

SELECT pg_catalog.setval('acl_sid_id_seq', 1, false);


SET search_path = seguridad, pg_catalog;

--
-- TOC entry 170 (class 1259 OID 210935)
-- Dependencies: 6
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
-- TOC entry 171 (class 1259 OID 210938)
-- Dependencies: 6
-- Name: t_r_usuario_rol; Type: TABLE; Schema: seguridad; Owner: pruebas; Tablespace: 
--

CREATE TABLE t_r_usuario_rol (
    id_tr_usuario integer NOT NULL,
    id_tr_rol integer NOT NULL
);


ALTER TABLE seguridad.t_r_usuario_rol OWNER TO pruebas;

--
-- TOC entry 172 (class 1259 OID 210941)
-- Dependencies: 1927 6
-- Name: t_rol_seguridad; Type: TABLE; Schema: seguridad; Owner: pruebas; Tablespace: 
--

CREATE TABLE t_rol_seguridad (
    id_t_rol integer NOT NULL,
    v_rol character varying(30) NOT NULL,
    l_rol_activo boolean DEFAULT true NOT NULL
);


ALTER TABLE seguridad.t_rol_seguridad OWNER TO pruebas;

--
-- TOC entry 173 (class 1259 OID 210945)
-- Dependencies: 1928 6
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
-- TOC entry 1923 (class 2604 OID 210949)
-- Dependencies: 163 162
-- Name: id; Type: DEFAULT; Schema: public; Owner: pruebas
--

ALTER TABLE ONLY acl_class ALTER COLUMN id SET DEFAULT nextval('acl_class_id_seq'::regclass);


--
-- TOC entry 1924 (class 2604 OID 210950)
-- Dependencies: 165 164
-- Name: id; Type: DEFAULT; Schema: public; Owner: pruebas
--

ALTER TABLE ONLY acl_entry ALTER COLUMN id SET DEFAULT nextval('acl_entry_id_seq'::regclass);


--
-- TOC entry 1925 (class 2604 OID 210951)
-- Dependencies: 167 166
-- Name: id; Type: DEFAULT; Schema: public; Owner: pruebas
--

ALTER TABLE ONLY acl_object_identity ALTER COLUMN id SET DEFAULT nextval('acl_object_identity_id_seq'::regclass);


--
-- TOC entry 1926 (class 2604 OID 210952)
-- Dependencies: 169 168
-- Name: id; Type: DEFAULT; Schema: public; Owner: pruebas
--

ALTER TABLE ONLY acl_sid ALTER COLUMN id SET DEFAULT nextval('acl_sid_id_seq'::regclass);


--
-- TOC entry 1965 (class 0 OID 210915)
-- Dependencies: 162 1973
-- Data for Name: acl_class; Type: TABLE DATA; Schema: public; Owner: pruebas
--

INSERT INTO acl_class VALUES (1, 'mx.sep.seguridad.modelo.ModuloMenu');
INSERT INTO acl_class VALUES (2, 'mx.sep.seguridad.modelo.OpcionMenu');


--
-- TOC entry 1966 (class 0 OID 210920)
-- Dependencies: 164 1973
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
-- TOC entry 1967 (class 0 OID 210925)
-- Dependencies: 166 1973
-- Data for Name: acl_object_identity; Type: TABLE DATA; Schema: public; Owner: pruebas
--

INSERT INTO acl_object_identity VALUES (1, false, 6, 1, NULL, 3);
INSERT INTO acl_object_identity VALUES (3, true, 11, 1, NULL, 3);
INSERT INTO acl_object_identity VALUES (2, true, 10, 1, NULL, 3);


--
-- TOC entry 1968 (class 0 OID 210930)
-- Dependencies: 168 1973
-- Data for Name: acl_sid; Type: TABLE DATA; Schema: public; Owner: pruebas
--

INSERT INTO acl_sid VALUES (1, false, 'ROLE_USUARIO');
INSERT INTO acl_sid VALUES (2, false, 'ROLE_USUARIO2');
INSERT INTO acl_sid VALUES (3, false, 'ROLE_ADMINISTRADOR');


SET search_path = seguridad, pg_catalog;

--
-- TOC entry 1969 (class 0 OID 210935)
-- Dependencies: 170 1973
-- Data for Name: t_opcion_menu; Type: TABLE DATA; Schema: seguridad; Owner: pruebas
--

INSERT INTO t_opcion_menu VALUES (2, 'Creación de módulo', 'Creación de módulo', 'ejemplos/modulo', 1);
INSERT INTO t_opcion_menu VALUES (4, 'Ejemplos intermedios', 'Ejemplos intermedios', NULL, 6);
INSERT INTO t_opcion_menu VALUES (1, 'Ejemplos simples', 'Ejemplos simples', NULL, 6);
INSERT INTO t_opcion_menu VALUES (3, 'Manejo de Tabs', 'Manejo de Tabs', ' ', 1);
INSERT INTO t_opcion_menu VALUES (8, 'Usuarios y roles', 'Usuarios y roles', ' ', 7);
INSERT INTO t_opcion_menu VALUES (9, 'Control de accesos', 'Control de accesos', ' ', 7);
INSERT INTO t_opcion_menu VALUES (11, 'Configuraciones', 'Configuraciones', NULL, NULL);
INSERT INTO t_opcion_menu VALUES (7, 'Seguridad', 'Seguridad', NULL, 11);
INSERT INTO t_opcion_menu VALUES (12, 'Resolución de contenido', 'Resolución de contenido', 'ejemplos/controllerJsp', 1);
INSERT INTO t_opcion_menu VALUES (13, 'Carga de archivo', 'Carga de archivo', 'ejemplos/cargaArchivos', 4);
INSERT INTO t_opcion_menu VALUES (14, 'Manejo de errores', 'Manejo de errores', 'ejemplos/manejoErrores', 1);
INSERT INTO t_opcion_menu VALUES (15, 'Formulario', 'Formulario', 'ejemplos/formulario', 1);
INSERT INTO t_opcion_menu VALUES (16, 'Descarga archivo', 'Descarga archivo', 'ejemplos/descargaArchivo', 4);
INSERT INTO t_opcion_menu VALUES (5, 'Grid simple', 'Grid simple', 'ejemplos/gridSimple', 4);
INSERT INTO t_opcion_menu VALUES (17, 'Grid paginado', 'Grid paginado', 'ejemplos/gridPaginado', 4);
INSERT INTO t_opcion_menu VALUES (6, 'Ejemplos SmartSol', 'Ejemplos SmartSol', NULL, NULL);
INSERT INTO t_opcion_menu VALUES (10, 'Ejercicios SmartSol', 'Ejercicios SmartSol', NULL, NULL);
INSERT INTO t_opcion_menu VALUES (18, 'Ejemplo cache', 'Ejemplo cache', 'ejemplos/escuelas', 4);
INSERT INTO t_opcion_menu VALUES (19, 'Pantalla juicios', 'Pantalla juicios', 'juicios/civil/reqjudicial/initCharola', 4);


--
-- TOC entry 1970 (class 0 OID 210938)
-- Dependencies: 171 1973
-- Data for Name: t_r_usuario_rol; Type: TABLE DATA; Schema: seguridad; Owner: pruebas
--

INSERT INTO t_r_usuario_rol VALUES (1, 3);
INSERT INTO t_r_usuario_rol VALUES (3, 2);
INSERT INTO t_r_usuario_rol VALUES (2, 1);
INSERT INTO t_r_usuario_rol VALUES (2, 2);


--
-- TOC entry 1971 (class 0 OID 210941)
-- Dependencies: 172 1973
-- Data for Name: t_rol_seguridad; Type: TABLE DATA; Schema: seguridad; Owner: pruebas
--

INSERT INTO t_rol_seguridad VALUES (2, 'ROLE_USUARIO2', true);
INSERT INTO t_rol_seguridad VALUES (3, 'ROLE_ADMINISTRADOR', true);
INSERT INTO t_rol_seguridad VALUES (1, 'ROLE_USUARIO', true);


--
-- TOC entry 1972 (class 0 OID 210945)
-- Dependencies: 173 1973
-- Data for Name: t_usuario_seguridad; Type: TABLE DATA; Schema: seguridad; Owner: pruebas
--

INSERT INTO t_usuario_seguridad VALUES (1, 'pi', 'pipo', 'Alejandro Pimentel', true);
INSERT INTO t_usuario_seguridad VALUES (2, 'brian', 'briantu', 'Brian Hernandez', true);
INSERT INTO t_usuario_seguridad VALUES (3, 'carlos', 'freeman', 'Carlos Urbina', true);


SET search_path = public, pg_catalog;

--
-- TOC entry 1930 (class 2606 OID 210954)
-- Dependencies: 162 162 1974
-- Name: acl_class_class_key; Type: CONSTRAINT; Schema: public; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY acl_class
    ADD CONSTRAINT acl_class_class_key UNIQUE (class);


--
-- TOC entry 1932 (class 2606 OID 210956)
-- Dependencies: 162 162 1974
-- Name: acl_class_pkey; Type: CONSTRAINT; Schema: public; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY acl_class
    ADD CONSTRAINT acl_class_pkey PRIMARY KEY (id);


--
-- TOC entry 1934 (class 2606 OID 210958)
-- Dependencies: 164 164 164 1974
-- Name: acl_entry_acl_object_identity_key; Type: CONSTRAINT; Schema: public; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY acl_entry
    ADD CONSTRAINT acl_entry_acl_object_identity_key UNIQUE (acl_object_identity, ace_order);


--
-- TOC entry 1936 (class 2606 OID 210960)
-- Dependencies: 164 164 1974
-- Name: acl_entry_pkey; Type: CONSTRAINT; Schema: public; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY acl_entry
    ADD CONSTRAINT acl_entry_pkey PRIMARY KEY (id);


--
-- TOC entry 1938 (class 2606 OID 210962)
-- Dependencies: 166 166 166 1974
-- Name: acl_object_identity_object_id_class_key; Type: CONSTRAINT; Schema: public; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY acl_object_identity
    ADD CONSTRAINT acl_object_identity_object_id_class_key UNIQUE (object_id_class, object_id_identity);


--
-- TOC entry 1940 (class 2606 OID 210964)
-- Dependencies: 166 166 1974
-- Name: acl_object_identity_pkey; Type: CONSTRAINT; Schema: public; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY acl_object_identity
    ADD CONSTRAINT acl_object_identity_pkey PRIMARY KEY (id);


--
-- TOC entry 1942 (class 2606 OID 210966)
-- Dependencies: 168 168 1974
-- Name: acl_sid_pkey; Type: CONSTRAINT; Schema: public; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY acl_sid
    ADD CONSTRAINT acl_sid_pkey PRIMARY KEY (id);


--
-- TOC entry 1944 (class 2606 OID 210968)
-- Dependencies: 168 168 168 1974
-- Name: acl_sid_sid_key; Type: CONSTRAINT; Schema: public; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY acl_sid
    ADD CONSTRAINT acl_sid_sid_key UNIQUE (sid, principal);


SET search_path = seguridad, pg_catalog;

--
-- TOC entry 1947 (class 2606 OID 210970)
-- Dependencies: 170 170 1974
-- Name: t_opcion_pkey; Type: CONSTRAINT; Schema: seguridad; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY t_opcion_menu
    ADD CONSTRAINT t_opcion_pkey PRIMARY KEY (id_t_opcion);


--
-- TOC entry 1949 (class 2606 OID 210972)
-- Dependencies: 171 171 171 1974
-- Name: t_r_usuario_rol_pkey; Type: CONSTRAINT; Schema: seguridad; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY t_r_usuario_rol
    ADD CONSTRAINT t_r_usuario_rol_pkey PRIMARY KEY (id_tr_usuario, id_tr_rol);


--
-- TOC entry 1951 (class 2606 OID 210974)
-- Dependencies: 172 172 1974
-- Name: t_rol_seguridad_pkey; Type: CONSTRAINT; Schema: seguridad; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY t_rol_seguridad
    ADD CONSTRAINT t_rol_seguridad_pkey PRIMARY KEY (id_t_rol);


--
-- TOC entry 1953 (class 2606 OID 210976)
-- Dependencies: 172 172 1974
-- Name: t_rol_seguridad_v_rol_key; Type: CONSTRAINT; Schema: seguridad; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY t_rol_seguridad
    ADD CONSTRAINT t_rol_seguridad_v_rol_key UNIQUE (v_rol);


--
-- TOC entry 1955 (class 2606 OID 210978)
-- Dependencies: 173 173 1974
-- Name: t_usuario_seguridad_pkey; Type: CONSTRAINT; Schema: seguridad; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY t_usuario_seguridad
    ADD CONSTRAINT t_usuario_seguridad_pkey PRIMARY KEY (id_t_usuario);


--
-- TOC entry 1957 (class 2606 OID 210980)
-- Dependencies: 173 173 1974
-- Name: t_usuario_seguridad_v_username_key; Type: CONSTRAINT; Schema: seguridad; Owner: pruebas; Tablespace: 
--

ALTER TABLE ONLY t_usuario_seguridad
    ADD CONSTRAINT t_usuario_seguridad_v_username_key UNIQUE (v_username);


--
-- TOC entry 1945 (class 1259 OID 210981)
-- Dependencies: 170 1974
-- Name: fki_t_opcion_padre; Type: INDEX; Schema: seguridad; Owner: pruebas; Tablespace: 
--

CREATE INDEX fki_t_opcion_padre ON t_opcion_menu USING btree (id_t_opcion);


SET search_path = public, pg_catalog;

--
-- TOC entry 1958 (class 2606 OID 210982)
-- Dependencies: 166 164 1939 1974
-- Name: fk_acl_entry_acl_object_identity; Type: FK CONSTRAINT; Schema: public; Owner: pruebas
--

ALTER TABLE ONLY acl_entry
    ADD CONSTRAINT fk_acl_entry_acl_object_identity FOREIGN KEY (acl_object_identity) REFERENCES acl_object_identity(id);


--
-- TOC entry 1959 (class 2606 OID 210987)
-- Dependencies: 1941 164 168 1974
-- Name: fk_acl_entry_acl_sid; Type: FK CONSTRAINT; Schema: public; Owner: pruebas
--

ALTER TABLE ONLY acl_entry
    ADD CONSTRAINT fk_acl_entry_acl_sid FOREIGN KEY (sid) REFERENCES acl_sid(id);


--
-- TOC entry 1960 (class 2606 OID 210992)
-- Dependencies: 162 166 1931 1974
-- Name: fk_acl_object_identity_acl_class; Type: FK CONSTRAINT; Schema: public; Owner: pruebas
--

ALTER TABLE ONLY acl_object_identity
    ADD CONSTRAINT fk_acl_object_identity_acl_class FOREIGN KEY (object_id_class) REFERENCES acl_class(id);


--
-- TOC entry 1961 (class 2606 OID 210997)
-- Dependencies: 166 1941 168 1974
-- Name: fk_acl_object_identity_acl_sid; Type: FK CONSTRAINT; Schema: public; Owner: pruebas
--

ALTER TABLE ONLY acl_object_identity
    ADD CONSTRAINT fk_acl_object_identity_acl_sid FOREIGN KEY (owner_sid) REFERENCES acl_sid(id);


SET search_path = seguridad, pg_catalog;

--
-- TOC entry 1962 (class 2606 OID 211002)
-- Dependencies: 170 170 1946 1974
-- Name: fk_t_opcion_padre; Type: FK CONSTRAINT; Schema: seguridad; Owner: pruebas
--

ALTER TABLE ONLY t_opcion_menu
    ADD CONSTRAINT fk_t_opcion_padre FOREIGN KEY (id_t_opcion) REFERENCES t_opcion_menu(id_t_opcion);


--
-- TOC entry 1963 (class 2606 OID 211007)
-- Dependencies: 172 171 1950 1974
-- Name: t_r_usuario_rol_id_tr_rol_fkey; Type: FK CONSTRAINT; Schema: seguridad; Owner: pruebas
--

ALTER TABLE ONLY t_r_usuario_rol
    ADD CONSTRAINT t_r_usuario_rol_id_tr_rol_fkey FOREIGN KEY (id_tr_rol) REFERENCES t_rol_seguridad(id_t_rol);


--
-- TOC entry 1964 (class 2606 OID 211012)
-- Dependencies: 1954 173 171 1974
-- Name: t_r_usuario_rol_id_tr_usuario_fkey; Type: FK CONSTRAINT; Schema: seguridad; Owner: pruebas
--

ALTER TABLE ONLY t_r_usuario_rol
    ADD CONSTRAINT t_r_usuario_rol_id_tr_usuario_fkey FOREIGN KEY (id_tr_usuario) REFERENCES t_usuario_seguridad(id_t_usuario);


--
-- TOC entry 1979 (class 0 OID 0)
-- Dependencies: 7
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2012-11-05 15:42:56 CST

--
-- PostgreSQL database dump complete
--

