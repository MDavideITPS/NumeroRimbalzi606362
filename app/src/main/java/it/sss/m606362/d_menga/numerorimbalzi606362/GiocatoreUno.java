package it.sss.m606362.d_menga.numerorimbalzi606362;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * PROBLEMI: lo stato dell'activity GiocatoreUno è salvato. Tuttavia nel momento in cui creo l'intent nell'activity GiocatoreDue
 * mettendo tutte le variabili da passargli e startando l'activity GiocatoreUno, questa viene ricreata(viene creata un'altra
 * istanza diversa dalla precendente.
 */

public class GiocatoreUno extends Activity {

    private static final String MAX_BOUNCE = "maxBounce";
    private static final String CURRENT_BOUNCE = "currentBounce";
    private static int REQUEST_CODE;


    private TextView maxBounceTextView;
    private TextView currentBounceTextView;
    private Button skipToPlayerTwoButton;

    private int maxBounce = 0;
    private int currentBounce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giocatore_uno);

        maxBounceTextView = (TextView) findViewById(R.id.rimbalziMaxTextView);
        currentBounceTextView = (TextView) findViewById(R.id.rimbalziTextView1);
        skipToPlayerTwoButton = (Button) findViewById(R.id.passaGiocatoreDueButton);


        skipToPlayerTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playerTwo = new Intent(GiocatoreUno.this, GiocatoreDue.class);
                playerTwo.putExtra(MAX_BOUNCE,maxBounce);
                playerTwo.putExtra(CURRENT_BOUNCE,currentBounce);
                startActivityForResult(playerTwo, REQUEST_CODE);
            }
        });



//        maxBounceTextView = (TextView) findViewById(R.id.rimbalziMaxTextView);
//        currentBounceTextView = (TextView) findViewById(R.id.rimbalziTextView1);
//        skipToPlayerTwoButton = (Button) findViewById(R.id.passaGiocatoreDueButton);
//
//        if(getIntent().getExtras().get("savedLong") != null) {
//            maxBounce = (int) getIntent().getExtras().get("savedLong");
//            maxBounceTextView.setText("" + maxBounce);
//            currentBounceTextView.setText("" + 0);
//        } else {
//            maxBounce = (int) getIntent().getExtras().get("maxBounce");
//            maxBounceTextView.setText("" + maxBounce);
//            currentBounce = (int) getIntent().getExtras().get("currentBounce");
//            currentBounce++;
//            currentBounceTextView.setText("" + (currentBounce));
//        }
//
//        skipToPlayerTwoButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(!checkBounceLimit()) {
//                    Intent playerTwo = new Intent(GiocatoreUno.this, GiocatoreDue.class);
//                    playerTwo.putExtra("currentBounce", currentBounce);
//                    playerTwo.putExtra("maxBounce", maxBounce);
//                    startActivity(playerTwo);
//                } else {
//                    Intent finish = new Intent(GiocatoreUno.this, Home.class);
//                    startActivity(finish);
//                }
//            }
//        });
    }

//    private boolean checkBounceLimit() {
//        if(currentBounce == maxBounce)
//            return true;
//        else
//            return false;
//    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(MAX_BOUNCE,maxBounce);
        outState.putInt(CURRENT_BOUNCE,currentBounce);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_giocatore_uno, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
