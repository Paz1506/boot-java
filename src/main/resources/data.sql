INSERT INTO USERS (EMAIL, FIRST_NAME, LAST_NAME, PASSWORD)
VALUES ('user@gmail.com', 'User_First', 'User_Last', 'password'),
       ('admin@javaops.ru', 'Admin_First', 'Admin_Last', 'admin');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('ROLE_USER', 1),
       ('ROLE_ADMIN', 2),
       ('ROLE_USER', 2);

INSERT INTO RESTAURANT (RESTAURANT_NAME)
VALUES ('burger king'),
       ('white rabbit'),
       ('golden');

INSERT INTO MENU (MENU_NAME, OFFER_DATE, RESTAURANT_ID)
VALUES ('dinner', '2020-07-12 21:31:44.976143', 1),
       ('lunch', '2020-07-12 21:31:44.976143', 2),
       ('eat', '2020-07-12 21:31:44.976143', 3);

INSERT INTO DISH (DISH_NAME, PRICE, MENU_ID)
VALUES ('soup', 80, 1),
       ('burger', 105, 1),
       ('rice', 100, 2),
       ('juice', 35, 3);