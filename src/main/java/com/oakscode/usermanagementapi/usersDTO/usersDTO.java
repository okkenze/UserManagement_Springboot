package com.oakscode.usermanagementapi.usersDTO;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName="build")
@NoArgsConstructor
public class usersDTO {
	@NotEmpty(message="is required")	
	private  String firstName;
	@NotEmpty(message="is required")
	private String lastName;
	@Email(message="is invalid")
	private String email;
	@Pattern(regexp="^\\d{11}$",message="Invalid mobile number entered")
	private String phone;
	@NotEmpty(message="is required")
	private String gender;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateOfBirth;
	@NotEmpty(message="is required")
	private String nationality;
	@Min(1)
	@Max(3)
	private int roleId;
	

}
