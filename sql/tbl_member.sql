create table tbl_member (
    mid varchar(50) not null primary key,
    mpw varchar(200) not null,
    mname varchar(50) not null,
    regDate timestamp default now()
)
;