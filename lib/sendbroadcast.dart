import 'dart:async';

import 'package:flutter/services.dart';

class SendBroadcast {
  static const MethodChannel _channel = MethodChannel('sendbroadcast');

  static Future<String?> get platformVersion async {
    final String? version = await _channel.invokeMethod(
      'getPlatformVersion',
    );
    return version;
  }

  static Future<String> send({
    required String value,
    required String action,
    required String param,
  }) async {
    final res = await _channel.invokeMethod('sendBroadcast', {
      "message": value,
      "action": action,
      "param": param,
    });
    return res;
  }
}
