ALTER TABLE paciente
ADD CONSTRAINT uq_paciente_cpf UNIQUE (cpf);
