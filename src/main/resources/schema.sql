create table if not exists student
(
   id integer not null,
   name varchar(255) not null,
   passport_number varchar(255) not null,
   primary key(id)
);

create table if not exists symbol_list (
  symbol char(16) not null,
  company_name varchar(255) not null
) 
as select * from CSVRead('data/nasdaq-listed-symbols_csv.csv');


create table if not exists nasdaq_list (
  symbol char(16) not null,
  company_name varchar(255) not null,
  security_name varchar(255),
  market_category char(1),
  test_issue char(1),
  financial_status char(1),
  round_lot_size decimal(5,2)
) 
as select * from CSVRead('data/nasdaq-listed_csv.csv');
