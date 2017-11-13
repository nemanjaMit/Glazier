DROP TABLE IF EXISTS prices;

 CREATE TABLE prices (
  id INTEGER,
  price INTEGER,
  PRIMARY KEY (id)
);

INSERT INTO prices (id, price) VALUES (0, 300);
INSERT INTO prices (id, price) VALUES (1, 100);
INSERT INTO prices (id, price) VALUES (2, 200);
INSERT INTO prices (id, price) VALUES (3, 350);