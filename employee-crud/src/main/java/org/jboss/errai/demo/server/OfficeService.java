package org.jboss.errai.demo.server;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.errai.demo.client.shared.Office;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class OfficeService {

  @PersistenceContext(unitName = "forge-default")
  private EntityManager em;

  public Office getById(Long id) {
    return em.find(Office.class, id);
  }

  @SuppressWarnings("unchecked")
  public List<Office> listAll() {
    return em.createNamedQuery("allOffices").getResultList();
  }
  
  public void create(Office entity) {
    em.persist(entity);
  }

  public void update(Long id, Office entity) {
    entity.setId(id);
    entity = em.merge(entity);
  }

  public void delete(Long id) {
    Office uc = em.find(Office.class, id);
    em.remove(uc);
  }
  
}