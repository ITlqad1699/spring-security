drop table if exists `customer` cascade;
drop table if exists `account` cascade;
drop table if exists `account_transactions` cascade;
drop table if exists `loans` cascade;
drop table if exists `cards` cascade;
drop table if exists `contact_messages` cascade;
drop table if exists `notice_details` cascade;

CREATE TABLE `customer`
(
    `customer_id`   int          NOT NULL AUTO_INCREMENT,
    `name`          varchar(100) NOT NULL,
    `email`         varchar(100) NOT NULL,
    `mobile_number` varchar(20)  NOT NULL,
    `pwd`           varchar(500) NOT NULL,
    `role`          varchar(100) NOT NULL,
    `create_dt`     timestamp DEFAULT NULL,
    `update_dt`     timestamp DEFAULT NULL,
    PRIMARY KEY (`customer_id`)
);


CREATE TABLE `account`
(
    `account_number` long         NOT NULL,
    `customer_id`    int          NOT NULL,
    `account_type`   varchar(100) NOT NULL,
    `branch_address` varchar(200) NOT NULL,
    `create_dt`      timestamp DEFAULT NULL,
    `update_dt`      timestamp DEFAULT NULL,
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
    PRIMARY KEY (`contact_id`)
);