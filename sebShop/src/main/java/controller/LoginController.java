package controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginController {

    //name, password
    private Map<String, String> accounts;

    public LoginController (){
        //this.accounts = new HashMap<>();
        readFromFile();
    }

    public void registerAccount (String name, String password){
        accounts.put(name, password);
        saveToFile();
    }

    public boolean login(String name, String inputPassword) {
        //user must be registered
        if(accounts.keySet().contains(name)){
            String savedPassword = accounts.get(name);
            if (savedPassword.equals(inputPassword)){
                return true;
            }
        }

        return false;
    }

    private void saveToFile  (){
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
            mapper.writeValue(new File(System.getProperty("user.dir") + "/src/main/resources/" + "accounts.json"), accounts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFromFile  (){
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
        try {
            File file = new File(System.getProperty("user.dir") + "/src/main/resources/" + "accounts.json");
            System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
            this.accounts = mapper.readValue(file, Map.class);
        } catch (Exception e) {
             e.printStackTrace();
        }
    }


}
