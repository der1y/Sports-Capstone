BEGIN
TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    user_id       SERIAL,
    username      varchar(50)  NOT NULL UNIQUE,
    password_hash varchar(200) NOT NULL,
    role          varchar(50)  NOT NULL,
    CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE standing
(
    id            serial PRIMARY KEY,
    season        int,
    standing_date DATE,
    conference    varchar(255),
    division      varchar(255),
    team          varchar(255),
    team_name     varchar(255),
    wins          int,
    losses        int,
    ties          int,
    division_rank int
);

CREATE TABLE users_standing
(
    user_id     int,
    standing_id int,
    CONSTRAINT PK_users_standing PRIMARY KEY (user_id, standing_id),
    CONSTRAINT FK_users FOREIGN KEY (user_id) REFERENCES users (user_id),
    CONSTRAINT FK_standing FOREIGN KEY (standing_id) REFERENCES standing (id)
);

COMMIT TRANSACTION;
