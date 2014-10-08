package com.example.DAO;

import android.content.Context;
import android.util.Log;



public class MontaBanco extends DaoGenerico {

	//private Context context;
    
    // Tabela com os dados do JOGADOR
    private static final String JOGADOR = 
    		"CREATE TABLE IF NOT EXISTS JOGADOR ( " +
            " ID integer PRIMARY KEY, " +
            " NOMEJOGADOR varchar(30), " +
            " RODADAS integer, " +
            " VITORIAS integer, " +
            " DERROTAS integer, " +
            " AVERAGE double " +
            " );";

  public MontaBanco(Context context) {
 		super(context);

 		//this.context = context;
 		
 		Log.i("BASE DE DADOS", "CRIANDO ESTRUTURA");
		
		dbOpen();
//		Log.d("VERS�O BASE ATUAL", Integer.toString(db.getVersion()));
		
		// Cria as tabelas
		db.execSQL(JOGADOR);
		
		dbClose();

		//Insere registro padr�o dos dados do dispositivo ao criar pela primeira vez a base.
		JogadorDAO dao = new JogadorDAO(context);
		
		if(dao.quantRegistro() == 0){
			dbOpen();
			db.execSQL("INSERT INTO JOGADOR(NOMEJOGADOR, RODADAS, VITORIAS, DERROTAS, AVERAGE) VALUES('Player 1', 0, 0, 0, 100.00)");
			dbClose();
		}

  }
}
