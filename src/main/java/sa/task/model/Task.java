package sa.task.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Table(name = "tasks")
@NamedQueries({
  @NamedQuery(name = Task.FIND_ALL, query = "SELECT u FROM Task u"),
  @NamedQuery(name = "TaskfindBygroup1", query = "SELECT u FROM Task u where u.group1 = :group1"),
  @NamedQuery(name = "TaskfindByuserid", query = "SELECT u FROM Task u where u.userid = :userid")
  })
public class Task {

    public static final String FIND_ALL = "Task.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    private String name;
    private int userid;// el usuario quien creo la tarea
    private boolean archived; // tarea archivada
    private boolean complete; // tarea completada
    private int group1; // miembros de la tarea
    private int board; // tablero de la tarea
    private String description; // descripcion de la tarea
    private Date created; // fecha de cracion
    private Date updated; // fecha de modificacion
    private Date dead; // fecha de terminacion
/*
    @ElementCollection
    private ArrayList<Integer> group2 = new ArrayList<Integer>();
    // private int lista
*/
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

    public boolean getArchived() {
        return archived;
    }
    public void setArchived(boolean archived) {
        this.archived = archived;
    }
    public boolean getComplete() {
        return complete;
    }
    public void setComplete(boolean complete) {
        this.complete = complete;
    }
    public int getGroup1() {
        return group1;
    }
    public void setGroup1(int group1) {
        this.group1 = group1;
    }

    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid= userid;
    }
    public int getBoard() {
        return board;
    }
    public void setBoard(int board) {
        this.board = board;
    }

    public String getDescription() {

        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        Date created = new Date();
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getDead() {
        return dead;
    }
      public void setDead(Date dead)   {
          this.dead = dead;



    }
/*
        public ArrayList<Integer> getGroup2() {
            return group2;
        }
*/
/*
        public void setGroup2(ArrayList<Integer> group2) {
            this.group2 = group2;
        }
/*

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
