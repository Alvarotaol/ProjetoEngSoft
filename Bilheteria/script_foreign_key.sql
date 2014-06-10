use bdbilheteria;

-- chaves estrangeiras da tabela evento
alter table evento
add constraint fk_timeM_evento foreign key (id_mandante) references timefutebol (id) on update cascade on delete cascade;

alter table evento
add constraint fk_timeV_evento foreign key (id_visitante) references timefutebol (id) on update cascade on delete cascade;

alter table evento
add constraint fk_estadio_evento foreign key (id_estadio) references estadio (id) on update cascade on delete cascade;

-- chave estrangeira da tabela setor
alter table setor
add constraint fk_setor_estadio foreign key (id_estadio) references estadio (id) on update cascade on delete cascade;
