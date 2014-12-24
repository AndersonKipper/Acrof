package com.example.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
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
            " PONTOS integer, " +
            " AVERAGE double " +
            " );";

  public MontaBanco(Context context) {
 		super(context);

 		//this.context = context;
 		
 		Log.i("BASE DE DADOS", "CRIANDO ESTRUTURA");
		
		dbOpen();
//		Log.d("VERSÃO BASE ATUAL", Integer.toString(db.getVersion()));
		
		// Cria as tabelas
		db.execSQL(JOGADOR);
		
		dbClose();

		//Insere registro padrão dos dados do dispositivo ao criar pela primeira vez a base.
		JogadorDAO dao = new JogadorDAO(context);
		
		if(dao.quantRegistro() == 0){
			dbOpen();
			db.execSQL("INSERT INTO JOGADOR(NOMEJOGADOR, RODADAS, VITORIAS, DERROTAS, PONTOS, AVERAGE) VALUES('Player 1', 0, 0, 0, 0, 100.00)");
			dbClose();
		}

  }
  
  public void onUpgrade(SQLiteDatabase database, int versaoAntiga,
			int versaoNova) {
		String sql = "DROP TABLE IF EXISTS " + JOGADOR;
		database.execSQL(sql);
		onCreate(database);
	}
}
