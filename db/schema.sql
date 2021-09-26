drop table if exists users;

CREATE TABLE post
(
    id          SERIAL PRIMARY KEY,
    name        text,
    description text,
    created     date
);

CREATE TABLE candidates
(
    id   SERIAL PRIMARY KEY,
    name text
);

CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    name     text,
    email    text unique,
    password text
);
