package gwt.material.errai.table.client.shared;


import org.jboss.errai.common.client.api.annotations.Portable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Portable
public class User{

	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String color;
	private String uniqueId;
	private String category;
	private String lastName;
	private String firstName;

	public User() {}

	public User(String name, String color) {
		setUsername(name);
		setColor(color);
	}

	public User(String uniqueId, String color, String username) {
		this.uniqueId = uniqueId;
		this.username = username;
		this.color = color;
	}

	public User(String username, String category, String firstName, String lastName) {
		this.username = username;
		this.category = category;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
