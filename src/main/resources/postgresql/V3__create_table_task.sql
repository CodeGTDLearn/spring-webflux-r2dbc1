-- CREATE SCHEMA public;
-- CREATE DATABASE postgres;
-- CREATE SCHEMA IF NOT EXISTS anime
-- CREATE TABLE anime (id SERIAL PRIMARY KEY, name VARCHAR(255));

-- CREATE SCHEMA IF NOT EXISTS anime;
-- CREATE TABLE anime (id SERIAL PRIMARY KEY, name VARCHAR(255));

-- CREATE TABLE IF NOT EXISTS task (
CREATE TABLE tasks (
        task_id SERIAL PRIMARY KEY,
        task_name VARCHAR(255),
        task_worker VARCHAR(255),
        project_id_fk INTEGER NOT NULL,
        FOREIGN KEY (project_id_fk) REFERENCES project (project_id_pk));