drop table if exists `customer` cascade;
drop table if exists `account` cascade;
drop table if exists `account_transactions` cascade;
drop table if exists `loans` cascade;
drop table if exists `cards` cascade;
drop table if exists `contact_messages` cascade;
drop table if exists `notice_details` cascade;
drop table if exists `role_permission` cascade;
drop table if exists `role` cascade;
drop table if exists `permission` cascade;
drop table if exists `authorities` cascade;


--
-- CREATE TABLE `role`
-- (
--     `role_id`   int(11)    NOT NULL primary key,
--     `role_name` varchar(6) NOT NULL,
--     `deleteFlg` int       default 0,
--     `create_dt` timestamp DEFAULT NULL,
--     `update_dt` timestamp DEFAULT NULL
-- );
--
-- CREATE TABLE `permission`
-- (
--     `permission_id` int(11)     NOT NULL primary key,
--     `name`          varchar(50) NOT NULL unique,
--     `deleteFlg`     int       default 0,
--     `create_dt`     timestamp DEFAULT NULL,
--     `update_dt`     timestamp DEFAULT NULL
-- );
--
-- CREATE TABLE `role_permission`
-- (
--     `role_name`     varchar(11) NOT NULL,
--     `permission_id` int(11)     NOT NULL,
--     PRIMARY KEY (`role_name`, `permission_id`),
--     CONSTRAINT `permission_ib_fk_2` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`permission_id`),
--     CONSTRAINT `roles_ib_fk_2` FOREIGN KEY (`role_name`) REFERENCES `role` (`role_name`)
-- );


CREATE TABLE `customer`
(
    `customer_id`   int          NOT NULL AUTO_INCREMENT,
    `name`          varchar(100) NOT NULL,
    `email`         varchar(100) NOT NULL,
    `mobile_number` varchar(20)  NOT NULL,
    `pwd`           varchar(500) NOT NULL,
    `role`          varchar(3)   NOT NULL,
    `create_dt`     timestamp DEFAULT NULL,
    `update_dt`     timestamp DEFAULT NULL,
    `deleteFlg`     int       default 0,
    PRIMARY KEY (`customer_id`)
--     PRIMARY KEY (`customer_id`),
--     CONSTRAINT `roles_ib_fk_1` FOREIGN KEY (`role`) REFERENCES `role` (`role_id`)
);


CREATE TABLE `account`
(
    `account_number` long         NOT NULL,
    `customer_id`    int          NOT NULL,
    `account_type`   varchar(100) NOT NULL,
    `branch_address` varchar(200) NOT NULL,
    `create_dt`      timestamp DEFAULT NULL,
    `update_dt`      timestamp DEFAULT NULL,
    `deleteFlg`      int       default 0,
    PRIMARY KEY (`account_number`),
    CONSTRAINT `customer_id_fk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE
);

CREATE INDEX `customer_id` ON `account` (`customer_id`);


CREATE TABLE `account_transactions`
(
    `transaction_id`      varchar(200) NOT NULL,
    `account_number`      int          NOT NULL,
    `customer_id`         int          NOT NULL,
    `transaction_dt`      date         NOT NULL,
    `transaction_summary` varchar(200) NOT NULL,
    `transaction_type`    varchar(100) NOT NULL,
    `transaction_amt`     int          NOT NULL,
    `closing_balance`     int          NOT NULL,
    `create_dt`           timestamp DEFAULT NULL,
    `update_dt`           timestamp DEFAULT NULL,
    `deleteFlg`           int       default 0,
    PRIMARY KEY (`transaction_id`),
    CONSTRAINT `accounts_ib_fk_2` FOREIGN KEY (`account_number`) REFERENCES `account` (`account_number`) ON DELETE CASCADE,
    CONSTRAINT `acct_user_ib_fk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE
);

CREATE INDEX `customer_id_account_transactions` ON `account_transactions` (`customer_id`);
CREATE INDEX `account_number` ON `account_transactions` (`account_number`);

CREATE TABLE `loans`
(
    `loan_number`        int          NOT NULL AUTO_INCREMENT,
    `customer_id`        int          NOT NULL,
    `start_dt`           date         NOT NULL,
    `loan_type`          varchar(100) NOT NULL,
    `total_loan`         int          NOT NULL,
    `amount_paid`        int          NOT NULL,
    `outstanding_amount` int          NOT NULL,
    `create_dt`          timestamp DEFAULT NULL,
    `update_dt`          timestamp DEFAULT NULL,
    `deleteFlg`          int       default 0,
    PRIMARY KEY (`loan_number`),
    CONSTRAINT `loan_customer_ib_fk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE
);

CREATE INDEX `customer_id_loans` ON `account_transactions` (`customer_id`);

CREATE TABLE `cards`
(
    `card_id`          int          NOT NULL AUTO_INCREMENT,
    `card_number`      varchar(100) NOT NULL,
    `customer_id`      int          NOT NULL,
    `card_type`        varchar(100) NOT NULL,
    `total_limit`      int          NOT NULL,
    `amount_used`      int          NOT NULL,
    `available_amount` int          NOT NULL,
    `create_dt`        timestamp DEFAULT NULL,
    `update_dt`        timestamp DEFAULT NULL,
    `deleteFlg`        int       default 0,
    PRIMARY KEY (`card_id`),

    CONSTRAINT `card_customer_ib_fk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE
);

CREATE INDEX `customer_id_cards` ON `account_transactions` (`customer_id`);

CREATE TABLE `notice_details`
(
    `notice_id`      int          NOT NULL AUTO_INCREMENT,
    `notice_summary` varchar(200) NOT NULL,
    `notice_details` varchar(500) NOT NULL,
    `notice_beg_dt`  date         NOT NULL,
    `notice_end_dt`  date      DEFAULT NULL,
    `create_dt`      timestamp DEFAULT NULL,
    `update_dt`      timestamp DEFAULT NULL,
    `deleteFlg`      int       default 0,
    PRIMARY KEY (`notice_id`)
);


CREATE TABLE `contact_messages`
(
    `contact_id`    varchar(50)   NOT NULL,
    `contact_name`  varchar(50)   NOT NULL,
    `contact_email` varchar(100)  NOT NULL,
    `subject`       varchar(500)  NOT NULL,
    `message`       varchar(2000) NOT NULL,
    `create_dt`     timestamp DEFAULT NULL,
    `update_dt`     timestamp DEFAULT NULL,
    `deleteFlg`     int       default 0,
    PRIMARY KEY (`contact_id`)
);


CREATE TABLE `authorities` (
    `id` int NOT NULL AUTO_INCREMENT,
    `customer_id` int NOT NULL,
    `name` varchar(50) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `customer_id_authorities` (`customer_id`),
    CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
);





