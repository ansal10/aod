# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table post_comment (
  id                        bigserial not null,
  description               text,
  created_on                timestamp,
  last_updated_on           timestamp,
  anonymous                 boolean,
  type                      integer,
  comment_id                bigint,
  post_id                   bigint,
  user_id                   bigint,
  constraint ck_post_comment_type check (type in (0,1)),
  constraint pk_post_comment primary key (id))
;

create table post_like (
  id                        bigserial not null,
  type                      integer,
  created_on                timestamp,
  comment_id                bigint,
  post_id                   bigint,
  user_id                   bigint,
  constraint ck_post_like_type check (type in (0,1,2,3,4)),
  constraint pk_post_like primary key (id))
;

create table post_post (
  id                        bigserial not null,
  title                     varchar(255),
  description               text,
  created_on                timestamp,
  last_updated_on           timestamp,
  anonymous                 boolean,
  views                     bigint,
  user_id                   bigint,
  constraint pk_post_post primary key (id))
;

create table post_profile (
  id                        bigserial not null,
  f_name                    varchar(255),
  l_name                    varchar(255),
  nick_name                 varchar(255),
  profile_pic               varchar(255),
  last_updated_on           varchar(255),
  constraint pk_post_profile primary key (id))
;

create table post_user (
  id                        bigserial not null,
  is_superuser              boolean,
  is_staff                  boolean,
  created_on                timestamp,
  email                     varchar(255),
  unique_email              varchar(255),
  password                  varchar(255),
  profile_id                bigint,
  constraint uq_post_user_profile_id unique (profile_id),
  constraint pk_post_user primary key (id))
;

alter table post_comment add constraint fk_post_comment_post_1 foreign key (post_id) references post_post (id);
create index ix_post_comment_post_1 on post_comment (post_id);
alter table post_comment add constraint fk_post_comment_user_2 foreign key (user_id) references post_user (id);
create index ix_post_comment_user_2 on post_comment (user_id);
alter table post_like add constraint fk_post_like_comment_3 foreign key (comment_id) references post_comment (id);
create index ix_post_like_comment_3 on post_like (comment_id);
alter table post_like add constraint fk_post_like_post_4 foreign key (post_id) references post_post (id);
create index ix_post_like_post_4 on post_like (post_id);
alter table post_like add constraint fk_post_like_user_5 foreign key (user_id) references post_user (id);
create index ix_post_like_user_5 on post_like (user_id);
alter table post_post add constraint fk_post_post_user_6 foreign key (user_id) references post_user (id);
create index ix_post_post_user_6 on post_post (user_id);
alter table post_user add constraint fk_post_user_profile_7 foreign key (profile_id) references post_profile (id);
create index ix_post_user_profile_7 on post_user (profile_id);



# --- !Downs

drop table if exists post_comment cascade;

drop table if exists post_like cascade;

drop table if exists post_post cascade;

drop table if exists post_profile cascade;

drop table if exists post_user cascade;

