-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 08, 2025 at 06:46 AM
-- Server version: 8.0.30
-- PHP Version: 8.3.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `platform_streamdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `films`
--

CREATE TABLE `films` (
  `Id_Film` int NOT NULL,
  `Name_Film` varchar(100) NOT NULL,
  `Genre` varchar(255) NOT NULL,
  `Actor` varchar(255) NOT NULL,
  `Director` varchar(255) NOT NULL,
  `link_film` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `films`
--

INSERT INTO `films` (`Id_Film`, `Name_Film`, `Genre`, `Actor`, `Director`, `link_film`) VALUES
(1, 'The Conjuring', 'Horror', 'Vera Farmiga, Patrick Wilson', 'James Wan', 'https://www.imdb.com/title/tt1457767/'),
(2, 'Die Hard', 'Action', 'Bruce Willis, Alan Rickman', 'John McTiernan', 'https://www.imdb.com/title/tt0095016/'),
(3, 'Psycho', 'Thriller', 'Anthony Perkins, Janet Leigh', 'Alfred Hitchcock', 'https://www.imdb.com/title/tt0054215/'),
(4, 'The Hangover', 'Comedy', 'Bradley Cooper, Ed Helms, Zach Galifianakis', 'Todd Phillips', 'https://www.imdb.com/title/tt1119646/'),
(5, 'La La Land', 'Musical', 'Ryan Gosling, Emma Stone', 'Damien Chazelle', 'https://www.imdb.com/title/tt3783958/'),
(6, 'Titanic', 'Romance', 'Leonardo DiCaprio, Kate Winslet', 'James Cameron', 'https://www.imdb.com/title/tt0120338/'),
(7, 'Star Wars', 'Sci-fi', 'Mark Hamill, Harrison Ford, Carrie Fisher', 'George Lucas', 'https://www.imdb.com/title/tt0076759/'),
(8, 'The Shawshank Redemption', 'Drama', 'Tim Robbins, Morgan Freeman', 'Frank Darabont', 'https://www.imdb.com/title/tt0111161/'),
(9, 'The Lord of the Rings', 'Fantasy', 'Elijah Wood, Viggo Mortensen, Ian McKellen', 'Peter Jackson', 'https://www.imdb.com/title/tt0167260/'),
(10, 'Everything Everywhere All At Once', 'Sci-fi', 'Michelle Yeoh, Ke Huy Quan, Jenny Slate', 'Daniel Kwan dan Daniel Scheinert', 'https://www.imdb.com/title/tt6718412/'),
(11, 'Warkop DKI Reborn: Jangkrik Boss! Part 1', 'Comedy', 'Abimana Aryasatya, Vino G. Bastian, Tora Sudiro', 'Anggy Umbara', 'https://www.imdb.com/title/tt5634446/'),
(12, '500 Days of Summer', 'Romance', 'Joseph Gordon-Levitt, Zooey Deschanel', 'Marc Webb', 'https://www.imdb.com/title/tt1022603/'),
(13, 'The Greatest Showman', 'Musical', 'Hugh Jackman, Zac Efron, Michelle Williams', 'Michael Gracey', 'https://www.imdb.com/title/tt1485796/'),
(14, 'Ip Man', 'Action', 'Donnie Yen, Simon Yam, Lynn Hung', 'Wilson Yip', 'https://www.imdb.com/title/tt1220719/'),
(15, 'Godzilla', 'Sci-fi', 'Aaron Taylor-Johnson, Elizabeth Olsen, Bryan Cranston', 'Gareth Edwards', 'https://www.imdb.com/title/tt1954470/'),
(16, 'Avatar', 'Sci-fi', 'Sam Worthington, Zoe Saldana, Sigourney Weaver', 'James Cameron', 'https://www.imdb.com/title/tt0499549/'),
(17, 'Godzilla Minus One', 'Sci-fi', 'Takumi Saito, Yuki Yamada, Masami Nagasawa', 'Takashi Yamazaki', 'https://www.imdb.com/title/tt14311370/'),
(18, 'Godzilla VS Kong', 'Sci-fi', 'Alexander Skarsgård, Millie Bobby Brown, Rebecca Hall', 'Adam Wingard', 'https://www.imdb.com/title/tt5034838/'),
(19, 'Avengers Endgame', 'Superhero', 'Robert Downey Jr., Chris Evans, Mark Ruffalo', 'Anthony Russo dan Joe Russo', 'https://www.imdb.com/title/tt4154796/'),
(20, 'Captain America : Civil War', 'Superhero', 'Chris Evans, Robert Downey Jr., Scarlett Johansson', 'Anthony Russo dan Joe Russo', 'https://www.imdb.com/title/tt3498820/'),
(21, 'Insidious', 'Horror', 'Patrick Wilson, Rose Byrne, Ty Simpkins', 'James Wan', 'https://www.imdb.com/title/tt1591095/'),
(22, 'Venom', 'Superhero', 'Tom Hardy, Michelle Williams, Riz Ahmed', 'Ruben Fleischer', 'https://www.imdb.com/title/tt1270797/'),
(23, 'Mean Girls', 'Comedy', 'Lindsay Lohan, Rachel McAdams, Lacey Chabert', 'Mark S. Waters', 'https://www.imdb.com/title/tt0377092/'),
(24, 'Gone Girl', 'Thriller', 'Ben Affleck, Rosamund Pike, Neil Patrick Harris', 'David Fincher', 'https://www.imdb.com/title/tt2267998/'),
(25, 'Shutter Island', 'Thriller', 'Leonardo DiCaprio, Mark Ruffalo, Ben Kingsley', 'Martin Scorsese', 'https://www.imdb.com/title/tt1130884/'),
(26, 'John Wick', 'Action', 'Keanu Reeves, Michael Nyqvist, Alfie Allen', 'Chad Stahelski dan David Leitch', 'https://www.imdb.com/title/tt2911666/'),
(27, 'Mission: Impossible', 'Action', 'Tom Cruise, Jon Voight, Emmanuelle Béart', 'Brian De Palma', 'https://www.imdb.com/title/tt0117060/'),
(28, 'The Matrix', 'Sci-fi', 'Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss', 'Lilly Wachowski dan Lana Wachowski', 'https://www.imdb.com/title/tt0133093/'),
(29, 'Hereditary', 'Horror', 'Toni Collette, Alex Wolff, Milly Shapiro', 'Ari Aster', 'https://www.imdb.com/title/tt7784604/'),
(30, 'A Quiet Place', 'Horror', 'Emily Blunt, John Krasinski, Millicent Simmonds', 'John Krasinski', 'https://www.imdb.com/title/tt6644200/'),
(31, 'IT', 'Horror', 'Bill Skarsgård, Jaeden Lieberher, Jeremy Ray Taylor', 'Andy Muschietti', 'https://www.imdb.com/title/tt1396484/'),
(32, 'The Silence of The Lambs', 'Thriller', 'Jodie Foster, Anthony Hopkins, Scott Glenn', 'Jonathan Demme', 'https://www.imdb.com/title/tt0102926/'),
(33, 'Parasite', 'Drama', 'Song Kang-ho, Lee Sun-kyun, Cho Yeo-jeong', 'Bong Joon-ho', 'https://www.imdb.com/title/tt6751668/'),
(34, 'Harry Potter and the Philosopher\'s Stone', 'Fantasy', 'Daniel Radcliffe, Rupert Grint, Emma Watson', 'Chris Columbus', 'https://www.imdb.com/title/tt0241527/'),
(35, 'The Lord of the Rings: The Two Towers', 'Fantasy', 'Elijah Wood, Viggo Mortensen, Ian McKellen', 'Peter Jackson', 'https://www.imdb.com/title/tt0167261/'),
(36, 'Percy Jackson & the Olympians: The Lightning Thief', 'Fantasy', 'Logan Lerman, Alexandra Daddario, Brandon T. Jackson', 'Chris Columbus', 'https://www.imdb.com/title/tt0814255/'),
(37, 'The Chronicles of Narnia: The Lion, the Witch and the Wardrobe', 'Fantasy', 'William Moseley, Anna Popplewell, Skandar Keynes', 'Andrew Adamson', 'https://www.imdb.com/title/tt0363771/'),
(38, 'The Golden Compass', 'Fantasy', 'Nicole Kidman, Daniel Craig, Dakota Blue Richards', 'Chris Weitz', 'https://www.imdb.com/title/tt0385752/'),
(39, 'Stardust', 'Fantasy', 'Claire Danes, Charlie Cox, Michelle Pfeiffer', 'Matthew Vaughn', 'https://www.imdb.com/title/tt0486655/'),
(40, 'The Spiderwick Chronicles', 'Fantasy', 'Freddie Highmore, Mary-Louise Parker, Nick Nolte', 'Mark Waters', 'https://www.imdb.com/title/tt0416236/'),
(41, 'Bridge to Terabithia', 'Fantasy', 'Josh Hutcherson, AnnaSophia Robb, Zooey Deschanel', 'Gábor Csupó', 'https://www.imdb.com/title/tt0398386/'),
(42, 'The NeverEnding Story', 'Fantasy', 'Noah Hathaway, Barret Oliver, Tami Stronach', 'Wolfgang Petersen', 'https://www.imdb.com/title/tt0088323/'),
(43, 'Labyrinth', 'Fantasy', 'David Bowie, Jennifer Connelly, Toby Froud', 'Jim Henson', 'https://www.imdb.com/title/tt0091369/'),
(44, 'Blade Runner 2049', 'Sci-Fi', 'Ryan Gosling, Harrison Ford, Ana de Armas', 'Denis Villeneuve', 'https://www.imdb.com/title/tt1856101/'),
(45, 'Interstellar', 'Sci-Fi', 'Matthew McConaughey, Anne Hathaway, Jessica Chastain', 'Christopher Nolan', 'https://www.imdb.com/title/tt0816692/'),
(46, 'Arrival', 'Sci-Fi', 'Amy Adams, Jeremy Renner, Forest Whitaker', 'Denis Villeneuve', 'https://www.imdb.com/title/tt2543164/'),
(47, 'Ex Machina', 'Sci-Fi', 'Domhnall Gleeson, Alicia Vikander, Oscar Isaac', 'Alex Garland', 'https://www.imdb.com/title/tt0470752/'),
(48, 'Her', 'Sci-Fi', 'Joaquin Phoenix, Amy Adams, Scarlett Johansson', 'Spike Jonze', 'https://www.imdb.com/title/tt1798709/'),
(49, 'The Martian', 'Sci-Fi', 'Matt Damon, Jessica Chastain, Kristen Wiig', 'Ridley Scott', 'https://www.imdb.com/title/tt3659388/'),
(50, 'Inception', 'Sci-Fi', 'Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page', 'Christopher Nolan', 'https://www.imdb.com/title/tt1375666/'),
(51, 'Mad Max: Fury Road', 'Sci-Fi', 'Tom Hardy, Charlize Theron, Nicholas Hoult', 'George Miller', 'https://www.imdb.com/title/tt1392190/'),
(52, 'The Matrix Resurrections', 'Sci-Fi', 'Keanu Reeves, Carrie-Anne Moss, Yahya Abdul-Mateen II', 'Lana Wachowski', 'https://www.imdb.com/title/tt10838180/'),
(53, 'Dune', 'Sci-Fi', 'Timothée Chalamet, Rebecca Ferguson, Oscar Isaac', 'Denis Villeneuve', 'https://www.imdb.com/title/tt11604190/'),
(54, 'Pengabdi Setan', 'Horror', 'Tara Basro, Bront Palarae, Endy Arfian', 'Joko Anwar', 'https://www.imdb.com/title/tt7343314/'),
(55, 'Mantan Manten', 'Drama', 'Reza Rahadian, Vino G. Bastian, Marsha Timothy', 'Joko Anwar', 'https://www.imdb.com/title/tt10436342/'),
(56, 'Gundala', 'Superhero', 'Abimana Aryasatya, Tara Basro, Bront Palarae', 'Joko Anwar', 'https://www.imdb.com/title/tt10436344/'),
(57, 'Impetigore', 'Horror', 'Tara Basro, Marsha Timothy, Christine Hakim', 'Joko Anwar', 'https://www.imdb.com/title/tt10436346/'),
(58, 'Perempuan Tanah Jahanam', 'Horror', 'Tara Basro, Marsha Timothy, Christine Hakim', 'Joko Anwar', 'https://www.imdb.com/title/tt10436348/'),
(59, 'KKN di Desa Penari', 'Horror', 'Tissa Biani, Adinda Thomas, Achmad Megantara', 'Awi Suryadi', 'https://www.imdb.com/title/tt10436350/'),
(60, 'Mencari Hilal', 'Drama', 'Reza Rahadian, Vino G. Bastian, Marsha Timothy', 'Isma YF', 'https://www.imdb.com/title/tt10436352/'),
(61, 'Surga yang Tak Dirindukan', 'Drama', 'Fedi Nuril, Laudya Cynthia Bella, Reza Rahadian', 'Kuntz Agus', 'https://www.imdb.com/title/tt10436354/'),
(62, 'Ayat-Ayat Cinta', 'Drama', 'Fedi Nuril, Rianti Cartwright, Carissa Putri', 'Hanung Bramantyo', 'https://www.imdb.com/title/tt10436356/'),
(63, 'Jalan Yang Jauh Jangan Lupa Pulang', 'Drama', 'Abimana Aryasatya, Vino G. Bastian, Tora Sudiro', 'Anggy Umbara', 'https://www.imdb.com/title/tt1234567/'),
(64, 'Warkop DKI Reborn 3', 'Comedy', 'Abimana Aryasatya, Vino G. Bastian, Tora Sudiro', 'Anggy Umbara', 'https://www.imdb.com/title/tt10436342/'),
(65, 'Warkop DKI Reborn 4', 'Comedy', 'Abimana Aryasatya, Vino G. Bastian, Tora Sudiro', 'Anggy Umbara', 'https://www.imdb.com/title/tt10436344/'),
(66, 'Laskar Pelangi', 'Drama', 'Ikranagara, Slamet Rahardjo, Tora Sudiro', 'Riri Riza', 'https://www.imdb.com/title/tt1285036/'),
(67, '5 cm', 'Drama', 'Fedi Nuril, Herjunot Ali, Denny Sumargo', 'Rizal Mantovani', 'https://www.imdb.com/title/tt2082194/'),
(68, 'Habibie & Ainun', 'Drama', 'Reza Rahadian, Bunga Citra Lestari', 'Fajar Bustomi', 'https://www.imdb.com/title/tt2561114/'),
(69, 'Oppenheimer', 'Drama', 'Tara Basro, Bront Palarae, Ayu Laksmi', 'Joko Anwar', 'https://www.imdb.com/title/tt15325732/'),
(70, 'Wiro Sableng: Pendekar Kapak Maut Naga Geni 212', 'Action', 'Vino G. Bastian, Marsha Timothy, Sherina Munaf', 'Anggy Umbara', 'https://www.imdb.com/title/tt10436346/'),
(71, 'Orang Kaya Baru', 'Comedy', 'Reza Rahadian, Raline Shah, Tora Sudiro', 'Ody C. Harahap', 'https://www.imdb.com/title/tt10436348/'),
(72, 'Inside Out', 'Drama', 'Reza Rahadian, Vino G. Bastian, Marsha Timothy', 'Joko Anwar', 'https://www.imdb.com/title/tt2096673/'),
(73, 'Dua Garis Biru', 'Drama', 'Angga Yunanda, Adhisty Zara', 'Gina S. Noer', 'https://www.imdb.com/title/tt10436352/'),
(74, 'Joker', 'Thriller', 'Joaquin Phoenix, Robert De Niro, Zazie Beetz', 'Todd Phillips', 'https://www.imdb.com/title/tt7286456/'),
(75, 'Spider-Man: Far From Home', 'Superhero', 'Tom Holland, Samuel L. Jackson, Jake Gyllenhaal', 'Jon Watts', 'https://www.imdb.com/title/tt6320628/'),
(76, 'Captain Marvel', 'Superhero', 'Brie Larson, Samuel L. Jackson, Ben Mendelsohn', 'Anna Boden, Ryan Fleck', 'https://www.imdb.com/title/tt4154664/'),
(77, 'Aladdin', 'Fantasy', 'Will Smith, Mena Massoud, Naomi Scott', 'Guy Ritchie', 'Aladdin'),
(78, 'Star Wars: The Rise of Skywalker', 'Action', 'Daisy Ridley, Adam Driver, John Boyega', 'J.J. Abrams', 'https://www.imdb.com/title/tt2527338/'),
(79, 'Doctor Sleep', 'Horror', 'Ewan McGregor, Rebecca Ferguson, Kyliegh Curran', 'Mike Flanagan', 'https://www.imdb.com/title/tt5606664/'),
(80, 'The Substance', 'Thriller', 'Demi Moore, Margaret Qualley', 'Coralie Fargeat', 'https://www.imdb.com/title/tt0117818/'),
(81, 'The Watchers', 'Thriller', 'Corey Haim, Barbara Williams, Lala Sloatman', 'Jon Hess', 'https://www.imdb.com/title/tt0100844/'),
(82, 'Exhuma', 'Horror', 'Kim Go Eun, Lee Dohyun, Choi Minsik', 'Jang Jae-hyun', 'https://www.imdb.com/title/tt10436356/'),
(83, 'The Hunger Games', 'Sci-fi', 'Jennifer Lawrence, Josh Hutcherson, Liam Hemsworth', 'Gary Ross', 'https://www.imdb.com/title/tt1392170/'),
(84, 'The Maze Runner', 'Sci-fi', 'Dylan O\'Brien, Kaya Scodelario, Will Poulter', 'Wes Ball', 'https://www.imdb.com/title/tt1790864/'),
(85, 'The Notebook', 'Romance', 'Ryan Gosling, Rachel McAdams, James Garner', 'Nick Cassavetes', 'https://www.imdb.com/title/tt0332280/'),
(86, 'The Fault in Our Stars', 'Romance', 'Shailene Woodley, Ansel Elgort, Nat Wolff', 'Josh Boone', 'https://www.imdb.com/title/tt2582846/'),
(87, 'P.S. I Love You', 'Romance', 'Hilary Swank, Gerard Butler, Lisa Kudrow', 'Richard LaGravenese', 'https://www.imdb.com/title/tt0431308/'),
(88, 'A Walk to Remember', 'Romance', 'Shane West, Mandy Moore, Peter Coyote', 'Adam Shankman', 'https://www.imdb.com/title/tt0266567/'),
(89, 'The Time Traveler\'s Wife', 'Romance', 'Eric Bana, Rachel McAdams, Arliss Howard', 'Robert Schwentke', 'https://www.imdb.com/title/tt0454794/'),
(90, 'Dear John', 'Romance', 'Channing Tatum, Amanda Seyfried, Richard Jenkins', 'Lasse Hallström', 'https://www.imdb.com/title/tt0983517/');

-- --------------------------------------------------------

--
-- Table structure for table `preferensi`
--

CREATE TABLE `preferensi` (
  `id_preferensi` int NOT NULL,
  `id_user` int NOT NULL,
  `preferensi_genre` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `preferensi_actor` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `preferensi`
--

INSERT INTO `preferensi` (`id_preferensi`, `id_user`, `preferensi_genre`, `preferensi_actor`) VALUES
(10, 2, 'Musical', 'Jackie');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `Id_User` int NOT NULL,
  `Username` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Id_User`, `Username`, `Email`, `Password`, `status`) VALUES
(1, 'Admin 1', 'admin1@gmail.com', 'admin1234', 'admin'),
(2, 'User 1', 'user1@gmail.com', '1234', 'user'),
(8, 'rhainy', 'rhainy@gmail.com', 'rhainy0.', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `films`
--
ALTER TABLE `films`
  ADD PRIMARY KEY (`Id_Film`);

--
-- Indexes for table `preferensi`
--
ALTER TABLE `preferensi`
  ADD PRIMARY KEY (`id_preferensi`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Id_User`) USING BTREE,
  ADD UNIQUE KEY `username` (`Username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `films`
--
ALTER TABLE `films`
  MODIFY `Id_Film` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=94;

--
-- AUTO_INCREMENT for table `preferensi`
--
ALTER TABLE `preferensi`
  MODIFY `id_preferensi` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `Id_User` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `preferensi`
--
ALTER TABLE `preferensi`
  ADD CONSTRAINT `preferensi_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`Id_User`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
