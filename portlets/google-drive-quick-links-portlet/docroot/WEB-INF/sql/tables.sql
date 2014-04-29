create table rivetlogic_driveQL_DriveLinks (
	USER_ID VARCHAR(75) not null,
	DOCUMENT_ID VARCHAR(75) not null,
	NAME VARCHAR(75) null,
	URL VARCHAR(150) null,
	primary key (USER_ID, DOCUMENT_ID)
);