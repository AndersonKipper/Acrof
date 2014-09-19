package com.example.acrofjogo;



import android.app.Activity;



import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CategoriaActivity extends Activity {

	private Button times;
	private Button paises;
	private TextView status;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_categoria);
		status = (TextView) findViewById(R.id.nivel);
		status.setText(MainActivity.nivel);
		
		
		
		
		//startActivity(new Intent(this, JogoActivity.class));
	}
	
	//metodo somente para TESTES
	public void jogo(View v){
		startActivity(new Intent(this, JogoActivity.class));
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
}
