-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER sports_capstone_owner
WITH PASSWORD 'Playball';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO sports_capstone_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO sports_capstone_owner;

CREATE USER sports_capstone_appuser
WITH PASSWORD 'Playball';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO sports_capstone_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO sports_capstone_appuser;
