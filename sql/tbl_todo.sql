DROP TABLE IF EXISTS tbl_todo;

CREATE TABLE tbl_todo(
     tno INT AUTO_INCREMENT PRIMARY KEY,
     title VARCHAR(500) NOT NULL,
     memo TEXT NOT NULL,
     regdate TIMESTAMP DEFAULT NOW(),
     moddate TIMESTAMP DEFAULT NOW()
)
;

INSERT INTO tbl_todo (title, memo) VALUES ('Test Title', 'Test Content');

INSERT INTO tbl_todo (title, memo)
SELECT title, memo from tbl_todo;

ALTER TABLE tbl_todo ADD duedate DATE NOT NULL;
ALTER TABLE tbl_todo ADD complete BOOLEAN NOT NULL DEFAULT FALSE;

SELECT * FROM tbl_todo;

UPDATE tbl_todo SET title = CONCAT(title, ' ',tno) WHERE tno > 0;
UPDATE tbl_todo SET memo = CONCAT(memo, ' ',tno) WHERE tno > 0;
UPDATE tbl_todo SET duedate = ADDDATE('2022-09-27',INTERVAL tno DAY) WHERE tno > 0;