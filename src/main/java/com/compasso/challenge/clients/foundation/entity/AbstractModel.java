package com.compasso.challenge.clients.foundation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractModel implements IModel {

	private static final long serialVersionUID = -394655476483911221L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The auto generated identity")
	private Integer id;
	
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AbstractModel(Integer id) {
		this.id = id;
	}

	public AbstractModel() {
	}

	@Override
	public IModel cloneModel() {
		try {
			IModel clone = (IModel) super.clone();
			return clone;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

}
