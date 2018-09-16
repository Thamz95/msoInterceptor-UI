package com.msointerceptor.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="alert_manager")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)
/*@NamedQueries({
    @NamedQuery(
        name = "findAlertById",
        query = "from AlertManager a where a.id = :id"
        ),
})*/
public class AlertManager {
	
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id; 

    @Column(name = "alerttype ",length=20)
    private String alertType ;

    @Column(name = "alerttrigger ",length=20) 
    private String alertTrigger;
    
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
    
    private AlertManager() {}
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAlertType() {
		return alertType;
	}

	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}

	public String getAlertTrigger() {
		return alertTrigger;
	}

	public void setAlertTrigger(String alertTrigger) {
		this.alertTrigger = alertTrigger;
	}
	    
}
