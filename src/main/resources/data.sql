INSERT INTO
    user_role (id, name)
VALUES
    (1, 'ADMIN'),
    (2, 'USER');

INSERT INTO
    application_user (id, username, password, role_id)
VALUES
    (1, 'user', '{noop}pass', 1),
    (2, 'admin', '{noop}hard', 2);
