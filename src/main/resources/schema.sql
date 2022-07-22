create table application_user(
    id BIGINT PRIMARY KEY,
    username VARCHAR(200) NOT NULL UNIQUE,
    password VARCHAR(500) NOT NULL
);

create table user_role (
    id BIGINT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(1000)
);

create table user_roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES application_user(id),
    FOREIGN KEY (role_id) REFERENCES user_role(id)
)
