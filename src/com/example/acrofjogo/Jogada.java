package com.example.acrofjogo;

import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;

public class Jogada extends JogoActivity implements Runnable{
	
	private CharSequence letra;
	
	public Jogada(CharSequence charSequence){
		this.letra = charSequence;
	}


	public void run() {
		
		
		TextView t = (TextView) findViewById(R.id.texto);
		t.setText("LALE");

		
		
	}
	

}
