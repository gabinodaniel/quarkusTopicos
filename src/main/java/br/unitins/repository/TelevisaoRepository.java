package br.unitins.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.unitins.model.Televisao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class TelevisaoRepository implements PanacheRepository<Televisao> {
    

    public Televisao findByMarca(String marca){
        return find("marca", marca).firstResult();
    }

    //Lista repository
    public List<Televisao> findByMarcaList (String marca){
        return find("marca LIKE ?1", "%" + marca + "%").list();
    }

   /*  public Televisao deletar(Long id){

        Televisao encontrarTelevisao = Televisao

        return null;

    } */

}

