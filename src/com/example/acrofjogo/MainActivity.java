package com.example.acrofjogo;


import java.util.ArrayList;

import com.example.DAO.MontaBanco;
import com.example.DAO.PalavraDAO;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SearchViewCompat.OnCloseListenerCompat;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
	public static String nivel="";
	public static ArrayList<String> categoria = new ArrayList<String>();
    private Button novoJogo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		
		//Ao iniciar o sistema cria as tabelas do banco caso ainda n�o exista.
		new MontaBanco(this);
				
		PalavraDAO db = new PalavraDAO(this);
		
		setContentView(R.layout.activity_main);
		
		//TextView a = (TextView) findViewById(R.id.t1);
	//	a.setText(""+db.quantRegistro());
		//startActivity(new Intent(this, NivelActivity.class));
		//startActivity(new Intent(this, JogoActivity.class));
		
	}

	public void novoJogo(View v){
		startActivity(new Intent(this, NivelActivity.class));
	}
	public void Instrucoes(View v){
		startActivity(new Intent(this, Lista.class));
	}
	
	public void sair(View v){
		finish();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void onBackPressed() {
		finish();
	}
}
