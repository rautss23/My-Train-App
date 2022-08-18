package com.casestudy.model;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	
	@Id
	private String username;
	@NotEmpty(message = "name cannot be empty")
	private String name;
	private int age;
	@NotEmpty(message = "gender cannot be empty")
	private String gender;
	@Email(message = "mail cannot be empty")
	private String email;
	@NotEmpty(message = "password cannot be empty")
	private String password;
	@NotNull(message = "contact cannot be empty")
	private long contact;
	private String roles;
	private List<Booking> bookings;
	
//	public Users() {
//		
//	}
//	
//	public Users(String username, String name, int age, String gender, String email, String password, long contact, String roles, List<Booking> bookings) {
//		super();
//		this.username = username;
//		this.name = name;
//		this.age = age;
//		this.gender = gender;
//		this.email = email;
//		this.password = password;
//		this.contact = contact;
//		this.roles = roles;
//		this.bookings = bookings;
//	}
//	
	 
	
//	
//	public List<Booking> getBookings() {
//		return bookings;
//	}
//
//	public void setBookings(List<Booking> bookings) {
//		this.bookings = bookings;
//	}
//
//	public long getContact() {
//		return contact;
//	}
//
//	public void setContact(long contact) {
//		this.contact = contact;
//	}
//
//	public String getRoles() {
//		return roles;
//	}
//
//	public void setRoles(String roles) {
//		this.roles = roles;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	public String getGender() {
//		return gender;
//	}
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	
//	

}
