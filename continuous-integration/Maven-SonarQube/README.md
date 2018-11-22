# Analyzing with SonarQube Scanner for Maven

See [SonarQube Documentation](https://docs.sonarqube.org/display/SCAN/Analyzing+with+SonarQube+Scanner+for+Maven)

* Edit the `~/.m2/settings.xml` file to set the plugin prefix and optionally the
SonarQube server URL.
    ```xml
        <settings>
            <pluginGroups>
                <pluginGroup>org.sonarsource.scanner.maven</pluginGroup>
            </pluginGroups>
            <profiles>
                <profile>
                    <id>sonar</id>
                    <activation>
                        <activeByDefault>true</activeByDefault>
                    </activation>
                    <properties>
                        <!-- Optional URL to server. Default value is http://localhost:9000 -->
                        <sonar.host.url>
                          http://localhost:9000
                        </sonar.host.url>
                    </properties>
                </profile>
             </profiles>
        </settings>
    ```

* It is recommended to set versions of Maven plugins: `pom.xml`
    ```xml
        <build>
            <pluginManagement>
                <plugins>
                    <plugin>
                        <groupId>org.sonarsource.scanner.maven</groupId>
                        <artifactId>sonar-maven-plugin</artifactId>
                        <version>3.5.0.1254</version>
                    </plugin>
                </plugins>
            </pluginManagement>
            ...
        </build>
    ```

* Analyzing a Maven Project
    Make sur the the SonarQube server is running (http://localhost:9000)
    ```
        $ mvn clean package
        $ mvn sonar:sonar
    ```
