package fr.artefrance.daj.ws.test.infrastructure.rest.client;


import fr.artefrance.daj.ws.infrastructure.rest.client.impl.URIBuilder;
import fr.artefrance.daj.ws.test.factory.URIBuilderFactory;
import org.junit.Test;

import java.net.MalformedURLException;

import static org.assertj.core.api.Assertions.assertThat;

public class URIBuilderTest {

    @Test
    public void check_right_local_uri() throws MalformedURLException {
        String actual = null;
        String expected = "http://localhost:8080/right_service_name_url";
        actual = URIBuilder.INSTANCE.buildURI(URIBuilderFactory.createRightLocalURL(), URIBuilderFactory.createRightServiceName());

        assertThat(actual).isEqualTo(expected);
    }

    @Test(expected = MalformedURLException.class)
    public void wrong_local_uri_with_wrong_service_url_must_throw_exception() throws MalformedURLException {
        URIBuilder.INSTANCE.buildURI(URIBuilderFactory.createWrongLocalURL(), URIBuilderFactory.createRightServiceName());
    }

    @Test(expected = MalformedURLException.class)
    public void wrong_local_uri_with_wrong_service_name_must_throw_exception() throws MalformedURLException {
        URIBuilder.INSTANCE.buildURI(URIBuilderFactory.createRightLocalURL(), URIBuilderFactory.createWrongServiceName());
    }

    @Test
    public void check_right_distant_uri() throws MalformedURLException {
        String actual = null;
        String expected = "http://sophia.artefrance.com:8080/right_service_name_url";
        actual = URIBuilder.INSTANCE.buildURI(URIBuilderFactory.createRightDistantURL(), URIBuilderFactory.createRightServiceName());

        assertThat(actual).isEqualTo(expected);
    }

    @Test(expected = MalformedURLException.class)
    public void wrong_distant_uri_with_wrong_service_url_must_throw_exception() throws MalformedURLException {
        URIBuilder.INSTANCE.buildURI(URIBuilderFactory.createWrongDistantURL(), URIBuilderFactory.createRightServiceName());
    }

    @Test(expected = MalformedURLException.class)
    public void wrong_distant_uri_with_wrong_service_name_must_throw_exception() throws MalformedURLException {
        URIBuilder.INSTANCE.buildURI(URIBuilderFactory.createRightDistantURL(), URIBuilderFactory.createWrongServiceName());
    }
}
