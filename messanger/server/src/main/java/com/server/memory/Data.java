package com.server.memory;

import com.server.model.Accounts;
import com.server.model.Messages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Data {
    private static final List<Accounts> accounts = new ArrayList<>();
    private static final HashMap<Accounts, Messages> data = new HashMap<>();

    public static List<Accounts> getAccounts() {
        return accounts;
    }

    public static HashMap<Accounts, Messages> getData() {
        return data;
    }
}
