package com.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
@Entity
@Table(name="user")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })//解决有字段为努力使在json化的时候，fasterxml.jackson将对象转换为json报错
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String codeid;
	
	private String name;
	
	private Integer type;
	
	private Integer cardtype;
	
	@Transient//排除掃描字段
	private String typename;
}
