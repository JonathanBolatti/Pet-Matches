package com.petmatches.users.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Calendar;

@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name="CODE_CONFIRM")
public class CodeConfirmModel implements Serializable {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(name = "CODE")	
	private  String code;
	
	@NotNull
	@Column(name = "EMAIL")	
	private  String email;

	@Column(name = "STATUS")	
	private Boolean status;

	@NotNull
	@Column(name = "REGIS_DATE")	
    @Temporal(TemporalType.TIMESTAMP)
    private  Calendar registerDate;
	
	
	
	

}
