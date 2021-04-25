package Exceptions;

import java.util.ArrayList;

public class MessengerDemoApp {
    public static void main(String[] args)  {
        MessengerService ms = new MessengerService();
        User niki = new User("niki", User.STATUS_ONLINE, true);
        User hannes = new User("hannes", User.STATUS_ONLINE, false);
        User berta=new User("berta", User.STATUS_OFFLINE, true);
        User helga=new User("helga", User.STATUS_ONLINE, false);
        User exceptiontest = new User("et", User.STATUS_ONLINE, false);

        //Registration
        try {
            ms.registerUser(niki);
            ms.registerUser(hannes);
            ms.registerUser(berta);
            ms.registerUser(berta);
            ms.registerUser(helga);
        } catch (UserAlreadyExistsException e) {
            e.printStackTrace();
        }
       //Create and send messages
        try {
            DirectMessage dm = new DirectMessage("Test", niki, hannes);
            DirectMessage dm2 = new DirectMessage("exception user offline test", niki, berta);
            DirectMessage dm3 = new DirectMessage("dfjslfd", niki, exceptiontest);
            BroadcastMessage bm = new BroadcastMessage("Text to all users", helga);
            BroadcastMessage bm2 = new BroadcastMessage("hello world", niki);
//            ms.sendDirectMessage(dm);
//            ms.sendDirectMessage(dm2);
//            ms.sendDirectMessage(dm3);
//            ms.sendBroadcastMessage(bm);
            ArrayList<Message> messagesTosend = new ArrayList<>();
            messagesTosend.add(dm);
            messagesTosend.add(dm2);
            messagesTosend.add(dm3);
            messagesTosend.add(bm);
            messagesTosend.add(bm2);

            for (Message message : messagesTosend) {
                try {
                    if (message instanceof DirectMessage) {
                        ms.sendDirectMessage((DirectMessage) message);
                    }
                    if (message instanceof BroadcastMessage) {
                        ms.sendBroadcastMessage((BroadcastMessage) message);
                    }
                } catch (MessengerException e) {
                    System.out.println("error when sending"+e.getMessage());
                }

            }

        } catch (MessageToSelfException e) {
            e.printStackTrace();
        }


    }
}
