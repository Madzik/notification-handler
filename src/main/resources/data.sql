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