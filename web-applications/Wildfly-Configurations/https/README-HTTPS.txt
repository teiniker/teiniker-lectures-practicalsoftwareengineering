How to use a HTTPS connection?
-------------------------------------------------------------------------------
*) Create a Keystore

$ pwd
/home/student/install/wildfly-x.y.z.Final/standalone/configuration

$ keytool -genkeypair -keystore wildfly.keystore -storepass student -keypass student -keyalg RSA -alias wildfly -dname "cn=ims,o=fhj,c=at" 
 
 
*) Configure Wildfly (standalone.xml):

    <management>
        <security-realms>
<!-- BEGIN SSL/TLS Configuration --> 
			<security-realm name="CertificateRealm">
				<server-identities>
					<ssl>
						<keystore path="wildfly.keystore" relative-to="jboss.server.config.dir" keystore-password="student" />
					</ssl>
				</server-identities>
			</security-realm>
<!-- END SSL/TLS Configuration --> 
		...
	</management>
	
 	<subsystem xmlns="urn:jboss:domain:undertow:2.0">
        <buffer-cache name="default"/>
        <server name="default-server">
            <http-listener name="default" socket-binding="http" redirect-socket="https"/>
<!-- BEGIN SSL/TLS Configuration --> 
            <https-listener name="https" socket-binding="https" security-realm="CertificateRealm"/>
<!-- END SSL/TLS Configuration --> 
            <host name="default-host" alias="localhost">
                <location name="/" handler="welcome-content"/>
                <access-log pattern="common" directory="${jboss.home.dir}/standalone/log" prefix="access"/>
                <filter-ref name="server-header"/>
                <filter-ref name="x-powered-by-header"/>
            </host>
        </server>
        <servlet-container name="default">
            <jsp-config/>
            <websockets/>
        </servlet-container>
        <handlers>
            <file name="welcome-content" path="${jboss.home.dir}/welcome-content"/>
        </handlers>
        <filters>
            <response-header name="server-header" header-name="Server" header-value="WildFly/9"/>
            <response-header name="x-powered-by-header" header-name="X-Powered-By" header-value="Undertow/1"/>
        </filters>
    </subsystem>

*) Restart Wildfly
	=> JBAS017519: Undertow HTTPS listener https listening on localhost/127.0.0.1:8443


How to access the Web application from a Browser?
-------------------------------------------------------------------------------
	
After starting the server, we can use a Browser to access the application's page:
    
    URL: https://localhost:8443/Servlet-SSL-SimpleLogin/
    
Note that it's also possible to access the page via regular HTTP: 
    
	URL: http://localhost:8080/Servlet-SSL-SimpleLogin/
    	
   
