# Boletim


## Integrantes :

- Gabriel Sun Gonçalo da Silva    RM : 88316

- Kleber Albert de Sousa Monteiro  RM : 88711

- Renato Miranda Esmail            RM : 86701


### Link do Youtube :

```

https://www.youtube.com/watch?v=RdHuh_qX45w

```


Verificar o status do Jenkins :

```

systemctl status jenkins

```

Parar o Jenkins :

```

sudo systemctl stop jenkins 

```

Iniciar o Jenkins :

```

sudo systemctl start jenkins 

```

### Pipeline Jenkins :

```

node {

  def resourceGroupName = 'rg-boletim-cp3-api'
  def resourceGroupLocation = 'brazilsouth'
  def appServicePlanName = 'BoletinPlan'
  def appServicePlanTier = 'FREE'
  def webAppName = 'boletim-api'
  def webAppRuntime = '"java:11:Java SE:11"'
  def packagePath = 'target/boletim-0.0.1-SNAPSHOT.jar'

  stage('Extrair Codigo Fonte') {
    echo 'Obtendo o Código Fonte ...'
    checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/rm88711/boletim']]])
  }

  stage('Build') {
    echo 'Empacotando o projeto...'
    sh '/opt/maven/bin/mvn clean package'
  }

  stage('Credenciais Azure') {
    echo 'Obtendo credenciais...'
    withCredentials([usernamePassword(credentialsId: 'AzureService', 
      passwordVariable: 'AZURE_CLIENT_SECRET',
      usernameVariable: 'AZURE_CLIENT_ID')]) {
      echo 'Logando na Azure...'
      sh 'az login -u $AZURE_CLIENT_ID -p $AZURE_CLIENT_SECRET'
    }
  }

  stage('Criar Infra') {
    echo 'Criando o Grupo de Recursos...'
    sh "az group create --name $resourceGroupName --location $resourceGroupLocation"
    echo 'Criando Plano de Serviço...'
    sh "az appservice plan create --name $appServicePlanName --resource-group $resourceGroupName --sku FREE"
    echo 'Criando o Web App...'
    sh "az webapp create --name $webAppName --plan $appServicePlanName --resource-group $resourceGroupName --runtime $webAppRuntime"
  }

  stage('Deploy') {
     echo 'Realizando o Deploy na Azure...'
     sh "az webapp deploy --resource-group $resourceGroupName --name $webAppName --src-path $packagePath --type jar"
  }

}

```


### DDL : 

```

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

```
