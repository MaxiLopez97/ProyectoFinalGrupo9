-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-11-2023 a las 18:26:37
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bomberos`
--
CREATE DATABASE IF NOT EXISTS `bomberos` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bomberos`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bombero`
--

CREATE TABLE `bombero` (
  `id_bombero` int(11) NOT NULL,
  `dni` varchar(8) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `fecha_nac` date NOT NULL,
  `celular` varchar(15) NOT NULL,
  `codBrigada` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `bombero`
--

INSERT INTO `bombero` (`id_bombero`, `dni`, `nombre`, `apellido`, `fecha_nac`, `celular`, `codBrigada`, `estado`) VALUES
(1, '39212122', 'Maxi', 'López', '1999-08-17', '31232132', 13, 1),
(8, '32131231', 'Juan Bautista ', 'Altamirano', '2000-01-19', '3213131', 33, 1),
(9, '31313131', 'dasdsa', 'dsadsad', '2020-11-18', '2312231', 14, 1),
(10, '2', 'aa', 'dd', '2023-11-04', '3213', 30, 1),
(11, '33', 'Nahuels', 'Escuderos', '2018-11-23', '23123', 30, 0),
(12, '11111', 'aaaadas', 'dsadas', '2021-11-13', '312312', 14, 0),
(13, '22222', 'dsadasdas', 'dsadasdas', '2021-11-21', '231321', 14, 1),
(14, '321312', 'dsadsadasdq', 'qeqwsdsa', '2020-11-03', '231321', 14, 1),
(15, '33422', 'dsadasaaa', 'ewqewq', '2023-11-05', '312312', 14, 1),
(16, '34444', 'ewwqqw', 'dasdada', '2020-11-07', '1111', 30, 1),
(17, '321321', 'dsadas', 'dsadas', '2015-11-25', '312312', 14, 1),
(26, '312312', 'dsadsa', 'dsadas', '2023-11-01', '312312', 30, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `brigada`
--

CREATE TABLE `brigada` (
  `codBrigada` int(11) NOT NULL,
  `nombre_br` varchar(20) NOT NULL,
  `especialidad` varchar(30) NOT NULL,
  `nro_cuartel` int(11) NOT NULL,
  `disponible` tinyint(1) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `brigada`
--

INSERT INTO `brigada` (`codBrigada`, `nombre_br`, `especialidad`, `nro_cuartel`, `disponible`, `estado`) VALUES
(13, 'Ala Norte', 'INCENDIO', 2, 0, 0),
(14, 'Forza', 'DERRUMBES', 1, 0, 1),
(19, 'Prueba', 'INUNDACIONES', 1, 0, 0),
(20, 'a', 'INCENDIO', 1, 0, 0),
(21, 'a', 'INCENDIO', 2, 0, 0),
(22, 'as', 'DERRUMBES', 2, 0, 0),
(23, 'a', 'INCENDIO', 2, 0, 0),
(24, 'ola', 'DERRUMBES', 2, 0, 0),
(25, 'qqq', 'DERRUMBES', 2, 0, 0),
(26, 'aasd', 'RESCATES_TRAFICO', 2, 0, 0),
(27, 'dsadas', 'DERRUMBES', 2, 0, 0),
(28, 'sdadsadas', 'RESCATES_TRAFICO', 1, 0, 0),
(29, 'oaaa', 'RESCATES_TRAFICO', 2, 0, 0),
(30, 'Sky', 'RESCATES_MONTAÑAS', 3, 0, 1),
(31, 'Osky', 'RESCATES_TRAFICO', 3, 0, 1),
(32, 'Kao', 'INUNDACIONES', 3, 0, 1),
(33, 'Yris', 'OPERATIVOS_PREVENCION', 3, 0, 1),
(34, 'dasdasdas', 'INCENDIO', 2, 0, 0),
(35, 'Legion', 'DERRUMBES', 4, 0, 0),
(36, 'Arton', 'RESCATES_MONTAÑAS', 3, 0, 0),
(37, 'Pruebasss', 'DERRUMBES', 3, 0, 0),
(38, 'disponible', 'DERRUMBES', 4, 0, 0),
(39, 'Ultima Brigada', 'RESCATES_MONTAÑAS', 5, 0, 0),
(40, 'aaa', 'DERRUMBES', 5, 1, 1),
(41, 'bbb', 'RESCATES_MONTAÑAS', 5, 1, 1),
(42, 'Grupo 9', 'DERRUMBES', 7, 1, 1),
(43, 'a', 'DERRUMBES', 4, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuartel`
--

CREATE TABLE `cuartel` (
  `codCuartel` int(11) NOT NULL,
  `nombre_cuartel` varchar(20) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `coord_X` int(11) NOT NULL,
  `coord_Y` int(11) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cuartel`
--

INSERT INTO `cuartel` (`codCuartel`, `nombre_cuartel`, `direccion`, `coord_X`, `coord_Y`, `telefono`, `correo`, `estado`) VALUES
(1, 'Osyris', 'Av. Norte 232', 332, 1762, '12320123', 'Osyris@gmail.com', 1),
(2, 'Sureste', 'Lafinur 471', 1532, 1745, '265712548', 'sur@gmail.com', 1),
(3, 'Sur', 'Boyero 11', 321, 232, '21321231', 'Sur@gmail.com', 1),
(4, 'Niress', 'AV Corrientes', 123, 333, '3213213', 'nire@gmail.com', 0),
(5, 'Ultima Prueba', 'Av Sol', 213, 1800, '32133132', 'prueba@gmail.com', 1),
(6, 'dsadsa', '3123', 312, 321, '321', 'dsaad@gmail.com', 0),
(7, 'Merlo', 'Av los Almendros', 332, 1992, '213231232', 'merlo@gmail.com', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `siniestro`
--

CREATE TABLE `siniestro` (
  `codigo` int(11) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `fecha_siniestro` datetime NOT NULL,
  `coord_X` int(11) NOT NULL,
  `coord_Y` int(11) NOT NULL,
  `detalles` text NOT NULL,
  `fecha_resol` date NOT NULL,
  `puntuacion` int(11) NOT NULL,
  `codBrigada` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `siniestro`
--

INSERT INTO `siniestro` (`codigo`, `tipo`, `fecha_siniestro`, `coord_X`, `coord_Y`, `detalles`, `fecha_resol`, `puntuacion`, `codBrigada`, `estado`) VALUES
(5, 'Derrumbes', '2023-11-04 00:00:00', 232, 11, 'Derrumbe en AV. Norte 123', '2023-11-14', 9, 14, 0),
(6, 'aa', '2023-11-09 00:00:00', 2321, 312312, 'sdadas', '0000-00-00', 0, 13, 0),
(7, 'Inundacioness', '2020-11-01 16:42:13', 12322, 112, 'Inundación en AV los Boleros', '2023-11-16', 9, 32, 0),
(8, 'Inundacion', '2023-11-19 16:45:24', 23312, 3123, 'Inundacion de baño', '0000-00-00', 0, 13, 0),
(9, 'Inundaciones', '2023-11-23 18:58:00', 23213, 332131, 'Inundacion en calle aa', '2023-11-15', 8, 13, 0),
(10, 'Inundacion', '2023-11-05 22:09:44', 3211, 212, 'Inundacion de una casa', '2023-11-15', 6, 32, 0),
(11, 'Inundacionesffffff', '2020-11-13 16:42:13', 123, 112, 'Inundación en AV los Boleros', '2023-11-16', 5, 14, 0),
(12, 'Inundacionesffffff', '2020-11-13 16:42:13', 123, 112, 'Inundación en AV los Boleros', '2023-11-16', 7, 30, 0),
(13, 'aaa', '2023-11-16 09:36:27', 312, 3122, 'dsa', '2023-11-15', 1, 30, 0),
(16, 'Derrumbe', '2023-11-08 00:00:00', 3232, 131, 'Derrumbe en Merlo San Luis', '2023-11-16', 9, 14, 0),
(17, 'INCENDIO', '2023-11-15 11:35:27', 233, 1123, 'Casa familiar', '2023-11-16', 7, 13, 0),
(18, 'Inundacion', '2023-11-08 20:08:57', 332, 481, 'Inundación de calle Boyero y Av del Sol.', '0000-00-00', 0, 32, 0),
(19, 'Rescate de Montaña', '2023-11-12 20:10:15', 2332, 23333, 'Rescatar 2 Hombres en una montaña', '2023-11-16', 9, 30, 0),
(20, 'Inundacionnn', '2023-11-05 20:12:21', 23232, 13131, 'Inundacion de una casa', '2023-11-17', 5, 30, 0),
(21, 'Derrumbe', '2023-11-02 20:13:02', 3322, 3222, 'Derrumbe de casa', '2023-11-15', 10, 14, 0),
(22, 'Rescate de Montaña', '2023-11-01 20:13:32', 232, 111, 'rescate', '2023-11-16', 9, 30, 0),
(23, 'Rescate de Montaña', '2023-11-12 23:54:29', 1000, 1000, 'Rescatar 1 persona en el Monte ', '2023-11-16', 10, 30, 0),
(24, 'ayer', '2023-11-16 05:09:08', 231, 3213, 'ayer', '2023-11-17', 7, 14, 0),
(25, 'hoy', '2023-11-17 05:09:33', 2131, 3132, 'hoy', '2023-11-17', 7, 32, 0),
(26, 'hoy', '2023-11-17 05:09:33', 2131, 3132, 'hoy', '0000-00-00', 0, 31, 1),
(27, 'Inundacion', '2023-11-05 20:12:21', 23232, 13131, 'Inundacion de una casa', '2023-11-17', 8, 14, 0),
(28, 'Prueba', '2023-11-15 08:17:33', 2221, 321, 'aaa', '2023-11-17', 10, 31, 0),
(29, 'Pruebaaaa', '2023-11-15 08:19:08', 22, 22, 'HOY HOY', '0000-00-00', 0, 30, 1),
(30, 'SDSADASDS', '2023-11-16 08:20:25', 232, 213, 'AA', '0000-00-00', 0, 31, 1),
(31, 'Derrumbe', '2023-11-09 00:00:00', 2321, 3213, 'derrumbe', '0000-00-00', 0, 14, 1),
(32, 'Derrumbe', '2023-11-15 13:19:52', 32, 131, 'Derrumbe', '0000-00-00', 0, 38, 1),
(33, 'Ultimo Siniestro', '2023-11-05 13:32:01', 2321, 32312, 'ULTIMO', '0000-00-00', 0, 39, 1),
(34, 'sdasdas', '2023-11-04 13:45:20', 31223, 123312, 'sdaasd', '0000-00-00', 0, 31, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bombero`
--
ALTER TABLE `bombero`
  ADD PRIMARY KEY (`id_bombero`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD KEY `bombero_ibfk_1` (`codBrigada`);

--
-- Indices de la tabla `brigada`
--
ALTER TABLE `brigada`
  ADD PRIMARY KEY (`codBrigada`),
  ADD KEY `brigada_ibfk_1` (`nro_cuartel`);

--
-- Indices de la tabla `cuartel`
--
ALTER TABLE `cuartel`
  ADD PRIMARY KEY (`codCuartel`);

--
-- Indices de la tabla `siniestro`
--
ALTER TABLE `siniestro`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `siniestro_ibfk_1` (`codBrigada`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bombero`
--
ALTER TABLE `bombero`
  MODIFY `id_bombero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `brigada`
--
ALTER TABLE `brigada`
  MODIFY `codBrigada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT de la tabla `cuartel`
--
ALTER TABLE `cuartel`
  MODIFY `codCuartel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `siniestro`
--
ALTER TABLE `siniestro`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bombero`
--
ALTER TABLE `bombero`
  ADD CONSTRAINT `bombero_ibfk_1` FOREIGN KEY (`codBrigada`) REFERENCES `brigada` (`codBrigada`);

--
-- Filtros para la tabla `brigada`
--
ALTER TABLE `brigada`
  ADD CONSTRAINT `brigada_ibfk_1` FOREIGN KEY (`nro_cuartel`) REFERENCES `cuartel` (`codCuartel`);

--
-- Filtros para la tabla `siniestro`
--
ALTER TABLE `siniestro`
  ADD CONSTRAINT `siniestro_ibfk_1` FOREIGN KEY (`codBrigada`) REFERENCES `brigada` (`codBrigada`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
