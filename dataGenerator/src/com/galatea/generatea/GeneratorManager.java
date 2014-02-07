package com.galatea.generatea;

import java.io.BufferedReader;
import java.io.File;
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

import com.galatea.generatea.Generators.Generator;
import com.galatea.generatea.Tables.AttributeValue.AttributeVal;
import com.galatea.generatea.Tables.AttributeValue.TableVal;
import com.google.common.collect.HashBasedTable;

public class GeneratorManager {

	// Table will sit here
	HashBasedTable<String, String, AttributeVal> table;
	AttributeVal<AbstractObject> a ;
	public void manageAttributeGeneration(AbstractObject parent){
		//for each child generte the children
		//alternate 
		generateTree(parent);
		
		
	}
	
	private HashBasedTable<Integer, String, AttributeVal> generateTree(AbstractObject obj){
		HashBasedTable<Integer, String, AttributeVal> table = null;
		HashBasedTable<Integer, String, AttributeVal> childTable = null;
		for(int i=0;i<obj.getNumInstances();i++){
			for(Attribute at: obj.getAttributes()){
				Generator g = 	at.Generator();
				AttributeVal a = g.generateAttributeVal();
				table.put(i, at.getName(), a);
			}
			if(obj.getChildren().size() != 0){
				for(AbstractObject child: obj.getChildren()){
					childTable =  generateTree(child);
					//table.put(i,child.getName(),childAttr);
				}
			}
			AttributeVal<HashBasedTable> childAttr = new TableVal(childTable);
			
		}
		return table;	
	}
	public void genereteFromXSD(){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File("C:/Users/Janaki/git/datagen_final/dataGenerator/src/com/galatea/generatea/config.xml"));
			List<AbstractObject> listObjs = new ArrayList<AbstractObject>();
		    AbstractObject newObj = new AbstractObject();
			System.out.println(doc.getDocumentElement().getNodeName());
			newObj.setName(doc.getDocumentElement().getNodeName());

            NodeList tree = doc.getElementsByTagName("Tree");
            int totalTress = tree.getLength();
            System.out.println("Total no of trees : " + totalTress);

            for(int s=0; s<tree.getLength() ; s++){


                Node mainObject = tree.item(s);
                if(mainObject.getNodeType() == Node.ELEMENT_NODE){

                	Element mainObjectElement = (Element)mainObject;
                	System.out.println("---"+mainObjectElement.getNodeName());
                    NodeList nodeListChildren = mainObjectElement.getChildNodes();
                    for(int j=0;j<nodeListChildren.getLength();j++){
                    	 if(nodeListChildren.item(j).getNodeType() == Node.ELEMENT_NODE 
                    			 && nodeListChildren.item(j).hasChildNodes()){
                    		 newObj.setName(nodeListChildren.item(j).getNodeName());
                    		 Node n = nodeListChildren.item(j);
                    		 NamedNodeMap m = n.getAttributes();
                    		 newObj.setNumInstances(Integer.parseInt(m.getNamedItem("maxOccurs").getNodeValue()));
                    		 System.out.println(m.getNamedItem("maxOccurs").getNodeValue());
                    		 System.out.println("===="+nodeListChildren.item(j).getNodeName());
                    		 Element eachObjectElement = (Element)nodeListChildren.item(j);
                    		// eachObjectElement.get
                             NodeList eachObjChildren = eachObjectElement.getChildNodes();
                    		 for(int k =0;k<eachObjChildren.getLength();k++){
                    			// System.out.println(eachObjChildren.item(k).getNodeType());
                    			 if(eachObjChildren.item(k).getNodeType() == Node.ELEMENT_NODE && !eachObjChildren.item(k).hasChildNodes() ){
                    				 //System.out.println(eachObjChildren.item(k).getNodeName());
                    				 Node attr = eachObjChildren.item(k);
//                    				 if(attr.getNodeName() == "String"){
//                    					 Attribute a = new Attribute();
//                    					 a.setType(Type.String);
//                    					 a.setRegexp(attr.getAttributes().getNamedItem("regex"));
//                    					 a.setlen(attr.getAttributes().getNamedItem("lengthOfString"));
//                    				 } else if(attr.getNodeName() == "int"){
//                    					 
//                    				 }else if(attr.getNodeName() == "BigDecimal"){
//                    					 
//                    				 }
                    				 
                    			 }
                    		 }
                    	 }
                    }
                    //------


                }//end of if clause


            }//end of for loop with s var
			//doc.getDocumentElement().set
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void getAttributes(AbstractObject obj){
		
	}
	public static void main(String args[]){
		BufferedReader br = null;
		GeneratorManager s = new GeneratorManager();
		s.genereteFromXSD();
	}
}
