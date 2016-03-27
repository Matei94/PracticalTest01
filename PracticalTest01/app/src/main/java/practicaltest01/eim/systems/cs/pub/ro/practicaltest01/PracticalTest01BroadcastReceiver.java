package practicaltest01.eim.systems.cs.pub.ro.practicaltest01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by matei on 27-Mar-16.
 */
public class PracticalTest01BroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if  (action.equals("action_time")) {
            Log.d("MATEI", "time is :" + intent.getStringExtra("time"));
        }

        if  (action.equals("action_arithmetic")) {
            Log.d("MATEI", "arithmetic is :" + String.valueOf(intent.getIntExtra("arithmetic", -1)));
        }

        if  (action.equals("action_geometric")) {
            Log.d("MATEI", "geometric is :" + String.valueOf(intent.getIntExtra("geometric", -1)));
        }
    }
}
