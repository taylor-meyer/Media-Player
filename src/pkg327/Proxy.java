
package pkg327;

/**
 * The Proxy implements ProxyInterface class. The class is incomplete
 *
 * @author Oscar Morales-Ponce
 * @version 0.15
 * @since 2019-01-24
 */
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import static java.lang.Integer.parseInt;

public class Proxy implements ProxyInterface {

    Dispatcher dispacher;   // This is only for test. it should use the Communication  Module

    public Proxy(Dispatcher dispacher) {
        this.dispacher = dispacher;
    }

    /*
    * Executes the  remote method "remoteMethod". The method blocks until
    * it receives the reply of the message. 
     */
    public JsonObject synchExecution(String remoteMethod, String[] param) {

        JsonObject jsonRequest = new JsonObject();
        JsonObject jsonParam = new JsonObject();

        jsonRequest.addProperty("remoteMethod", remoteMethod);

        // It is hardcoded. Instead it should be dynamic using  RemoteRef
        RemoteMethod remoteMethodClass = new RemoteMethod();

        String[] remoteArray = remoteMethodClass.getRemoteReference(remoteMethod);

        jsonRequest.addProperty("objectName", remoteArray[1]); // Check if this is right...

        String[] temp = remoteArray[2].split(" "); // Splits params into individual objects

        for (int i = 0; i < temp.length; i++) {

            String[] parameters = temp[i].split(" ");

            for (String s : parameters) {

                String[] paramSplit = temp[i].split(":");

                if (paramSplit[1].equals("Integer")) {
                    jsonParam.addProperty(paramSplit[0], parseInt(param[i]));
                } else if (paramSplit[1].equals("String")) {
                    jsonParam.addProperty(paramSplit[0], param[i]);
                }
            }
        }
        jsonRequest.add("param", jsonParam);
        jsonRequest.addProperty("callSemantic", remoteArray[3]); // We know that remoteArray[3] and [4] contain the next properties

        jsonRequest.addProperty("returnType", remoteArray[4]);
        JsonParser parser = new JsonParser();

        System.out.println("JsonRequest sent to dispatcher: " + jsonRequest.toString() + "\n\n");

        String s = dispacher.dispatch(jsonRequest.toString());
        JsonObject jsonResponse = parser.parse(s).getAsJsonObject();
        System.out.println("jsonResponse: " + jsonResponse);
        return jsonResponse;
    }

    /*
    * Executes the  remote method remoteMethod and returns without waiting
    * for the reply. It does similar to synchExecution but does not 
    * return any value
    * 
     */
    public void asynchExecution(String remoteMethod, String[] param) {
        return;
    }

    private static void deSerializeNestedParam(String jsonString) {

//        String executeJson ="{'remoteMethod' : 'getSongChunk','object':'SongServices','param':{'song':'songId','fragment':2}}";
//        Execute execute = new Gson().fromJson(executeJson, Execute.class);
//        System.out.println(execute);
    }

    public static void main(String[] args) {

        // serializeNestedParam();
        //deSerializeNestedParam();   
        Dispatcher dispatcher = new Dispatcher();
        Proxy proxy = new Proxy(dispatcher);
        //String[] params = new String[]{"999", "myPlaylist", "101F3"};
        String[] params = new String[]{"TaylorM", "asdf"};
        JsonObject jsonObject = proxy.synchExecution("validateAccount", params);
        System.out.println(jsonObject);
    }

}
