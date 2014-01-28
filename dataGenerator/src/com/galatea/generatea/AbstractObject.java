package com.galatea.generatea;

import java.util.ArrayList;
import java.util.List;

public class AbstractObject {

	private ArrayList<Attribute> attributes;
	private int numInstances;
	private List<AbstractObject> children;
	private String name;

	public AbstractObject(String n, ArrayList<Attribute> a, int numOfInstances,
			ArrayList<AbstractObject> ch) {
		name = n;
		attributes = a;
		children = ch;
		numInstances = numOfInstances;
	}

	public AbstractObject() {
		name = "default";
		attributes = new ArrayList();
		children = new ArrayList();
		numInstances = 0;
	}

	public AbstractObject(String n, int numOfInstances) {
		name = n;
		attributes = new ArrayList();
		children = new ArrayList();
		numOfInstances = 0;
	}

	public AbstractObject(ArrayList<Attribute> a, int numOfInstances,
			ArrayList<AbstractObject> ch) {
		name = "default";
		attributes = a;
		children = ch;
		numInstances = numOfInstances;
	}

	public void setName(String n) {
		name = n;
	}

	public void setAttributes(ArrayList<Attribute> a) {
		attributes = a;
	}

	public void clearAttributes() {
		attributes.clear();
		numInstances = 0;
	}

	public void addAttribute(Attribute a) {
		attributes.add(a);
	}

	public List<AbstractObject> getChildren() {
		return children;
	}

	public void setChildren(List<AbstractObject> children) {
		this.children = children;
	}

	public void addAChild(AbstractObject c) {
		children.add(c);
	}

	public int getNumInstances() {
		return numInstances;
	}

	public void setNumInstances(int numInstances) {
		this.numInstances = numInstances;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(name + "(AbstractObject): \n");
		for (Attribute a : attributes) {
			sb.append("\t");
			sb.append(a.toString());
		}

		return sb.toString();
	}
}