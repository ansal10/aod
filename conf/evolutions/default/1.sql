# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table comment (
  id                        bigserial not null,
  name                      varchar(255),
  constraint pk_comment primary key (id))
;

create table post (
  id                        bigserial not null,
  title                     text not null,
  description               varchar(255),
  constraint pk_post primary key (id))
;




# --- !Downs

drop table if exists comment cascade;

drop table if exists post cascade;

