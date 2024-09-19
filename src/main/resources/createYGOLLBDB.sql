CREATE DATABASE yugioh;

CREATE TABLE player(
id int primary key auto_increment,
name varchar(32) NOT NULL
);


CREATE TABLE deck(
id int primary key auto_increment,
name varchar(32) NOT NULL
);


CREATE TABLE duel(
id int primary key auto_increment,
player_one_id int NOT NULL,
deck_one_id int NOT NULL,
player_two_id int NOT NULL,
deck_two_id int NOT NULL,
result int NOT NULL,
win_condition ENUM('LP_Depletion', 'Exodia', 'Final_Countdown', 'Vennominaga', 'Last_Turn', 'Destiny_Board') NOT NULL DEFAULT 'LP_Depletion',
duel_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
foreign key (player_one_id) references player(id),
foreign key (player_two_id) references player(id),
foreign key (deck_one_id) references deck(id),
foreign key (deck_two_id) references deck(id),
CHECK (player_one_id != player_two_id),
CHECK (deck_one_id != deck_two_id)
);


CREATE TABLE set_card (
  set_code VARCHAR(32) NOT NULL,  -- Primary key (set_code)
  name VARCHAR(255) NOT NULL,
  set_name VARCHAR(255) NOT NULL,
  set_rarity VARCHAR(32) NOT NULL,
  set_price DECIMAL(10, 2) DEFAULT 0.00,
  PRIMARY KEY (set_code)
);

CREATE TABLE deck_set_card (
id int primary key auto_increment,
deck_id int,
set_card_id varchar(32),
foreign key (deck_id) references deck(id),
foreign key (set_card_id) references set_card(set_code)
);
