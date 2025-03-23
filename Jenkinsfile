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
                    },
                    '构建client-svc': {
                        bat '''cd client-svc
                                dir
                                C:\\Joe\\Maven\\apache-maven-3.8.8\\bin\\mvn clean package'''
                    },
                    '构建client-svc8083': {
                        bat '''cd client-svc8083
                                dir
                                C:\\Joe\\Maven\\apache-maven-3.8.8\\bin\\mvn clean package'''
                    }
                )
            }
        }

        stage('停止已启动应用'){
            steps {
                bat '''call C:\\Joe\\workspace\\stop.bat
                       exit 0'''
            }
        }

        stage('备份目标文件夹下文件'){
            steps {
                bat '''move "C:\\Joe\\workspace\\jars\\*" "C:\\Joe\\workspace\\jars\\backup"
                       exit 0'''
            }
        }

        stage('复制打包文件到目标文件夹'){
            steps {
                bat '''copy "C:\\Joe\\workspace\\register-center-svc\\target\\register-center-svc-0.0.1-SNAPSHOT.jar" "C:\\Joe\\workspace\\jars"
                       copy "C:\\Joe\\workspace\\bwic-svc\\target\\bwic-svc-0.0.1-SNAPSHOT.jar" "C:\\Joe\\workspace\\jars"
                       copy "C:\\Joe\\workspace\\client-svc\\target\\client-svc-0.0.1-SNAPSHOT.jar" "C:\\Joe\\workspace\\jars"
                       copy "C:\\Joe\\workspace\\client-svc8083\\target\\client-svc8083-0.0.1-SNAPSHOT.jar" "C:\\Joe\\workspace\\jars"
                       exit 0'''
            }
        }
    }
}