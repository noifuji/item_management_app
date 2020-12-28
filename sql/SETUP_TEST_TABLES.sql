delete from ADMIN_USER;
drop table ADMIN_USER;

delete from ITEM;
drop table ITEM;

delete from ITEM_CATEGORY;
drop table ITEM_CATEGORY;

create table ADMIN_USER (
ADMIN_ID varchar(20) NOT NULL PRIMARY KEY,
PASSWORD varchar(8) NOT NULL
);
 
 insert into ADMIN_USER values ('admin', '00000000');
 insert into ADMIN_USER values ('takahashi', '11111111');
 


create table ITEM_CATEGORY (
ITEM_CATEGORY_CODE char(3) NOT NULL PRIMARY KEY,
ITEM_CATEGORY_NAME varchar(20) NOT NULL
);
 
 insert into ITEM_CATEGORY values ('001', '書籍');
 insert into ITEM_CATEGORY values ('002', 'DVD');
 insert into ITEM_CATEGORY values ('003', '家電');
 insert into ITEM_CATEGORY values ('004', '食品');
 insert into ITEM_CATEGORY values ('005', 'その他');



create table ITEM (
ITEM_NO int AUTO_INCREMENT NOT NULL PRIMARY KEY,
ITEM_CATEGORY_CODE char(3) NOT NULL,
ITEM_NAME varchar(100),
EXPLANATION varchar(1000),
PRICE int,
RECOMMEND_FLG char(1),
LAST_UPDATE_DATE_TIME datetime,
CONSTRAINT FK_ITEM_CATEGORY_CODE
    FOREIGN KEY (ITEM_CATEGORY_CODE) 
    REFERENCES ITEM_CATEGORY (ITEM_CATEGORY_CODE)
    ON DELETE RESTRICT ON UPDATE RESTRICT
);

 insert into ITEM values (1, '001', 'もものかんづめ', 'さくらももこの名作', 1000, '0', cast('2020/12/24 23:59:59' as datetime));
 insert into ITEM values (2, '002', 'ローマの休日', '不朽の名作', 2000, '1', cast('2020/12/24 23:59:59' as datetime));
 insert into ITEM values (3, '003', 'ヘアドライヤー', 'マイナスイオンドライヤー', 3000, '0', cast('2020/12/24 23:59:59' as datetime));
 insert into ITEM values (4, '004', 'どら焼き', '北海道産あずき使用', 500, '1', cast('2020/12/24 23:59:59' as datetime ));
 insert into ITEM values (5, '005', '入浴剤', 'アロマの香り', 700, '0', cast('2020/12/24 23:59:59' as datetime ));