-- INSERT INTO `permission` (`permission_id`, `name`)
-- VALUES ('001', 'READ'),
--        ('002', 'EDIT'),
--        ('003', 'ADD'),
--        ('004', 'DELETE');
--
-- INSERT INTO `role` (`role_id`, `role_name`)
-- VALUES ('001', 'ADM001'),
--        ('002', 'SUB001'),
--        ('003', 'SUB002'),
--        ('004', 'SUB003'),
--        ('005', 'SUB004'),
--        ('006', 'USE001');
--
-- INSERT INTO `role_permission` (`role_name`, `permission_id`)
-- VALUES ('ADM001', '001'),
--        ('ADM001', '002'),
--        ('ADM001', '003'),
--        ('ADM001', '004'),
--        ('SUB001', '001'),
--        ('SUB001', '002'),
--        ('SUB001', '003'),
--        ('SUB002', '001'),
--        ('SUB002', '002'),
--        ('SUB002', '003'),
--        ('USE001', '001'),
--        ('USE001', '003');

INSERT INTO `customer` (`name`, `email`, `mobile_number`, `pwd`, `role`, `create_dt`, `update_dt`)
VALUES ('Happy', 'happy@example.com', '9876548337', '$2y$12$oRRbkNfwuR8ug4MlzH5FOeui.//1mkd.RsOAJMbykTSupVy.x/vb2',
        '001', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());


INSERT INTO `customer` (`name`, `email`, `mobile_number`, `pwd`, `role`, `create_dt`, `update_dt`)
VALUES ('Happy', 'DaLQA', '9876548337', '$2y$12$oRRbkNfwuR8ug4MlzH5FOeui.//1mkd.RsOAJMbykTSupVy.x/vb2',
        '001', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());


INSERT INTO `account` (`customer_id`, `account_number`, `account_type`, `branch_address`, `create_dt`, `update_dt`)
VALUES (1, 1865764534, 'Savings', '123 Main Street, New York', current_timestamp(), CURRENT_TIMESTAMP());



INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_dt, transaction_summary,
                                  transaction_type, transaction_amt, closing_balance, create_dt, update_dt)
VALUES (UUID(), 1865764534, 1, CURRENT_DATE - 7, 'Coffee Shop', 'Withdrawal', 30, 34500,
        CURRENT_TIMESTAMP() - INTERVAL '7' DAY, NULL);

INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_dt, transaction_summary,
                                  transaction_type, transaction_amt, closing_balance, create_dt, update_dt)
VALUES (UUID(), 1865764534, 1, CURRENT_DATE - 6, 'Uber', 'Withdrawal', 100, 34400,
        CURRENT_TIMESTAMP() - INTERVAL '6' DAY, NULL);

INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_dt, transaction_summary,
                                  transaction_type, transaction_amt, closing_balance, create_dt, update_dt)
VALUES (UUID(), 1865764534, 1, CURRENT_DATE - 5, 'Self Deposit', 'Deposit', 500, 34900,
        CURRENT_TIMESTAMP() - INTERVAL '5' DAY, NULL);

INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_dt, transaction_summary,
                                  transaction_type, transaction_amt, closing_balance, create_dt, update_dt)
VALUES (UUID(), 1865764534, 1, CURRENT_DATE - 4, 'Ebay', 'Withdrawal', 600, 34300,
        CURRENT_TIMESTAMP() - INTERVAL '4' DAY, NULL);

INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_dt, transaction_summary,
                                  transaction_type, transaction_amt, closing_balance, create_dt, update_dt)
VALUES (UUID(), 1865764534, 1, CURRENT_DATE - 2, 'OnlineTransfer', 'Deposit', 700, 35000,
        CURRENT_TIMESTAMP() - INTERVAL '2' DAY, NULL);

INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_dt, transaction_summary,
                                  transaction_type, transaction_amt, closing_balance, create_dt, update_dt)
VALUES (UUID(), 1865764534, 1, CURRENT_DATE - 1, 'Amazon.com', 'Withdrawal', 100, 34900,
        CURRENT_TIMESTAMP() - INTERVAL '1' DAY, NULL);



INSERT INTO `loans` (`customer_id`, `start_dt`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`,
                     `create_dt`, `update_dt`)
VALUES (1, '2020-10-13', 'Home', 200000, 50000, 150000, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO `loans` (`customer_id`, `start_dt`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`,
                     `create_dt`, `update_dt`)
VALUES (1, '2020-06-06', 'Vehicle', 40000, 10000, 30000, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO `loans` (`customer_id`, `start_dt`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`,
                     `create_dt`, `update_dt`)
VALUES (1, '2018-02-14', 'Home', 50000, 10000, 40000, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO `loans` (`customer_id`, `start_dt`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`,
                     `create_dt`, `update_dt`)
VALUES (1, '2018-02-14', 'Personal', 10000, 3500, 6500, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO `cards` (`card_number`, `customer_id`, `card_type`, `total_limit`, `amount_used`, `available_amount`,
                     `create_dt`, `update_dt`)
VALUES ('4565XXXX4656', 1, 'Credit', 10000, 500, 9500, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO `cards` (`card_number`, `customer_id`, `card_type`, `total_limit`, `amount_used`, `available_amount`,
                     `create_dt`, `update_dt`)
VALUES ('3455XXXX8673', 1, 'Credit', 7500, 600, 6900, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO `cards` (`card_number`, `customer_id`, `card_type`, `total_limit`, `amount_used`, `available_amount`,
                     `create_dt`, `update_dt`)
VALUES ('2359XXXX9346', 1, 'Credit', 20000, 4000, 16000, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());


INSERT INTO notice_details (notice_summary, notice_details, notice_beg_dt, notice_end_dt, create_dt, update_dt)
VALUES ('Home Loan Interest rates reduced',
        'Home loan interest rates are reduced as per the government guidelines. The updated rates will be effective immediately',
        CURRENT_DATE - 30, CURRENT_DATE + 30, CURRENT_TIMESTAMP(), null);

INSERT INTO notice_details (notice_summary, notice_details, notice_beg_dt, notice_end_dt, create_dt, update_dt)
VALUES ('Net Banking Offers',
        'Customers who will opt for Internet banking while opening a saving account will get a $50 amazon voucher',
        CURRENT_DATE - 30, CURRENT_DATE + 30, CURRENT_TIMESTAMP(), null);

INSERT INTO notice_details (notice_summary, notice_details, notice_beg_dt, notice_end_dt, create_dt, update_dt)
VALUES ('Mobile App Downtime',
        'The mobile application of the EazyBank will be down from 2AM-5AM on 12/05/2020 due to maintenance activities',
        CURRENT_DATE - 30, CURRENT_DATE + 30, CURRENT_TIMESTAMP(), null);

INSERT INTO notice_details (notice_summary, notice_details, notice_beg_dt, notice_end_dt, create_dt, update_dt)
VALUES ('E Auction notice',
        'There will be an e-auction on 12/08/2020 on the Bank website for all the stubborn arrears. Interested parties can participate in the e-auction',
        CURRENT_DATE - 30, CURRENT_DATE + 30, CURRENT_TIMESTAMP(), null);

INSERT INTO notice_details (notice_summary, notice_details, notice_beg_dt, notice_end_dt, create_dt, update_dt)
VALUES ('Launch of Millennia Cards',
        'Millennia Credit Cards are launched for the premium customers of EazyBank. With these cards, you will get 5% cashback for each purchase',
        CURRENT_DATE - 30, CURRENT_DATE + 30, CURRENT_TIMESTAMP(), null);

INSERT INTO notice_details (notice_summary, notice_details, notice_beg_dt, notice_end_dt, create_dt, update_dt)
VALUES ('COVID-19 Insurance',
        'EazyBank launched an insurance policy which will cover COVID-19 expenses. Please reach out to the branch for more details',
        CURRENT_DATE - 30, CURRENT_DATE + 30, CURRENT_TIMESTAMP(), null);


--
-- INSERT INTO `authorities` (`customer_id`, `name`)
-- VALUES (1, 'VIEWACCOUNT');
--
-- INSERT INTO `authorities` (`customer_id`, `name`)
-- VALUES (1, 'VIEWCARDS');
--
-- INSERT INTO `authorities` (`customer_id`, `name`)
-- VALUES (1, 'VIEWLOANS');
--
-- INSERT INTO `authorities` (`customer_id`, `name`)
-- VALUES (1, 'VIEWBALANCE');
--
DELETE
FROM `authorities`;

INSERT INTO `authorities` (`customer_id`, `name`)
VALUES (1, 'ROLE_USER');

INSERT INTO `authorities` (`customer_id`, `name`)
VALUES (1, 'ROLE_ADMIN');

INSERT INTO `authorities` (`customer_id`, `name`)
VALUES (2, 'ROLE_ADMIN');