
INSERT INTO roles(id, name) VALUES('{2889ba93-cc77-4753-a3a8-5738ce6b0149}', 'ROLE_USER');

INSERT INTO roles(id, name) VALUES('{4dc1c94e-6364-41f0-8cfb-fb07aaaa1b0d}', 'ROLE_ADMIN');

INSERT INTO profile (id, username, email, password) VALUES ('{695e4d0b-2627-47d0-923b-c445e0c9625c}', 'Dude', 'cool@gmail.com','Bro');
INSERT INTO profile (id, username, email, password) VALUES ('{dd14ff3a-f723-4a29-b0d1-ef32209885ee}', 'Le', 'Le@gmail.com','Epic');

INSERT INTO user_roles (user_id, role_id) VALUES ('{695e4d0b-2627-47d0-923b-c445e0c9625c}', '{4dc1c94e-6364-41f0-8cfb-fb07aaaa1b0d}');
INSERT INTO user_roles (user_id, role_id) VALUES ('{dd14ff3a-f723-4a29-b0d1-ef32209885ee}', '{2889ba93-cc77-4753-a3a8-5738ce6b0149}');

