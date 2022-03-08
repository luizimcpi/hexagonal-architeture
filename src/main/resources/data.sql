INSERT INTO accounts (id) VALUES (1);
INSERT INTO accounts (id) VALUES (2);

INSERT INTO transactions (id, account_id, created_at, amount, type) VALUES (RANDOM_UUID(), 1, now(), 100.0, 'CREDIT');
INSERT INTO transactions (id, account_id, created_at, amount, type) VALUES (RANDOM_UUID(), 2, now(), 225.0, 'CREDIT');
