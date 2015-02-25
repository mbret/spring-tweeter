-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
<<<<<<< HEAD
-- Client :  127.0.0.1
-- Généré le :  Mer 25 Février 2015 à 00:26
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12
=======
-- Host: 127.0.0.1
-- Generation Time: Feb 25, 2015 at 01:24 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12
>>>>>>> 561010c50cf8c690b15c5d06e10192181f378915

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `spring`
--

-- --------------------------------------------------------

--
-- Structure de la table `follow`
--

CREATE TABLE IF NOT EXISTS `follow` (
  `id` varchar(200) NOT NULL,
  `followed` varchar(200) NOT NULL,
  `follower` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `followed` (`followed`),
  KEY `follower` (`follower`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `tweet`
--

CREATE TABLE IF NOT EXISTS `tweet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(200) NOT NULL,
  `user` varchar(200) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
<<<<<<< HEAD
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

=======
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;
>>>>>>> 561010c50cf8c690b15c5d06e10192181f378915

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` varchar(200) NOT NULL,
  `firstName` varchar(200) NOT NULL,
  `mail` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `password` varchar(30) NOT NULL,
<<<<<<< HEAD
  PRIMARY KEY (`id`)
=======
  PRIMARY KEY (`id`),
  UNIQUE KEY `mail` (`mail`)
>>>>>>> 561010c50cf8c690b15c5d06e10192181f378915
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `follow`
--
ALTER TABLE `follow`
  ADD CONSTRAINT `follow_ibfk_2` FOREIGN KEY (`follower`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `follow_ibfk_1` FOREIGN KEY (`followed`) REFERENCES `user` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
