package br.unitins.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.unitins.model.Televisao;
import br.unitins.repository.TelevisaoRepository;



@Path("/televisoes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TelevisaoResource {
    
    
     @Inject
    private TelevisaoRepository repository;

    @GET
    public List<Televisao> getAll() {
        
         return repository.findAll().list();

    }

    @POST
    @Transactional
    public Televisao insert(Televisao televisao) {

        repository.persist(televisao);

        return televisao;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Televisao update(@PathParam("id") Long id, Televisao televisao) {

         Televisao entity = repository.findById(id);

         entity.setMarca(televisao.getMarca());
         entity.setModelo(televisao.getModelo());

        return entity;
    }

    @GET
    @Path("/count")
    public long count(){
        return repository.count();
    }

    @GET
    @Path("/search/{marca}")
    public Televisao search(@PathParam("marca") String marca){
        return repository.findByMarca(marca);
    } 
   
    @DELETE
    @Path("/{marca}")
    @Transactional
    public Televisao del(@PathParam("marca") String marca) {
        Televisao televisaoDel = repository.findByMarca(marca);
        repository.delete(televisaoDel);
        return televisaoDel;
    }
    
}
