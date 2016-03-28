package practicaltest01.eim.systems.cs.pub.ro.practicaltest01;

import android.content.Context;
import android.content.Intent;

import java.util.Date;
import java.util.Random;

/**
 * Created by matei on 27-Mar-16.
 */
public class ProcessingThread extends Thread {
    private Context context;
    private boolean keepRunning = true;
    private int leftValue;
    private int rightValue;

    public ProcessingThread(Context context, Intent intent) {
        this.context = context;
    }

    public void stopThread() {
        keepRunning = false;
    }

    @Override
    public void run() {
        while (keepRunning) {
            int min = 1;
            int max = 100;

            Random r = new Random();

            Intent i1 = new Intent();
            i1.setAction(Constants.ACTION_1);
            i1.putExtra("val00", r.nextInt(max - min + 1) + min);
            i1.putExtra("val01", r.nextInt(max - min + 1) + min);
            i1.putExtra("val10", r.nextInt(max - min + 1) + min);
            i1.putExtra("val11", r.nextInt(max - min + 1) + min);

            context.sendBroadcast(i1);

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
