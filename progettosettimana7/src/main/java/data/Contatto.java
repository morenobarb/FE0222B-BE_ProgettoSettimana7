package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;


@NamedQuery(name ="getContatto.byCognome", query = "SELECT distinct c from Contatto c join c.numTelefoni n where c.cognome like :cognome" )

@Entity
@Table(name = "contatto")

public class Contatto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String nome;
	private String cognome;
	private String email;
	private ArrayList<NumeroTelefono> numTelefoni;

	///////////////////// COSTRUTTORI//////////////////////////////////

	public Contatto() {
	}

	public Contatto(String nome, String cognome, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
	}

	///////////////////////////// GETTERS e SETTERS/////////////////////////////////////

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	@Column(name = "nome")
	public String getNome() {
		return nome;
	}

	@Column(name = "cognome")
	public String getCognome() {
		return cognome;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(mappedBy = "contatto", cascade = CascadeType.ALL)
	public ArrayList<NumeroTelefono> getNumTelefoni() {
		return numTelefoni;
	}

	public void setNumTelefoni(ArrayList<NumeroTelefono> numTelefoni) {
		this.numTelefoni = numTelefoni;
	}

}