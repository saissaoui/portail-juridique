package fr.artefrance.daj.ws.infrastructure.rest.client;

import java.io.IOException;

public interface JerseyClient {
    public String callWebService(String serviceUrl, String serviceName, Object params) throws IOException;
    public String callWebService(String serviceUrl, String serviceName) throws IOException;
}
