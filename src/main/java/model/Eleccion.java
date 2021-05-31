package model;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Eleccion {
	private Integer id;
	private String nombre;
	private Date fechainicio;
	private Date fechafin;
	private String cargo;
}
