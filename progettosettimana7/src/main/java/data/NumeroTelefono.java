package data;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "numero")
public class NumeroTelefono implements Serializable {

	private static final long serialVersionUID = 1L;

	private String numeroTelefono;

	private Contatto contatto;

	@Id
	@Column(name = "numero_telefono")
	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	@ManyToOne
	@JoinColumn(name = "id_contatto")
	public Contatto getContatto() {
		return contatto;
	}

	public void setContatto(Contatto contatto) {
		this.contatto = contatto;
	}

	public NumeroTelefono() {}
	
	
	public NumeroTelefono(String numeroTelefono, Contatto contatto) {
		super();
		this.numeroTelefono = numeroTelefono;
		this.contatto = contatto;
	}
	
	
	

}



