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


