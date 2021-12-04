package com.company;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;


// This commit is modified. So notice it fast. :) HELLO (:
// Daca un sofer e in graba si tu il observi ce ai face?
// WOOP WOOP Thats the sound of the POLICE 0.0 

// Comment comment comment comment comment

// This is another comment 

public class Main {

    public static void addJSONObjectToFile(){
        JSONObject myJSONObject = new JSONObject();
        myJSONObject.put("Command","CreateNewUser");
        JSONObject userInput = new JSONObject();
        userInput.put("id",0);
        userInput.put("firstName","John");
        userInput.put("lastName","Reese");
        userInput.put("age",24);
        userInput.put("grades",new JSONArray());
        userInput.put("attendance",new JSONObject().put("date","11-30-2021").put("isPresent",true));
        myJSONObject.put("User",userInput);

        System.out.println(myJSONObject);
    }

    public static void readJsonFile(){
        String schoolData = "src/com/company/SchoolData.json";

        try {
            String contents = new String(Files.readAllBytes(Paths.get(schoolData)));
            JSONObject jsonObject = new JSONObject(contents);
            Set<String> keys = jsonObject.keySet();
            for (String i : keys) {
                System.out.println("Key: " + i + ", Value: " + jsonObject.get(i));
            }

            JSONArray students = jsonObject.getJSONArray("Student");
            for (int i = 0; i < students.length(); i++) {
                System.out.println("Student #" + (i + 1));
                System.out.println("id = " + students.getJSONObject(i).getInt("id") +
                        "\n" + "first name = " + students.getJSONObject(i).getString("firstName") +
                        "\n" + "last name = " + students.getJSONObject(i).getString("lastName") +
                        "\n" + "age = " + students.getJSONObject(i).getInt("age") +
                        "\n" + "grades = " + students.getJSONObject(i).getJSONArray("grades") +
                        "\n" + "attendance date= " + students.getJSONObject(i).getJSONObject("attendance").getString("date") +
                        "\n" + "did they attend? = " + students.getJSONObject(i).getJSONObject("attendance").getBoolean("isPresent")
                );
            }

            JSONArray professors = jsonObject.getJSONArray("Professor");
            for (int i = 0; i < professors.length(); i++) {
                System.out.println("Professor #" + (i + 1));
                System.out.println("id = " + professors.getJSONObject(i).getInt("id") +
                        "\n" + "first name = " + professors.getJSONObject(i).getString("firstName") +
                        "\n" + "last name = " + professors.getJSONObject(i).getString("lastName") +
                        "\n" + "age = " + professors.getJSONObject(i).getInt("age")
                );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readJsonFile();
        //TODO
        addJSONObjectToFile(); // This method creates a new JSONObject
    }
}

/*
                    Access Levels:

|==================================================|
|  Modifier  | Class | Package | Subclass  | World |
|==================================================|
| public     |   Y   |    Y    |     Y     |   Y   |
| protected  |   Y   |    Y    |     Y     |   N   |
| standard   |   Y   |    Y    |     N     |   N   |
| private    |   Y   |    N    |     N     |   N   |
|==================================================|

                    Design document:
====================================================================================
Main program:
1. The user can sign in as a student or professor
2. If the user is not in the database (the SchoolData.json file), they will be added as a Student or Professor
3. Once the user is signed in, they can perform their specific tasks
====================================================================================
Humans:
1. Have first names, last names, and ages

Students:
1. Inherit everything from Humans
2. Can only see their own grades
3. Can see their attendance dates
4. Can see the first names and last names of all students
5. Can see their average grade

Professors:
1. Inherit everything from Humans
2. Can see all students
3. Can add grades to any student
4. Can add attendance to any student
5. Can see the first names and last names of all students and professors
6. Can see the average grade of any student
====================================================================================

                    To Do:
1. Setting the values from the json file into constructor


                    In Progress:
1. Adding JSONObject to File

                    Done (Saved in a different project):
1. Add grades method
2. Grades average method
3. Print Student data
4. Print Professor data
5. Add attendance method
6. Print Student attendance
 */