package practicaltest01.eim.systems.cs.pub.ro.practicaltest01;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01MainActivity extends AppCompatActivity {

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.setButton:
                    Log.d("MATEI", et00.getText().toString());
                    if (et00.getText().toString().equals("") ||
                            et01.getText().toString().equals("") ||
                            et10.getText().toString().equals("") ||
                            et11.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Enter all numbers", Toast.LENGTH_LONG).show();
                        break;
                    }


                    Intent intent = new Intent(getApplicationContext(), PracticalTest01SecondaryActivity.class);
                    intent.putExtra("et00", Integer.valueOf(et00.getText().toString()));
                    intent.putExtra("et01", Integer.valueOf(et01.getText().toString()));
                    intent.putExtra("et10", Integer.valueOf(et10.getText().toString()));
                    intent.putExtra("et11", Integer.valueOf(et11.getText().toString()));
//                  startActivityForResult(intent, Constants.SECOND_ACTIVITY_REQUEST_CODE);
                    startActivity(intent);

                    break;
//                case R.id.button4:
//                    if (serviceIntent == null) {
//                        serviceIntent = new Intent(getApplicationContext(), PracticalTest01Service.class);
//                        serviceIntent.putExtra("leftValue",  Integer.parseInt(textView.getText().toString()));
//                        serviceIntent.putExtra("rightValue", Integer.parseInt(textView2.getText().toString()));
//                        startService(serviceIntent);
//                    }
//                    break;
                default:
                    Log.d("MATEI", "Invalid view id: " + v.getId());
            }
        }
    }

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private EditText et00 = null;
    private EditText et01 = null;
    private EditText et10 = null;
    private EditText et11 = null;
    private Button setButton = null;

    private IntentFilter intentFilter;
    private PracticalTest01BroadcastReceiver broadcastReceiver;
    private Intent serviceIntent = null;

    private void initGraphics() {
        et00 = (EditText) findViewById(R.id.et00);
        et01 = (EditText) findViewById(R.id.et01);
        et10 = (EditText) findViewById(R.id.et10);
        et11 = (EditText) findViewById(R.id.et11);
        setButton = (Button) findViewById(R.id.setButton);

        setButton.setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);

        initGraphics();

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("et00")) {
                et00.setText(savedInstanceState.getString("et00"));
            } else {
                et00.setText("0");
            }
            if (savedInstanceState.containsKey("et01")) {
                et01.setText(savedInstanceState.getString("et01"));
            } else {
                et01.setText("0");
            }
            if (savedInstanceState.containsKey("et10")) {
                et10.setText(savedInstanceState.getString("et10"));
            } else {
                et10.setText("0");
            }
            if (savedInstanceState.containsKey("et11")) {
                et11.setText(savedInstanceState.getString("et11"));
            } else {
                et11.setText("0");
            }
        }

        broadcastReceiver = new PracticalTest01BroadcastReceiver(et00, et01, et10, et11);

        intentFilter = new IntentFilter();
        intentFilter.addAction(Constants.ACTION_1);

        serviceIntent = new Intent(getApplicationContext(), PracticalTest01Service.class);
        startService(serviceIntent);

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

        registerReceiver(broadcastReceiver, intentFilter);

        Log.d("MATEI", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("MATEI", "onPause");

        unregisterReceiver(broadcastReceiver);
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("MATEI", "onStop");
    }

    @Override
    protected void onDestroy() {
        if (serviceIntent != null) {
            stopService(serviceIntent);
        }
        Log.d("MATEI", "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("MATEI", "onRestart");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("et00", et00.getText().toString());
        outState.putString("et01", et01.getText().toString());
        outState.putString("et10", et10.getText().toString());
        outState.putString("et11", et11.getText().toString());

        Log.d("MATEI", "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("et00")) {
                et00.setText(savedInstanceState.getString("et00"));
            } else {
                et00.setText("0");
            }
            if (savedInstanceState.containsKey("et01")) {
                et01.setText(savedInstanceState.getString("et01"));
            } else {
                et01.setText("0");
            }
            if (savedInstanceState.containsKey("et10")) {
                et10.setText(savedInstanceState.getString("et10"));
            } else {
                et10.setText("0");
            }
            if (savedInstanceState.containsKey("et11")) {
                et11.setText(savedInstanceState.getString("et11"));
            } else {
                et11.setText("0");
            }
        }

        Log.d("MATEI", "onRestoreInstanceState");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case Constants.SECOND_ACTIVITY_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    Bundle dataFromChild = data.getExtras();
                    Toast.makeText(this, dataFromChild.getString("toparent"), Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
