package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Segurado extends Model {

	public String nome;
	public String cpf;
	public String email;
	public String telefone;

}