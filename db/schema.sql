drop table if exists post;
drop table if exists candidates;
drop table if exists users;
drop table if exists cities;

CREATE TABLE post
(
    id          SERIAL PRIMARY KEY,
    name        text,
    description text,
    created     date
);

CREATE TABLE candidates
(
    id      SERIAL PRIMARY KEY,
    name    text,
    city_id int,
    created date
);

CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    name     text,
    email    text unique,
    password text
);

CREATE TABLE cities
(
    id   serial primary key,
    name text unique
);
