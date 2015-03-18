package it.sss.m606362.d_menga.numerorimbalzi606362;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Home extends Activity {

    private static final String MAX_BOUNCE = "maxBounce";
    private static final String SAVED_INT = "savedInt";

    private Button startButton;
    private EditText maxBounceTextEdit;
    private TextView bounceTextEdit;
    private int maxBounce;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        maxBounceTextEdit = (EditText) findViewById(R.id.maxPassaggiTextEdit);
        startButton = (Button) findViewById(R.id.startButton);
        bounceTextEdit = (TextView) findViewById(R.id.risultatoTextView);

        if (getIntent().hasExtra("currentBounce")) {
            bounceTextEdit.setText("" + getIntent().getExtras().getInt("currentBounce"));
        }

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start = new Intent(Home.this, GiocatoreUno.class);
                if (maxBounceTextEdit.getText().toString().isEmpty()) {
                    Toast.makeText(Home.this, R.string.maxBounceTextEditEmpty, Toast.LENGTH_SHORT).show();
                } else {
                    maxBounce = Integer.parseInt(maxBounceTextEdit.getText().toString());
                    if (maxBounce <= 0) {
                        Toast.makeText(Home.this, R.string.maxBounceError, Toast.LENGTH_SHORT).show();
                    } else {
                        start.putExtra(SAVED_INT, maxBounce);
                        startActivity(start);
                    }
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(MAX_BOUNCE, maxBounce);
        super.onSaveInstanceState(outState);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
