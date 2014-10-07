package com.example.DAO;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class PalavraDAO extends SQLiteOpenHelper {

	private static final int VERSAO = 1;
	private static final String TABELA = "palavras";
	private static final String DATABASE = "acrof";
	public static Context c;

	// constante para log no logcast
	// private static final String TAG = "CADASTRO_ALUNO";

	public PalavraDAO(Context context) {
		super(context, DATABASE, null, VERSAO);
		// TODO Auto-generated constructor stub
		c = context;
	}

	@Override
	public void onCreate(SQLiteDatabase database) {

		String ddl = "CREATE TABLE " + TABELA + "( "
				+ "id INTEGER PRIMARY KEY autoincrement, " + "palavra TEXT, "
				+ "nivel TEXT, " + "categoria TEXT);";

		// execucao do comando no dSQLite
		database.execSQL(ddl);
		
		if (quantRegistro(database) == 0) {

			cadastrarPalavras(database);

		}

	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int versaoAntiga,
			int versaoNova) {
		String sql = "DROP TABLE IF EXISTS " + TABELA;
		database.execSQL(sql);
		onCreate(database);
	}

	// em testes

	public void cadastrarPalavras(SQLiteDatabase database) {
		 try 
		    {
		    	

		        // Obtem o contexto definido globalmente e abre o arquivo do Assets
		        InputStream is = c.getAssets().open("insert.txt");
		        BufferedReader br = new BufferedReader(new InputStreamReader(is));
		        String insert = null;

		        // Instancia do stringbuilder que sera utilizada para leitura do arquivo
		       // sb = new StringBuilder();
		     
		        while ((insert = br.readLine()) != null){
		        	database.execSQL(insert);
		        	//Toast.makeText(c, "Numero de registros " + insert , Toast.LENGTH_SHORT).show();
		        }
		        
		        br.close();
		        is.close();
		      

		    } catch (Exception e1) {AssetManager assetManager;  
		    
		        Toast.makeText(c, "Excecao no arquivo " + e1.getMessage() , Toast.LENGTH_LONG).show();
		    }
	}

	// varifica se existe registros na tabela
	public Integer quantRegistro(SQLiteDatabase database) {

		String sql = "SELECT * FROM " + TABELA;
		
		Cursor cursor = database.rawQuery(sql, null);

		int i = cursor.getCount();
		
		cursor.close();
		
		 Toast.makeText(c, "Numero de registros " + i , Toast.LENGTH_LONG).show();
		return i;

	}

	public ArrayList<String> getLista() {
		
		ArrayList<String> lista = new ArrayList<String>();
		String sql = "SELECT * FROM " + TABELA;
		
		
		
		Cursor cursor = getReadableDatabase().rawQuery(sql, null);

		
		
		
		try{
			while(cursor.moveToNext()){
				String linha = cursor.getString(1);
				lista.add(linha);
			}
		}catch(SQLException e){
		Toast.makeText(c, "Erro" + e , Toast.LENGTH_LONG).show();
		}
		
		cursor.close();
		
		 return lista;

	}
	
	
	public String getPalavra(String nivel, String categoria){
		
String sql = "SELECT palavra FROM " + TABELA + " WHERE nivel = '" + nivel + "' AND categoria = '" + categoria + "'";
		
		
		
		Cursor cursor = getReadableDatabase().rawQuery(sql, null);

		int i = 0;
		
		int id = new Random().nextInt(cursor.getCount());
		
		String palavra = "";
		try{
			while(cursor.moveToNext()){
				
				if(i == id){
					palavra = cursor.getString(0);
					Toast.makeText(c, sql + " --- " + palavra, Toast.LENGTH_LONG).show();
				}
				i++;
			}
		}catch(SQLException e){
		Toast.makeText(c, "Erro" + e , Toast.LENGTH_LONG).show();
		}
		
		cursor.close();
		
		
		return palavra;
	}
	

}
