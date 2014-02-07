package com.galatea.generatea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.galatea.generatea.Generators.DistributionType;
import com.galatea.generatea.Tables.AttributeValue.AttributeVal;
import com.google.common.collect.HashBasedTable;

public class GeneratorManager {

	// Table will sit here
	HashBasedTable<String, String, AttributeVal> table;
	AttributeVal<AbstractObject> a;
	AbstractObject objectTree = new AbstractObject();

	public void readFromConfigFile() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File(
					"src/com/galatea/generatea/config.xml"));
			NodeList tree = doc.getElementsByTagName("Tree");
			for (int s = 0; s < tree.getLength(); s++) {
				Node mainObject = tree.item(s);
				if (mainObject.getNodeType() == Node.ELEMENT_NODE) {
					Element mainObjectElement = (Element) mainObject;
					NodeList nodeListChildren = mainObjectElement
							.getChildNodes();
					for (int j = 0; j < nodeListChildren.getLength(); j++) {
						if (nodeListChildren.item(j).getNodeType() == Node.ELEMENT_NODE
								&& nodeListChildren.item(j).hasChildNodes()) {
							objectTree.setName(nodeListChildren.item(j)
									.getNodeName());
							Node n = nodeListChildren.item(j);
							NamedNodeMap m = n.getAttributes();
							objectTree.setNumInstances(Integer.parseInt(m
									.getNamedItem("maxOccurs").getNodeValue()));
							Element eachObjectElement = (Element) nodeListChildren
									.item(j);
							readAttributes(objectTree, eachObjectElement);
						}
					}
					System.out.println(objectTree.getName());
					for (Attribute attr : objectTree.getAttributes()) {
						System.out.println(attr.getName());
					}
					for (AbstractObject obj : objectTree.getChildren()) {
						System.out.println(obj.getName());
					}

				}

			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void readAttributes(AbstractObject obj, Element e) {
		ArrayList<Attribute> attr = new ArrayList<Attribute>();
		NodeList eachObjChildren = e.getChildNodes();
		for (int k = 0; k < eachObjChildren.getLength(); k++) {
			Node c = eachObjChildren.item(k);
			if (c.getNodeType() == Node.ELEMENT_NODE) {
				Element cElement = (Element) c;
				if (!cElement.hasChildNodes()) {
					Attribute a = null;
					if (c.getNodeName() == "String") {
						String name = cElement.getAttribute("name");
						String regexp = cElement.getAttribute("regexp");
						String preDefined = cElement
								.getAttribute("pre-defined");
						List<String> predefinedVals = null;
						if (preDefined != "" && preDefined != null) {
							// read from file and set into list of strings
							BufferedReader br;
							String fileName = "src/com/galatea/generatea/"+preDefined;
							try {
								br = new BufferedReader(new FileReader(fileName));
								String currLine;
								predefinedVals = new ArrayList<String>();
								while ((currLine = br.readLine()) != null) {
									predefinedVals.add(currLine);
								}
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						a = new Attribute(name, Type.String, null, null, null,
								null, regexp, predefinedVals, null, null);
						attr.add(a);
					} else if (c.getNodeName() == "int") {
						String name = cElement.getAttribute("name");
						String disType = cElement.getAttribute("dist");
						String lb = cElement.getAttribute("lowerBound");
						String ub = cElement.getAttribute("upperBound");
						String po = cElement.getAttribute("percentOutlying");
						a = new Attribute(name, Type.Int, Enum.valueOf(
								DistributionType.class, disType.trim()
										.toUpperCase()),
								Double.parseDouble(lb), Double.parseDouble(ub),
								Double.parseDouble(po), null, null, null, null);
						attr.add(a);
					} else if (c.getNodeName() == "BigDecimal") {
						String name = cElement.getAttribute("name");
						String disType = cElement.getAttribute("dist");
						String lb = cElement.getAttribute("lowerBound");
						String ub = cElement.getAttribute("upperBound");
						String po = cElement.getAttribute("percentOutlying");
						a = new Attribute(name, Type.BigDecimal, Enum.valueOf(
								DistributionType.class, disType.trim()
										.toUpperCase()),
								Double.parseDouble(lb), Double.parseDouble(ub),
								Double.parseDouble(po), null, null, null, null);
						attr.add(a);
					} else if (c.getNodeName() == "Boolean") {
						String name = cElement.getAttribute("name");
						a = new Attribute(name, Type.Boolean, null, null, null,
								null, null, null, null, null);
						attr.add(a);
					}
				} else {
					AbstractObject child = new AbstractObject();
					child.setName(cElement.getNodeName());
					Element eachObjectElement = (Element) c;
					child.setNumInstances(Integer.parseInt(eachObjectElement
							.getAttribute("maxOccurs")));
					child.setDistribution(eachObjectElement
							.getAttribute("distribution"));
					obj.addAChild(child);
					readAttributes(child, eachObjectElement);
				}
			}
		}
		obj.setAttributes(attr);
	}

	public static void main(String args[]) {
		GeneratorManager s = new GeneratorManager();
		// read from config file into internal structure
		s.readFromConfigFile();
		// generate table
		// ooutput file
	}
}
