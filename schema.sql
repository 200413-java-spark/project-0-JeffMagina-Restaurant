CREATE TABLE OrderHistory (
	order_id serial primary key,
	name varchar,
	orderCost decimal,
	paymentAmount decimal,
	changeGiven decimal
);
CREATE TABLE CustomerOrder (
        order_id int primary key,
        name varchar,
        quantity int
);
ALTER TABLE CustomerOrder
ADD FOREIGN KEY (order_id) REFERENCES OrderHistory(order_id);
