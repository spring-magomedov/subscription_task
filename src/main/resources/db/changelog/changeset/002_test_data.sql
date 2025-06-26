--liquibase formatted sql
--changeset postgres:002_test_data

INSERT INTO users(username, password) VALUES
                                          ('john_doe', 'securepass123'),
                                          ('alice_smith', 'p@ssw0rd!'),
                                          ('bob_jackson', 'bobpass789');

INSERT INTO subscriptions(service_name, start_date, end_date, userid) VALUES
                                                                          ('YouTubePremium', NOW(), NOW() + INTERVAL '1 month', 1),
                                                                          ('Netflix', NOW(), NOW() + INTERVAL '1 year', 1),
                                                                          ('VKMusic', NOW(), NOW() + INTERVAL '6 months', 2),
                                                                          ('YandexPlus', NOW(), NOW() + INTERVAL '3 months', 3),
                                                                          ('YouTubePremium', NOW(), NOW() + INTERVAL '2 months', 2);

INSERT INTO users(username, password) VALUES
                                          ('emma_wilson', 'emma2023'),
                                          ('mike_brown', 'mikespass!');

INSERT INTO subscriptions(service_name, start_date, end_date, userid) VALUES
                                                                          ('Netflix', NOW(), NOW() + INTERVAL '6 months', 4),
                                                                          ('YandexPlus', NOW(), NOW() + INTERVAL '9 months', 5),
                                                                          ('VKMusic', NOW(), NOW() + INTERVAL '1 year', 4);