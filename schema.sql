CREATE TABLE orderhistory (
    	order_id serial primary key,
        name varchar,
        cust_order varchar,
        orderCost decimal,
        paymentAmount decimal,
        changegiven decimal
);