CREATE TABLE IF NOT EXISTS question (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        text VARCHAR(255),
    option_a VARCHAR(100),
    option_b VARCHAR(100),
    option_c VARCHAR(100),
    option_d VARCHAR(100),
    correct_option VARCHAR(1)
    );

CREATE TABLE IF NOT EXISTS quiz_session (
                                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                            user_id BIGINT,
                                            question_id BIGINT,
                                            correct BOOLEAN
);

INSERT INTO question (text, option_a, option_b, option_c, option_d, correct_option)
VALUES
    ('What is the capital of France?', 'Paris', 'London', 'Berlin', 'Madrid', 'A'),
    ('Who developed Java?', 'Microsoft', 'Oracle', 'Sun Microsystems', 'Google', 'C'),
    ('What is 2 + 2?', '3', '4', '5', '6', 'B');

INSERT INTO question (text, option_a, option_b, option_c, option_d, correct_option)
VALUES
    ('What is the largest planet in our solar system?', 'Earth', 'Mars', 'Jupiter', 'Saturn', 'C'),
    ('Who wrote "To Kill a Mockingbird"?', 'Harper Lee', 'J.K. Rowling', 'George Orwell', 'Mark Twain', 'A'),
    ('What is the speed of light?', '300,000 km/s', '150,000 km/s', '500,000 km/s', '1,000,000 km/s', 'A'),
    ('Who painted the Mona Lisa?', 'Vincent van Gogh', 'Pablo Picasso', 'Leonardo da Vinci', 'Claude Monet', 'C'),
    ('What is the smallest country in the world?', 'Vatican City', 'Monaco', 'Nauru', 'San Marino', 'A'),
    ('Which programming language is known as the "mother of all languages"?', 'C', 'Java', 'Assembly', 'Fortran', 'A'),
    ('Who was the first president of the United States?', 'George Washington', 'Thomas Jefferson', 'Abraham Lincoln', 'John Adams', 'A'),
    ('What is the chemical symbol for water?', 'H2O', 'O2', 'CO2', 'HO2', 'A');