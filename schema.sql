CREATE TABLE customer(
        customerID serial primary key,
        name varchar
);

CREATE TABLE customerTicket (
        customerTicketID serial primary key,
        customerID int REFERENCES customer(customerID),
        orderCost decimal,
        paymentAmount decimal,
        changeGiven decimal
);

CREATE TABLE orderItem (
        orderItemID serial primary key,
        customerTicketID int REFERENCES customerTicket(customerTicketID),
        quantity int,
        name varchar
);