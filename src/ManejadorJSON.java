import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ManejadorJSON {
    public InfoMoneda Respuesta (String jsonObject){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        return gson.fromJson(jsonObject, InfoMoneda.class);
    }
}
