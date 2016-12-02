Maven: POM Inheritance
-------------------------------------------------------------------------------

Elements in the POM that are merged are the following:
- dependencies
- developers and contributors
- plugin lists (including reports)
- plugin executions with matching ids
- plugin configuration
- resources
	
The Super POM is one example of project inheritance, however you can also 
introduce your own parent POMs by specifying the parent element in the POM.


Maven: POM Aggregation
-------------------------------------------------------------------------------

Instead of specifying the parent POM from the module, Aggregation specifies the 
modules from the parent POM. By doing so, the parent project now knows its modules, 
and if a Maven command is invoked against the parent project, that Maven command 
will then be executed to the parent's modules as well.

To do Project Aggregation, you must do the following:
- Change the parent POMs packaging to the value "pom" .
- Specify in the parent POM the directories of its modules (children POMs)

Now, whenever a Maven command processes the parent module, that same Maven command 
would be ran against the child modules as well. 	


Project Inheritance vs Project Aggregation
-------------------------------------------------------------------------------
If you have several Maven projects, and they all have similar configurations, 
you can refactor your projects by pulling out those similar configurations and 
making a parent project. 
Thus, all you have to do is to let your Maven projects inherit that parent project, 
and those configurations would then be applied to all of them.

And if you have a group of projects that are built or processed together, you 
can create a parent project and have that parent project declare those projects as 
its modules. 
By doing so, you'd only have to build the parent and the rest will follow.

But of course, you can have both Project Inheritance and Project Aggregation.

You'd just have to apply all three rules:
- Specify in every child POM who their parent POM is.
- Change the parent POMs packaging to the value "pom" .
- Specify in the parent POM the directories of its modules (children POMs).


Example: Project Inheritance and Project Aggregation
-------------------------------------------------------------------------------

	Maven-Modules-Parent
	+-pom.xml

	<modelVersion>4.0.0</modelVersion>

	<groupId>org.se.lab</groupId>
	<artifactId>Maven-Modules-Parent</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>pom</packaging>

	<modules>
    	<module>../Maven-Modules-Simple</module>
  	</modules>
  
	<build>
		<plugins>
			<plugin>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.1</version>
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
				</configuration>
			</plugin>
		</plugins>
	</build>

	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
			<scope>test</scope>
		</dependency>
	</dependencies>
	

	Maven-Modules-Simple
	+-pom.xml

	<modelVersion>4.0.0</modelVersion>

	<parent>
		<groupId>org.se.lab</groupId>
		<artifactId>Maven-Modules-Parent</artifactId>
		<version>0.0.1-SNAPSHOT</version>
		<relativePath>../Maven-Modules-Parent/pom.xml</relativePath>
	</parent>

	<artifactId>Maven-Modules-Simple</artifactId>

	Notice that we now have an added section, the parent section. 
	This section allows us to specify which artifact is the parent of our POM.

	