package it.polito.tdp.lab05.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class AnagrammaDAO {
	
	/**
	 * tramite una query SQL permette di verificare se l’anagramma calcolato è presente nel dizionario.
	 * @param anagramma
	 * @return
	 */
	public boolean isCorrect(String anagramma) {
		final String sql="SELECT p.nome "
				+ "FROM parola p "
				+ "WHERE p.nome=? ";
		List<String> anagrammiCorretti= new ArrayList<>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				anagrammiCorretti.add(rs.getString("nome"));				
			}

			conn.close();
			
			if(anagrammiCorretti.contains(anagramma))
				return true;
			else
				return false;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	
	}

}
