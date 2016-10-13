package com.adobe.aem.sql;

import java.io.StringWriter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class DataConvertUtil {

	public String convertToString(Document xml) {
		try {
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();
			StreamResult result = new StreamResult(new StringWriter());
			DOMSource source = new DOMSource(xml);
			transformer.transform(source, result);
			return result.getWriter().toString();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	// Convert Customer data retrieved from the AEM JCR
	// into an XML schema to pass back to client
//	public Document toXml(List<Customer> custList) {
//		try {
//			DocumentBuilderFactory factory = DocumentBuilderFactory
//					.newInstance();
//			DocumentBuilder builder = factory.newDocumentBuilder();
//			Document doc = builder.newDocument();
//
//			// Start building the XML to pass back to the AEM client
//			Element root = doc.createElement("Customers");
//			doc.appendChild(root);
//
//			// Get the elements from the collection
//			int custCount = custList.size();
//
//			// Iterate through the collection to build up the DOM
//			for (int index = 0; index < custCount; index++) {
//
//				// Get the Customer object from the collection
//				Customer myCust = (Customer) custList.get(index);
//
//				Element Customer = doc.createElement("Customer");
//				root.appendChild(Customer);
//
//				// Add rest of data as child elements to customer
//				// Set First Name
//				Element first = doc.createElement("First");
//				first.appendChild(doc.createTextNode(myCust.getCustFirst()));
//				Customer.appendChild(first);
//
//				// Set Last Name
//				Element last = doc.createElement("Last");
//				last.appendChild(doc.createTextNode(myCust.getCustLast()));
//				Customer.appendChild(last);
//
//				// Set Description
//				Element desc = doc.createElement("Description");
//				desc.appendChild(doc.createTextNode(myCust.getCustDescription()));
//				Customer.appendChild(desc);
//
//				// Set Address
//				Element address = doc.createElement("Address");
//				address.appendChild(doc.createTextNode(myCust.getCustAddress()));
//				Customer.appendChild(address);
//			}
//
//			return doc;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
}
