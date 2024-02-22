package ca.sheridancollege.vutran.beans;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class Account {
	private Long id;
	private String name;
	private String email;
	private String password;
	private String gender;
	private boolean subscribe;
	private Country country;
	private String message;
}




/*
 * 
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "password": "secretpassword",
  "gender": "Male",
  "subscribe": true,
  "country": "CANADA",
  "message": "This is a test message."
}, 
{
  "name": "David Vu",
  "email": "dv@example.com",
  "password": "secretpassword",
  "gender": "Male",
  "subscribe": true,
  "country": "US",
  "message": "This is a test message."
}

*/
