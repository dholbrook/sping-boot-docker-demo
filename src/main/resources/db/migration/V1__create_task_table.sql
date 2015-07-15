CREATE TABLE `task` (
  `id`          BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NOT NULL,
  `complete`    TINYINT(1)   NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
