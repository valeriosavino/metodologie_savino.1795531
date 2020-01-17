-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Gen 17, 2020 alle 12:47
-- Versione del server: 10.1.40-MariaDB
-- Versione PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fabbricasemanticadb`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `defann`
--

CREATE TABLE `defann` (
  `Codice` int(11) NOT NULL,
  `Word` text NOT NULL,
  `Hypernym` text NOT NULL,
  `Definition` text NOT NULL,
  `Email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `myann`
--

CREATE TABLE `myann` (
  `Codice` int(11) NOT NULL,
  `Word1` text NOT NULL,
  `Selected1` text NOT NULL,
  `Word2` text NOT NULL,
  `Selected2` text NOT NULL,
  `Word3` text NOT NULL,
  `Selected3` text NOT NULL,
  `Email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `senseann`
--

CREATE TABLE `senseann` (
  `Codice` int(11) NOT NULL,
  `Word` text NOT NULL,
  `Description` text NOT NULL,
  `Senses` text NOT NULL,
  `Email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `senseval`
--

CREATE TABLE `senseval` (
  `Codice` int(11) NOT NULL,
  `Word` text NOT NULL,
  `Example` text NOT NULL,
  `Sense` text NOT NULL,
  `YesNo` text NOT NULL,
  `Email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `trann`
--

CREATE TABLE `trann` (
  `CodiceTA` int(8) NOT NULL,
  `Word` text NOT NULL,
  `Description` text NOT NULL,
  `Translation` text NOT NULL,
  `Email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `trval`
--

CREATE TABLE `trval` (
  `Codice` int(11) NOT NULL,
  `Word` text NOT NULL,
  `Description` text NOT NULL,
  `Translations` text NOT NULL,
  `Email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `utenti`
--

CREATE TABLE `utenti` (
  `Email` varchar(255) NOT NULL,
  `Password` char(32) NOT NULL,
  `LingueSistema` varchar(255) NOT NULL,
  `AltreLingue` text,
  `Livello` char(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `utenti`
--

INSERT INTO `utenti` (`Email`, `Password`, `LingueSistema`, `AltreLingue`, `Livello`) VALUES
('ciaobello22@live.it', '123456789', 'Italiano;', '', NULL),
('ciaobello@live.it', '12345678', 'Inglese;', 'Francese', 'C2');

-- --------------------------------------------------------

--
-- Struttura della tabella `wordann`
--

CREATE TABLE `wordann` (
  `Codice` int(11) NOT NULL,
  `Description` text NOT NULL,
  `Word` text NOT NULL,
  `Email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `defann`
--
ALTER TABLE `defann`
  ADD PRIMARY KEY (`Codice`),
  ADD KEY `Email` (`Email`);

--
-- Indici per le tabelle `myann`
--
ALTER TABLE `myann`
  ADD PRIMARY KEY (`Codice`),
  ADD KEY `Email` (`Email`);

--
-- Indici per le tabelle `senseann`
--
ALTER TABLE `senseann`
  ADD PRIMARY KEY (`Codice`),
  ADD KEY `Email` (`Email`);

--
-- Indici per le tabelle `senseval`
--
ALTER TABLE `senseval`
  ADD PRIMARY KEY (`Codice`),
  ADD KEY `Email` (`Email`);

--
-- Indici per le tabelle `trann`
--
ALTER TABLE `trann`
  ADD PRIMARY KEY (`CodiceTA`),
  ADD KEY `Email` (`Email`);

--
-- Indici per le tabelle `trval`
--
ALTER TABLE `trval`
  ADD PRIMARY KEY (`Codice`),
  ADD KEY `Email` (`Email`);

--
-- Indici per le tabelle `utenti`
--
ALTER TABLE `utenti`
  ADD PRIMARY KEY (`Email`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- Indici per le tabelle `wordann`
--
ALTER TABLE `wordann`
  ADD PRIMARY KEY (`Codice`),
  ADD KEY `Email` (`Email`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `defann`
--
ALTER TABLE `defann`
  MODIFY `Codice` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `myann`
--
ALTER TABLE `myann`
  MODIFY `Codice` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `senseann`
--
ALTER TABLE `senseann`
  MODIFY `Codice` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `senseval`
--
ALTER TABLE `senseval`
  MODIFY `Codice` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `trann`
--
ALTER TABLE `trann`
  MODIFY `CodiceTA` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `trval`
--
ALTER TABLE `trval`
  MODIFY `Codice` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `wordann`
--
ALTER TABLE `wordann`
  MODIFY `Codice` int(11) NOT NULL AUTO_INCREMENT;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `defann`
--
ALTER TABLE `defann`
  ADD CONSTRAINT `defann_ibfk_1` FOREIGN KEY (`Email`) REFERENCES `utenti` (`Email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `myann`
--
ALTER TABLE `myann`
  ADD CONSTRAINT `myann_ibfk_1` FOREIGN KEY (`Email`) REFERENCES `utenti` (`Email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `senseann`
--
ALTER TABLE `senseann`
  ADD CONSTRAINT `senseann_ibfk_1` FOREIGN KEY (`Email`) REFERENCES `utenti` (`Email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `senseval`
--
ALTER TABLE `senseval`
  ADD CONSTRAINT `senseval_ibfk_1` FOREIGN KEY (`Email`) REFERENCES `utenti` (`Email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `trann`
--
ALTER TABLE `trann`
  ADD CONSTRAINT `trann_ibfk_1` FOREIGN KEY (`Email`) REFERENCES `utenti` (`Email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `trval`
--
ALTER TABLE `trval`
  ADD CONSTRAINT `trval_ibfk_1` FOREIGN KEY (`Email`) REFERENCES `utenti` (`Email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `wordann`
--
ALTER TABLE `wordann`
  ADD CONSTRAINT `wordann_ibfk_1` FOREIGN KEY (`Email`) REFERENCES `utenti` (`Email`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
