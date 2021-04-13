package it.polito.tdp.lab05.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		Model model= new Model();
		List<String> anagrammi=model.anagrammi("poi");
		System.out.println(model.getAnagrammiCorretti(anagrammi));
		System.out.println(model.getAnagrammiErrati(anagrammi));
		
	}

}
