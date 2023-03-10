package br.unitins.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

 import br.unitins.dto.ControleDTO;
import br.unitins.dto.ControleResponseDTO;
import br.unitins.model.Controle;
import br.unitins.repository.TelevisaoRepository;
import br.unitins.repository.ControleRepository; 

@Path("/controles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class ControleResource {
    
    @Inject
    private ControleRepository repository;

    @Inject
    private TelevisaoRepository televisaoRepository;

    @GET
    public List<ControleResponseDTO> getAll() {
        
        

        return repository.findAll()
            .stream()
            .map(municipio -> new ControleResponseDTO(controle))
            .collect(Collectors.toList());
            
        // return repository.findAll().list();

    }

    @POST
    @Transactional
    public ControleResponseDTO insert(ControleDTO dto) {

        Controle entity = new Controle();
        entity.setNome(dto.getNome());
        entity.setTelevisao(televisaoRepository.findById(dto.getIdTelevisao()));

        repository.persist(entity);

        return new ControleResponseDTO(entity);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Controle update(@PathParam("id") Long id, Controle controle) {

         Controle entity = repository.findById(id);

         entity.setNome(controle.getNome());

        return entity;
    }

    @GET
    @Path("/count")
    public long count(){
        return repository.count();
    }

    @GET
    @Path("/search/{nome}")
    public List<Controle> search(@PathParam("nome") String nome){
        return repository.findByNome(nome);
    }

}
