How to implement integration tests for services?
-------------------------------------------------------------------------------

1) Add the following plugin settings to pom.xml (see REST-IntegrationTest)
	- maven-surefire-plugin		<--! Unit tests -->
	- maven-failsafe-plugin		<--! Integration tests -->
	
2) Add test cases
	- ArticlesITCase (including DB setup + teardown, and property files)
			
    Note that you have to rename the property files:
        test/resources/client.properties.template => client.properties
        test/resources/jdbc.properties.template => jdbc.properties


How to run the integration test from the command line?
-------------------------------------------------------------------------------
$ mvn verify 


How to generate Test JavaDocs?
-------------------------------------------------------------------------------
$ mvn javadoc:test-javadoc
