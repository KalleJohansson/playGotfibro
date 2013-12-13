# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table member (
  id                        integer auto_increment not null,
  lastname                  varchar(255),
  firstname                 varchar(255),
  address                   varchar(255),
  postcode                  varchar(255),
  postal                    varchar(255),
  constraint pk_member primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table member;

SET FOREIGN_KEY_CHECKS=1;

