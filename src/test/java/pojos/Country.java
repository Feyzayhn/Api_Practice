package pojos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
     /*
    "country": {
        "id": 3,
        "name": "USA",
        "states": null
    }
     */


    private Integer id;
    private String name;
    private Object states;

    public Country() {
    }

    public Country(Integer id, String name, Object states) {
        this.id = id;
        this.name = name;
        this.states = states;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getStates() {
        return states;
    }

    public void setStates(Object states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", states=" + states +
                '}';
    }
}
