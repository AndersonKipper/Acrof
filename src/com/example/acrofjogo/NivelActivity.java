package com.example.acrofjogo;



import android.app.Activity;




import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class NivelActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nivel);
		
		
	}
	
	public void setFacil(View v){
		
		startActivity(new Intent(this, CategoriaActivity.class));
		MainActivity.nivel = "FACIL";
		finish();
	}
	
	public void setMedio(View v){
		
		startActivity(new Intent(this, CategoriaActivity.class));
		MainActivity.nivel = "MEDIO";
		finish();
	}
	
	public void setDificil(View v){
		MainActivity.nivel = "DIFICIL";
		startActivity(new Intent(this, CategoriaActivity.class));
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
}
