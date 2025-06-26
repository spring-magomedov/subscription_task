--liquibase formatted sql
--changeset postgres:001_init

create table if not exists users(
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username varchar(50) NOT NULL UNIQUE,
    password varchar(50) not null,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT now()
);

create table if not exists subscriptions(
    id SERIAL primary key,
    service_name VARCHAR(50) NOT NULL,
    start_date TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    end_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    userId int not null,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
    updated_at TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
    constraint fk_user foreign key (userId) references users(id)
)