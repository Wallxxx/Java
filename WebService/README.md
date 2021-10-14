# Web-Service

Требуется реализовать веб-сервис, реализующий логику работы клиентов  
с банковскими счетами.

Реализовать:  
1) Выпуск новой карты  
2) Просмотр списка карт  
3) Внесение средств  
4) Проверка баланса  

### Запуск

В ```out/artifacts/WebService_jar/``` прописать: ```java -jar WebService.jar```

### Использование

1) Для выпуска новой карты: ```http://localhost:8080/api/cards/newCard/{номер_счёта}```  
2) Для просмотра всех карт пользователя: ```http://localhost:8080/api/cards/getCardsByUserId/{id}```  
3) Для Внесения средств на счёт по номеру счёта: ```http://localhost:8080/api/account/addDeposit/```,  далее **json**:  
```
{
	"number": "number",
	"value": 100
}
```  
4) Для проверки баланса по номеру счёта: ```http://localhost:8080/api/account/getBalanceByAccountNumber/{номер_счёта}```


### Содержимое базы данных

```
INSERT INTO Users (name, surname, patronymic, age, phone, address) VALUES ('Maxim', 'Ushakov', 'Engen', 22, '89851241200', 'Moscow');
INSERT INTO Users (name, surname, patronymic, age, phone, address) VALUES ('Pasha', 'Kisel', 'Olegov', 22, '89833241200', 'Moscow');
INSERT INTO Users (name, surname, patronymic, age, phone, address) VALUES ('Kirill', 'Fost', 'Denisov', 19, '89851266200', 'Tyla');
INSERT INTO Users (name, surname, patronymic, age, phone, address) VALUES ('Leha', 'Demin', 'Ivanov', 21, '89851241258', 'Moscow');

INSERT INTO Accounts (user, number, balance) VALUES (1, '7908-0000', 0);
INSERT INTO Accounts (user, number, balance) VALUES (2, '7908-0021', 0);
INSERT INTO Accounts (user, number, balance) VALUES (3, '7908-0019', 0);
INSERT INTO Accounts (user, number, balance) VALUES (4, '7908-0010', 0);

INSERT INto Cards (account, number) VALUES (1, '1274 0000 5555 0001');
INSERT INto Cards (account, number) VALUES (1, '1274 0000 5555 0002');
INSERT INto Cards (account, number) VALUES (2, '1274 0034 5555 0000');
INSERT INto Cards (account, number) VALUES (3, '1274 0120 5555 0001');
INSERT INto Cards (account, number) VALUES (4, '1274 0077 5555 0001');
```

### Примеры запросов

1) Выпуск новой карты: ```http://localhost:8080/api/cards/newCard/7908-0000``` (создание карты для счёта **7908-0000**)  
2) Просмотр всех карт пользоваетля по его id: ```http://localhost:8080/api/cards/getCardsByUserId/1``` (вывод всех карт пользователя **Maxim**)  
3) Внесение средств (добавить 100 монет на счёт): ```http://localhost:8080/api/account/addDeposit/```, далее **json**:  
```
{
	"number": "7908-0000",
	"value": 100
}
```  
4) Проверка баланса: ```http://localhost:8080/api/account/getBalanceByAccountNumber/7908-0000``` (вывод баланса на счету **7908-0000**)  
