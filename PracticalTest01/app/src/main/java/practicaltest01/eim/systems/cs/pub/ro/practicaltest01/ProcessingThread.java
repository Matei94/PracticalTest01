package practicaltest01.eim.systems.cs.pub.ro.practicaltest01;

import android.content.Context;
import android.content.Intent;

import java.util.Date;

/**
 * Created by matei on 27-Mar-16.
 */
public class ProcessingThread extends Thread {
    private Context context;
    private Intent intent;
    private boolean keepRunning = true;

    public ProcessingThread(Context context, Intent intent) {
        this.context = context;
        this.intent = intent;
    }

    public void stopThread() {
        keepRunning = false;
    }

    @Override
    public void run() {
        while (keepRunning) {
            int leftValue  = intent.getIntExtra("leftValue", 0);
            int rightValue = intent.getIntExtra("rightValue", 0);

            Intent i1 = new Intent();
            i1.setAction("action_time");
            i1.putExtra("time", new Date().toString());

            Intent i2 = new Intent();
            i2.setAction("action_arithmetic");
            i2.putExtra("arithmetic", leftValue + rightValue);

            Intent i3 = new Intent();
            i3.setAction("action_geometric");
            i3.putExtra("geometric", leftValue - rightValue);

            context.sendBroadcast(i1);
            context.sendBroadcast(i2);
            context.sendBroadcast(i3);

            sleep();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(Constants.SLEEP_TIME);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
