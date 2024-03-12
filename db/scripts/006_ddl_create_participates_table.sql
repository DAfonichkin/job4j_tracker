CREATE TABLE participates (
   id serial PRIMARY KEY,
   item_id int not null REFERENCES items(id),
   j_user_id int not null REFERENCES j_user(id),
   UNIQUE (item_id, j_user_id)
);