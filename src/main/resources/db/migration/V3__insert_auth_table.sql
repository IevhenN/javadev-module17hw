CREATE TABLE IF NOT EXISTS roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT true
);

CREATE TABLE IF NOT EXISTS users_roles(
    user_id BIGINT,
    role_id BIGINT,
    CONSTRAINT pk_users_roles PRIMARY KEY(user_id,role_id),
    CONSTRAINT fk_users_roles_user_id FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_users_roles_role_id FOREIGN KEY (role_id) REFERENCES roles(id)
);

INSERT INTO users (username,password)
VALUES ('user','$2a$10$gYuPPevYaeBR8BliDsXWIuFz3o7uVBJlfNx2K8Gje4qt2aKGOptNG');

INSERT INTO roles (name)
VALUES
('ADMIN'),
('USER');

INSERT INTO users_roles (user_id,role_id)
VALUES(1,1);

