package fr.artefrance.daj.ws.infrastructure.rest.client.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import fr.artefrance.daj.ws.infrastructure.rest.client.JerseyClient;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class JerseyClientImpl implements JerseyClient {

    @Autowired
    private Client client;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger logger = getLogger(JerseyClient.class);

    public String callWebService(String serviceUrl, String serviceName, Object params) throws IOException {

        String entity = null;

        WebResource resource = client.resource(URIBuilder.INSTANCE.buildURI(
                serviceUrl,
                serviceName));

        WebResource.Builder builder = resource.type(MediaType.APPLICATION_JSON_TYPE);

        try {
            ClientResponse response = builder.post(
                    ClientResponse.class,
                    objectMapper.writeValueAsString(params)
                                                  );

            entity = response.getEntity(String.class);
        } catch (IOException e) {
            logger.error("Error when calling Web Service", e);
        }

        return entity;
    }

    public String callWebService(String serviceUrl, String serviceName) throws IOException {
        return callWebService(serviceUrl, serviceName, null);
    }
}
