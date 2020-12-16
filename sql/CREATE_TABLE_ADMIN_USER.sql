create table admin_user (
admin_id varchar(20) NOT NULL PRIMARY KEY,
password varchar(8) NOT NULL
);
 
 insert into admin_user values ('admin', '00000000');
 insert into admin_user values ('takahashi', '11111111');