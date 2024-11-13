create table mobiles (id integer not null auto_increment, company varchar(255), image varchar(255), mname varchar(255), price double precision not null, ram integer not null, storage integer not null, primary key (id));
create table orders (id integer not null auto_increment, mid integer, uid integer, primary key (id));
create table users (id integer not null auto_increment, birth date, email varchar(255), mobile varchar(255), uname varchar(255), password varchar(255), primary key (id));
alter table orders add constraint fk_mid foreign key (mid) references mobiles (id);
alter table orders add constraint fk_uid foreign key (uid) references users (id);

INSERT INTO users(uname,email,mobile,password) VALUES('Admin', 'admin@gmail.com', '9999999999', 'admin');
INSERT INTO users(uname,email,mobile,password) VALUES('Nilesh', 'nilesh@gmail.com', '9527331338', 'nilesh');

INSERT INTO mobiles(mname,ram,storage,company,price,image) VALUES("GALAXY M33 5G",8,128,"samsung",19499,"m33_5g.jpg");
INSERT INTO mobiles(mname,ram,storage,company,price,image) VALUES("9A Sport",2,32,"Redmi",6999,"9ASport.jpg");
INSERT INTO mobiles(mname,ram,storage,company,price,image) VALUES("narzo 50i",4,64,"realme",8999,"narzo50i.jpg");
INSERT INTO mobiles(mname,ram,storage,company,price,image) VALUES("A31",6,128,"oppo",11990,"oppoA31.jpg");
INSERT INTO mobiles(mname,ram,storage,company,price,image) VALUES("iQOO Z6",6,128,"vivo",15999,"iQOOz6.jpg");

