package br.com.s2it.incubadora.model.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "acessory")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Accessory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7692317719290253396L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="accessory_id")
    private int id;

    @Column(name="name")
    private String name;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
