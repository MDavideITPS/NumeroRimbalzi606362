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

    private static final String CURRENT_BOUNCE = "currentBounce";

    private TextView maxBounceTextView;
    private TextView currentBounceTextView;
    private Button skipToPlayerOneButton;

    private int maxBounce;
    private int currentBounce;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giocatore_due);


        maxBounceTextView = (TextView) findViewById(R.id.rimbalziMaxTextView2);
        currentBounceTextView = (TextView) findViewById(R.id.rimbalziTextView2);
        skipToPlayerOneButton = (Button) findViewById(R.id.passaGiocatoreUnoButton);

        maxBounce = getIntent().getExtras().getInt("maxBounce");
        currentBounce = getIntent().getExtras().getInt("currentBounce");
        maxBounceTextView.setText("" + maxBounce);
        currentBounce++;
        currentBounceTextView.setText("" + currentBounce);

        if (!checkBounceLimit()) {
            skipToPlayerOneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        } else {
            skipToPlayerOneButton.setText(R.string.returnToHomeButton);
            skipToPlayerOneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent finish = new Intent(GiocatoreDue.this, Home.class);
                    finish.putExtra(CURRENT_BOUNCE, currentBounce);
                    startActivity(finish);
                }
            });
        }
    }

    private boolean checkBounceLimit() {
        if (maxBounce == currentBounce) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void finish() {
        Intent playerOne = new Intent();
        playerOne.putExtra(CURRENT_BOUNCE, currentBounce);
        playerOne.putExtra("maxBounce", maxBounce);
        setResult(RESULT_OK, playerOne);
        super.finish();
    }

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
