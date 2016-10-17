package fr.artefrance.daj.ws.infrastructure.rest.client.impl;


import org.apache.commons.validator.routines.UrlValidator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

public enum URIBuilder {
    INSTANCE;


    public String buildURI(String serviceUrl, String serviceName) throws MalformedURLException {

        UrlValidator urlValidator = new UrlValidator(UrlValidator.ALLOW_LOCAL_URLS);
        URL url =  new URL(serviceUrl + serviceName);

        Optional<String> uri = Optional.of(url.toString());

        return uri.filter(urlValidator::isValid)
                .orElseThrow(() -> new MalformedURLException("Error when building Web Service URI"));
    }
}
