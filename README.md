# Задача Магазин

## Описание
Это финальная задача! В этом задании попрактикуемся с правилами чистого кода и принципами SOLID.

Нужно написать программу-магазин, в которой пользователи заказывают товары. Вам предоставляется свобода в продумывании функциональности вашей программы, как и в проектировании её структуры. В процессе реализации вы должны применить принцип избегания магических чисел, DRY и как минимум 4 из 5 принципов SOLID, причём явно комментариями в коде или при отправке решения указать по одному примеру применения каждого принципа в вашем решении со ссылками на конкретные места кода на гитхабе.

Примеры возможностей программы:
* Вывод доступных для покупки товаров
* Фильтрация товаров по ключевым словам, ценам, производителям
* Составление продуктовой корзины пользователя
* Трекинг заказа в системе доставки
* Возврат заказа, повтороение заказа
* Система рейтинга для товаров
* Простая рекомендательная система для покупок

## Реализация
1. Продумайте и зафиксируйте список возможностей вашей программы.
2. Продумайте консольный интерфейс взаимодействия пользователя с вашей программой.
3. Продумайте систему классов, которые вам понадобятся для реализации вашей программы.
4. Напишите вашу программу, явно применив вышеперечисленные принципы хорошего кода.
5. При отправке решения укажите, в чём именно было применение каждого этого принципа (по одному примеру) со ссылками на конкретные места кода на гитхабе.
6. Протестируйте работу программы. Не забывайте про правила форматирования кода (для автоформата можете выделить код в идее и нажать **Ctrl+Alt+L**).

## Применение
### S - принцип единственной ответственности (Single Responsibility Principle)
Класс должен выполнять только те функции, для которых он логически предназначен.

Пример:
- [InventoryUtilImpl.java](ecommerce-service/src/main/java/com/dromakin/ecommerce/utils/InventoryUtilImpl.java)
- [InventoryServiceImpl.java](ecommerce-service/src/main/java/com/dromakin/ecommerce/services/InventoryServiceImpl.java)

### O - принцип открытости/закрытости (Open Closed Principle)
Программные сущности должны быть открыты для расширения, но закрыты для
модификации.

Например:
- [OrderService.java](ecommerce-service/src/main/java/com/dromakin/ecommerce/services/OrderService.java)

### L - принцип замены Барбары Лисков (Liskov Substitution Principle)
Наследуй только тогда, когда можешь играть роль за предка.


### I - принцип сегрегации (разделения) интерфейса (Interface Segregation Principle)
Много интерфейсов, специально предназначенных для клиентов, лучше, чем один
интерфейс общего назначения.

В utils, services много интерфейсов, которые скрывают реализацию методов.

Например:
- [CalculatorRatingProduct.java](ecommerce-service/src/main/java/com/dromakin/ecommerce/utils/CalculatorRatingProduct.java)
- [CalculatorRatingProductImpl.java](ecommerce-service/src/main/java/com/dromakin/ecommerce/utils/CalculatorRatingProductImpl.java)

### D - принцип инверсии зависимостей (Dependency Inversion Principle)
Всё зависит от абстракций (интерфейсов), а не от деталей реализации друг друга.

Прекрасный пример это сервисы в spring boot приложении.

Например:
- [ProductService.java](ecommerce-service/src/main/java/com/dromakin/ecommerce/services/ProductService.java)

### Правило DRY (Don’t Repeat Yourself): не повторяй свой код

Нужные функции для [InventoryServiceImpl класса](ecommerce-service/src/main/java/com/dromakin/ecommerce/services/InventoryServiceImpl.java) я вынес в [InventoryUtilImpl.java](ecommerce-service/src/main/java/com/dromakin/ecommerce/utils/InventoryUtilImpl.java) класс.


## Дополнительно
Как запустить для проверки?

```shell
docker-compose up
```
![0.png](docs%2F0.png)
![1.png](docs%2F1.png)


### Swagger API
http://localhost:8081/swagger-ui.html

![2.png](docs%2F2.png)
![3.png](docs%2F3.png)

#### Задания

* Вывод доступных для покупки товаров

http://localhost:8081/swagger-ui.html#!/inventory-controller/readAllUsingGET

Фильтр по уникальному значению:

http://localhost:8081/swagger-ui.html#!/inventory-controller/readByCodeUsingGET

* Фильтрация товаров по ключевым словам, ценам, производителям

http://localhost:8081/swagger-ui.html#!/product-controller/readByNameUsingGET_1

http://localhost:8081/swagger-ui.html#!/product-controller/getByPriceUsingPOST

http://localhost:8081/swagger-ui.html#!/product-controller/readByManufacturerIdUsingGET

* Составление продуктовой корзины пользователя

http://localhost:8081/swagger-ui.html#!/order-controller/readUsingGET_3

* Трекинг заказа в системе доставки

http://localhost:8081/swagger-ui.html#!/order-controller/getActiveOrdersUsingGET

ACTIVE статусы: InDelivery, Wrapping, Checking (default)

ARCHIVED статусы: Delivered, Returned, Canceled

Посмотреть активные статусы:
http://localhost:8081/swagger-ui.html#!/order-controller/getActiveOrdersUsingGET

Посмотреть архивные статусы:
http://localhost:8081/swagger-ui.html#!/order-controller/getArchivedOrdersUsingGET

Варианты доставки:
- Checking -> Wrapping -> InDelivery -> Delivered (обычный заказ)
- Checking -> Wrapping -> InDelivery -> Returned (возврат)
- Checking -> Canceled (отменили заказ)


Изменение статуса происходит в ручном режиме.

http://localhost:8081/swagger-ui.html#!/order-controller/updateStatusUsingPOST

Сторонний сервис доставки должен делать запрос на наш REST API.


* Возврат заказа, повтороение заказа

Так как данные из таблицы не удаляются и меняются статусы с ACTIVE на ARCHIVED.

То для повтора заказа нам необходимо просто поменять статус и еще раз его выполнить.

На рекомендательную систему это никак не повлияет.

* Система рейтинга для товаров

http://localhost:8081/swagger-ui.html#!/inventory-controller/ratingUsingGET

http://localhost:8081/swagger-ui.html#!/inventory-controller/ratingUsingGET_1

* Простая рекомендательная система для покупок

http://localhost:8081/swagger-ui.html#!/order-controller/getRecommendationsUsingPOST

http://localhost:8081/swagger-ui.html#!/order-controller/getRecommendationsUsingGET

## Проверка API через POSTMAN:
[Netology.postman_collection.json](Netology.postman_collection.json)

![4.png](docs%2F4.png)
