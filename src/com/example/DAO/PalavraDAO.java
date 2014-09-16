package com.example.DAO;

import java.io.*;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PalavraDAO extends SQLiteOpenHelper {

	private static final int VERSAO = 6;
	private static final String TABELA = "Palavras";
	private static final String DATABASE = "Aforc";
	public SQLiteDatabase db;

	// constante para log no logcast
	// private static final String TAG = "CADASTRO_ALUNO";

	public PalavraDAO(Context context) {
		super(context, DATABASE, null, VERSAO);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase database) {

		String ddl = "CREATE TABLE IF NOT EXISTS " + TABELA + "( " +
				//"id INTEGER PRIMARY KEY, " +
			    "palavra TEXT, " + 
				"categoria TEXT)";

		// execucao do comando no dSQLite
		db.execSQL(ddl);
		/*
		if(this.quantRegistro() == 0){
			
			//cadastrarPalavras();
		}*/
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int versaoAntiga,
			int versaoNova) {

	}

	
	
	 //em testes
	
	public void cadastrarPalavras(){
		try {
		// Instancia um objeto do tipo File
				File arquivo = new File("times.txt");
				
				
					// Construtor de um FileReader (note o tratamento de IOException)
					// Caso seja feito um append no arquivo, necessario passar o
					//    valor true apos o identificador do arquivo
					FileReader fr = new FileReader(arquivo);
					
					// Criacao do BufferedReader
					BufferedReader br = new BufferedReader(fr);
					
					dbOpen();
					
					// Leitura do arquivo.
					// Enquanto esta ready para ler...
					while (br.ready()) {
						// Le a proxima linha
						String linha = br.readLine();
						db.execSQL("INSERT INTO " + TABELA + "(palavra, categoria) VALUES(" + linha + ", 'TIMES')");
					}
					
					dbClose();
					// Fecha os recursos (IMPORTANTISSIMO)
					br.close();
					fr.close();
					
					
				} catch (IOException e) {
					e.printStackTrace();
				} 
		
		
	}
	
	//varifica se existe registros na tabela
	public Integer quantRegistro(){
		
		dbOpen();	
		Cursor c = db.rawQuery("SELECT * FROM " + TABELA, null);
		
		int i = c.getCount();
			
		c.close();
		dbClose();

	return i;
	
	}
	
	public String teste() {
		
		dbOpen();
					
		Cursor c = db.rawQuery("SELECT palavra FROM "+ TABELA +" ORDER BY ID", null);

		String a ="";

		if (c.moveToFirst()) {

			do {
					
					a = c.getString(c.getColumnIndex("palavra"));
					
					break;

				} while (c.moveToNext());

			}

		c.close();
		dbClose();
			
		return a;
	
	}
	
	// Abre o banco
		public void dbOpen(){ this.db = this.getWritableDatabase(); }
							
		// Fecha o banco
		public void dbClose(){ this.db.close(); }

}
