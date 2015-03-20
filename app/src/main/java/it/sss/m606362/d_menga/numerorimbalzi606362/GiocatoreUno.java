package it.sss.m606362.d_menga.numerorimbalzi606362;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GiocatoreUno extends Activity {

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

        maxBounce = getIntent().getExtras().getInt(Code.SAVED_INT);
        maxBounceTextView.setText("" + maxBounce);
        currentBounceTextView.setText("" + 0);

        if (checkBounceLimit()) {
            skipToPlayerTwoButton.setText(R.string.returnToHomeButton);
            skipToPlayerTwoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        } else {
            skipToPlayerTwoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent playerTwo = new Intent(GiocatoreUno.this, GiocatoreDue.class);
                    playerTwo.putExtra(Code.MAX_BOUNCE_STRING, maxBounce);
                    playerTwo.putExtra(Code.CURRENT_BOUNCE_STRING, currentBounce);
                    startActivityForResult(playerTwo, 0);
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

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Code.BOUNCE_DONE) {
            currentBounce = data.getExtras().getInt(Code.CURRENT_BOUNCE_STRING);
            currentBounce++;
            currentBounceTextView.setText("" + currentBounce);
            if (checkBounceLimit()) {
                Toast.makeText(this, R.string.gameOverMessageToast, Toast.LENGTH_SHORT).show();
                skipToPlayerTwoButton.setText(R.string.returnToHomeButton);
                skipToPlayerTwoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent finish = new Intent(GiocatoreUno.this, Home.class);
                        finish.putExtra(Code.CURRENT_BOUNCE_STRING, currentBounce);
                        startActivity(finish);
                    }
                });
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(Code.MAX_BOUNCE_STRING, maxBounce);
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