pipeline {
    agent any
    stages {
        stage('编译打包项目'){
            steps {
                parallel(
                    '构建EurekaServer': {
                        bat '''cd register-center-svc
                                dir
                                C:\\Joe\\Maven\\apache-maven-3.8.8\\bin\\mvn clean package'''
                    },
                    '构建bwic-svc': {
                        bat '''cd bwic-svc
                                dir
                                C:\\Joe\\Maven\\apache-maven-3.8.8\\bin\\mvn clean package'''
                    }
                )
            }
        }
    }
}