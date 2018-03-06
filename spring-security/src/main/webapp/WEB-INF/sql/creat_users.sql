DROP DATABASE  IF EXISTS `spring_security`;

CREATE DATABASE  IF NOT EXISTS `spring_security`;
USE `spring_security`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--

INSERT INTO `users` 
VALUES 
('atem','{bcrypt}$2a$04$6aAqFWgQla3Zr5WopbmaAOlAwHmuAg6N8QylytxqPnWdhmInhkO2i',1),
('madara','{bcrypt}$2a$04$fUPVhrZSczZrgY/0Z4M1cejg5Otv5eov/mQv66XqNsXiauhLeL.gm',1),
('aizen','{bcrypt}$2a$04$ueDrIXmA4VMlw660SsSrf.6XaUQhV83d9v3iw4KMlllyHyk0c5iVm',1),
('zamasu','{bcrypt}$2a$04$OLxClBGbM5rV3XDlli01QeEqtb2EBvJ0dr8CsThAledvtLE4Hd6pG',1),
('acknologia','{bcrypt}$2a$04$dz51y4Qz6NtHECKaW9S6yuZKL812vYEWBEGe1TbDQ09.vNTTTLdRu',1);


--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('atem','ROLE_EMPLOYEE'),
('madara','ROLE_EMPLOYEE'),
('aizen','ROLE_EMPLOYEE'),
('zamasu','ROLE_EMPLOYEE'),
('acknologia','ROLE_EMPLOYEE'),
('atem','ROLE_MANAGER'),
('madara','ROLE_MANAGER'),
('aizen','ROLE_MANAGER'),
('atem','ROLE_ADMIN');


