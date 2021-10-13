CREATE TABLE Users (
                       id integer PRIMARY KEY AUTO_INCREMENT,
                       name VARChar(100) NOT NULL ,
                       surname varchar(100) NOT NULL ,
                       patronymic varchar(100),
                       age int NOT NULL ,
                       phone varchar(100) NOT NULL ,
                       address varchar(255) NOT NULL,
                       version BIGINT not null default 0
);

CREATE TABLE Accounts (
                          id INTEger PRIMARY KEY AUTO_INCREMENT,
                          user int NOT NULL ,
                          number varchar(100) NOT NULL UNIQUE,
                          balance DECIMAL NOT NULL ,
                          version bigint not null default 0,
                          FOREIGN KEY (user) REFERENCES Users(id) on DELETE CASCADE on UPDATE CASCADE
);

CREATE TABLE Cards (
                       id integer PRIMARY KEY AUTO_INCREMENT,
                       account int NOT NULL ,
                       number varchar(100) NOT NULL UNIQUE,
                       version bigint not null default 0,
                       FOREIGN KEY (account) REFERENCES Accounts(id) on DELETE CASCADE on UPDATE CASCADE
);