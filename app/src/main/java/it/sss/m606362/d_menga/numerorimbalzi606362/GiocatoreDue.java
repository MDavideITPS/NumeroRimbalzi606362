package it.sss.m606362.d_menga.numerorimbalzi606362;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class GiocatoreDue extends Activity {

    private TextView maxBounceTextView;
    private TextView currentBounceTextView;
    private Button skipToPlayerOneButton;

    private int maxBounce;
    private int currentBounce;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giocatore_due);


//        maxBounceTextView = (TextView) findViewById(R.id.rimbalziMaxTextView2);
//        currentBounceTextView = (TextView) findViewById(R.id.rimbalziTextView2);
//        maxBounce =(int) getIntent().getExtras().get("maxBounce");
//        currentBounce = (int) getIntent().getExtras().get("currentBounce");
//        maxBounceTextView.setText("" + maxBounce);
//        currentBounce++;
//        currentBounceTextView.setText("" + currentBounce);
//
//        skipToPlayerOneButton = (Button) findViewById(R.id.passaGiocatoreUnoButton);
//        skipToPlayerOneButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(!checkBounceLimit()) {
//                    Intent playerOne = new Intent(GiocatoreDue.this, GiocatoreUno.class);
//                    playerOne.putExtra("currentBounce",currentBounce);
//                    playerOne.putExtra("maxBounce",maxBounce);
//                    startActivity(playerOne);
//                } else {
//                    Intent finish = new Intent(GiocatoreDue.this, Home.class);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_giocatore_due, menu);
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
