create table comment(
id bigint not null auto_increment,
order_service_id bigint not null,
description text not null,
data_send datetime not null,
primary key (id),
foreign key (order_service_id) references order_service (id)
);