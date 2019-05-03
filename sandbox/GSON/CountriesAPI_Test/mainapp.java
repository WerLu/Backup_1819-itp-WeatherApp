import com.sun.deploy.net.HttpResponse;

public class mainapp {
    public static void main(String[] args) {
        String json = "[{\"id\": 8484,\"name\": \"David\",\"height\": 173.2,\"weight\": 75.42},{ \"id\": 8485,\"name\": \"Ronald\",\"height\": 183.73,\"weight\": 83.1}]";

        Gson gson = new Gson();
        Person[] persons = gson.fromJson(json, Person[].class);

        System.out.println(persons[0].name);
    }
}
