CREATE DATABASE yugioh;

CREATE TABLE Player(
id int primary key auto_increment,
name varchar(32)
);

INSERT INTO Player (name) VALUES ('Krasimir');
INSERT INTO Player (name) VALUES ('Rumen');
INSERT INTO Player (name) VALUES ('Dinko');
INSERT INTO Player (name) VALUES ('Koceto');
INSERT INTO Player (name) VALUES ('Alexander');
INSERT INTO Player (name) VALUES ('Niki2');
INSERT INTO Player (name) VALUES ('Niki3');

CREATE TABLE Deck(
id int primary key auto_increment,
name varchar(32)
);

INSERT INTO Deck (name) VALUES ('Ultimate Insect');
INSERT INTO Deck (name) VALUES ('Water Dedalus');
INSERT INTO Deck (name) VALUES ('Dark Paladin');
INSERT INTO Deck (name) VALUES ('Ojama Armed');
INSERT INTO Deck (name) VALUES ('Silent Magician');
INSERT INTO Deck (name) VALUES ('Slifer Jam');
INSERT INTO Deck (name) VALUES ('Ra Burn');
INSERT INTO Deck (name) VALUES ('Jinzo Controll');

CREATE TABLE Duelist(
id int primary key auto_increment,
playerId int,
deckId int,
foreign key (playerId) references Player(id),
foreign key (deckId) references Deck(id)
);

ALTER TABLE Duelist
ADD CONSTRAINT pdUnique UNIQUE (playerId, deckId);

SELECT * FROM Player;
SELECT * FROM Deck;

SELECT id FROM Player WHERE name = 'Rumen';
SELECT id FROM Deck WHERE name = 'Water Dedalus';

CREATE TABLE Duel(
id int primary key auto_increment,
player1Id int,
deck1Id int,
player2Id int,
deck2Id int,
result int,
foreign key (player1Id) references Player(id),
foreign key (player2Id) references Player(id),
foreign key (deck1Id) references Deck(id),
foreign key (deck2Id) references Deck(id),
CHECK (player1Id != player2Id),
CHECK (deck1Id != deck2Id)
);


INSERT INTO Duel (player1Id, deck1Id, player2Id, deck2Id, result)
VALUES (3, 3, 4, 4, 2);


SELECT COUNT(*) AS victoriesPlayer FROM Duel WHERE (player1Id = 2 AND result = 1) OR (player2Id = 2 AND result = 2);

SELECT COUNT(*) AS lossesPlayer FROM Duel WHERE (player1Id = 2 AND result = 2) OR (player2Id = 2 AND result = 1);

SELECT COUNT(*) AS drawsPlayer FROM Duel WHERE (player1Id = 2 AND result = 0) OR (player2Id = 2 AND result = 0);


SELECT COUNT(*) AS victoriesDeck FROM Duel WHERE (deck1Id = 2 AND result = 1) OR (deck2Id = 2 AND result = 2);

SELECT COUNT(*) AS lossesPlayer FROM Duel WHERE (deck1Id = 2 AND result = 2) OR (deck2Id = 2 AND result = 1);

SELECT COUNT(*) AS drawsPlayer FROM Duel WHERE (deck1Id = 2 AND result = 0) OR (deck2Id = 2 AND result = 0);