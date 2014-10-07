package com.example.acrofjogo;

import java.util.ArrayList;

import com.example.DAO.PalavraDAO;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SearchViewCompat.OnCloseListenerCompat;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class Lista extends Activity {
	
		
		private ArrayAdapter<String> adapter;
		private ListView lvListagem;
		
		// Definição do layout de exibição da listagem
		private int adapterLayout = android.R.layout.simple_list_item_1;
		TextView texto;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			
			PalavraDAO db = new PalavraDAO(this);
			ArrayList<String> lista = db.getLista();
			setContentView(R.layout.lista);
			
			
			lvListagem = (ListView) findViewById(R.id.listView1);
			
			this.adapter = new ArrayAdapter<String>(this, adapterLayout, lista);
			// associacao do adapter a listView
			this.lvListagem.setAdapter(adapter);
		
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
}
