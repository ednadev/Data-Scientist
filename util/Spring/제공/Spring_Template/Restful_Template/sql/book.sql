create table book
(isbn char(12) primary key, 
title varchar(100), 
catalogue varchar(50),
nation varchar(50), 
publish_date date, 
publisher varchar(100),
author varchar(50),
price  int(6),
currency char(6),
description varchar(4000)
);