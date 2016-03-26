package practicaltest01.eim.systems.cs.pub.ro.practicaltest01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class PracticalTest01SecondaryActivity extends AppCompatActivity {

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.backButton:
                    Intent intentFromParent = getIntent();
                    Bundle dataFromParent = intentFromParent.getExtras();

                    Intent intentToParent = new Intent();
                    intentToParent.putExtra("toparent", dataFromParent.getString("tochild") + " indeed");
                    setResult(RESULT_OK, intentToParent);
                    finish();
                    break;
                default:
                    Log.d("MATEI", "Invalid view id: " + v.getId());
            }
        }
    }

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_secondary);

        ((Button) findViewById(R.id.backButton)).setOnClickListener(buttonClickListener);
    }
}
