DELIMITER $$
CREATE PROCEDURE testDataInsert()
BEGIN
    DECLARE i INT DEFAULT 1;

    WHILE i <= 120 DO
        INSERT INTO board(title, content, writer)
		VALUES(concat('제목',i), concat('내용',i), concat('작성자',i));
        SET i = i + 1;
    END WHILE;
END$$
DELIMITER $$

call testDataInsert;