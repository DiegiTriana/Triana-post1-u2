package com.patrones.u2;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Demo: Singleton + Factory Method ===\n");

        NotificationLogger logger1 = NotificationLogger.INSTANCE;
        NotificationLogger logger2 = NotificationLogger.INSTANCE;
        System.out.println("Misma instancia: " + (logger1 == logger2));

        Notifier email = NotifierFactory.create("email");
        Notifier sms   = NotifierFactory.create("sms");
        Notifier push  = NotifierFactory.create("push");

        email.send("cliente@mail.com", "Su pedido #1001 fue confirmado");
        sms.send("+57-300-0000001", "Pedido #1001 confirmado");
        push.send("device-token-abc123", "Nuevo pedido listo para enviar");

        NotifierFactory.register("slack", () -> new Notifier() {
            public String channel() { return "SLACK"; }
            public void send(String r, String m) {
                NotificationLogger.INSTANCE.log(channel(), r, m);
            }
        });
        NotifierFactory.create("slack").send("#pedidos", "Pedido #1001 procesado");

        NotificationLogger.INSTANCE.printAll();
    }
}