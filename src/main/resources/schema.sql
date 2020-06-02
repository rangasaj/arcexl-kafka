CREATE TABLE IF NOT EXISTS stock_price (
                    stock_symbol varchar(100),
                    price_date date,
                    price numeric,
                    constraint stock_price_pk primary key (stock_symbol, price_date)
                    );