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
-- Name: t_archivo_seq; Type: SEQUENCE SET; Schema: public; Owner: pruebas
--

SELECT pg_catalog.setval('t_archivo_seq', 3, false);


--
-- Name: t_formulario_seq; Type: SEQUENCE SET; Schema: public; Owner: pruebas
--

SELECT pg_catalog.setval('t_formulario_seq', 18, true);


--
-- Data for Name: t_archivo; Type: TABLE DATA; Schema: public; Owner: pruebas
--



--
-- Data for Name: t_formulario; Type: TABLE DATA; Schema: public; Owner: pruebas
--

INSERT INTO t_formulario VALUES (1, 'brian', 'Hernandez', 'b@b.com', '12345', '56548287');


--
-- PostgreSQL database dump complete
--

