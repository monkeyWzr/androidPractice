package com.example.wzr.servicebestpractice;

/**
 * Created by wzr on 2017/8/5.
 */

public interface DownloadListener {

    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPaused();

    void onCanceled();
}
