package com.msointerceptor.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="user")
@NamedQueries({
    @NamedQuery(
        name = "findUserById",
        query = "from User u where u.id = :id"
        ),
   /* @NamedQuery(
        name = "findUsersByAccountId",
        query = "from User u where u.account.id = :id"
        ),*/
})
public class User extends AuditModel{


	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id; 

    @Column(name = "email_address") private String emailAddress;

    @Column(name = "password") private String password;

    @Column(name = "name") private String name;

    @Column(name = "created_by") private int createdBy;

    @OneToMany(fetch = FetchType.LAZY,
    		mappedBy="quotesUser",
    		cascade=CascadeType.ALL,
    		orphanRemoval = true)
    private List<Quote> userQuote = new ArrayList<>();
    
    
    private User() {}

    public int getId() {

        return id;

    }

    public void setId(int id) {

        this.id = id;

    }

    public String getEmailAddress() {

        return emailAddress;

    }

    public void setEmailAddress(String emailAddress) {

        this.emailAddress = emailAddress;

    }

    public String getPassword() {

        return password;

    }

    public void setPassword(String password) {

        this.password = password;

    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

    public int getCreatedBy() {

        return createdBy;

    }
    public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
    
	public List<Quote> getUserQuote() {
		return userQuote;
	}

	public void setUserQuote(List<Quote> userQuote) {
		this.userQuote = userQuote;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", emailAddress=" + emailAddress + ", password=" + password + ", name=" + name
				+ ", createdBy=" + createdBy+ ";, userQuote=" + userQuote + "]";
	}

	

  

}