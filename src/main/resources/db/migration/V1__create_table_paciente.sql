CREATE TABLE paciente (
  id serial PRIMARY KEY,
  nome varchar(50),
  sobrenome varchar(100),
  cpf varchar(15),
  endereco varchar(100),
  email varchar(100)
);