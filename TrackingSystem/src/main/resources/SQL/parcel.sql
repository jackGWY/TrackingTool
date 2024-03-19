

-- ----------------------------
-- Table structure for cla_document
-- ----------------------------
CREATE TABLE `parcel`  (
                                 `id` varchar(64) NOT NULL COMMENT 'primary key',
                                 `name` varchar(225) NULL DEFAULT NULL COMMENT 'parcel name',
                                 `guest_name` varchar(225) NULL DEFAULT NULL COMMENT 'guest name',
                                 `guest_id` varchar(225) NULL DEFAULT NULL COMMENT 'guest id',
                                 `is_available` varchar(225) NULL DEFAULT NULL COMMENT 'parcel is available for receptionist',
                                 `storage_place` varchar(200) NULL DEFAULT NULL COMMENT 'parcel storage place',
                                 `checkin_time` datetime(0) NULL DEFAULT NULL COMMENT 'parce check in time',
                                 `checkout_time` datetime(0) NULL DEFAULT NULL COMMENT 'parce check out time',
                                 `pickup_time` datetime(0) NULL DEFAULT NULL COMMENT 'parce pick up time',
                                 PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB COMMENT = 'parcel information';

