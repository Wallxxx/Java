package com.client.items;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ListItem {

    public String sender;
    public String message;

    @Override
    public String toString() {
        return "Sender: " + sender + "\nMessage: " + message;
    }

}
