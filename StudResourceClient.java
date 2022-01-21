//Jersey JAX-RS Client for Rest API

package com.java.jersey.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.java.jersey.model.User;

public class StudResourceClient {

    public static void main(String[] args) {
        //getUsers();
        getUser();
       // createUser();
       // updateUser();
       //deleteUser();
    }

    private static void getStudents() {
        Client client = ClientBuilder.newClient();

        String entity = client.target("http://localhost:8080/jersey-crud-example/api").path("studs")
        .request(MediaType.APPLICATION_JSON).header("some-header", "true").get(String.class);

        System.out.println(entity);
    }

    private static void getStudent() {
        Client client = ClientBuilder.newClient();

        String entity = client.target("http://localhost:8080/jersey-crud-example/api").path("studs").path("user/100")
       .request(MediaType.APPLICATION_JSON).header("some-header", "true").get(String.class);

        System.out.println(entity);
    }
 
    private static void createStudent() {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/jersey-crud-example/api").path("student");

        Student stud = new Student();
        stud.setNo(104);
        stud.setName("Preeti");
	stud.setDob("1998-04-29");
	stud.setDoj("2021-12-18");

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));

        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
    }

    private static void updateStudent() {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/jersey-crud-example/api").path("stud")
        .path("stud/1");

        Student stud = new Student();
        stud.setNo(1);
        stud.setName("ABC");
	stud.setDob("1998-04-29");
	stud.setDoj("2021-12-18");

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.put(Entity.entity(user, MediaType.APPLICATION_JSON));

        String userJson = response.readEntity(String.class);

        System.out.println(response.getStatus());
        System.out.println(userJson);
    }

    private static void deleteStudent() {

         Client client = ClientBuilder.newClient();
         WebTarget webTarget = client.target("http://localhost:8080/jersey-crud-example/api").path("studs")
        .path("stud/100");

         Student stud = new Student();
         stud.setNo(1);
         stud.setName("ABC");
	 stud.setDob("1998-04-29");
	 stud.setDoj("2021-12-18");

         Invocation.Builder invocationBuilder = webTarget.request();
         Response response = invocationBuilder.delete();

         System.out.println(response.getStatus());
         System.out.println(response.readEntity(String.class));
    }
}