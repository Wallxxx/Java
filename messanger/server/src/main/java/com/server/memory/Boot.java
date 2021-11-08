package com.server.memory;

import com.server.model.Accounts;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;

@Component
public class Boot {

    public Boot() {

    }

    public void saveAccounts(String login, String password) {
        try (FileWriter writer = new FileWriter("accounts.txt", true)) {
            writer.write(login + "/" + password + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void loadAccounts() {
        try {
            File file = new File("accounts.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String[] line = reader.readLine().split("/");
            while (line[0] != null) {
                Accounts account = new Accounts(line[0], line[1]);
                Data.getAccounts().add(account);
                Data.getData().put(account, new ArrayList<>());
                line = reader.readLine().split("/");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("[Error] Boot -> loadAccounts: NullPointerException");
        }
    }


}
