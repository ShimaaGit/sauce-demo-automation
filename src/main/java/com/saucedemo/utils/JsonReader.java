package com.saucedemo.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {
     List<String> emails = new ArrayList<>();
     List<String> passwords = new ArrayList<>();

    public void dataReader(String role) throws IOException, ParseException {
        // Define the JSON file path
        String JSON_FILE_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.json";

        // Parse the JSON file
        JSONObject jsonData = (JSONObject) new JSONParser().parse(new FileReader(JSON_FILE_PATH));

        // Retrieve user data from the "Data" array
        JSONArray usersArray = (JSONArray) jsonData.get("Data");

        // Loop through the users to find the matching role
        for (Object userObj : usersArray) {
            JSONObject user = (JSONObject) userObj;
            if (role.equals(user.get("users"))) {
                emails.add((String) user.get("email"));
                passwords.add((String) user.get("password"));
                break; // Stop after finding the first matching role
            }
        }
    }

    public List<String> getEmails() {
        return emails;
    }

    public List<String> getPasswords() {
        return passwords;
    }
}
