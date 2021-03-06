--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: clients; Type: TABLE; Schema: public; Owner: mf
--

CREATE TABLE clients (
    id integer NOT NULL,
    stylistid integer,
    name character varying,
    phone character varying,
    address character varying,
    email character varying,
    special_details character varying,
    preferred_stylist character varying,
    emergency_name character varying,
    emergency_phone character varying,
    ok_to_text boolean
);


ALTER TABLE clients OWNER TO mf;

--
-- Name: clients_id_seq; Type: SEQUENCE; Schema: public; Owner: mf
--

CREATE SEQUENCE clients_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE clients_id_seq OWNER TO mf;

--
-- Name: clients_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mf
--

ALTER SEQUENCE clients_id_seq OWNED BY clients.id;


--
-- Name: stylists; Type: TABLE; Schema: public; Owner: mf
--

CREATE TABLE stylists (
    id integer NOT NULL,
    name character varying,
    hours character varying,
    specialties character varying,
    pathtoimg character varying
);


ALTER TABLE stylists OWNER TO mf;

--
-- Name: stylists_id_seq; Type: SEQUENCE; Schema: public; Owner: mf
--

CREATE SEQUENCE stylists_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE stylists_id_seq OWNER TO mf;

--
-- Name: stylists_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mf
--

ALTER SEQUENCE stylists_id_seq OWNED BY stylists.id;


--
-- Name: clients id; Type: DEFAULT; Schema: public; Owner: mf
--

ALTER TABLE ONLY clients ALTER COLUMN id SET DEFAULT nextval('clients_id_seq'::regclass);


--
-- Name: stylists id; Type: DEFAULT; Schema: public; Owner: mf
--

ALTER TABLE ONLY stylists ALTER COLUMN id SET DEFAULT nextval('stylists_id_seq'::regclass);


--
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: mf
--

COPY clients (id, stylistid, name, phone, address, email, special_details, preferred_stylist, emergency_name, emergency_phone, ok_to_text) FROM stdin;
1	1	Magnolia Crawford	5556667777	123 Forgotten Lane Portland, OR 97203	neverbooked@gmail.com	frequent no-show	Naomi Smalls	Ron Swanson	5556667778	t
2	1	Jiggly Caliente	5556668888	123 Baked Potato Lane Portland, OR 97203	bustedgrill@gmail.com	chatty client	Naomi Smalls	Ronald McDonald	5556668889	f
\.


--
-- Name: clients_id_seq; Type: SEQUENCE SET; Schema: public; Owner: mf
--

SELECT pg_catalog.setval('clients_id_seq', 2, true);


--
-- Data for Name: stylists; Type: TABLE DATA; Schema: public; Owner: mf
--

COPY stylists (id, name, hours, specialties, pathtoimg) FROM stdin;
3	Test1	09:00-16:00MTRF	color	../../resources/public/images/dummy.jpg
1	Naomi Smalls	09:00-17:00MWF	hair, color, extensions	/images/naomi.jpg
2	Kim Chi	09:00-17:00TR	hair, color	/images/kimchi.jpg
\.


--
-- Name: stylists_id_seq; Type: SEQUENCE SET; Schema: public; Owner: mf
--

SELECT pg_catalog.setval('stylists_id_seq', 3, true);


--
-- Name: clients clients_pkey; Type: CONSTRAINT; Schema: public; Owner: mf
--

ALTER TABLE ONLY clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);


--
-- Name: stylists stylists_pkey; Type: CONSTRAINT; Schema: public; Owner: mf
--

ALTER TABLE ONLY stylists
    ADD CONSTRAINT stylists_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

