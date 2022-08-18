-- Database: instagram
select pg_terminate_backend(pid) from pg_stat_activity where datname='instagram';
DROP DATABASE IF EXISTS instagram;

CREATE DATABASE instagram
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

-- Table: public.user_role

--DROP TABLE IF EXISTS public.user_role;

CREATE TABLE public.user_role
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    role character varying(255) NOT NULL,
    CONSTRAINT user_role_pkey PRIMARY KEY (id)
);
ALTER SEQUENCE user_role_id_seq RESTART WITH 1;
INSERT INTO user_role("role") VALUES('admin'),('user');

-- Table: public.user_status

--DROP TABLE IF EXISTS public.user_status;

CREATE TABLE public.user_status
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    status character varying(255) NOT NULL,
    CONSTRAINT user_status_pkey PRIMARY KEY (id)
);
ALTER SEQUENCE user_status_id_seq RESTART WITH 1;
INSERT INTO user_status("status") VALUES('active'),('blocked');

-- Table: public.users

--DROP TABLE IF EXISTS public.users;

CREATE TABLE public.users
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    name character varying(255) NOT NULL,
    surname character varying(255) NOT NULL,
    nickname character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    role_id bigint NOT NULL,
    status_id bigint NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT email_unique UNIQUE (email),
    CONSTRAINT nickname_unique UNIQUE (nickname),
    CONSTRAINT fk_user_role_id FOREIGN KEY (role_id)
        REFERENCES public.user_role (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_user_status_id FOREIGN KEY (status_id)
        REFERENCES public.user_status (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);