CREATE SCHEMA IF NOT EXISTS client;

CREATE TABLE client
(
    id   UUID         NOT NULL,
    name VARCHAR(255) NOT NULL
);

ALTER TABLE client
    ADD CONSTRAINT client_pk PRIMARY KEY (id);

ALTER TABLE client
    ADD CONSTRAINT client_name_uk UNIQUE (name);

CREATE TABLE program
(
    id                INTEGER      NOT NULL,
    name              VARCHAR(255) NOT NULL,
    start_date        TIMESTAMP DEFAULT NULL,
    end_date          TIMESTAMP DEFAULT NULL,
    total_impressions BIGINT    DEFAULT 0,
    engagement_rate   FLOAT     DEFAULT 0
);

ALTER TABLE program
    ADD CONSTRAINT program_pk PRIMARY KEY (id);

CREATE TABLE influencer
(
    id                INTEGER      NOT NULL,
    name              VARCHAR(255) NOT NULL,
    location          VARCHAR(255) DEFAULT NULL,
    user_access_token TEXT         DEFAULT NULL,
    token_expiry      TIMESTAMP    DEFAULT NULL,
    follower_count    BIGINT       DEFAULT 0,
    age_range         VARCHAR(50)  DEFAULT NULL,
    engagement_rate   FLOAT        DEFAULT 0
);

ALTER TABLE influencer
    ADD CONSTRAINT influencer_pk PRIMARY KEY (id);

CREATE TABLE post
(
    id            UUID        NOT NULL,
    platform      VARCHAR(50) NOT NULL,
    is_active     BOOLEAN DEFAULT TRUE,
    likes         BIGINT  DEFAULT 0,
    comment_count BIGINT  DEFAULT 0,
    influencer_id INTEGER     NOT NULL
);

ALTER TABLE post
    ADD CONSTRAINT post_pk PRIMARY KEY (id);

ALTER TABLE post
    ADD CONSTRAINT influencer_fk FOREIGN KEY (influencer_id) REFERENCES influencer (id);

CREATE TABLE client_program
(
    client_id  UUID    NOT NULL,
    program_id INTEGER NOT NULL
);

ALTER TABLE client_program
    ADD CONSTRAINT client_program_pk PRIMARY KEY (client_id, program_id);

ALTER TABLE client_program
    ADD CONSTRAINT client_fk FOREIGN KEY (client_id) REFERENCES client (id);

ALTER TABLE client_program
    ADD CONSTRAINT program_fk FOREIGN KEY (program_id) REFERENCES program (id);

CREATE TABLE client_influencer
(
    client_id     UUID    NOT NULL,
    influencer_id INTEGER NOT NULL
);

ALTER TABLE client_influencer
    ADD CONSTRAINT client_influencer_pk PRIMARY KEY (client_id, influencer_id);

ALTER TABLE client_influencer
    ADD CONSTRAINT client_fk FOREIGN KEY (client_id) REFERENCES client (id);

ALTER TABLE client_influencer
    ADD CONSTRAINT influencer_fk FOREIGN KEY (influencer_id) REFERENCES influencer (id);

CREATE TABLE program_influencer
(
    program_id    INTEGER NOT NULL,
    influencer_id INTEGER NOT NULL
);

ALTER TABLE program_influencer
    ADD CONSTRAINT program_influencer_pk PRIMARY KEY (program_id, influencer_id);

ALTER TABLE program_influencer
    ADD CONSTRAINT program_fk FOREIGN KEY (program_id) REFERENCES program (id);

ALTER TABLE program_influencer
    ADD CONSTRAINT influencer_fk FOREIGN KEY (influencer_id) REFERENCES influencer (id);