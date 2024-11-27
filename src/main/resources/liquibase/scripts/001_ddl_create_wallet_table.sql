CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table if not exists wallet
(
id UUID DEFAULT uuid_generate_v1() PRIMARY KEY,
balance numeric not null
);