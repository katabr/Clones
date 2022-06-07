--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.23
-- Dumped by pg_dump version 9.6.23

-- Started on 2022-06-06 18:23:18 MSK

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12431)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2169 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 185 (class 1259 OID 267676)
-- Name: breed; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.breed (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE public.breed OWNER TO postgres;

--
-- TOC entry 2170 (class 0 OID 0)
-- Dependencies: 185
-- Name: TABLE breed; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.breed IS 'Таблица с породами кошек';


--
-- TOC entry 2171 (class 0 OID 0)
-- Dependencies: 185
-- Name: COLUMN breed.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.breed.id IS 'Идентификатор записи';


--
-- TOC entry 2172 (class 0 OID 0)
-- Dependencies: 185
-- Name: COLUMN breed.name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.breed.name IS 'Название породы';


--
-- TOC entry 2161 (class 0 OID 267676)
-- Dependencies: 185
-- Data for Name: breed; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.breed (id, name) FROM stdin;
1	Мексиканская
2	Классическая
3	С чипсами
\.


--
-- TOC entry 2043 (class 2606 OID 267683)
-- Name: breed breed_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.breed
    ADD CONSTRAINT breed_pkey PRIMARY KEY (id);


-- Completed on 2022-06-06 18:23:18 MSK

--
-- PostgreSQL database dump complete
--

