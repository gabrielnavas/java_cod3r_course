create table if not exists tb_assento(
	id SERIAL primary key,
	name varchar(255) not null
);

create table if not exists tb_cliente(
	id SERIAL primary key,
	name varchar(255) not null,
	tb_assento_id bigint,
	    FOREIGN KEY (tb_assento_id)
	    	REFERENCES tb_assento(id)
);
