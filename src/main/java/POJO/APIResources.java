package POJO;

public enum APIResources {

    AddUser("/api/users"),
    UpdateUser("/api/users/2"),
    DeleteUser("/api/users/2"),
    getSingleUser("/api/users/2"),
    listUsers("/api/users");

    String resource ;

    APIResources(String resource) {
        this.resource = resource;
    }

    public String getResource()
    {
        return resource;
    }
}
