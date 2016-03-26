package practicaltest01.eim.systems.cs.pub.ro.practicaltest01;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class PracticalTest01MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);

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

        Log.d("MATEI", "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.d("MATEI", "onRestoreInstanceState");
    }
}
