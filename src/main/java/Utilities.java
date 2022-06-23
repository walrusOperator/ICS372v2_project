import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utilities {

    /**
     * Method used to convert a json file into json array
     * @return (JSONArray) - animals parsed from json input file
     */
    public static JSONArray readJSON(){
        JSONParser parser = new JSONParser();

        try {
            JSONObject obj = (JSONObject) parser.parse(new FileReader("Project1_input.json"));
            return (JSONArray)obj.get("shelter_roster");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method used to create a JSON output file of the given shelterList
     * @param roster - (ShelterList) shelterList used to create the JSON output file
     */
    public static void writeJSON(ShelterList roster){
        JSONArray sheltersToWrite = new JSONArray();
        JSONObject fileData = new JSONObject();
        List<Shelter> allShelters = new ArrayList<>(roster.getShelters());

        for (Shelter currentShelter : allShelters) {
            for (int j = 0; j < currentShelter.size(); j++) {
                Animal currentAnimal = currentShelter.getAnimalList().get(j);
                JSONObject currentAnimalData = new JSONObject();
                try {
                    currentAnimalData.put("shelter_id", currentShelter.toString());
                    currentAnimalData.put("animal_type", currentAnimal.getAnimal_Type());
                    currentAnimalData.put("animal_name", currentAnimal.getAnimal_Name());
                    currentAnimalData.put("animal_id", currentAnimal.getAnimal_ID());
                    currentAnimalData.put("weight", currentAnimal.getAnimal_weight());
                    currentAnimalData.put("receipt_date", currentAnimal.getReceipt_date());
                }catch (Exception e){
                    System.out.println("File creation unsuccessful");
                }
                sheltersToWrite.add(currentAnimalData);
            }
        }
        fileData.put("shelter_roster", sheltersToWrite);

        try(FileWriter file = new FileWriter("Project1_output.json")){
            file.write(fileData.toJSONString());
            file.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }


}
