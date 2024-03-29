
package pkg327;

/**
 * The Dispatcher implements DispatcherInterface.
 *
 * @author Oscar Morales-Ponce
 * @version 0.15
 * @since 02-11-2019
 */
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dispatcher implements DispatcherInterface {

    HashMap<String, Object> ListOfObjects;
    LoginServices loginServices = new LoginServices();
    PlaylistServices playlistServices = new PlaylistServices();
    //PlaylistServices playlistServices = new PlaylistServices();

    public Dispatcher() {
        ListOfObjects = new HashMap<String, Object>();
    }

    /* 
    * dispatch: Executes the remote method in the corresponding Object
    * @param request: Request: it is a Json file
    {
        "remoteMethod":"getSongChunk",
        "objectName":"SongServices",
        "param":
          {
              "song":490183,
              "fragment":2
          }
    }
     */
    public String dispatch(String request) {
        JsonObject jsonReturn = new JsonObject();
        JsonParser parser = new JsonParser();
        JsonObject jsonRequest = parser.parse(request).getAsJsonObject();
        
        
        String classType = jsonRequest.get("objectName").getAsString();
        
        if(classType.equals("LoginServices"))
            this.registerObject(loginServices, "LoginServices");
        
        if(classType.equals("PlaylistServices"))
            this.registerObject(playlistServices, "PlaylistServices");
        
        //else if(classType.equals("PlaylistServices"))
            //this.registerObject(playlistServices, "PlaylistServices");

        try {
            // Obtains the object pointing to SongServices
            Object object = ListOfObjects.get(jsonRequest.get("objectName").getAsString());
            System.out.println(object.getClass());
            Method[] methods = object.getClass().getMethods();
            Method method = null;

            String regex = "\\Q" + jsonRequest.get("remoteMethod").getAsString() + "\\E";

            final Pattern pattern = Pattern.compile(regex);

            for (int i = 0; i < methods.length; i++) {

                final Matcher matcher = pattern.matcher(methods[i].getName());
                
                if (matcher.find()) {
                    method = methods[i];
                }
            }
            
            if (method == null) {
                jsonReturn.addProperty("error", "Method does not exist");
                return jsonReturn.toString();
            }
            // Prepare the  parameters 
            Class[] types = method.getParameterTypes();
              
            
            Object[] parameter = new Object[types.length];
            String[] strParam = new String[types.length];
            JsonObject jsonParam = jsonRequest.get("param").getAsJsonObject();
            
            int j = 0;
            for (Map.Entry<String, JsonElement> entry : jsonParam.entrySet()) {
                strParam[j++] = entry.getValue().getAsString();
            }
            
            for (int i = 0; i < types.length; i++) {

                switch (types[i].getCanonicalName()) {
                    case "java.lang.Long":
                        parameter[i] = Long.parseLong(strParam[i]);
                        break;
                    case "int":
                        parameter[i] = Integer.parseInt(strParam[i]);
                        break;
                    case "java.lang.String":
                        parameter[i] = new String(strParam[i]);
                        break;
                }
            }
            
            Class returnType = method.getReturnType();
            System.out.println("\n\nReturn type: " + returnType + "\n\n");

            String ret = "";

            switch (returnType.getCanonicalName()) {
                
                case "java.lang.Long":
                    ret = method.invoke(object, parameter).toString();
                    break;
                case "int":
                    ret = method.invoke(object, parameter).toString();
                    break;
                case "java.lang.String":
                    ret = (String) method.invoke(object, parameter);
                    break;
                case "boolean":
                    
                    ret = method.invoke(object, parameter).toString();
                    System.out.println("Being returned: !!! " + ret);

                    break;  
                    
                case "void":
                    
                    method.invoke(object, parameter);
                    
                    ret = "void";
                    System.out.println("Being returned: !!! " + ret);

                    break; 
            }
            jsonReturn.addProperty("ret", ret);

        } catch (InvocationTargetException | IllegalAccessException e) {
            //    System.out.println(e);
            jsonReturn.addProperty("error", "Error on " + jsonRequest.get("objectName").getAsString() + "." + jsonRequest.get("remoteMethod").getAsString());
        }

        return jsonReturn.toString();
    }

    /* 
    * registerObject: It register the objects that handle the request
    * @param remoteMethod: It is the name of the method that 
    *  objectName implements. 
    * @objectName: It is the main class that contaions the remote methods
    * each object can contain several remote methods
     */
    public void registerObject(Object remoteMethod, String objectName) {
        ListOfObjects.put(objectName, remoteMethod);
    }

    //  Testing
    public static void main(String[] args) {

        // Instance of the Dispatcher
        Dispatcher dispatcher = new Dispatcher();

        LoginServices loginHandler = new LoginServices();

        Method[] methods = loginHandler.getClass().getMethods();

        for (int i = 0; i < methods.length; i++) {
            //System.out.println(methods[i]);
        }

        Proxy p0 = new Proxy(dispatcher);

        String[] params = new String[]{"TaylorM", "asdf"};
        JsonObject jsonObject = p0.synchExecution("validateAccount", params);


        //SongDispatcher songDispatcher = new SongDispatcher();

        

        // Testing  the dispatcher function
        // First we read the request. In the final implementation the jsonRequest
        // is obtained from the communication module
        try {
            // String jsonRequest = new String(Files.readAllBytes(Paths.get("C:\\Users\\corni\\Desktop\\git-repos\\327-Media-Player\\a-Proxy\\IsolatedClass\\getSongChunk.json")));
            String jsonRequest = jsonObject.toString();

            //System.out.println(jsonRequest);

            //System.out.println("jsonRequest in String format: " + jsonRequest);
            String ret = dispatcher.dispatch(jsonRequest);
            //System.out.println(ret);

            //System.out.println(jsonRequest);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
