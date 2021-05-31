package model;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voto {
	private Integer id;
	private Date fechacreacion;
	private Date fechavoto;
	private String enlace;
	private String estamento;
	private String candidato;
	private String votante;
}
