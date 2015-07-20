
# --- !Ups

create table POST (
  id SERIAL NOT NULL,
  title varchar (120) NOT NULL,
  description text,
  createdon timestamp with time zone ,
  lastupdatedon timestamp with time zone ,
  category_id integer NOT NULL,
  user_id integer not null
);

# ----- !Downs

DROP TABLE POST;
