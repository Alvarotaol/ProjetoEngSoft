use bdbilheteria;

-- chave estrangeira da tabela setorDispinivelpartida
alter table setordisponivelpartida
add constraint fk_setor_disponivel foreign key (id_setor) references setor (id) on update cascade on delete cascade;

alter table setordisponivelpartida
add constraint fk_setor_partida foreign key (id_evento) references evento (id) on update cascade on delete cascade;

-- chave estrangeira da tabela cadeira
alter table cadeira
add constraint fk_cadeira_fileira foreign key (id_fileira) references fileira (id) on update cascade on delete cascade;

-- chave estrangeira da tabela fileira
alter table fileira
add constraint fk_fileira_setor foreign key (id_setor) references setor (id) on update cascade on delete cascade;

-- chaves estrangeira table ingresso
alter table ingresso
add constraint fk_ingresso_usuario foreign key (id_usuario) references usuario (id) on update cascade on delete cascade;

alter table ingresso
add constraint fk_ingresso_cadeira foreign key (id_cadeira) references cadeira (id) on update cascade on delete cascade;

alter table ingresso
add constraint fk_ingresso_evento foreign key (id_evento) references evento (id) on update cascade on delete cascade;