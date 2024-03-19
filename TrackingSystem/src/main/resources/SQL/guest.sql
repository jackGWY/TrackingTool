CREATE TABLE `guest`  (
                           `id` varchar(64) NOT NULL COMMENT 'primary key',
                           `name` varchar(225) NULL DEFAULT NULL COMMENT 'guest name',

                           PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB COMMENT = 'guest information';
