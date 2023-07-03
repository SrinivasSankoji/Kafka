package com.kafka.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String firstName;
	private String lastName;

}
