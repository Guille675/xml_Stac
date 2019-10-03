package xml;

import java.util.List;

public class Cliente {
	private String id;
	
	

	private String nombre;
    private String telefono;
    private String comentario;
    
    public String getCliente() {
		return id;
	}

	public void setCliente(String id) {
		this.id = id;
	}
    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }
    public String gettelefono() {
        return telefono;
    }
    public void settelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getcomentario() {
        return comentario;
    }
    public void setcomentario(String comentario) {
        this.comentario = comentario;
    }

	@Override
	public String toString() {
		return "id [nombre=" + nombre + ", telefono=" + telefono + ", comentario=" + comentario + "]";
	}

	

}
