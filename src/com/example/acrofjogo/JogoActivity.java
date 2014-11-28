package com.example.acrofjogo;


import com.example.DAO.JogadorDAO;
import com.example.DAO.PalavraDAO;
import com.example.model.Jogador;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;
import android.support.v4.widget.SearchViewCompat.OnCloseListenerCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;


public class JogoActivity extends Activity {
	
	//Variaveis
	String palavra; //Guarda a palavra do bd que irá ser sorteada
	int espacos=0;
	String esconde; //Aqui a palavra é substituida por '-'
	int tentativas=0;
	int venceu=0; //Qundo venceu for igual ao tamanho da palavra é pq ganhou.
	StringBuilder achou; //Quando digita a letra certa ele subistitui o '-' pela letra
	Context c;
	Jogador jg;
	JogadorDAO daoJg = new JogadorDAO(this);
	ImageView img;
	int testaTentativa = 0; // testa se tentativa mudou
	int tamPalavra = 0;
	
	
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
	private TextView status;
	private TextView pala;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_partida);
		
		c = this;
		img = (ImageView) findViewById(R.id.imageView1);
		
		jg = daoJg.getJogador();
		
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
		status= (TextView) findViewById(R.id.textStatus);
		
	        
		/* ##### INICIO DO TRATAMENTO DOS BOTOES ##### */
		
        
		buttonQ.setOnClickListener(new Clique(buttonQ.getText().toString(), buttonQ));
		
		buttonW.setOnClickListener(new Clique(buttonW.getText().toString(), buttonW));
		
		buttonE.setOnClickListener(new Clique(buttonE.getText().toString(), buttonE));
		
		buttonR.setOnClickListener(new Clique(buttonR.getText().toString(), buttonR));
		
		buttonT.setOnClickListener(new Clique(buttonT.getText().toString(), buttonT));
		
		buttonY.setOnClickListener(new Clique(buttonY.getText().toString(), buttonY));
		
		buttonU.setOnClickListener(new Clique(buttonU.getText().toString(), buttonU));

		buttonI.setOnClickListener(new Clique(buttonI.getText().toString(), buttonI));

		buttonO.setOnClickListener(new Clique(buttonO.getText().toString(), buttonO));

		buttonP.setOnClickListener(new Clique(buttonP.getText().toString(), buttonP));

		buttonA.setOnClickListener(new Clique(buttonA.getText().toString(), buttonA));

		buttonS.setOnClickListener(new Clique(buttonS.getText().toString(), buttonS));
		
		buttonD.setOnClickListener(new Clique(buttonD.getText().toString(), buttonD));

		buttonF.setOnClickListener(new Clique(buttonF.getText().toString(), buttonF));

		buttonG.setOnClickListener(new Clique(buttonG.getText().toString(), buttonG));
		
		buttonH.setOnClickListener(new Clique(buttonH.getText().toString(), buttonH));
		
		buttonJ.setOnClickListener(new Clique(buttonJ.getText().toString(), buttonJ));
		
		buttonK.setOnClickListener(new Clique(buttonK.getText().toString(), buttonK));
		
		buttonL.setOnClickListener(new Clique(buttonL.getText().toString(), buttonL));
		
		buttonCC.setOnClickListener(new Clique(buttonCC.getText().toString(), buttonCC));
		
		buttonZ.setOnClickListener(new Clique(buttonZ.getText().toString(), buttonZ));
		
		buttonX.setOnClickListener(new Clique(buttonX.getText().toString(), buttonX));

		buttonC.setOnClickListener(new Clique(buttonC.getText().toString(), buttonC));
		
		buttonV.setOnClickListener(new Clique(buttonV.getText().toString(), buttonV));

		buttonB.setOnClickListener(new Clique(buttonB.getText().toString(), buttonB));

		buttonN.setOnClickListener(new Clique(buttonN.getText().toString(), buttonN));

		buttonM.setOnClickListener(new Clique(buttonM.getText().toString(), buttonM));
		
		/* ###### FIM DO TRATAMENTO DOS BOTOES  #####*/
		
		
		/* ###### MOSTRA PALAVRA ESCONDIDA ##### */
		PalavraDAO db = new PalavraDAO(this);
		
		
		palavra= db.getPalavra(MainActivity.nivel, MainActivity.categoria);
		

		//explicar o q acontece aqui, tamPalavra recebe o tamanho da palavra gerada, contasse os espaços cria um 'nova' string que recebe palavra com espaços e depois palavra recebe 'nova',
		//esconde recebe palavra e trca por _ e lanca na textview.
		
		tamPalavra = palavra.length();
		//Conta os espaços da palavra
				for(int x=0 ; x < palavra.length(); x++){
					if(palavra.charAt(x) == ' '){
						espacos++;
					}
				}
		
		//Esconde a palavra colocando '_' no lugar das letras
		
		
		
		String nova="";
		for(int i = 0; i < palavra.length(); i++ ){
			nova += palavra.charAt(i) + " ";
		}
		
		palavra = nova;
		
		//Recebe palavra para subistituir por '-' depois
		esconde = palavra;
		//TextView
		TextView t = (TextView) findViewById(R.id.texto);
		for(Character i='A'; i <= 'Z'; i++){
			esconde = esconde.replace(i, '_');
		}
		//Exibe a palavra escondida na tela
		t.setText(esconde);
		
		//achou recebe a palavra escondida
		achou = new StringBuilder(esconde);
		
		
		
		
		
		venceu = venceu + espacos;

		
		
		status.setText("R: " + jg.getRodadas() + " V: " + jg.getVitorias() + " D: " + jg.getDerrotas());

	}
	
	public void fazJogada(CharSequence letra, Button b){
		
			
	
		//Pega a letra
		char l = letra.charAt(0);
			
			int y=0;
			//Percorre a palavra para ver se tem a letra
			for(int i=0; i < palavra.length(); i++){
				
				int acertou=0;
				//Se siver substitui o '-' pela letra
				if(palavra.charAt(i)==l){
					achou.setCharAt(i, l);
					b.setBackgroundColor(Color.GREEN);
					b.setEnabled(false); 
					venceu++;
					
					y++;
					acertou++;
					//Para não diminuir mais de uma vez para a mesma letra, se tiver mais de uma vez a mesma letra na palavra
					if(y <= 1){
						//Se acertou diminui para não somar lá embaixo (gambiarra aqui)
						tentativas--;
					}
				}
				if(y == 0){
					b.setBackgroundColor(Color.RED);
					b.setEnabled(false); 
				}
				
			}
			
			//Verifica se perdeu
			if(tentativas >= 5){
				
				//Soma uma rodada
				jg.setRodadas(jg.getRodadas()+1);
				
				//Soma uma derrota
				jg.setDerrotas(jg.getDerrotas()+1);
				
				//Atualiza o banco
				daoJg.atualizar(jg);
			
				img.setImageResource(R.drawable.corpo_completo);
				

		      ///   setContentView(R.layout.dialog_continua);  

				AlertDialog.Builder builder = new AlertDialog.Builder(this);
			    // Get the layout inflater
			    LayoutInflater inflater = this.getLayoutInflater();
			   

			    // Inflate and set the layout for the dialog
			    // Pass null as the parent view because its going in the dialog layout
			    builder.setView(inflater.inflate(R.layout.dialog_perdeu, null)).setCancelable(false)
			    
			    // Add action buttons
			           .setPositiveButton("CONTINUAR JOGANDO", new DialogInterface.OnClickListener() {
			        	   
			               @Override
			               public void onClick(DialogInterface dialog, int id) {
			            	   Intent myIntent = new Intent(c, JogoActivity.class);
			            	   startActivity(myIntent);
			            	   finish();
			               }
			           })
			           .setNegativeButton("SAIR", new DialogInterface.OnClickListener() {
			               public void onClick(DialogInterface dialog, int id) {
			            	   finish();
			               }
			           });      
			    
			  
			     builder.show();

				
			/*
				
				AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				
				LayoutInflater inflater = this.getLayoutInflater();
				
				builder.setView(inflater.inflate(R.layout.dialog_continua, null));
				 
		        // Setting Dialog Title
		        builder.setTitle("Você perdeu! :(");
		 
		        // Setting Dialog Message
		        builder.setMessage("A palavra era: \n \n      Anderson Gay \n \n O que deseja fazer agora?");
		 
		        // Setting Icon to Dialog
		        //alertDialog.setIcon(R.drawable.delete);
		 
		        // Setting Positive "Yes" Button
		        builder.setPositiveButton("Jogar novamente", new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog,int which) {
		 
		            // Write your code here to invoke YES event
		            Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
		            }
		        });
		 
		        // Setting Negative "NO" Button
		        builder.setNegativeButton("Sair", new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog, int which) {
		            // Write your code here to invoke NO event
		            Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
		            dialog.cancel();
		            }
		        });
		 
		        // Showing Alert Message
		        builder.show();
			*/
				
				//Chama a tela de continua
				//startActivity(new Intent(this, ContinuarActivity.class));
				//finish();
			}
			
			//if para verificar se ganhou
			if(venceu == tamPalavra){
				
				//Soma uma rodada
				jg.setRodadas(jg.getRodadas()+1);
				
				//Soma uma vitoria
				jg.setVitorias(jg.getVitorias()+1);
				
				//Atualiza o banco
				daoJg.atualizar(jg);
				
				//Chama a tela de continua
				//startActivity(new Intent(this, ContinuarActivity.class));
				//finish();
				
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
			    // Get the layout inflater
			    LayoutInflater inflater = this.getLayoutInflater();
			   

			    // Inflate and set the layout for the dialog
			    // Pass null as the parent view because its going in the dialog layout
			    builder.setView(inflater.inflate(R.layout.dialog_ganhou, null)).setCancelable(false)
			    // Add action buttons
			           .setPositiveButton("CONTINUAR JOGANDO", new DialogInterface.OnClickListener() {
			               @Override
			               public void onClick(DialogInterface dialog, int id) {
			            	   Intent myIntent = new Intent(c, JogoActivity.class);
			            	   startActivity(myIntent);
			            	   finish();
			               }
			           })
			           .setNegativeButton("SAIR", new DialogInterface.OnClickListener() {
			               public void onClick(DialogInterface dialog, int id) {
			            	   finish();
			               }
			           });      
			    
			     builder.show();

			}
			
		
			//TextView
			TextView t = (TextView) findViewById(R.id.texto);
			
			//Printa na tela
			t.setText(achou);
			
			
			
			tentativas++;
			
			if(testaTentativa != tentativas){
				mudaTela(tentativas);
				testaTentativa = tentativas;
			}
		
	}
	//Só teste
	public void TestaJogada(Button b){
		b.setBackgroundColor(Color.MAGENTA);
	}

	
public void mudaTela(int tela){
	
	switch (tela) {
	case 1: 
		img.setImageResource(R.drawable.cabeca);
		break;
	case 2: 
		img.setImageResource(R.drawable.corpo);
		break;
	case 3: 
		img.setImageResource(R.drawable.braco_d);
		break;
	case 4: 
		img.setImageResource(R.drawable.braco_e);
		break;
	case 5: 
		img.setImageResource(R.drawable.perna_d);
		break;

	default:
		break;
	}
}
		
	
	
	
	
	//Tratamento de evento dos botoes
	public class Clique implements OnClickListener{

		String letra="";
		Button b;
		
		public Clique(String letra, Button b) {
			this.letra = letra;
			this.b = b;
			
		}

		@Override
		public void onClick(View v) {
			fazJogada(letra,b);
		}
		
		
	}
	
	//caso do usuario fechar o jogo
		public void onBackPressed() {
		    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(c);
		    alertDialogBuilder.setIcon(R.drawable.ic_launcher);
		    alertDialogBuilder.setTitle("Jogo da Forca");
		 
		    alertDialogBuilder.setMessage("Desistir da Partida?").setCancelable(false).setPositiveButton("Sim",
		        new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog, int id) {
		            	jg.setRodadas(jg.getRodadas()+1);
						
						//Soma uma derrota
						jg.setDerrotas(jg.getDerrotas()+1);
						
						//Atualiza o banco
						daoJg.atualizar(jg);
						startActivity(new Intent(c, ContinuarActivity.class));
		            	finish();
		            }
		        })
		        .setNegativeButton("Não",
		        new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog, int id) {
		                dialog.cancel();
		            }
		        });
		 
		    AlertDialog alertDialog = alertDialogBuilder.create();
		    alertDialog.show();
		}
	

}
