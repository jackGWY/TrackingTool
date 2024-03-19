CREATE TABLE `storage`  (
                           `locker_id` varchar(64) NOT NULL COMMENT 'primary key',
                           `locker_name` varchar(225) NULL DEFAULT NULL COMMENT 'locker_name ',

                           PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB COMMENT = 'storage information';
