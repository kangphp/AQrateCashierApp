package models;

import java.time.LocalDateTime;

public class User {
    private Integer id;
    private String name;
    private String username;
    private String password;
    private LocalDateTime createdAt;    
    
    public User(Integer id, String name, String username, String password, LocalDateTime createdAt){
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.createdAt = createdAt;
    }
    
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getUsername(){
        return username;
    }
    public void setUsernameS(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }   
    
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }
    
    @Override
    public String toString(){
        return String.format("ID: %d, Name: %s, Created At: %s",
                getId(),
                getName(),
                getUsername(),
                getCreatedAt()
        );
    }
    
}
            
            
            
    

