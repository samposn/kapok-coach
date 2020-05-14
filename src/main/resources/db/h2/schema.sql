DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`
(
    `id`      IDENTITY PRIMARY KEY,
    `title`   VARCHAR(128),
    `content` CLOB,
    `status`  VARCHAR(64)
);