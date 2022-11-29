create table user_role (
    id BIGINT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(1000)
);

create table application_user(
     id BIGINT PRIMARY KEY,
     username VARCHAR(200) NOT NULL UNIQUE,
     password VARCHAR(500) NOT NULL,
     role_id BIGINT,
     foreign key (role_id) references user_role(id)
);
