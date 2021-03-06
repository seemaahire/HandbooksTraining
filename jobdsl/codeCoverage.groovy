mavenJob("CodeCoverage") {
  logRotator(60, 20, 1, -1)
  description('Code Coverage Test for application')
  scm {
   		git {
     		branch('*/master')
     		remote {
       			name('')
       			refspec('')
       			url('https://github.com/OpsTree/ContinuousIntegration.git')
     		}
   		}
 	}
  goals('clean cobertura:cobertura -Dcobertura.report.format=xml')
  rootPOM('Spring3HibernateApp/pom.xml')
  mavenInstallation('maven2')
  publishers {
    coberturaPublisher {
     coberturaReportFile('**/target/site/cobertura/coverage.xml')
     onlyStable(false)
     failUnhealthy(false)
     failUnstable(false)
     autoUpdateHealth(false)
     autoUpdateStability(false)
     zoomCoverageChart(false)
     failNoReports(true)
     sourceEncoding('ASCII')
     maxNumberOfBuilds(0)
    }
  }
}
