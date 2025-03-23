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
                bat '''robocopy register-center-svc\\target C:\\Joe\\workspace\\jars register-center-svc-0.0.1-SNAPSHOT.jar
                       robocopy client-svc8083\\target C:\\Joe\\workspace\\jars client-svc-8083-0.0.1-SNAPSHOT.jar
                       robocopy client-svc\\target C:\\Joe\\workspace\\jars client-svc-0.0.1-SNAPSHOT.jar
                       robocopy bwic-svc\\target C:\\Joe\\workspace\\jars bwic-svc-0.0.1-SNAPSHOT.jar
                       exit 0'''
            }
        }
    }

    post {
        success {
            echo 'Post-build task: Sending success notification...'
        }
    }
}