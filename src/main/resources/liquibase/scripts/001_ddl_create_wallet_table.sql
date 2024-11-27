create table if not exists wallet
(
id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
balance numeric not null
);