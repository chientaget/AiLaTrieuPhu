CREATE DATABASE db_altp

CREATE TABLE Player(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
   fullName VARCHAR(255),
   email VARCHAR(255),
   username VARCHAR(30) UNIQUE NOT NULL,
	PASSWORD VARCHAR(30) NOT NULL ,
   totalMoney BIGINT
);

CREATE TABLE Admin (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30) UNIQUE NOT NULL,
	PASSWORD VARCHAR(30) NOT NULL
);
db_altpdb_altpdb_altp
CREATE TABLE Question (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    topic VARCHAR(255) not null ,
    ques VARCHAR(255) NOT NULL UNIQUE ,
    answer1 VARCHAR(255) NOT NULL,
    answer2 VARCHAR(255) NOT NULL,
    answer3 VARCHAR(255) NOT NULL,
    answerCorrect VARCHAR(255) NOT NULL
);

CREATE TABLE Price(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    price VARCHAR(255) NOT NULL
);


-- Chèn dữ liệu cho bảng Admin (1 admin)
INSERT INTO Admin VALUES
(1,'admin', 'admin123');  -- Admin


-- Chèn dữ liệu cho bảng Player (10 players)
INSERT INTO Player VALUES
(1, 'Player 1 Full Name', 'player1@example.com','player1', '123', 1000),  -- Player 1
(2, 'Player 2 Full Name', 'player2@example.com','player2', '123', 1500),  -- Player 2
(3, 'Player 3 Full Name', 'player3@example.com','player3', '123', 2000),  -- Player 3
(4, 'Player 4 Full Name', 'player4@example.com','player4', '123', 2500),  -- Player 4
(5, 'Player 5 Full Name', 'player5@example.com','player5', '123', 3000);  -- Player 5


-- Chèn dữ liệu cho bảng Question (các câu hỏi về công nghệ)
INSERT INTO Question (topic, ques, answer1, answer2, answer3, answerCorrect) VALUES
('công nghệ', 'Công ty nào sản xuất dòng sản phẩm iPhone?', 'SpaceX', 'Samsung', 'Google', 'Apple'),
('công nghệ', 'Ai là người sáng lập Microsoft?', 'Donal Trump', 'Steve Jobs', 'Mark Zuckerberg', 'Bill Gates'),
('công nghệ', 'Phần mềm nào được sử dụng để lập trình Android?', 'NetBean', 'Eclipse', 'Visual Studio', 'Android Studio'),
('công nghệ', 'Công nghệ nào được sử dụng để lưu trữ dữ liệu trên đám mây?', 'Excel', 'Bluetooth', 'Blockchain', 'Cloud computing'),
('công nghệ', 'Loại mạng nào thường được sử dụng để kết nối các thiết bị trong một văn phòng?', 'CAP', 'WAN', 'FPT', 'LAN'),
('công nghệ', 'Ai là người sáng lập SpaceX?', 'Donal Trump', 'Richard Branson', 'Jeff Bezos', 'Elon Musk'),
('công nghệ', 'Công nghệ nào được sử dụng để truyền tín hiệu TV qua sóng radio?', 'Microwave', 'Digital', 'Satellite', 'Analog'),
('công nghệ', 'Thiết bị nào được sử dụng để đo khoảng cách bằng sử dụng sóng âm thanh?', 'Ruler', 'GPS', 'Radar', 'Sonic rangefinder'),
('công nghệ', 'Nền tảng nào được sử dụng để phát triển ứng dụng iOS?', 'SamSung', 'Android Studio', 'Xcode', 'Xcode'),
('công nghệ', 'Đâu là ngôn ngữ lập trình phổ biến trong phát triển web?', 'Html', 'Python', 'C++', 'JavaScript'),
('công nghệ', 'Thiết bị nào được sử dụng để chuyển đổi tín hiệu kỹ thuật số sang analog?', 'Router wifi', 'ADC (Analog-to-Digital Converter)', 'CPU (Central Processing Unit)', 'DAC (Digital-to-Analog Converter)'),
('công nghệ', 'Công nghệ nào được sử dụng trong các ứng dụng thực tế ảo (VR)?', 'Glasses', 'Augmented Reality (AR)', 'Mixed Reality (MR)', 'Virtual Reality (VR)'),
('công nghệ', 'Loại thiết bị nào được sử dụng để ghi và tái sản xuất âm thanh?', 'Key Board', 'Speaker', 'Webcam', 'Microphone'),
('công nghệ', 'Ngôn ngữ lập trình nào được sử dụng cho phát triển ứng dụng di động iOS?', 'Javascript', 'Java', 'C#', 'Swift'),
('công nghệ', 'Ai là người sáng lập Amazon?', 'The Rock', 'Elon Musk', 'Mark Zuckerberg', 'Jeff Bezos');

INSERT INTO Price (price) VALUES ('200');
INSERT INTO Price (price) VALUES ('400');
INSERT INTO Price (price) VALUES ('600');
INSERT INTO Price (price) VALUES ('800');
INSERT INTO Price (price) VALUES ('1000');
INSERT INTO Price (price) VALUES ('200000');

SELECT * FROM question `db-blog`