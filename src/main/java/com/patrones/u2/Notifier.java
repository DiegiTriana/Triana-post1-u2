package com.patrones.u2;

public interface Notifier {
    void send(String recipient, String message);
    String channel();
}