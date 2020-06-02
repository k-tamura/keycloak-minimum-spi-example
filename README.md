This is a minimum Keycloak SPI module example which replaces Keycloak user's locale with Accept-Language header.

**Build the module:**

```bash
mvn clean package
```

**Deploy the module:**

```bash
jboss-cli.sh --command="module add --name=org.t246osslab.keycloak.locale \
    --resources=target/accept-lang-locale-selector.jar \
    --dependencies=org.keycloak.keycloak-server-spi,org.keycloak.keycloak-services,javax.ws.rs.api"
```

**Edit `standalone.xml` to enable the module:**

```xml
        <subsystem xmlns="urn:jboss:domain:keycloak-server:1.1">
            <web-context>auth</web-context>
            <providers>
                <provider>classpath:${jboss.home.dir}/providers/*</provider>
                <!-- Add the following line -->
                <provider>module:org.t246osslab.keycloak.locale</provider>
                <!------------------------->
            </providers>

            ...(omitted)...

            <!-- Add the following lines -->
            <spi name="localeSelector">
                <default-provider>acceptLanguageLocaleSelector</default-provider>
                <provider name="acceptLanguageLocaleSelector" enabled="true">
                </provider>
            </spi>
            <!------------------------------>
            <spi name="eventsStore">
                <provider name="jpa" enabled="true">
```
