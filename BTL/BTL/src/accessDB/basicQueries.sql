select * from DATETIME where ID = N'DATETIME113';
select * from LOCATION where ID = N'LOCATION23';
select * from ORGANIZATION where ID = N'ORGANIZATION11';
select * from AGREEMENT where ID = 'AGREEMENT98';
select name from COUNTRY limit 100;
select * from COUNTRY where population > 1000000000;
select officialLanguage from COUNTRY where name = N'Tây Ban Nha';
select description from PERSON where name = N'Pele';
select description from LOCATION where coordinate = N'23°22\'N 105°20\'E';
select ID, name, description from EVENT where name like N'Giải bóng đá %';