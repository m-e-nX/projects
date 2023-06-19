package com.project.Horizon.Model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    String username;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String password;
    @Column(nullable = false, unique = true)
    private String email;

    public Student(){
        super();
    }
    public Student(Long id, String name, String password, String email, String username) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.username = username;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email+ ", username=" + username + "]";
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail(String email){
        return email;
    }
    public void setEmail(String email){
        this.email= email;
    }
    public String getUsername(String username){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }
   
   public static String generateUsername(String username){
    String lowercaseInput = username.toLowerCase();
    String underscoredInput = lowercaseInput.replace(" ", "_");
    String finalOutput = "@" + underscoredInput;
    return finalOutput;
   }

  
}
