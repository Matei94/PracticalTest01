package practicaltest01.eim.systems.cs.pub.ro.practicaltest01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by matei on 27-Mar-16.
 */
public class PracticalTest01BroadcastReceiver extends BroadcastReceiver {
    EditText et00, et01, et10, et11;

    PracticalTest01BroadcastReceiver(EditText et00, EditText et01, EditText et10, EditText et11) {
        this.et00 = et00;
        this.et01 = et01;
        this.et10 = et10;
        this.et11 = et11;

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if  (action.equals(Constants.ACTION_1)) {
            et00.setText(String.valueOf(intent.getIntExtra("val00", 42)));
            et01.setText(String.valueOf(intent.getIntExtra("val01", 42)));
            et10.setText(String.valueOf(intent.getIntExtra("val10", 42)));
            et11.setText(String.valueOf(intent.getIntExtra("val11", 42)));
        }

    }
}
