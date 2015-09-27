CREATE TABLE IF NOT EXISTS equipment_type (
	equipment 		VARCHAR(20) NOT NULL,
	equipType 		VARCHAR(30) NOT NULL,
	equipTypeIndex  INT(3) NOT NULL,
	PRIMARY KEY(equipment, equipTypeIndex)
);

INSERT INTO equipment_type VALUES ('Armor', 'Light', 1);
INSERT INTO equipment_type VALUES ('Armor', 'Medium', 2);
INSERT INTO equipment_type VALUES ('Armor', 'Heavy', 3);
INSERT INTO equipment_type VALUES ('Shield', 'Buckler', 1);
INSERT INTO equipment_type VALUES ('Shield', 'Light Shield', 2);
INSERT INTO equipment_type VALUES ('Shield', 'Kite Shield', 3);
INSERT INTO equipment_type VALUES ('Shield', 'Tower Shield', 4);
INSERT INTO equipment_type VALUES ('OneHandWeapon', 'Longsword', 1);
INSERT INTO equipment_type VALUES ('OneHandWeapon', 'Dagger', 2);
INSERT INTO equipment_type VALUES ('OneHandWeapon', 'Cudgel', 3);
INSERT INTO equipment_type VALUES ('TwoHandWeapon', 'Greatsword', 1);
INSERT INTO equipment_type VALUES ('TwoHandWeapon', 'Warhammer', 2);
INSERT INTO equipment_type VALUES ('TwoHandWeapon', 'Staff', 3);
INSERT INTO equipment_type VALUES ('TwoHandWeapon', 'Bow', 4);
INSERT INTO equipment_type VALUES ('TwoHandWeapon', 'Crossbow', 5);

CREATE TABLE IF NOT EXISTS equipment_stat_budget (
	equipment	VARCHAR(20) NOT NULL,
	level		INTEGER NOT NULL,
	stat_points	INTEGER NOT NULL,
	PRIMARY KEY(equipment, level)
);

INSERT INTO equipment_stat_budget VALUES ('Armor', 1, 1);
INSERT INTO equipment_stat_budget VALUES ('Armor', 2, 3);
INSERT INTO equipment_stat_budget VALUES ('Armor', 3, 5);
INSERT INTO equipment_stat_budget VALUES ('Armor', 4, 7);
INSERT INTO equipment_stat_budget VALUES ('Armor', 5, 9);
INSERT INTO equipment_stat_budget VALUES ('Armor', 6, 11);
INSERT INTO equipment_stat_budget VALUES ('Armor', 7, 13);
INSERT INTO equipment_stat_budget VALUES ('Armor', 8, 15);
INSERT INTO equipment_stat_budget VALUES ('Armor', 9, 17);
INSERT INTO equipment_stat_budget VALUES ('Armor', 10, 19);
INSERT INTO equipment_stat_budget VALUES ('Armor', 11, 21);
INSERT INTO equipment_stat_budget VALUES ('Armor', 12, 23);
INSERT INTO equipment_stat_budget VALUES ('Armor', 13, 25);
INSERT INTO equipment_stat_budget VALUES ('Armor', 14, 27);
INSERT INTO equipment_stat_budget VALUES ('Armor', 15, 30);
INSERT INTO equipment_stat_budget VALUES ('Armor', 16, 33);
INSERT INTO equipment_stat_budget VALUES ('Armor', 17, 36);
INSERT INTO equipment_stat_budget VALUES ('Armor', 18, 39);
INSERT INTO equipment_stat_budget VALUES ('Armor', 19, 44);
INSERT INTO equipment_stat_budget VALUES ('Armor', 20, 50);
INSERT INTO equipment_stat_budget VALUES ('Shield', 1, 1);
INSERT INTO equipment_stat_budget VALUES ('Shield', 2, 3);
INSERT INTO equipment_stat_budget VALUES ('Shield', 3, 5);
INSERT INTO equipment_stat_budget VALUES ('Shield', 4, 7);
INSERT INTO equipment_stat_budget VALUES ('Shield', 5, 9);
INSERT INTO equipment_stat_budget VALUES ('Shield', 6, 11);
INSERT INTO equipment_stat_budget VALUES ('Shield', 7, 13);
INSERT INTO equipment_stat_budget VALUES ('Shield', 8, 15);
INSERT INTO equipment_stat_budget VALUES ('Shield', 9, 17);
INSERT INTO equipment_stat_budget VALUES ('Shield', 10, 19);
INSERT INTO equipment_stat_budget VALUES ('Shield', 11, 21);
INSERT INTO equipment_stat_budget VALUES ('Shield', 12, 23);
INSERT INTO equipment_stat_budget VALUES ('Shield', 13, 25);
INSERT INTO equipment_stat_budget VALUES ('Shield', 14, 27);
INSERT INTO equipment_stat_budget VALUES ('Shield', 15, 30);
INSERT INTO equipment_stat_budget VALUES ('Shield', 16, 33);
INSERT INTO equipment_stat_budget VALUES ('Shield', 17, 36);
INSERT INTO equipment_stat_budget VALUES ('Shield', 18, 39);
INSERT INTO equipment_stat_budget VALUES ('Shield', 19, 44);
INSERT INTO equipment_stat_budget VALUES ('Shield', 20, 50);
INSERT INTO equipment_stat_budget VALUES ('OneHandWeapon', 1, 1);
INSERT INTO equipment_stat_budget VALUES ('OneHandWeapon', 2, 3);
INSERT INTO equipment_stat_budget VALUES ('OneHandWeapon', 3, 5);
INSERT INTO equipment_stat_budget VALUES ('OneHandWeapon', 4, 7);
INSERT INTO equipment_stat_budget VALUES ('OneHandWeapon', 5, 9);
INSERT INTO equipment_stat_budget VALUES ('OneHandWeapon', 6, 11);
INSERT INTO equipment_stat_budget VALUES ('OneHandWeapon', 7, 13);
INSERT INTO equipment_stat_budget VALUES ('OneHandWeapon', 8, 15);
INSERT INTO equipment_stat_budget VALUES ('OneHandWeapon', 9, 17);
INSERT INTO equipment_stat_budget VALUES ('OneHandWeapon', 10, 19);
INSERT INTO equipment_stat_budget VALUES ('OneHandWeapon', 11, 21);
INSERT INTO equipment_stat_budget VALUES ('OneHandWeapon', 12, 23);
INSERT INTO equipment_stat_budget VALUES ('OneHandWeapon', 13, 25);
INSERT INTO equipment_stat_budget VALUES ('OneHandWeapon', 14, 27);
INSERT INTO equipment_stat_budget VALUES ('OneHandWeapon', 15, 30);
INSERT INTO equipment_stat_budget VALUES ('OneHandWeapon', 16, 33);
INSERT INTO equipment_stat_budget VALUES ('OneHandWeapon', 17, 36);
INSERT INTO equipment_stat_budget VALUES ('OneHandWeapon', 18, 39);
INSERT INTO equipment_stat_budget VALUES ('OneHandWeapon', 19, 44);
INSERT INTO equipment_stat_budget VALUES ('OneHandWeapon', 20, 50);
INSERT INTO equipment_stat_budget VALUES ('TwoHandWeapon', 1, 1);
INSERT INTO equipment_stat_budget VALUES ('TwoHandWeapon', 2, 3);
INSERT INTO equipment_stat_budget VALUES ('TwoHandWeapon', 3, 5);
INSERT INTO equipment_stat_budget VALUES ('TwoHandWeapon', 4, 7);
INSERT INTO equipment_stat_budget VALUES ('TwoHandWeapon', 5, 9);
INSERT INTO equipment_stat_budget VALUES ('TwoHandWeapon', 6, 11);
INSERT INTO equipment_stat_budget VALUES ('TwoHandWeapon', 7, 13);
INSERT INTO equipment_stat_budget VALUES ('TwoHandWeapon', 8, 15);
INSERT INTO equipment_stat_budget VALUES ('TwoHandWeapon', 9, 17);
INSERT INTO equipment_stat_budget VALUES ('TwoHandWeapon', 10, 19);
INSERT INTO equipment_stat_budget VALUES ('TwoHandWeapon', 11, 21);
INSERT INTO equipment_stat_budget VALUES ('TwoHandWeapon', 12, 23);
INSERT INTO equipment_stat_budget VALUES ('TwoHandWeapon', 13, 25);
INSERT INTO equipment_stat_budget VALUES ('TwoHandWeapon', 14, 27);
INSERT INTO equipment_stat_budget VALUES ('TwoHandWeapon', 15, 30);
INSERT INTO equipment_stat_budget VALUES ('TwoHandWeapon', 16, 33);
INSERT INTO equipment_stat_budget VALUES ('TwoHandWeapon', 17, 36);
INSERT INTO equipment_stat_budget VALUES ('TwoHandWeapon', 19, 44);
INSERT INTO equipment_stat_budget VALUES ('TwoHandWeapon', 20, 50);

CREATE TABLE IF NOT EXISTS num_equipment_stats (
	equip_slot 	VARCHAR(20) UNIQUE NOT NULL,
	num_stats	INTEGER NOT NULL,
	PRIMARY KEY(equip_slot)
);

INSERT INTO num_equipment_stats VALUES ('Armor', 3);
INSERT INTO num_equipment_stats VALUES ('OneHandWeapon', 2);
INSERT INTO num_equipment_stats VALUES ('TwoHandWeapon', 3);
INSERT INTO num_equipment_stats VALUES ('Shield', 2);

CREATE TABLE IF NOT EXISTS abilities (
	name VARCHAR(32),
	character_type VARCHAR(32),
	base_value INTEGER(12),
	scaling FLOAT(5,2),
	per_level INTEGER(12));

INSERT INTO abilities (name,character_type,base_value,scaling,per_level) VALUES ('Wish','Cleric','8','0.5','3');
INSERT INTO abilities (name,character_type,base_value,scaling,per_level) VALUES ('Astral Blessing','Cleric','10','0.6','5');
INSERT INTO abilities (name,character_type,base_value,scaling,per_level) VALUES ('Resistance','Cleric','3','0.3','1');
INSERT INTO abilities (name,character_type,base_value,scaling,per_level) VALUES ('Weaken','Cleric','3','0.3','1');
INSERT INTO abilities (name,character_type,base_value,scaling,per_level) VALUES ('Decimate','Warrior','10','0.5','5');
INSERT INTO abilities (name,character_type,base_value,scaling,per_level) VALUES ('Spinning Slash','Warrior','8','0.5','4');
INSERT INTO abilities (name,character_type,base_value,scaling,per_level) VALUES ('Raise Morale','Warrior','3','0.1','1');
INSERT INTO abilities (name,character_type,base_value,scaling,per_level) VALUES ('Decisive Strike','Warrior','10','1','7');
INSERT INTO abilities (name,character_type,base_value,scaling,per_level) VALUES ('Crescent Slash','Rogue','15','0.7','6');
INSERT INTO abilities (name,character_type,base_value,scaling,per_level) VALUES ('Taste Their Fear','Rogue','8','0.8','5');
INSERT INTO abilities (name,character_type,base_value,scaling,per_level) VALUES ('Dragon Rage','Rogue','20','0.5','5');
INSERT INTO abilities (name,character_type,base_value,scaling,per_level) VALUES ('Shadow Assault','Rogue','15','0.9','8');
INSERT INTO abilities (name,character_type,base_value,scaling,per_level) VALUES ('Disintegrate','Wizard','20','0.6','10');
INSERT INTO abilities (name,character_type,base_value,scaling,per_level) VALUES ('Incinerate','Wizard','25','0.6','9');
INSERT INTO abilities (name,character_type,base_value,scaling,per_level) VALUES ('Shocking Orb','Wizard','18','0.7','7');
INSERT INTO abilities (name,character_type,base_value,scaling,per_level) VALUES ('Dark Matter','Wizard','15','1','8');
INSERT INTO abilities (name,character_type,base_value,scaling,per_level) VALUES ('Swing Ax','GoblinWarrior','0','1','0');
INSERT INTO abilities (name,character_type,base_value,scaling,per_level) VALUES ('Fire Ball','Gob(linMage','0','1','0');
INSERT INTO abilities (name,character_type,base_value,scaling,per_level) VALUES ('Smash','Ogre','0','1','0');
INSERT INTO abilities (name,character_type,base_value,scaling,per_level) VALUES ('Sneak Attack','OrcRogue','0','1','0');
INSERT INTO abilities (name,character_type,base_value,scaling,per_level) VALUES ('Lunge','OrcWarrior','0','1','0');
INSERT INTO abilities (name,character_type,base_value,scaling,per_level) VALUES ('Chump','TrollBoss','0','1','0');

CREATE TABLE IF NOT EXISTS monsters (
	name VARCHAR(30),
	character_type VARCHAR(20),
	base_health FLOAT(5,2),
	health_scaling FLOAT(5,2),
	base_damage FLOAT(5,2),
	base_strength FLOAT(5,2),
	base_dexterity FLOAT(5,2),
	base_intelligence FLOAT(5,2),
	base_wisdom FLOAT(5,2),
	stat_scaling FLOAT(5,2),
	PRIMARY KEY (name)
);

INSERT INTO monsters VALUES ('Goblin Mage', 'Wizard', 50, 1.05, 10, 1, 1, 10, 5, 1.05); 
INSERT INTO monsters VALUES ('Goblin Warrior', 'Warrior', 50, 1.05, 10, 10, 1, 1, 5, 1.05); 
INSERT INTO monsters VALUES ('Orc Rogue', 'Rogue', 50, 1.05, 15, 1, 10, 1, 5, 1.05); 
INSERT INTO monsters VALUES ('Orc Warrior', 'Warrior', 100, 1.05, 15, 10, 1, 1, 5, 1.05); 
INSERT INTO monsters VALUES ('Ogre', 'Warrior', 300, 1.05, 35, 1, 1, 10, 5, 1.05); 
INSERT INTO monsters VALUES ('Troll Boss', 'Warrior', 150, 1.50, 25, 10, 1, 1, 5, 1.05); 