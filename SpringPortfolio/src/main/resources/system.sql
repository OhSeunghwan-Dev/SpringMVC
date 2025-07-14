CREATE USER test IDENTIFIED BY test;

DROP USER test CASCADE;

GRANT connect, resource, dba TO test;

