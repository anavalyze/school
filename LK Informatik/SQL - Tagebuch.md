[[LK Informatik]]
#28-02-2025

## Datensätze
- schuelerliste

## Attribute

| Attribut | Datentyp |
| -------- | -------- |
| name     | String   |
| vorname  | String   |
| id       | int      |
Primärschlüssel: name


# Befehle

## Erzeugen
INSERT INTO `schuelerliste` (`name`, `vorname`, `id`) VALUES ('Schwarz', 'Michael', '3');
ALTER TABLE `schuelerliste`  ADD `Klasse` INT NOT NULL  AFTER `id`;
INSERT INTO `schuelerliste`(`name`, `vorname`, `sid`) VALUES ("Müller", "Gustav", 20);
INSERT INTO `schuelerliste`(`name`, `vorname`, `sid`) VALUES ("Schenider", "Matheo", 22);
INSERT INTO `schuelerliste`(`name`, `vorname`, `sid`) VALUES ("Klein", "Thomas", 21);

CREATE TABLE zeugnis (
    sid int,
    jahr int,
    halbjahr int,
    ma int,
    de int,
    sp int
); 
## Löschen
ALTER TABLE `schuelerliste` DROP `Klasse`;

## Verändern
UPDATE `schuelerliste` SET `name` = 'Meyer' WHERE `schuelerliste`.`id` = 5;
ALTER TABLE `schuelerliste` CHANGE `id` `sid` INT(5) NOT NULL;
ALTER TABLE `zeugnis` ADD PRIMARY KEY( `sid`);

---




![[Pasted image 20250228103150.png]]




INSERT INTO `schuelerliste` (`name`, `vorname`, `sid`) VALUES ('Schmidt', 'Henri', '7');

UPDATE `schuelerliste` SET `name` = 'Schmiedt' WHERE `schuelerliste`.`name` = 'Schmied';

insert into 'kurs'('knr', 'leiter', 'kname', 'jahrgang) values (25, 'Winkler', 'GKINF', 12);


![[Pasted image 20250228105340.png]]