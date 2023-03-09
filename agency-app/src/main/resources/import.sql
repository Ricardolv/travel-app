INSERT INTO CUSTOMER(id, name) VALUES (nextval('hibernate_sequence'), 'Richard');
INSERT INTO CUSTOMER(id, name) VALUES (nextval('hibernate_sequence'), 'Liliane');
INSERT INTO CUSTOMER(id, name) VALUES (nextval('hibernate_sequence'), 'Bernardo');
INSERT INTO CUSTOMER(id, name) VALUES (nextval('hibernate_sequence'), 'Maressa');


INSERT INTO RESERVE(id, code_customer) VALUES (nextval('hibernate_sequence'), 1);
INSERT INTO RESERVE(id, code_customer) VALUES (nextval('hibernate_sequence'), 2);
INSERT INTO RESERVE(id, code_customer) VALUES (nextval('hibernate_sequence'), 1);
INSERT INTO RESERVE(id, code_customer) VALUES (nextval('hibernate_sequence'), 2);