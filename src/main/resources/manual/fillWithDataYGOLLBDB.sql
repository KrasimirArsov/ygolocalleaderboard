
INSERT INTO player (name) VALUES ('Krasimir');
INSERT INTO player (name) VALUES ('Rumen');
INSERT INTO player (name) VALUES ('Dinko');
INSERT INTO player (name) VALUES ('Koceto');
INSERT INTO player (name) VALUES ('Alexander');
INSERT INTO player (name) VALUES ('Niki2');
INSERT INTO player (name) VALUES ('Niki3');


INSERT INTO deck (name) VALUES ('Ultimate Insect');
INSERT INTO deck (name) VALUES ('Water Dedalus');
INSERT INTO deck (name) VALUES ('Dark Paladin');
INSERT INTO deck (name) VALUES ('Ojama Armed');
INSERT INTO deck (name) VALUES ('Silent Magician');
INSERT INTO deck (name) VALUES ('Slifer Jam');
INSERT INTO deck (name) VALUES ('Ra Burn');
INSERT INTO deck (name) VALUES ('Jinzo Controll');


INSERT INTO Duel (player1Id, deck1Id, player2Id, deck2Id, result)
VALUES (3, 3, 4, 4, 2);

//generated

INSERT INTO player (name) VALUES ('Yugi Muto');
INSERT INTO player (name) VALUES ('Seto Kaiba');
INSERT INTO player (name) VALUES ('Joey Wheeler');
INSERT INTO player (name) VALUES ('Mai Valentine');
INSERT INTO player (name) VALUES ('Marik Ishtar');

INSERT INTO deck (name) VALUES ('Yugi\'s Deck');
INSERT INTO deck (name) VALUES ('Kaiba\'s Deck');
INSERT INTO deck (name) VALUES ('Joey\'s Deck');
INSERT INTO deck (name) VALUES ('Mai\'s Deck');
INSERT INTO deck (name) VALUES ('Marik\'s Deck');

INSERT INTO set_card (set_code, name, set_name, set_rarity, set_price)
VALUES
('LOB-001', 'Blue-Eyes White Dragon', 'Legend of Blue Eyes White Dragon', 'Ultra Rare', 250.00),
('LOB-002', 'Dark Magician', 'Legend of Blue Eyes White Dragon', 'Ultra Rare', 180.00),
('MRD-003', 'Red-Eyes B. Dragon', 'Metal Raiders', 'Super Rare', 150.00),
('PGD-004', 'Exodia the Forbidden One', 'Pharaoh\'s Servant', 'Secret Rare', 500.00),
('LOB-005', 'Monster Reborn', 'Legend of Blue Eyes White Dragon', 'Super Rare', 100.00);

INSERT INTO deck_set_card (deck_id, set_card_id) VALUES (1, 'LOB-002'); -- Yugi's Deck has Dark Magician
INSERT INTO deck_set_card (deck_id, set_card_id) VALUES (2, 'LOB-001'); -- Kaiba's Deck has Blue-Eyes White Dragon
INSERT INTO deck_set_card (deck_id, set_card_id) VALUES (3, 'MRD-003'); -- Joey's Deck has Red-Eyes B. Dragon
INSERT INTO deck_set_card (deck_id, set_card_id) VALUES (4, 'LOB-005'); -- Mai's Deck has Monster Reborn
INSERT INTO deck_set_card (deck_id, set_card_id) VALUES (5, 'PGD-004'); -- Marik's Deck has Exodia

INSERT INTO duel (player_one_id, deck_one_id, player_two_id, deck_two_id, result, win_condition)
VALUES
(1, 1, 2, 2, 1, 'Exodia'),
(3, 3, 4, 4, 2, 'LP_Depletion'),
(5, 5, 1, 1, 1, 'Destiny_Board');