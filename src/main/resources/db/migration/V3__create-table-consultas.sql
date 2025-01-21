create table consultas(

                          id bigint not null auto_increment,
                          titulo varchar(300) not null,
                          mensaje varchar(600) not null,
                          status tinyint not null,
                          fecha datetime not null,
                          usuario_id bigint not null,
                          curso_id bigint not null,

                          primary key (id),
                          constraint fk_consultas_usuario_id foreign key (usuario_id) references usuarios(id),
                          constraint fk_consultas_curso_id foreign key (curso_id) references cursos(id)


);