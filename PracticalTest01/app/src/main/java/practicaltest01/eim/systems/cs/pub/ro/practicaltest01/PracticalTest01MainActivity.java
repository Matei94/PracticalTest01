package practicaltest01.eim.systems.cs.pub.ro.practicaltest01;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01MainActivity extends AppCompatActivity {

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01SecondaryActivity.class);
                    intent.putExtra("tochild", "magic");
                    startActivityForResult(intent, Constants.SECOND_ACTIVITY_REQUEST_CODE);
                    break;
                case R.id.button2:
                    int leftValue = Integer.parseInt(textView.getText().toString());
                    textView.setText(String.valueOf(leftValue + 1));
                    break;
                case R.id.button3:
                    int rightValue = Integer.parseInt(textView2.getText().toString());
                    textView2.setText(String.valueOf(rightValue + 1));
                    break;
                default:
                    Log.d("MATEI", "Invalid view id: " + v.getId());
            }
        }
    }

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private Button button = null;
    private Button button2 = null;
    private Button button3 = null;
    private TextView textView = null;
    private TextView textView2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);

        button  = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);

        button.setOnClickListener(buttonClickListener);
        button2.setOnClickListener(buttonClickListener);
        button3.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("leftCount")) {
                textView.setText(savedInstanceState.getString("leftCount"));
            } else {
                textView.setText("0");
            }

            if (savedInstanceState.containsKey("rightCount")) {
                textView2.setText(savedInstanceState.getString("rightCount"));
            } else {
                textView2.setText("0");
            }
        }

        Log.d("MATEI", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("MATEI", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("MATEI", "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("MATEI", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("MATEI", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("MATEI", "onRestart");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("leftCount", textView.getText().toString());
        outState.putString("rightCount", textView2.getText().toString());

        Log.d("MATEI", "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("leftCount")) {
                textView.setText(savedInstanceState.getString("leftCount"));
            } else {
                textView.setText("0");
            }

            if (savedInstanceState.containsKey("rightCount")) {
                textView2.setText(savedInstanceState.getString("rightCount"));
            } else {
                textView2.setText("0");
            }
        }

        Log.d("MATEI", "onRestoreInstanceState");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("MATEI", "onActivityResult");

        switch (requestCode) {
            case Constants.SECOND_ACTIVITY_REQUEST_CODE:
                Log.d("MATEI", "onActivityResult 1");
                if (resultCode == RESULT_OK) {
                    Log.d("MATEI", "onActivityResult 2");
                    Bundle dataFromChild = data.getExtras();
                    Toast.makeText(this, dataFromChild.getString("toparent"), Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
