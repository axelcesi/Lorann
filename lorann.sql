-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 06 juin 2018 à 21:26
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `lorann`
--

DELIMITER $$
--
-- Procédures
--
DROP PROCEDURE IF EXISTS `query_level`$$
CREATE DEFINER=`java`@`%` PROCEDURE `query_level` (IN `searchedID` INT)  BEGIN
    SELECT Level_Code
    FROM levels
    WHERE ID = searchedID;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `levels`
--

DROP TABLE IF EXISTS `levels`;
CREATE TABLE IF NOT EXISTS `levels` (
  `ID` int(11) NOT NULL,
  `Level_Code` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `levels`
--

INSERT INTO `levels` (`ID`, `Level_Code`) VALUES
(1, 'O-----O-O---O-O----O\r\nI.....I1I...I2I....I\r\nI.....P.I...I.I....I\r\nI.....I.P...I.I....I\r\nI.....I.I...I.I....I\r\nI.....I.I...I.I..@.I\r\nI.....I.I...I.I....I\r\nI.....I.I...P.I....I\r\nI..*..I.I...I.P....I\r\nI.....I.I...I.I....I\r\nO-----O-O---O-O--O$O\r\n....................'),
(2, 'O-----------------O.\r\nI*.......1........I.\r\nI.O------P------O.I.\r\nI.I......2......I.I.\r\nI.I.O---------O.I.I.\r\nI.I.I....@....I.I.I.\r\nI.I.I.........I.I.I.\r\nI.I.O----P----O.I.I.\r\nI.I......3......I.I.\r\nI.O-------------O.I.\r\nI........4.......$O.\r\nO----------------OO.'),
(3, '.....O-------O......\r\n.....I.......I......\r\n.....I.......I......\r\n.....I...@...I......\r\nO----O-OPOPO-O----O.\r\nI....1.......2....I.\r\nI................*I.\r\nO----OPO-O-OPO----O.\r\n.....I.......I......\r\n.....I...3...I......\r\n.....I.......I......\r\n.....O--O$O--O......'),
(4, '......O------O......\r\n....O-O......O-O....\r\n.O--O...O--O...O--O.\r\nOO..1...I..I...2..OO\r\nI*......I@.O.......I\r\nO-------O..P.......I\r\nI.......P..O-------O\r\nI.......O..I.......I\r\nO$..3...I..I...4.O-O\r\n.O--O...O--O...O-O..\r\n....O-O......O-O....\r\n......O------O......'),
(5, 'O-----------------O.\r\nOO.......@.......OO.\r\n.OO--P-------P--OO..\r\n..OO...........OO...\r\n...OO....1....OO....\r\n....OO.......OO.....\r\n.....OO--P--OO......\r\n......I.....I.......\r\nO-----O.....O-----O.\r\nI........*........I.\r\nI..2.....O.....3..I.\r\nO-------O$O-------O.'),
(6, '.....O-------O......\r\n.....I...4...I......\r\n.....I.......I......\r\n.....I...@...I......\r\nO----O-OPOPO-O----O.\r\nI............2....I.\r\nI...............1*I.\r\nO----OPO-O-OPO----O.\r\n.....I.......I......\r\n.....I...3...I......\r\n.....I.......I......\r\n.....O--O$O--O......');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
