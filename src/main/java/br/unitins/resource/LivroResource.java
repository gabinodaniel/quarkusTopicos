package br.unitins.resource;

import java.util.List;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.unitins.model.Livro;

@Path("/livro")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LivroResource {
    
    @POST
    @Transactional
    public Livro insert(Livro livro){
        livro.persist();
        return livro;
    }

    @GET
    @Path("/all")
    public List<Livro> getAll(){
        return Livro.findAll().list();
    }

    @GET
    @Path("/{id}")
    public Livro findById(@PathParam("id") Long id){
        return Livro.findById(id);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Livro updateLivro(@PathParam ("id") Long id, Livro livro) {
        
        Livro entity = Livro.findById(id);

        entity.setAutor(livro.getAutor());
        entity.setCorCapa(livro.getCorCapa());
        entity.setDataLanc(livro.getDataLanc());
        entity.setGenero(livro.getGenero());
        entity.setNome(livro.getNome());

        return entity;
    }

    @PATCH
    @Path("/{id}")
    @Transactional
    public Livro updateLivroParcial(@PathParam ("id") Long id, Livro livro) {
        
        Livro entity = Livro.findById(id);

        if(livro.getAutor() != null && !livro.getAutor().isBlank()){
            entity.setAutor(livro.getAutor());
        }
        if(livro.getCorCapa() != null && !livro.getCorCapa().isBlank()){
            entity.setCorCapa(livro.getCorCapa());
        }
       if(livro.getDataLanc() != null && !livro.getDataLanc().isBlank()){
            entity.setDataLanc(livro.getDataLanc());
       }
       if(livro.getGenero() != null && !livro.getGenero().isBlank()){
            entity.setGenero(livro.getGenero());
       }
       if(livro.getNome() != null && !livro.getNome().isBlank()){
        entity.setNome(livro.getNome());
       } 
        
        
        return entity;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public String delete(@PathParam("id") Long id){
        if(Livro.deleteById(id)){
            return "Deu certo";
        }else{
            return "Da nada";
        }
    }


}
