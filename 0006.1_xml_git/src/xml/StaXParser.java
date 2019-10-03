package xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StaXParser {
	
		static final String ID = "ID";
		static final String CLIENTE = "cliente";
	    static final String NOMBRE = "nombre";
	    static final String TELEFONO = "telefono";
	    static final String COMENTARIO = "comentario";
	   

	    @SuppressWarnings({ "unchecked", "null" })
	    public List<Cliente> readConfig(String configFile) {
	        List<Cliente> clientes = new ArrayList<Cliente>();
	        try {
	            // First, create a new XMLInputFactory
	            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
	            // Setup a new eventReader
	            InputStream in = new FileInputStream(configFile);
	            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
	            // read the XML document
	            Cliente nombre = null;

	            while (eventReader.hasNext()) {
	                XMLEvent event = eventReader.nextEvent();

	                if (event.isStartElement()) {
	                    StartElement startElement = event.asStartElement();
	                    // If we have an item element, we create a new item
	                    if (startElement.getName().getLocalPart().equals(CLIENTE)) {
	                    	nombre = new Cliente();
	                        // We read the attributes from this tag and add the date
	                        // attribute to our object
	                        Iterator<Attribute> attributes = startElement
	                                .getAttributes();
	                        while (attributes.hasNext()) {
	                            Attribute attribute = attributes.next();
	                            if (attribute.getName().toString().equals("ID")) {
	                            	nombre.setCliente(attribute.getValue());
	                            }

	                        }
	                    }
	                    if (event.isStartElement()) {
	                        if (event.asStartElement().getName().getLocalPart()
	                                .equals(NOMBRE)) {
	                            event = eventReader.nextEvent();
	                            nombre.setnombre(event.asCharacters().getData());
	                            continue;
	                        }
	                    }
	                    if (event.isStartElement()) {
	                        if (event.asStartElement().getName().getLocalPart()
	                                .equals(TELEFONO)) {
	                            event = eventReader.nextEvent();
	                            nombre.settelefono(event.asCharacters().getData());
	                            continue;
	                        }
	                    }

	                    if (event.isStartElement()) {
	                        if (event.asStartElement().getName().getLocalPart()
	                                .equals(COMENTARIO)) {
	                            event = eventReader.nextEvent();
	                            nombre.setcomentario(event.asCharacters().getData());
	                            continue;
	                        }
	                    }
	                   
	                }
	                // If we reach the end of an item element, we add it to the list
	                if (event.isEndElement()) {
	                    EndElement endElement = event.asEndElement();
	                    if (endElement.getName().getLocalPart().equals(CLIENTE)) {
	                    	Cliente.add(clientes);
	                    }
	                }

	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (XMLStreamException e) {
	            e.printStackTrace();
	        }
	        return clientes;
	    }

	
}
