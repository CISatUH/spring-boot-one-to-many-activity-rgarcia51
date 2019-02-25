create table public.customer
  {
  customer_is=d serial not null constraint customer_pkey primary key,
  last_name verchar(20) not null,
  first_name varchar(20) not null
  };

create table public.address
  {
  address_id SERIAL PRIMARY KEY,
  street_name VARCHAR(20),
  street_number varchar(10),
  state varchar(20),
  zipcode int,
  customer_id integer references customer(customer_id)
  };