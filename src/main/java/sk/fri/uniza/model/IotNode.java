package sk.fri.uniza.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;


@org.hibernate.annotations.NamedQueries({
        @org.hibernate.annotations.NamedQuery(
                name = "IotNode_findByHouseHold",
                query = "from IotNode where household_id = :houseHoldId"),
        @org.hibernate.annotations.NamedQuery(
                name = "IotNode_findAll",
                query = "from IotNode"),
})

@Entity

public class IotNode {


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @ApiModelProperty(accessMode =  ApiModelProperty.AccessMode.READ_ONLY)  //rovnako ako houseHold
    private Long id;

    @NotEmpty
    private String Name;


    @ManyToOne
    //@JoinColumn(name="houseHold_id", nullable=false) //ako z 4. The Models
    @JoinColumn(name="houseHold_id", insertable = false , nullable=false) //ako z 4. The Models
    private HouseHold houseHold;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public HouseHold getHouseHold() {
        return houseHold;
    }

    public void setHouseHold(HouseHold houseHold) {
        this.houseHold = houseHold;
    }
}
