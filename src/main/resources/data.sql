INSERT INTO product (id, name, category)
VALUES (1, 'Apple', 'FRUITS');
INSERT INTO product (id, name, category)
VALUES (2, 'Banana', 'FRUITS');
INSERT INTO product (id, name, category)
VALUES (3, 'Carrot', 'VEGETABLES');
INSERT INTO product (id, name, category)
VALUES (4, 'Potatoes', 'VEGETABLES');
INSERT INTO product (id, name, category)
VALUES (5, 'Tomato', 'VEGETABLES');
INSERT INTO product (id, name, category)
VALUES (6, 'Milk', 'DAIRY');
INSERT INTO product (id, name, category)
VALUES (7, 'Yogurt', 'DAIRY');

INSERT INTO offer (id, productId, unitOfMeasurement, units, status)
VALUES (1, 4, 'PACKAGE', 1.0, 'SUBMITTED');
INSERT INTO product_offered (id, productId, unitOfMeasurement, units, status)
VALUES (2, 5, 'PACKAGE', 1.0, 'SUBMITTED');
INSERT INTO product_offered (id, productId, unitOfMeasurement, units, status)
VALUES (3, 1, 'PACKAGE', 1.0, 'SUBMITTED');
INSERT INTO product_offered (id, productId, unitOfMeasurement, units, status)
VALUES (4, 1, 'PACKAGE', 1.0, 'RESERVED');
INSERT INTO product_offered (id, productId, unitOfMeasurement, units, status)
VALUES (5, 2, 'PACKAGE', 1.0, 'TAKEN');
INSERT INTO product_offered (id, productId, unitOfMeasurement, units, status)
VALUES (6, 6, 'PACKAGE', 1.0, 'EXPIRED');

INSERT INTO user (id, username, active)
VALUES (1, "test@gmail.com, 1), (2, "test2@gmail.com, 1),
       (3, "test3@gmail.com", 1);

INSERT INTO user_product_subscription (id, userId, productId)
VALUES (1, 1, 1),
       (2, 1, 2),
       (3, 1, 3),
       (4, 2, 5);