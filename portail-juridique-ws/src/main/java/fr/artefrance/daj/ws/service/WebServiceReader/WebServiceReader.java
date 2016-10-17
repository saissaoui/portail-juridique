package fr.artefrance.daj.ws.service.WebServiceReader;

import java.io.IOException;
import java.util.List;

@FunctionalInterface
public interface WebServiceReader<T> {
    List<T> read(String wsReturnStringValue) throws IOException;
}
