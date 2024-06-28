package com.wposs.diplofirebase0.MessageActivity.Interfaces;

import java.util.List;

public interface MessageView {
    void clearMessageInput();
    void loadMessages();
    public void displayMessages(List<String> messages);
    void showMessageError();
}
