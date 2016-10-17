package fr.artefrance.daj.ws.test.factory;


public class URIBuilderFactory {

    public static String createRightLocalURL() {
        return "http://localhost:8080";
    }

    public static String createWrongLocalURL() {
        return "http://local-%host:8080";
    }

    public static String createRightDistantURL() {
        return "http://sophia.artefrance.com:8080";
    }

    public static String createWrongDistantURL() {
        return "http://sophia.artefrance.%-.com:8080";
    }

    public static String createRightServiceName() {
        return "/right_service_name_url";
    }

    public static String createWrongServiceName() {
        return "/wrong_,service_ <%-''> _name_url";
    }
}
