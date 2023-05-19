package org.example.interfaces;

import org.example.models.Character;
import org.example.models.User;

public interface GameInterface {
     void continueGame(User user);
     void startGame(User user);

     void joinServer(String ip ,int port);

     void generateNewCity();


}
