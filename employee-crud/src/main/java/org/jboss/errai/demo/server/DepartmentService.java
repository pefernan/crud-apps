package org.jboss.errai.demo.server;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.errai.demo.client.shared.Department;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class DepartmentService {

  @PersistenceContext(unitName = "forge-default")
  private EntityManager em;

  public Department getById(Long id) {
    return em.find(Department.class, id);
  }

  @SuppressWarnings("unchecked")
  public List<Department> listAll() {
    return em.createNamedQuery("allDepartments").getResultList();
  }
  
  public void create(Department entity) {
    em.persist(entity);
  }

  public void update(Long id, Department entity) {
    entity.setId(id);
    entity = em.merge(entity);
  }

  public void delete(Long id) {
    Department uc = em.find(Department.class, id);
    em.remove(uc);
  }
  
}