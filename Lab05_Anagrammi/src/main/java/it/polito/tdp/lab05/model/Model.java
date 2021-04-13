package it.polito.tdp.lab05.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.lab05.DAO.AnagrammaDAO;

public class Model {
	
	private AnagrammaDAO anagrammaDao;
	
	public Model() {
		this.anagrammaDao= new AnagrammaDAO();
	}
	
	public List<String> anagrammi(String parola){
		List<String> risultato= new ArrayList<>();
		permuta("",parola,0,risultato);
		return risultato;
	}


	private void permuta(String parziale, String lettere, int livello, List<String> risultato) {
		if(lettere.length()==0) {
			//caso terminale
			risultato.add(parziale);			
		}	
		else {
			//ricorsione
			for(int pos=0; pos<lettere.length(); pos++) {
				
				char tentativo = lettere.charAt(pos) ; 
				
				String nuovaParziale = parziale + tentativo ;
				String nuovaLettere = lettere.substring(0, pos)+lettere.substring(pos+1) ;
				permuta(nuovaParziale, nuovaLettere, livello+1, risultato) ;
			}
		
		}
    }
	
	public List<String> getAnagrammiCorretti(List<String> risultato){
		List<String> anagrammiCorretti= new ArrayList<>();
		for(String parola:risultato) {
			if(anagrammaDao.isCorrect(parola))
				anagrammiCorretti.add(parola);
		}
		return anagrammiCorretti;
	}
	
	public List<String> getAnagrammiErrati(List<String> risultato){
		List<String> anagrammiErrati= new ArrayList<>();
		for(String parola:risultato) {
			if(!anagrammaDao.isCorrect(parola))
				anagrammiErrati.add(parola);
		}
		return anagrammiErrati;
	}

	
	
	

	
}
