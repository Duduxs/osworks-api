create table order_service(
id bigint not null auto_increment,
description text not null,
price Decimal(10,2) not null,
status varchar(20) not null,
open_date datetime not null,
close_date datetime,
client_id bigint not null,

primary key(id),
foreign key (client_id) references client (id)
);