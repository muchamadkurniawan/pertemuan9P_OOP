package ModelJSON;

import NodeData.NodeBuku;
import NodeJSON.NodeJSONBuku;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ModelJSONBuku {
    public String fname;
    NodeJSONBuku nodeJSONBuku = new NodeJSONBuku();

    public ModelJSONBuku(){
        this.fname = "src/Database/buku.json";
    }

    public boolean cekFile(){
        boolean cek = false;
        File file = new File(this.fname);
        if(file.exists()){
            cek = true;
        }
        return cek;
    }

    public JSONArray convertArrayListtoJSONArray(ArrayList<NodeBuku> listbook){
        if (listbook == null){
            return null;
        }else{
            JSONArray jsonArray = new JSONArray();
            for (int i = 0; i < listbook.size(); i++) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put(nodeJSONBuku.kodeBuku,listbook.get(i).kodeBuku);
                jsonObject.put(nodeJSONBuku.judulBuku,listbook.get(i).judulBuku);
                jsonObject.put(nodeJSONBuku.pengarang,listbook.get(i).pengarang);
                jsonObject.put(nodeJSONBuku.tahunTerbit,listbook.get(i).tahunTerbit);
                jsonObject.put(nodeJSONBuku.stok,listbook.get(i).stok);
                jsonArray.add(jsonObject);
            }
            return jsonArray;
        }
    }

    public void writeJSON(ArrayList<NodeBuku> listbook){
        if (listbook == null) {
            System.out.println("Data buku kosong");
        }else{
            JSONArray jsonArray = convertArrayListtoJSONArray(listbook);
            try {
                FileWriter file = new FileWriter(this.fname);
                file.write(jsonArray.toJSONString());
                file.flush();
                file.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<NodeBuku> convertJSONArraytoArrayList(){
        ArrayList<NodeBuku> listbook = new ArrayList<>();
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            int kodeBuku = Integer.parseInt(jsonObject.get(nodeJSONBuku.kodeBuku).toString());
            String judulBuku = jsonObject.get(nodeJSONBuku.judulBuku).toString();
            String pengarang = jsonObject.get(nodeJSONBuku.pengarang).toString();
            int tahunTerbit = Integer.parseInt(jsonObject.get(nodeJSONBuku.tahunTerbit).toString());
            int stok = Integer.parseInt(jsonObject.get(nodeJSONBuku.stok).toString());
            listbook.add(new NodeBuku(kodeBuku,judulBuku,pengarang,tahunTerbit,stok));
        }
        return listbook;
    }
}
