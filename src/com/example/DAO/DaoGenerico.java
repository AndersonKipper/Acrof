package com.example.DAO;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DaoGenerico extends SQLiteOpenHelper {
	
	private static int VERSION = 1;
	private static String DB_NAME = "forca.db";
	
	public SQLiteDatabase db;

	public DaoGenerico(Context context) {
		super(context, DB_NAME, null, VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		Log.i("BASE", "ONCREATE GENERIC DAO");
	}

	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		
	}
	
	// Abre o banco
	public void dbOpen(){ this.db = this.getWritableDatabase(); }
						
	// Fecha o banco
	public void dbClose(){ this.db.close(); }

	
}