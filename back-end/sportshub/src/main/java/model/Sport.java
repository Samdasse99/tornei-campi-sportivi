package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Sport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSport;
	
	@Column(length = 30, nullable = false)
	private String nomeSport;
	
	@ManyToMany(mappedBy = "sports", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Campo> campi;
}
