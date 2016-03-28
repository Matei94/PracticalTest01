package practicaltest01.eim.systems.cs.pub.ro.practicaltest01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01SecondaryActivity extends AppCompatActivity {

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.sumButton:
                    Toast.makeText(getApplicationContext(), "Sum = " + String.valueOf(v00 + v01 + v10 + v11), Toast.LENGTH_LONG).show();

//                    Intent intentToParent = new Intent();
//                    intentToParent.putExtra("toparent", dataFromParent.getString("tochild") + " indeed");
//                    setResult(RESULT_OK, intentToParent);
//                    finish();
                    break;
                case R.id.prodButton:
                    Toast.makeText(getApplicationContext(), "Sum = " + String.valueOf(v00 * v01 * v10 * v11), Toast.LENGTH_LONG).show();

                    break;
                default:
                    Log.d("MATEI", "Invalid view id: " + v.getId());
            }
        }
    }

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private TextView tv00 = null;
    private TextView tv01 = null;
    private TextView tv10 = null;
    private TextView tv11 = null;
    private Button sumButton = null;
    private Button prodButton = null;
    private int v00, v01, v10, v11;

    private void initGraphics() {
        tv00 = (TextView) findViewById(R.id.tw00);
        tv01 = (TextView) findViewById(R.id.tw01);
        tv10 = (TextView) findViewById(R.id.tw10);
        tv11 = (TextView) findViewById(R.id.tw11);
        sumButton = (Button) findViewById(R.id.sumButton);
        prodButton = (Button) findViewById(R.id.prodButton);

        sumButton.setOnClickListener(buttonClickListener);
        prodButton.setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_secondary);

        initGraphics();

        Intent intentFromParent = getIntent();
        Bundle dataFromParent = intentFromParent.getExtras();

        v00 = dataFromParent.getInt("et00");
        v01 = dataFromParent.getInt("et01");
        v10 = dataFromParent.getInt("et10");
        v11 = dataFromParent.getInt("et11");

        tv00.setText(String.valueOf(v00));
        tv01.setText(String.valueOf(v01));
        tv10.setText(String.valueOf(v10));
        tv11.setText(String.valueOf(v11));
    }
}
