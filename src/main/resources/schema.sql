DROP TABLE IF EXISTS todos;
CREATE TABLE todos
(
    id           INTEGER     NOT NULL,
    title        VARCHAR(50) NOT NULL,
    description  VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);