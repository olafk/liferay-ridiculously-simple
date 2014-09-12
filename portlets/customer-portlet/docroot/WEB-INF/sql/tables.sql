create table customer_Customer (
	customerId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(30) null,
	street VARCHAR(30) null,
	city VARCHAR(30) null,
	zip VARCHAR(30) null
);

create table customer_Invoices (
	invoiceId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	customerId LONG,
	date_ DATE null,
	amount LONG,
	paid BOOLEAN
);