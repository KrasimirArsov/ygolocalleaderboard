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

-- Table: effective_card
CREATE TABLE effective_card (
    name VARCHAR(64) PRIMARY KEY,
    type VARCHAR(64),
    description TEXT,
    race VARCHAR(64),
    atk INT,
    def INT,
    level INT,
    attribute VARCHAR(64)
);

-- Table: set_card
CREATE TABLE set_card (
  set_code VARCHAR(32) NOT NULL,  -- Primary key (set_code)
  name VARCHAR(64) NOT NULL,  -- Foreign key to effective_card(name)
  set_name VARCHAR(255) NOT NULL,
  set_rarity VARCHAR(255) NOT NULL,
  set_price DECIMAL(10, 2) DEFAULT 0.00,
  artwork INT DEFAULT 0,  -- New artwork field with default value
  PRIMARY KEY (set_code),
  CONSTRAINT fk_set_card_name FOREIGN KEY (name) REFERENCES effective_card(name) ON DELETE CASCADE
);

CREATE TABLE deck_set_card (
id int primary key auto_increment,
deck_id int,
set_card_id varchar(32),
foreign key (deck_id) references deck(id),
foreign key (set_card_id) references set_card(set_code)
);

CREATE TABLE card_image (
    id VARCHAR(255) PRIMARY KEY,        -- This represents the file name on the file system
    artwork INT,                        -- Integer field for artwork
    effective_card_id VARCHAR(64),      -- Foreign key referring to the effective_card table
    FOREIGN KEY (effective_card_id) REFERENCES effective_card(name)  -- Assuming 'name' is the PK of effective_card
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

CREATE VIEW player_deck_win_rate AS
SELECT
    p.id AS player_id,
    d.id AS deck_id,
    COUNT(*) AS total_duels,
    SUM(CASE
        WHEN (duel.player_one_id = p.id AND duel.result = 1) OR
             (duel.player_two_id = p.id AND duel.result = 2) THEN 1
        ELSE 0
    END) AS wins,
    (SUM(CASE
        WHEN (duel.player_one_id = p.id AND duel.result = 1) OR
             (duel.player_two_id = p.id AND duel.result = 2) THEN 1
        ELSE 0
    END) / COUNT(*)) * 100 AS win_rate
FROM duel
JOIN player p ON p.id IN (duel.player_one_id, duel.player_two_id)
JOIN deck d ON d.id IN (duel.deck_one_id, duel.deck_two_id)
WHERE (duel.player_one_id = p.id AND duel.deck_one_id = d.id)
      OR (duel.player_two_id = p.id AND duel.deck_two_id = d.id)
GROUP BY p.id, d.id;
