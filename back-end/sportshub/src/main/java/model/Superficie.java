package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Superficie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSuperficie;
	
	@Column(length = 20, nullable = false)
	private String materiale;
	
	@OneToMany(mappedBy = "superficie", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Campo> campi;
}
