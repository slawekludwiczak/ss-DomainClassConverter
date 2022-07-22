INSERT INTO
    application_user (id, username, password)
VALUES
    (1, 'user', '{noop}pass'),
    (2, 'admin', '{noop}hard');

INSERT INTO
    user_role (id, name)
VALUES
    (1, 'ADMIN'),
    (2, 'USER');

INSERT INTO
    user_roles (user_id, role_id)
VALUES
    (1, 2),
    (2, 1);
