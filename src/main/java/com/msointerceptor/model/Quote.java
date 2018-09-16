package com.msointerceptor.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="QUOTES")
public class Quote extends AuditModel{
	
	
	private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
	    private Integer id;

	    @Column(name = "user_name")
	    private String userName;

	    @Column(name = "quote")
	    private String quote;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="user_id")
	    @JsonIgnore
	    private User quotesUser;
	    
		public Quote() {
	    }
		
	    public Quote(String userName, String quote) {
	        this.userName = userName;
	        this.quote = quote;
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getUserName() {
	        return userName;
	    }

	    public void setUserName(String userName) {
	        this.userName = userName;
	    }

	    public String getQuote() {
	        return quote;
	    }

	    public void setQuote(String quote) {
	        this.quote = quote;
	    }

	    public User getQuotesUser() {
			return quotesUser;
		}

		public void setQuotesUser(User quotesUser) {
			this.quotesUser = quotesUser;
		}

		@Override
		public String toString() {
			return "Quote [id=" + id + ", userName=" + userName + ", quote=" + quote + ", quotesUser=" + quotesUser
					+ "]";
		}
		
		 @Override
		    public boolean equals(Object o) {
		        if (this == o) return true;
		        if (!(o instanceof Quote )) return false;
		        return id != null && id.equals(((Quote) o).id);
		    }
		    @Override
		    public int hashCode() {
		        return 31;
		    }

}
