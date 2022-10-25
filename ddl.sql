drop sequence SQ_ALUNOS;
drop sequence SQ_NOTAS;
--
drop table t_alunos;
drop table t_notas;
--
create table t_alunos(id_aluno      number
                     ,nm_nome       varchar2(80)
                     ,nm_nome_curso varchar2(80)
                     ,nm_turma      varchar2(10)
                     );
--
create table t_notas(id_nota      number
                    ,id_aluno     number
                    ,nm_materia   varchar2(50)
                    ,nm_nota_CP1  number
                    ,nm_nota_CP2  number
                    ,nm_nota_CP3  number
                    ,nm_nota_CP4  number
                    ,nm_nota_CP5  number
                    ,nm_nota_CP6  number
                    ,nm_challenger_1 number
                    ,nm_challenger_2 number
                    ,nm_challenger_3 number
                    ,nm_challenger_4 number
                    ,nm_nota_GS1  number
                    ,nm_nota_GS2  number
                    ,nm_situacao  varchar2(1) 
                    );
--
CREATE SEQUENCE SQ_ALUNOS
START WITH 1
INCREMENT BY 1
MAXVALUE 99999
NOCACHE
NOCYCLE;
--
CREATE SEQUENCE SQ_NOTAS
START WITH 1
INCREMENT BY 1
MAXVALUE 99999
NOCACHE
NOCYCLE;


--
declare
 vrt_notas t_notas%rowtype;
begin
  --
  insert into t_alunos(id_aluno,nm_nome,nm_nome_curso,nm_turma)
            values(SQ_ALUNOS.NEXTVAL,'kleber','Analise e desenvolvimento de sistemas','2TDSJ');
  --
  vrt_notas.id_nota          := SQ_NOTAS.NEXTVAL;
  vrt_notas.id_aluno         := SQ_NOTAS.CURRVAL;
  vrt_notas.nm_materia       := 'DEVOPS TOOLS & CLOUD COMPUTING';
  vrt_notas.nm_nota_cp1      := 9;
  vrt_notas.nm_nota_cp2      := 9;
  vrt_notas.nm_nota_cp3      := 0;
  vrt_notas.nm_nota_cp4      := 0;
  vrt_notas.nm_nota_cp5      := 9;
  vrt_notas.nm_nota_cp6      := 0;
  vrt_notas.nm_challenger_1  := 9;
  vrt_notas.nm_challenger_2  := 9.5;
  vrt_notas.nm_challenger_3  := 10;
  vrt_notas.nm_challenger_4  := 0;
  vrt_notas.nm_nota_gs1      := 5.5;
  vrt_notas.nm_nota_gs2      := 0;
  vrt_notas.nm_situacao      := 'P';
  insert into t_notas
     values vrt_notas;
  commit;
end;
--