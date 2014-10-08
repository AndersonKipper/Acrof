package com.example.DAO;

import com.example.model.Jogador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class JogadorDAO extends DaoGenerico {

	private static String TABELA = "JOGADOR";
	
	public JogadorDAO(Context context) {
		super(context);
	}
	
	// Atualiza os dados do dispositivo
	public int atualizar(Jogador jg) {
			
		dbOpen();
			
		ContentValues values = new ContentValues();
			
		values.put("NOMEJOGADOR", jg.getNomeJogador());
		values.put("RODADAS", jg.getRodadas());
		values.put("VITORIAS", jg.getVitorias());
		values.put("DERROTAS", jg.getDerrotas());
		values.put("AVERAGE", jg.getAverage());
					
		String id = String.valueOf(jg.getIdJogador());

		String where = "id" + "=?";
		String[] whereArgs = new String[] { id };

		int i = db.update(TABELA, values, where, whereArgs);
			
		dbClose();
			
	return i;
	}
	
	// Verifica se existe registro com os dados do dispositivo
	// Essa tabela possui somente 1 registro
	public Integer quantRegistro(){
			
		dbOpen();	
		Cursor c = db.rawQuery("SELECT * FROM " + TABELA, null);
		
		int i = c.getCount();
			
		c.close();
		dbClose();

	return i;
	}
	
	// Retorna os dados do dispositivo
	public Jogador getJogador(){
			
		dbOpen();
		
		// Retorna os dados cadastros do dispositivo
		Cursor c = db.rawQuery("SELECT * FROM " + TABELA, null);
			
		if (c.getCount() > 0){
				
			Jogador jg = new Jogador();
				
			c.moveToFirst();
			jg.setIdJogador(c.getInt(c.getColumnIndex("ID")));
			jg.setNomeJogador(c.getString(c.getColumnIndex("NOMEJOGADOR")));
			jg.setRodadas(c.getInt(c.getColumnIndex("RODADAS")));
			jg.setVitorias(c.getInt(c.getColumnIndex("VITORIAS")));
			jg.setDerrotas(c.getInt(c.getColumnIndex("DERROTAS")));
			jg.setAverage(c.getDouble(c.getColumnIndex("AVERAGE")));

				
			c.close();
			dbClose();
				
			return jg;
		}
			
	c.close();
	dbClose();
	return null;
	}

}
