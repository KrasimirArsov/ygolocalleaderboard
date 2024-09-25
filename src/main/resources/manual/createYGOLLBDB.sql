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

CREATE VIEW deck_win_loss_draw_ratios AS
SELECT
    d.id AS deck_id,
    d.name AS deck_name,
    -- Total duels where the deck was used
    COUNT(duel.id) AS total_duels,

    -- Wins where deck was either deck_one or deck_two
    SUM(CASE WHEN duel.result = 1 AND duel.deck_one_id = d.id THEN 1
             WHEN duel.result = 2 AND duel.deck_two_id = d.id THEN 1
             ELSE 0 END) AS total_wins,

    -- Losses where deck was either deck_one or deck_two
    SUM(CASE WHEN duel.result = 2 AND duel.deck_one_id = d.id THEN 1
             WHEN duel.result = 1 AND duel.deck_two_id = d.id THEN 1
             ELSE 0 END) AS total_losses,

    -- Draws (assuming result = 0 means draw)
    SUM(CASE WHEN duel.result = 0 AND (duel.deck_one_id = d.id OR duel.deck_two_id = d.id) THEN 1
             ELSE 0 END) AS total_draws,

    -- Win ratio
    IFNULL(SUM(CASE WHEN duel.result = 1 AND duel.deck_one_id = d.id THEN 1
                    WHEN duel.result = 2 AND duel.deck_two_id = d.id THEN 1
                    ELSE 0 END) / COUNT(duel.id), 0) AS win_ratio,

    -- Loss ratio
    IFNULL(SUM(CASE WHEN duel.result = 2 AND duel.deck_one_id = d.id THEN 1
                    WHEN duel.result = 1 AND duel.deck_two_id = d.id THEN 1
                    ELSE 0 END) / COUNT(duel.id), 0) AS loss_ratio,

    -- Draw ratio
    IFNULL(SUM(CASE WHEN duel.result = 0 AND (duel.deck_one_id = d.id OR duel.deck_two_id = d.id) THEN 1
                    ELSE 0 END) / COUNT(duel.id), 0) AS draw_ratio

FROM deck d
LEFT JOIN duel ON d.id = duel.deck_one_id OR d.id = duel.deck_two_id
GROUP BY d.id, d.name;

CREATE VIEW player_win_loss_draw_ratios AS
SELECT
    p.id AS player_id,
    p.name AS player_name,

    -- Total duels where the player participated (as either player_one or player_two)
    COUNT(duel.id) AS total_duels,

    -- Wins (player as either player_one or player_two)
    SUM(CASE WHEN duel.result = 1 AND duel.player_one_id = p.id THEN 1
             WHEN duel.result = 2 AND duel.player_two_id = p.id THEN 1
             ELSE 0 END) AS total_wins,

    -- Losses (player as either player_one or player_two)
    SUM(CASE WHEN duel.result = 2 AND duel.player_one_id = p.id THEN 1
             WHEN duel.result = 1 AND duel.player_two_id = p.id THEN 1
             ELSE 0 END) AS total_losses,

    -- Draws (assuming result = 0 means draw)
    SUM(CASE WHEN duel.result = 0 AND (duel.player_one_id = p.id OR duel.player_two_id = p.id) THEN 1
             ELSE 0 END) AS total_draws,

    -- Win ratio
    IFNULL(SUM(CASE WHEN duel.result = 1 AND duel.player_one_id = p.id THEN 1
                    WHEN duel.result = 2 AND duel.player_two_id = p.id THEN 1
                    ELSE 0 END) / COUNT(duel.id), 0) AS win_ratio,

    -- Loss ratio
    IFNULL(SUM(CASE WHEN duel.result = 2 AND duel.player_one_id = p.id THEN 1
                    WHEN duel.result = 1 AND duel.player_two_id = p.id THEN 1
                    ELSE 0 END) / COUNT(duel.id), 0) AS loss_ratio,

    -- Draw ratio
    IFNULL(SUM(CASE WHEN duel.result = 0 AND (duel.player_one_id = p.id OR duel.player_two_id = p.id) THEN 1
                    ELSE 0 END) / COUNT(duel.id), 0) AS draw_ratio

FROM player p
LEFT JOIN duel ON p.id = duel.player_one_id OR p.id = duel.player_two_id
GROUP BY p.id, p.name;

