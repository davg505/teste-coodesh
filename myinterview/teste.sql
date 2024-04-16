-- Define as informações de conexão com o banco de dados MySQL
SET @host = 'rds-interview.digiage.com.br';
SET @user = 'interview';
SET @password = '2MLGz6q5py4mFNII';
SET @database = 'employees';

-- Cria a tabela funcionario_teste_david, se não existir
CREATE TABLE IF NOT EXISTS funcionario_teste_david (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    genero VARCHAR(10) NOT NULL,
    data_nascimento INT NOT NULL,
    salario DECIMAL(10, 2) NOT NULL
);

-- Insere dados de exemplo na tabela funcionario_teste_david
INSERT INTO funcionario_teste_david (nome, genero, data_nascimento, salario) VALUES
('João', 'M', 1980, 5000.00),
('Maria', 'F', 1985, 6000.00),
('Carlos', 'M', 1990, 5500.00),
('Ana', 'F', 1995, 6500.00),
('Pedro', 'M', 1988, 5200.00),
('Mariana', 'F', 1982, 7000.00);

-- Query que retorna a quantidade de funcionários separados por sexo
SELECT genero, COUNT(*) AS quantidade_funcionarios
FROM funcionario_teste_david
GROUP BY genero;

-- Query que retorna a quantidade de funcionários distintos por sexo e idade
SELECT genero, YEAR(CURDATE()) - data_nascimento AS idade, COUNT(DISTINCT id) AS quantidade_funcionarios_distintos
FROM funcionario_teste_david
GROUP BY genero, idade;

-- Query que retorna a média, mínimo e máximo de salário por sexo
SELECT genero, AVG(salario) AS media_salario, MIN(salario) AS min_salario, MAX(salario) AS max_salario
FROM funcionario_teste_david
GROUP BY genero;
