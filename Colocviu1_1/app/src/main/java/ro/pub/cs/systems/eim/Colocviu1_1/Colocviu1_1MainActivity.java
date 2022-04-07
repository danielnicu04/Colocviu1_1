package ro.pub.cs.systems.eim.Colocviu1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Colocviu1_1MainActivity extends AppCompatActivity {

    private EditText navigatorEditText;
    private Button northButton;
    private Button southButton;
    private Button westButton;
    private Button eastButton;

    private EditText nrPressesEditText;
    private Button navigateToSecondaryActivityButton;
    //private int nrButtonClicks;


    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String navigatorText = navigatorEditText.getText().toString();
            int nr = Integer.parseInt(nrPressesEditText.getText().toString());
            switch(view.getId()) {
                    case R.id.west_button:
                        navigatorText += " West";
                        navigatorEditText.setText(navigatorText);
                        nr++;
                        nrPressesEditText.setText(String.valueOf(nr));
                        //nrButtonClicks++;
                        break;
                    case R.id.north_button:
                        navigatorText += " North";
                        navigatorEditText.setText(navigatorText);
                        nr++;
                        nrPressesEditText.setText(String.valueOf(nr));
                        //nrButtonClicks++;
                    break;
                    case R.id.south_button:
                        navigatorText += " South";
                        navigatorEditText.setText(navigatorText);
                        nr++;
                        nrPressesEditText.setText(String.valueOf(nr));
                        //nrButtonClicks++;
                    break;
                    case R.id.east_button:
                        navigatorText += " East";
                        navigatorEditText.setText(navigatorText);
                        nr++;
                        nrPressesEditText.setText(String.valueOf(nr));
                        //nrButtonClicks++;
                    break;
                case R.id.navigate_second:
                    Intent intent = new Intent(getApplicationContext(), Colocviu1_1SecondaryActivity.class);
                    String current = navigatorEditText.getText().toString();
                    intent.putExtra("CURRENT_INSTRUCTIONS", current);
                    startActivityForResult(intent, 2022);
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_1_main);

        navigatorEditText = (EditText)findViewById(R.id.navigator_edittext);

        northButton = (Button)findViewById(R.id.north_button);
        southButton = (Button)findViewById(R.id.south_button);
        westButton = (Button)findViewById(R.id.west_button);
        eastButton = (Button)findViewById(R.id.east_button);
        nrPressesEditText = (EditText)findViewById(R.id.nr_presses);

        northButton.setOnClickListener(buttonClickListener);
        southButton.setOnClickListener(buttonClickListener);
        westButton.setOnClickListener(buttonClickListener);
        eastButton.setOnClickListener(buttonClickListener);

        navigateToSecondaryActivityButton = (Button)findViewById(R.id.navigate_second);
        navigateToSecondaryActivityButton.setOnClickListener(buttonClickListener);

        if(savedInstanceState != null) {
            if (savedInstanceState.containsKey("NR_PRESSES")) {
                Log.d("TAG", "Value saved is: " + savedInstanceState.getInt("NR_PRESSES"));
                nrPressesEditText.setText(savedInstanceState.getInt("NR_PRESSES"));
            }
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 2022) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("NR_PRESSES", nrPressesEditText.getText().toString());
    }
}