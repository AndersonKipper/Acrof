package com.example.acrofjogo;



import android.app.Activity;



import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class CategoriaActivity extends Activity {

	private Button times;
	private Button paises;
	private Button animais;
	private Button objetos;
	private Button frutas;
	private Button profissoes;
	//private TextView status;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_categoria);
		
		//status = (TextView) findViewById(R.id.nivel);
		//status.setText(MainActivity.nivel);
		
		times = (Button) findViewById(R.id.times);
		times.setOnClickListener(new Categoria("TIMES"));
		
		paises = (Button) findViewById(R.id.paises);
		paises.setOnClickListener(new Categoria("PAISES"));
		
		animais = (Button) findViewById(R.id.animais);
		animais.setOnClickListener(new Categoria("ANIMAIS"));
		
		objetos = (Button) findViewById(R.id.objetos);
		objetos.setOnClickListener(new Categoria("OBJETOS"));
		
		frutas = (Button) findViewById(R.id.frutas);
		frutas.setOnClickListener(new Categoria("FRUTAS"));
		
		profissoes = (Button) findViewById(R.id.profissoes);
		profissoes.setOnClickListener(new Categoria("PROFISSOES"));
		
		
		
		
		//startActivity(new Intent(this, JogoActivity.class));
	}
	
	//metodo somente para TESTES
	public void jogo(View v){
		startActivity(new Intent(this, JogoActivity.class));
		finish();
	}
	
	public class Categoria implements OnClickListener{

		String categoria;
		 public Categoria(String cat) {
			// TODO Auto-generated constructor stub
			categoria = cat;
		}

		@Override
		public void onClick(View v) {
			 MainActivity.categoria = categoria;
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
		// automatically handle clicks on the Home/Up button, so long
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
