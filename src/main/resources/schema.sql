


create table if not exists companies (
  symbol char(16) not null,
  company_name varchar(255) not null,
  security_name varchar(255),
  market_category char(1),
  test_issue char(1),
  financial_status char(1),
  round_lot_size decimal(5,2)
) 
as select * from CSVRead('data/companies.csv');
