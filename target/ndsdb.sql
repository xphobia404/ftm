--
-- PostgreSQL database dump
--

-- Dumped from database version 16.8
-- Dumped by pg_dump version 16.8

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: accounts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.accounts (
    account_id character varying(255) NOT NULL,
    user_id character varying(255) NOT NULL,
    balance integer DEFAULT 0,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE public.accounts OWNER TO postgres;

--
-- Name: transactions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transactions (
    transaction_id character varying(255) NOT NULL,
    account_id character varying(255) NOT NULL,
    type character varying(20) NOT NULL,
    amount integer NOT NULL,
    "timestamp" timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE public.transactions OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    user_id character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Data for Name: accounts; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.accounts (account_id, user_id, balance, created_at, updated_at) FROM stdin;
a6d3dd51-862b-4beb-a72a-f4f063827f38	0546e323-80c0-41e3-8e43-2deceb16661f	99850	2025-03-06 22:20:16.269136	\N
\.


--
-- Data for Name: transactions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.transactions (transaction_id, account_id, type, amount, "timestamp") FROM stdin;
84050bc5-9c55-4dab-a128-763caeedf345	a6d3dd51-862b-4beb-a72a-f4f063827f38	DEBIT	50	2025-03-07 00:41:09.341852
8e0739bc-899d-44bb-9031-68fb4d58355a	a6d3dd51-862b-4beb-a72a-f4f063827f38	DEBIT	100	2025-03-07 00:45:40.825798
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (user_id, name, password, email, created_at, updated_at) FROM stdin;
0546e323-80c0-41e3-8e43-2deceb16661f	ivan tigris sitohang	@ivan123	ivantigris@email.com	2025-03-06 21:48:47.151	2025-03-06 21:50:49.675
781c7883-8b70-4624-98e4-74d8aa77cfbb	John Doe	password123	johndoe@example.com	2025-03-08 07:37:12.487375	\N
\.


--
-- Name: accounts accounts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT accounts_pkey PRIMARY KEY (account_id);


--
-- Name: transactions transactions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions
    ADD CONSTRAINT transactions_pkey PRIMARY KEY (transaction_id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- PostgreSQL database dump complete
--

