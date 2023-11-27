import ModelJSON.ModelJSONBuku;
import NodeData.NodeBuku;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // create object jsonOBject
        JSONObject jsonObject = new JSONObject();
        JSONObject database = new JSONObject();
        jsonObject.put("nama","Rizky");
        jsonObject.put("umur",20);
        jsonObject.put("alamat","Jl. Raya");

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("name","name1");
        jsonObject2.put("age","age1");

        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("name","name2");
        jsonObject3.put("age","age2");

        database.put("data1",jsonObject);
        database.put("data2",jsonObject2);
        database.put("data3",jsonObject3);

        System.out.println(database);
    }
}