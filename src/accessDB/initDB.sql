set global max_allowed_packet = 1073741824;
drop database if exists BTL_NHOM14;
create database BTL_NHOM14;
use BTL_NHOM14;

create table DATETIME (
	ID char(32) primary key,
    name nvarchar(128) null,
    description nvarchar(1024) null,
	dateTime datetime null
);

create table COUNTRY (
	ID char(32) primary key,
    name nvarchar(128) null,
    description nvarchar(1024) null,
    population int null,
    officialLanguage nvarchar(20) null
);

create table PERSON (
	ID char(32) primary key,
    name nvarchar(128) null,
    description nvarchar(1024) null,
    gender bit(1) null,
    countryID char(32) null,
    dateOfBirthID char(32) null,
    constraint FK_PERSON_COUNTRY foreign key (countryID) references COUNTRY(ID),
    constraint FK_PERSON_DATETIME foreign key (dateOfBirthID) references DATETIME(ID)
);

create table LOCATION (
	ID char(32) primary key,
    name nvarchar(128) null,
    description nvarchar(1024) null,
    coordinate nvarchar(32) null,
    countryID char(32) null,
    constraint FK_LOCATION_COUNTRY foreign key (countryID) references COUNTRY(ID)
);

create table ORGANIZATION (
	ID char(32) primary key,
    name nvarchar(128) null,
    description nvarchar(1024) null,
    leaderID char(32) null,
    locationID char(32) null,
    foundationDateID char(32) null,
    constraint FK_ORGANIZATION_PERSON foreign key (leaderID) references PERSON(ID),
    constraint FK_ORGANIZATION_LOCATION foreign key (locationID) references LOCATION(ID),
    constraint FK_ORGANIZATION_DATETIME foreign key (foundationDateID) references DATETIME(ID)
);

create table AGREEMENT (
	ID char(32) primary key,
    name nvarchar(128) null,
    description nvarchar(1024) null,
    timeID char(32) null,
    locationID char(32) null,
    constraint FK_AGREEMENT_DATETIME foreign key (timeID) references DATETIME(ID),
    constraint FK_AGREEMENT_LOCATION foreign key (locationID) references LOCATION(ID)
);

create table EVENT (
	ID char(32) primary key,
	name nvarchar(128) null,
	description nvarchar(1024) null,
    startTimeID char(32) null,
    endTimeID char(32) null,
    locationID char(32) null,
    constraint FK_EVENT_DATETIME_S foreign key (startTimeID) references DATETIME(ID),
    constraint FK_EVENT_DATETIME_E foreign key (endTimeID) references DATETIME(ID),
    constraint FK_EVENT_LOCATION foreign key (locationID) references LOCATION(ID)
);

create table ARTICLE (
	ID char(32) primary key,
	link nvarchar(256) null
);

create table FACT (
	ID char(32) primary key,
	subjectID char(32) null,
    objectID char(32) null,
    relationship char(32) null,
    timeID char(32) null,
    articleID char(32) null,
    
    constraint FK_FACT_ARTICLE foreign key (articleID) references ARTICLE(ID)
);