# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table comment (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_comment primary key (id))
;

create table post (
  id                        bigint not null,
  title                     text not null,
  description               varchar(255),
  constraint pk_post primary key (id))
;

create sequence comment_seq;

create sequence post_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists comment;

drop table if exists post;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists comment_seq;

drop sequence if exists post_seq;

