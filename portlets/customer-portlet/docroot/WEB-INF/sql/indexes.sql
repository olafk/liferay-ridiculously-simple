create index IX_549677C3 on customer_Customer (companyId);
create index IX_C1D01305 on customer_Customer (groupId);
create index IX_4BC8027F on customer_Customer (userId);
create index IX_DB0ED10B on customer_Customer (userId, groupId);

create index IX_B1501BB on customer_Invoices (companyId);
create index IX_39316E9A on customer_Invoices (customerId);
create index IX_B33DD350 on customer_Invoices (customerId, groupId);
create index IX_D7D8BAFD on customer_Invoices (groupId);
create index IX_8E8E7B87 on customer_Invoices (userId);
create index IX_AFCC0103 on customer_Invoices (userId, groupId);