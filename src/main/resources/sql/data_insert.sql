--Insert test users
INSERT INTO app_user(id, name, surname, username, email, encrypted_password, enabled)
VALUES (2, 'Test', 'User', 'testuser', 'jazvillagra.jv@fpuna.edu.py', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
INSERT INTO app_user(id, name, surname, username, email, encrypted_password, ENABLED)
VALUES (1, 'Admin', 'User', 'admin', 'jazvillagra.jv@gmail.com', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
--Insert test roles
INSERT INTO app_role(id, role_name)
VALUES(1, 'ROLE_ADMIN');
INSERT INTO app_role(id, role_name)
VALUES(2, 'ROLE_USER');
--Insert user's roles
INSERT INTO user_role(id, user_id, role_id)
VALUES(1, 1, 1);
INSERT INTO user_role(id, user_id, role_id)
VALUES(2, 1, 2);
INSERT INTO user_role(id, user_id, role_id)
VALUES(3, 2, 2);
