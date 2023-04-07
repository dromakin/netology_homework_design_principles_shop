DELETE FROM manufacturer;

insert into manufacturer(id, name, description)
VALUES (1, 'LTD MilkProducts', 'Make milk products'),
       (2, 'Swisher Milk Productions', 'Make milk products'),
       (3, 'Bakery Products By Voshue', 'production of bakery products')
;

DELETE FROM products;
insert into products(id, code, name, description, price, manufacturer) VALUES
       (1, 'P1001', 'Milk', 'UHT Milk 1.5%', 10, 1),
       (2, 'P1002', 'Milk', 'Whole milk 4.5%', 15, 1),
       (3, 'P1003', 'Yogurt', 'Spoon yogurt 1%', 20, 1),
       (4, 'P1004', 'Yogurt', 'Spoon yogurt with raspberries 1%', 25, 1),
       (5, 'P1005', 'Yogurt', 'Spoon yogurt with peach 1%', 25, 1),
       (6, 'P1006', 'Yogurt', 'Spoon yogurt with wild berries 1%', 25, 1),
       (7, 'P1007', 'Yogurt', 'Drinking yogurt 1%', 20, 1),
       (8, 'P1008', 'Yogurt', 'Drinking yogurt with peach 1%', 20, 1),
       (9, 'P2001', 'Milk', 'UHT Milk 1%', 10, 2),
       (10, 'P2002', 'Milk', 'Whole milk 5%', 16, 2),
       (11, 'P2003', 'Yogurt', 'Spoon yogurt 0.5%', 22, 2),
       (12, 'P2004', 'Yogurt', 'Spoon yogurt with raspberries 0.5%', 27, 2),
       (13, 'P2005', 'Yogurt', 'Spoon yogurt with peach 0.5%', 25, 2),
       (14, 'P2006', 'Yogurt', 'Spoon yogurt with wild berries 1%', 25, 2),
       (15, 'P2007', 'Yogurt', 'Drinking yogurt 1%', 25, 2),
       (16, 'P2008', 'Yogurt', 'Drinking yogurt with peach 1%', 25, 2),
       (17, 'P3001', 'Bread', 'Fresh bread', 5, 3),
       (18, 'P3002', 'Cake', 'Fresh Cake with wild berries', 50, 3),
       (19, 'P3003', 'Cake', 'Сake with biscuit', 20, 3),
       (20, 'P3004', 'Cookie', 'Chocolate cookie', 15, 3),
       (21, 'P3005', 'Cookie', 'Biscuit cookie', 15, 3)
;
