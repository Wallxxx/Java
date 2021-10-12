CREATE TABLE Users (
                       id integer PRIMARY KEY AUTO_INCREMENT,
                       name VARChar(100),
                       surname varchar(100),
                       patronymic varchar(100),
                       age int,
                       phone varchar(100),
                       address varchar(255)
);

CREATE TABLE Accounts (
                          id INTEger PRIMARY KEY AUTO_INCREMENT,
                          user int,
                          number varchar(100),
                          balance DECIMAL,
                          FOREIGN KEY (user) REFERENCES Users(id) on DELETE CASCADE on UPDATE CASCADE
);

CREATE TABLE Cards (
                       id integer PRIMARY KEY AUTO_INCREMENT,
                       account int,
                       number varchar(100),
                       FOREIGN KEY (account) REFERENCES Accounts(id) on DELETE CASCADE on UPDATE CASCADE
);