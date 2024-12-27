package com.devsuperior.dsclient.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.devsuperior.dsclient.entities.Client;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ClientDTO {

	private Long id;
	
	@NotBlank (message="Nome do cliente deve ser informado")
	@Size(min=3, max=100, message="Nome deve conter de 3 a 100 caracteres")	
	private String name;
	
	@NotBlank (message="CPF do cliente deve ser informado")
	@CPF(message="Cpf inválido")
	private String cpf;
	
	@Positive(message="A renda do cliente deve ser positivo")
	private Double income;
	
	@PastOrPresent(message="Data de nascimento não pode ser data futura")
	private LocalDate birthDate;
	
	@Min(0)
	@Positive(message="Número de filhos do cliente deve ser positivo")
	private Integer children;
	
	public ClientDTO() {
	}	
	
	public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.children = children;
	}

	public ClientDTO(Client entity) {
		id = entity.getId();
		name = entity.getName();
		cpf = entity.getCpf();
		income = entity.getIncome();
		birthDate = entity.getBirthDate();
		children = entity.getChildren();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCpf() {
		return cpf;
	}

	public Double getIncome() {
		return income;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public Integer getChildren() {
		return children;
	}
	
}
