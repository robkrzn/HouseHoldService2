package sk.fri.uniza.resources;

import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sk.fri.uniza.db.IotNodeDAO;
import sk.fri.uniza.model.IotNode;


import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api("/IotNode")
@Path("/IotNode")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IoTNodeResource {

    private IotNodeDAO iotNodeDAO;

    public IoTNodeResource(IotNodeDAO iotNodeDAO) {
        this.iotNodeDAO = iotNodeDAO;
    }

    @POST
    @UnitOfWork //Otvorí novú hibernate session
    @ApiOperation(value = "Prídá nový typ IoTNode")
    public IotNode createIotNode(@Valid IotNode iotNode) {
        return iotNodeDAO.create(iotNode);
    }

    @PUT
    @UnitOfWork //Otvorí novú hibernate session
    @ApiOperation(value = "Upraví existujúci IotNode")
    public IotNode updateIotNode(@Valid IotNode iotNode) {
        return iotNodeDAO.update(iotNode);
    }
    @GET
    @UnitOfWork //Otvorí novú hibernate session
    @Path("{id}")
    @ApiOperation(value = "Zobrazí IotNode")
    public IotNode findIotNode(@PathParam("id")Long id) {
        return iotNodeDAO.findById(id);
    }

    @GET
    @UnitOfWork //Otvorí novú hibernate session
    @ApiOperation(value = "Zobrazí všetky IotNode")
    public List<IotNode> allIotNodes() {
        return iotNodeDAO.allIotNodes();
    }

}
