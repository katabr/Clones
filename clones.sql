--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.23
-- Dumped by pg_dump version 9.6.23

-- Started on 2022-06-07 13:00:05 MSK

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
-- TOC entry 2180 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 187 (class 1259 OID 267686)
-- Name: clone; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.clone (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE public.clone OWNER TO postgres;

--
-- TOC entry 2181 (class 0 OID 0)
-- Dependencies: 187
-- Name: TABLE clone; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.clone IS 'Таблица с клонами';


--
-- TOC entry 2182 (class 0 OID 0)
-- Dependencies: 187
-- Name: COLUMN clone.id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.clone.id IS 'Идентификатор записи';


--
-- TOC entry 2183 (class 0 OID 0)
-- Dependencies: 187
-- Name: COLUMN clone.name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.clone.name IS 'Имя клона';


--
-- TOC entry 186 (class 1259 OID 267684)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 4
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 267676)
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."user" (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE public."user" OWNER TO postgres;

--
-- TOC entry 2184 (class 0 OID 0)
-- Dependencies: 185
-- Name: TABLE "user"; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public."user" IS 'Таблица с пользователями';


--
-- TOC entry 2185 (class 0 OID 0)
-- Dependencies: 185
-- Name: COLUMN "user".id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public."user".id IS 'Идентификатор записи';


--
-- TOC entry 2186 (class 0 OID 0)
-- Dependencies: 185
-- Name: COLUMN "user".name; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public."user".name IS 'Имя пользователя';


--
-- TOC entry 2172 (class 0 OID 267686)
-- Dependencies: 187
-- Data for Name: clone; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.clone (id, name) FROM stdin;
1	Первый клон
2	Второй клон
\.


--
-- TOC entry 2187 (class 0 OID 0)
-- Dependencies: 186
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 4, false);


--
-- TOC entry 2170 (class 0 OID 267676)
-- Dependencies: 185
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."user" (id, name) FROM stdin;
1	Мексиканская
2	Классическая
3	С чипсами
\.


--
-- TOC entry 2052 (class 2606 OID 267693)
-- Name: clone clone_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clone
    ADD CONSTRAINT clone_pkey PRIMARY KEY (id);


--
-- TOC entry 2050 (class 2606 OID 267695)
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


-- Completed on 2022-06-07 13:00:06 MSK

--
-- PostgreSQL database dump complete
--

