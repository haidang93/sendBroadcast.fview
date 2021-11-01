package com.example.sendbroadcast;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import android.app.Application;
import android.app.Service;
import android.app.Activity;
import android.content.Intent;
import android.content.Context;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;

/** SendbroadcastPlugin */
public class SendbroadcastPlugin implements FlutterPlugin, MethodCallHandler {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private MethodChannel channel;
  private Context context;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "sendbroadcast");
    channel.setMethodCallHandler(this);
    context = flutterPluginBinding.getApplicationContext();
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    
    
    if (call.method.equals("sendBroadcast")){
      final String value = call.argument("message");
      Intent intent = new Intent("com.vietdung.testbroadcast.ACTION_LISTENER");
      intent.putExtra("message",value);
      context.sendBroadcast(intent);
      result.success(value);
    }else{
      result.notImplemented();
    }
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }
}
