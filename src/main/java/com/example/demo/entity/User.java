package com.example.demo.entity;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.exceptions.BadLocationException;
import com.example.demo.exceptions.InvalideAgeException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data @NoArgsConstructor @ToString
public class User {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 25)
	private String firstName;
	@Column(length = 25)
	private String lastName;
	@Column(length = 25)
	private String password;
	//@Temporal(TemporalType.DATE)
	private String birthDate;
	private String location;
	
	public User(Long id, String firstName, String lastName, String password, String birthDate, String location) throws BadLocationException, InvalideAgeException {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		LocalDate birthday = converteToDate(birthDate);
		if(valideAge(birthday)) {
		this.birthDate = birthDate;
		}else {
			throw new InvalideAgeException();
		}
		if(valideLocation(location)) {
		this.location = location;
		}else {
			throw new BadLocationException();
		}
	}


public LocalDate converteToDate(String birthDate){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate localDate = LocalDate.parse(birthDate, formatter);

    return localDate;
}
public boolean valideAge(LocalDate birthDate){
    return calculateAge(birthDate) > 18;
}
public int calculateAge(LocalDate birthDay) {
    return _calculateAge(birthDay,LocalDate.now());
}
private int _calculateAge(LocalDate birthDate, LocalDate now) {
return Period.between(birthDate, now).getYears();
}
public boolean valideLocation(String location){
    return location.toLowerCase().contains("france");
}
}
