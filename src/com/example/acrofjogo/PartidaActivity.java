package com.example.acrofjogo;


import com.example.DAO.MontaBanco;
import com.example.DAO.PalavraDAO;

import android.app.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.widget.SearchViewCompat.OnCloseListenerCompat;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class PartidaActivity extends Activity {
	ImageView img;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		
		//Ao iniciar o sistema cria as tabelas do banco caso ainda não exista.
		new MontaBanco(this);
				
		PalavraDAO db = new PalavraDAO(this);
		
		setContentView(R.layout.activity_partida);
		
		img = (ImageView) findViewById(R.id.imageView1);
		
		
	}

	public void muda(View v){
		img.setImageResource(R.drawable.corpo_completo);
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
