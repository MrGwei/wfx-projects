create table `role` ( `id` int (11) default null ,
`name` char (10) default null ) ENGINE = InnoDB default CHARSET = utf8;

create table `user` ( `id` int (11) default null ,
`username` char (10) default null ,
`password` char (100) default null ) ENGINE = InnoDB default CHARSET = utf8;

create table `user_role` ( `user_id` int (11) default null ,
`role_id` int (11) default null ) ENGINE = InnoDB default CHARSET = utf8;