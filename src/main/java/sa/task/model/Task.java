package sa.task.model;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
@NamedQueries({@NamedQuery(name = Task.FIND_ALL, query = "SELECT u FROM Task u")})
public class Task {

    public static final String FIND_ALL = "Task.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    private String name;
    private int archivado;
    private int grupo;
    private int tablero;
    private String description;

    // private int lista

    public Long getCode() {
        return code;
    }
    public void setCode(Long code) {
        this.code = code;
    }

    public String getName(){
      return name;
    }
    public void setName(String name){
      this.name = name;
    }

    public int getArchivado() {
        return archivado;
    }
    public void setArchivado(int archivado) {
        this.archivado = archivado;
    }
    public int getGrupo() {
        return grupo;
    }
    public void setGrupo(int archivado) {
        this.grupo = grupo;
    }
    public int getTablero() {
        return grupo;
    }
    public void setTablero(int tablero) {
        this.tablero = tablero;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
/*
    public String getPrueba() {
        return description;
    }
    public void setPrueba(String prueba) {
        this.prueba = prueba;
    }

    public int getLista() {
        return lista;
    }

    public void setLista(int lista) {
        this.lista = lista;
    }
    */
}
