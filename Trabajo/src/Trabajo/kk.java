package Trabajo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class kk implements Serializable {
	private Integer codigo;
	private String usuario;
	private String mensaje;

	public kk() {
		this.codigo = null;
		this.usuario = null;
		this.mensaje = null;
	}

	public kk(Integer codigo, String usuario, String mensaje) {
		this.codigo = codigo;
		this.usuario = usuario;
		this.mensaje = mensaje;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
