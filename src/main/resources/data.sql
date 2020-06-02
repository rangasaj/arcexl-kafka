insert into stock_price (stock_symbol, price_date,price)
    select stock_symbol , price_date , price  from (
        select 'T-IBM' as stock_symbol ,to_date('2020-01-03','YYYY-MM-DD') as price_date, 25.0 as price
    ) x where not exists(select * from stock_price WHERE stock_symbol = 'T-IBM' AND price_date='2020-01-03');
