--CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table if not exists wallet
(
id UUID DEFAULT random_uuid() PRIMARY KEY,
balance numeric not null
);