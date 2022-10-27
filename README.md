# Boletim



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

* Pipeline Jenkins :

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
