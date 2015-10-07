use bdbilheteria;

insert into TimeFutebol (nomeTime, cnpjTime) values ('ABC FC', '001');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Corinthians', '002');
insert into TimeFutebol (nomeTime, cnpjTime) values ('São Paulo', '003');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Palmeiras', '004');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Santos FC', '005');
insert into TimeFutebol (nomeTime, cnpjTime) values ('América Futebol Clube/RN', '006');
insert into TimeFutebol (nomeTime, cnpjTime) values ('América Futebol Clube/MG', '007');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Santa Cruz/RN', '008');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Criciúma/SC', '009');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Palmeira/RN', '010');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Potiguar de Mossoró', '011');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Baraúnas/RN', '012');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Portuguesa/SP', '013');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Fortaleza/CE', '014');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Globo/RN', '015');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Ceará/CE', '016');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Figueirense/SC', '017');
insert into TimeFutebol (nomeTime, cnpjTime) values ('CRB/AL', '018');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Atlético/GO', '019');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Goiás/GO', '020');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Vila Nova/GO', '021');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Nacional/MA', '022');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Cuiabá/MT', '023');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Figueirense/SC', '024');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Coritiba/PR', '025');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Clube Atlético/PR', '026');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Paraná/PR', '027');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Grêmio/RS', '028');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Internacional/RS', '029');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Juventude/RS', '030');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Caxias/RS', '031');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Sampaio Correa/MA', '032');
insert into TimeFutebol (nomeTime, cnpjTime) values ('ASA/AL', '033');
insert into TimeFutebol (nomeTime, cnpjTime) values ('CSA/AL', '034');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Vitória/BA', '035');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Bahia/BA', '036');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Bahia de Feida/BA', '037');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Flamengo/RJ', '038');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Vasco da Gama/RJ', '039');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Fluminense/RJ', '040');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Botafogo/RJ', '041');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Treze/PB', '043');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Campinense/PB', '044');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Botafogo/PB', '045');
insert into TimeFutebol (nomeTime, cnpjTime) values ('CSP/PB', '042');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Icasa/CE', '046');
insert into TimeFutebol (nomeTime, cnpjTime) values ('São Caetano/SP', '047');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Ponte Preta/SP', '048');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Guarani/SP', '049');
insert into TimeFutebol (nomeTime, cnpjTime) values ('Bragantino/SP', '050');

update TimeFutebol set anofundacao='1900';

insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Frasqueirão', 'Rua Antônio Lourenço', 'Ponta Negra', 'Natal', 'RN', '59.016-500');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Arena das Dunas', 'Av. Prudente de Morais', 'Lagoa Nova', 'Natal', 'RN', '59.020-510');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Vila Belmiro', 'Rua Princesa Isabel', 'Vila Belmiro', 'Santos', 'SP', '11.075-501');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Beira Rio', 'Avenida Padre Cacique', 'Praia de Belas', 'Porto Alegre', 'RS', '90.180-240');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Arena Fonte Nova', 'Ladeira Fonte das Pedras', 'Nazaré', 'Salvador', 'BA', '40.050-565');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Itaipava Arena Pernambuco', 'Av. Deus é Fiel', 'Penedo', 'Recife', 'PE', '54.710-010');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Olímpico Monumental', 'Av. Doutor Carlos Barbosa', 'Azenha', 'Porto Alegre', 'RS', '90.880-440');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('São Januário', 'Rua General Almério de Moura', 'Vasco-da-Gama', 'Rio de Janeiro', 'RJ', '20.921-060');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Maracanã', 'Rua Professor Eurico Barreto', 'Maracanã', 'Rio de Janeiro', 'RJ', '20.271-150');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Arena Barrettão', 'BR 406', 'São Geraldo', 'Ceará-Mirim', 'RN', '59.570-000');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Arena Castelão', 'Rua Alberto Craveiro', 'Castelão', 'Fortaleza', 'CE', '60.861-211');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Ilha do Retiro', 'Rua Sport Clube do Recife', 'Ilha do Leite', 'Recife', 'PE', '50.550-560');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Itaquerão', 'Rua Miguel Ignácio Cury', 'Vila Carmosina', 'São Paulo', 'SP', '08.295-005');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Mineirão', 'Rua Antônio Abrahão Caram', 'São José da Pampulha', 'Belo Horizonte', 'MG', '31.275-000');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Independência', 'Rua Pitangui', 'Horto', 'Belo Horitonte', 'MG', '31.010-460');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Vila Capanema', 'Rua Engenheiro Rebouças', 'Rebouças', 'Curitiba', 'PR', '81.210-040');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Arena da Baixada', 'Av. Presidente Getúlio Vargas', 'Alto da Glória', 'Água Verde', 'PR', '80.250-060');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Serra Dourada', 'Rua Fued José Sebba', 'Jardim Goiás', 'Goiânia', 'GO', '75.805-100');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Arena Pantanal', 'Av. Agrícola Paes de Barros', 'Verdão', 'Cuiabá', 'MT', '78.030-210');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Orlando Scarpelli', 'Rua Umaitá', 'Estreito', 'Florianópolis', 'SC', '88.070-430');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Professor Dário Rodrigues Leite', 'Praça Mário Ceciliano Monteiro dos Santos', 'Vila Paraíba', 'Guaratinguetá', 'SP', '12.515-235');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('José Nazareno', 'BR 101', 'Novo Horizonte', 'Goianinha', 'RN', '59.173-000');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Iberezão', 'Rua Coronel Júlio Pinheiro', 'Miguel Pereira Maia', 'Santa Cruz', 'RN', '59.200-000');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Morumbi', 'Praça Roberto Gomes Pedroza', 'Morumbi', 'São Paulo', 'SP', '05.653-070');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Mundão do Arruda', 'Av. Beberibe', 'Arruda', 'Recife', 'PE', '52.130-000');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Anacleto Campanella', 'Walter Thomé', 'Olimpico', 'São Caetano do Sul', 'SP', '09.570-320');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Palestra Itália', 'Rua Turiassu', 'Perdizes', 'São Paulo', 'SP', '59.173-000');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Moisés Lucarelli', 'Av. Francisco Glicério', 'Jardim Proença', 'Campinas', 'SP', '13.026-350');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Canindé', 'Rua Comendador Nestor Pereira', 'Canindé', 'São Paulo', 'SP', '03.034-070');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Arena Joinville', 'Rua Inácio Bastos', 'Bucarein', 'Joinville', 'SC', '89.202-310');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Ressacada', 'Av. Deputado Doimício Freitas', 'Carianos', 'Florianópolis', 'SC', '88.047-400');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Heriberto Hulse', 'Rua Treze de Maio', 'Comerciário', 'Criciúma', 'SC', '88.802-290');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Arena da Amazônia', 'Av. Djalma Batista', 'Flores', 'Manaus', 'AM', '69.050-010');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Curuzu', 'Av. Almirante Barroso', 'Curuzu', 'Belém', 'PA', '66.093-971');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Aflitos', 'Av. Conselheiro Rosa e Silva', 'Aflitos', 'Recife', 'PE', '52.020-220');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Alfredo Jaconi', 'Rua Hercules Gallo', 'Centro', 'Caxias do Sul', 'RS', '00.000-000');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Brinco de Ouro da Princesa', 'Av. Imperatriz Dona Teresa Cristina', 'Jardim Guarani', 'Campinas', 'SP', '13.100-200');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Mané Garrincha', 'Espaço Estádio Nacional Mané Garrincha', 'Asa Norte', 'Brasília', 'DF', '70.700-701');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Zinho de Oliveira', 'Av. Antônio Maia', 'Velha Marabá', 'Marabá', 'PA', '00.000-000');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Raolino de Oliveira', 'Rua 539A', 'Jardim Paraíba', 'Volta Redonda', 'RJ', '00.000-000');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Ninho do Periquito', 'Rua Projetada', 'Santo Antônio', 'São Gonçalo do Amarante', 'RN', '59.290-000');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Rei Pelé', 'Av. Siqueira Campos', 'Trapiche da Barra', 'Maceió', 'AL', '57.010-003');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Genervino Evangelista da Fonseca', 'Rua Araguaia', 'Centro', 'Catalão', 'GO', '75.701-490');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Amigão', 'Rua Teixeira de Freitas', 'São José', 'Campina Grande', 'PB', '58.100-000');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Índio Condá', 'Rua Clevelândia', 'Centro', 'Chapecó', 'SC', '89.807-450');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Barradão', 'Rua Artêmio Castro Valente', 'Nossa Senhora da Vitória', 'Salvador', 'BA', '41.750-240');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Louvival Batista', 'Av. Cedro', 'Treze de Julho', 'Aracaju', 'SE', '49.020-170');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Boca do Jacaré', 'Q. Eptg Via Eptg', 'Taguatinga', 'Brasília', 'DF', '00.000-000');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Presidente Vargas', 'Av. Marechal Deodoro', 'Gentilândia', 'Fortaleza', 'CE', '60.020-061');
insert into Estadio (nome, logradouro, bairro, cidade, estado, cep) values ('Onésio Alvarenga', 'Rua 256 354, Setor Universitário', 'Centro', 'Goiânia', 'GO', '74.610-200');

-- chaves estrangeiras da tabela evento
alter table Evento
add constraint fk_timeM_evento foreign key (id_mandante) references TimeFutebol (id) on update cascade on delete cascade;

alter table Evento
add constraint fk_timeV_evento foreign key (id_visitante) references TimeFutebol (id) on update cascade on delete cascade;

alter table Evento
add constraint fk_estadio_evento foreign key (id_estadio) references Estadio (id) on update cascade on delete cascade;

-- chave estrangeira da tabela setor
alter table Setor
add constraint fk_setor_estadio foreign key (id_estadio) references Estadio (id) on update cascade on delete cascade;

-- chave estrangeira da tabela setorDispinivelpartida
alter table SetorDisponivelPartida
add constraint fk_setor_disponivel foreign key (id_setor) references Setor (id) on update cascade on delete cascade;

alter table SetorDisponivelPartida
add constraint fk_setor_partida foreign key (id_evento) references Evento (id) on update cascade on delete cascade;

-- chave estrangeira da tabela cadeira
alter table Cadeira
add constraint fk_cadeira_fileira foreign key (id_fileira) references Fileira (id) on update cascade on delete cascade;

-- chave estrangeira da tabela fileira
alter table Fileira
add constraint fk_fileira_setor foreign key (id_setor) references Setor (id) on update cascade on delete cascade;

-- chaves estrangeira table ingresso
alter table Ingresso
add constraint fk_ingresso_usuario foreign key (id_usuario) references Usuario (id) on update cascade on delete cascade;

alter table Ingresso
add constraint fk_ingresso_cadeira foreign key (id_cadeira) references Cadeira (id) on update cascade on delete cascade;

alter table Ingresso
add constraint fk_ingresso_evento foreign key (id_evento) references Evento (id) on update cascade on delete cascade;

insert into Usuario (login, senha, tipo) values ('breno', 'breno', 1);
