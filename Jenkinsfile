node {
    stage("Clone the project - GitHub") {
        git 'https://github.com/alisonrodolfo/agrotis-challenge.git'
    }



    stage("Build - Maven") {
        sh "./mvn clean test-compile"
    }

    stage("Unit tests - Junit") {
        try {
            sh "./mvn clean test -Pexcludee2e=**/true*\n"

            publishHTML target: [
                allowMissing: false,
                alwaysLinkToLastBuild: false,
                keepAll: true,
                reportDir: 'build/reports/tests/test',
                reportFiles: 'index.html',
                reportName: 'Unit Test Report'
            ]
        } catch (err) {
            step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*UnitTest.xml'])
            throw err
        }
    }

    stage("Code Coverage - Jacoco") {
        sh "./mvn jacoco:repor"

        publishHTML target: [
            allowMissing: false,
            alwaysLinkToLastBuild: false,
            keepAll: true,
            reportDir: 'build/reports/jacocoHtml',
            reportFiles: 'index.html',
            reportName: 'Jacoco Coverage Report'
        ]
    }
    stage("PMD") {
        sh "./mvn pmd:pmd pmd:cpd"

        publishHTML target: [
            allowMissing: false,
            alwaysLinkToLastBuild: false,
            keepAll: true,
            reportDir: 'build/reports/pmdHtml',
            reportFiles: 'index.html',
            reportName: 'PMD Report'
        ]
    }

    stage("BDD | Dependency Vulnerability Check | PMD ") {
        sh "./mvn verify"

        publishHTML target: [
            allowMissing: false,
            alwaysLinkToLastBuild: false,
            keepAll: true,
            reportDir: 'build/reports/verify',
            reportFiles: 'verify-report.html',
            reportName: 'verify Report'
        ]
    }
}
