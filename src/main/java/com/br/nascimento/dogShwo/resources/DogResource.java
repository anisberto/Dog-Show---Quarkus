package com.br.nascimento.dogShwo.resources;

import com.br.nascimento.dogShwo.entities.Dog;
import com.br.nascimento.dogShwo.services.DogService;
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
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

@Path("/dog")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DogResource {

  @Inject
  private DogService dogService;

  @GET
  public List<Dog> getAllDog() {
    return dogService.listAll();
  }

  @GET
  @Path("{id:\\d+}")
  @Transactional
  public Dog getDogById(@PathParam("id") Long id) {
    return dogService.findById(id);
  }

  @POST
  @Transactional
  public Dog saveDog(@RequestBody Dog dog) {
      dogService.persist(dog);
      Dog savedDog = dogService.findById(dog.getId());
      if (savedDog != null) {
          return savedDog;
        }
        return null;
    }
    
    @PUT
    @Path("/{id:\\d+}/update")
    @Transactional
    public Dog updateDog(@PathParam("id") Long id, @RequestBody Dog dog) {
        Dog updatedDog = dogService.findById(id);
        if (updatedDog != null) {
            dogService.persist(updatedDog);
            return updatedDog;
        }
        return null;
    }
    
    @DELETE
    @Path("/{id:\\d+}/delete")
    @Transactional
    public void deleteDog(@PathParam("id") Long id) {
        dogService.delete(dogService.findById(id));
  }
}
