package com.example.acrofjogo;

import android.app.Activity;

import android.os.Bundle;
import android.support.v4.widget.SearchViewCompat.OnCloseListenerCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;


public class JogoActivity extends Activity {
	
	//Variaveis
	String palavra; //Guarda a palavra do bd que irá ser sorteada
	String esconde; //Aqui a palavra é substituida por '-'
	StringBuilder achou; //Quando digita a letra certa ele subistitui o '-' pela letra
	
	private Button buttonQ;
	private Button buttonW;
	private Button buttonE;
	private Button buttonR;
	private Button buttonT;
	private Button buttonY;
	private Button buttonU;
	private Button buttonI;
	private Button buttonO;
	private Button buttonP;
	private Button buttonA;
	private Button buttonS;
	private Button buttonD;
	private Button buttonF;
	private Button buttonG;
	private Button buttonH;
	private Button buttonJ;
	private Button buttonK;
	private Button buttonL;
	private Button buttonCC; //Ç
	private Button buttonZ;
	private Button buttonX;
	private Button buttonC;
	private Button buttonV;
	private Button buttonB;
	private Button buttonN;
	private Button buttonM;
	
	private TextView texto; //Só para testes
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jogo);
		
		buttonQ = (Button) findViewById(R.id.buttonQ);
		buttonW = (Button) findViewById(R.id.buttonW);
		buttonE = (Button) findViewById(R.id.buttonE);
		buttonR = (Button) findViewById(R.id.buttonR);
		buttonT = (Button) findViewById(R.id.buttonT);
		buttonY = (Button) findViewById(R.id.buttonY);
		buttonU = (Button) findViewById(R.id.buttonU);
		buttonI = (Button) findViewById(R.id.buttonI);
		buttonO = (Button) findViewById(R.id.buttonO);
		buttonP = (Button) findViewById(R.id.buttonP);
		buttonA = (Button) findViewById(R.id.buttonA);
		buttonS = (Button) findViewById(R.id.buttonS);
		buttonD = (Button) findViewById(R.id.buttonD);
		buttonF = (Button) findViewById(R.id.buttonF);
		buttonG = (Button) findViewById(R.id.buttonG);
		buttonH = (Button) findViewById(R.id.buttonH);
		buttonJ = (Button) findViewById(R.id.buttonJ);
		buttonK = (Button) findViewById(R.id.buttonK);
		buttonL = (Button) findViewById(R.id.buttonL);
		buttonCC = (Button) findViewById(R.id.buttonCC); //Ç
		buttonZ = (Button) findViewById(R.id.buttonZ);
		buttonX = (Button) findViewById(R.id.buttonX);
		buttonC = (Button) findViewById(R.id.buttonC);
		buttonV = (Button) findViewById(R.id.buttonV);
		buttonB = (Button) findViewById(R.id.buttonB);
		buttonN = (Button) findViewById(R.id.buttonN);
		buttonM = (Button) findViewById(R.id.buttonM);
		
		texto = (TextView) findViewById(R.id.texto); //Apenas pata teste
		
		
		/* ##### INICIO DO TRATAMENTO DE EVENTO DOS BOTOES ##### */
		
		//outra forma
		buttonQ.setOnClickListener(new Clique(buttonQ.getText().toString()));
		
		buttonW.setOnClickListener(new Clique(buttonW.getText().toString()));
		
		buttonE.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				fazJogada(buttonE.getText());
			}
		});
		buttonR.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				fazJogada(buttonR.getText());
			}
		});
		buttonT.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				fazJogada(buttonT.getText());
			}
		});
		buttonY.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				fazJogada(buttonY.getText());
			}
		});
		buttonU.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				fazJogada(buttonU.getText());
			}
		});
		buttonI.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				fazJogada(buttonI.getText());
			}
		});
		buttonO.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				fazJogada(buttonO.getText());
			}
		});
		buttonP.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				fazJogada(buttonP.getText());
			}
		});
		buttonA.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				fazJogada(buttonA.getText());
			}
		});
		buttonS.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				fazJogada(buttonS.getText());
			}
		});
		buttonD.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				fazJogada(buttonD.getText());
			}
		});
		buttonF.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				fazJogada(buttonF.getText());
			}
		});
		buttonG.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				fazJogada(buttonG.getText());
			}
		});
		buttonH.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				fazJogada(buttonH.getText());
			}
		});
		buttonJ.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				fazJogada(buttonJ.getText());
			}
		});
		buttonK.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				fazJogada(buttonK.getText());
			}
		});
		buttonL.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				fazJogada(buttonL.getText());
			}
		});
		buttonCC.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				fazJogada(buttonCC.getText());
			}
		});
		buttonZ.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				fazJogada(buttonZ.getText());
			}
		});
		buttonX.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				fazJogada(buttonX.getText());
			}
		});
		buttonC.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				fazJogada(buttonC.getText());
			}
		});
		buttonV.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				fazJogada(buttonV.getText());
			}
		});
		buttonB.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				fazJogada(buttonB.getText());
			}
		});
		buttonN.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				fazJogada(buttonN.getText());
			}
		});
		buttonM.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				fazJogada(buttonM.getText());
			}
		});
		
		/* ###### FIM DO TRATAMENTO DE EVENTO DOS BOTOES  #####*/
		
		
		/* ###### MOSTRA PALAVRA ESCONDIDA ##### */
		
		//Só para testes, depois tem que fazer receber a palavra sorteada do banco
		palavra="SC INTERNACIONAL";
		
		//Recebe palavra para subistituir por '-' depois
		esconde = palavra;
		
		//Esconde a palavra colocando '_' no lugar das letras
		for(Character i='A'; i <= 'Z'; i++){
			esconde = esconde.replace(i, '-');
		}

		//TextView
		TextView t = (TextView) findViewById(R.id.texto);
		
		//Exibe a palavra escondida na tela
		t.setText(esconde);
		
		//achou recebe a palavra escondida
		achou = new StringBuilder(esconde);

	}
	
	public void fazJogada(CharSequence letra){
		
		//Pega a letra
		char l = letra.charAt(0);
		
		//Percorre a palavra para ver se tem a letra
		for(int i=0; i < palavra.length(); i++){
			
			//Se siver substitui o '-' pela letra
			if(palavra.charAt(i)==l){
				achou.setCharAt(i, l);
			}
			
		}
		
		//TextView
		TextView t = (TextView) findViewById(R.id.texto);
		
		//Printa na tela
		t.setText(achou);
		
		
	}
	

		
	
	
	
	
	//Tratamento de evento dos botoes
	public class Clique implements OnClickListener{

		String letra="";
		public Clique(String letra) {
			this.letra = letra;
			
		}

		@Override
		public void onClick(View v) {
			fazJogada(letra);
		}
		
		
	}
	

}
