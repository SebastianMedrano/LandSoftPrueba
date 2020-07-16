DROP TABLE IF EXISTS albums;
 
CREATE TABLE albums (
   position INT AUTO_INCREMENT,
   id INT,
  userId INT  ,
  title VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO albums (position,id,userId,title) VALUES
  (1,1,1,'quidem molestiae enim'),
  (2,2,1,'sunt qui excepturi placeat culpa');

