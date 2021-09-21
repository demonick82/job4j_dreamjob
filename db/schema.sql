CREATE TABLE post
(
    id          SERIAL PRIMARY KEY,
    name        text,
    description text,
    created     date
);

CREATE TABLE candidates
(
    id          SERIAL PRIMARY KEY,
    name        text
);
