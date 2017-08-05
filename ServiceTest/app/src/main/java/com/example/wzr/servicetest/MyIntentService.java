package com.example.wzr.servicetest;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by wzr on 2017/8/5.
 */

public class MyIntentService extends IntentService {
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyIntentService", "onDestroy executed");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("MYIntentService", "Thread id: " + Thread.currentThread().getId());
    }
}
