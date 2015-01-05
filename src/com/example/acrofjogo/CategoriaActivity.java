package com.example.acrofjogo;



import java.util.ArrayList;

import android.app.Activity;



import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckBox;
import android.widget.TextView;

public class CategoriaActivity extends Activity {

	private CheckBox times;
	private CheckBox paises;
	private CheckBox animais;
	private CheckBox objetos;
	private CheckBox frutas;
	private CheckBox profissoes;
	
	private Button continua;
	//private TextView status;
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_categoria);
		
		//status = (TextView) findViewById(R.id.nivel);
		//status.setText(MainActivity.nivel);
		
		times = (CheckBox) findViewById(R.id.times);
		
		paises = (CheckBox) findViewById(R.id.paises);
		
		animais = (CheckBox) findViewById(R.id.animais);
		
		objetos = (CheckBox) findViewById(R.id.objetos);
		
		frutas = (CheckBox) findViewById(R.id.frutas);
		
		profissoes = (CheckBox) findViewById(R.id.profissoes);
		
		continua = (Button) findViewById(R.id.continuar);
		continua.setOnClickListener(new Categoria());
		
		
		
		
		//startActivity(new Intent(this, JogoActivity.class));
	}
	
	//metodo somente para TESTES
	public void jogo(View v){
		startActivity(new Intent(this, JogoActivity.class));
		finish();
	}
	
	public class Categoria implements OnClickListener{

		String categoria = "";
	
		@Override
		public void onClick(View v) {
			ArrayList<String> categ = new ArrayList<String>(); 
			
			if(animais.isChecked()){
				categ.add("ANIMAIS");
			}
			
			if(frutas.isChecked()){
				categ.add("FRUTAS");
			}
			
			if(paises.isChecked()){
				categ.add("PAISES");
			}
			
			if(objetos.isChecked()){
				categ.add("OBJETOS");
			}
			
			if(times.isChecked()){
				categ.add("TIMES");
			}
			
			if(profissoes.isChecked()){
				categ.add("PROFISSOES");
			}
			
			 MainActivity.categoria = categ;
				jogo(v);
			
			
		}	

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
		// automatically handle clicks on the Home/Up CheckBox, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void onBackPressed() {
		startActivity(new Intent(this, NivelActivity.class));
		finish();
	}
}
