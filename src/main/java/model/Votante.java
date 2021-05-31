package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Votante {
	private Integer id;
	private String nombre;
	private String email;
	private String documento;
	private String tipodocumento;
	private String eleccion;
}
