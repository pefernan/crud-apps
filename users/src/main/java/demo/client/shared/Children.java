package demo.client.shared;

/**
 * This class was automatically generated by the data modeler tool.
 */

@javax.persistence.Entity
public class Children implements java.io.Serializable
{

   static final long serialVersionUID = 1L;

   @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO, generator = "CHILDREN_ID_GENERATOR")
   @javax.persistence.Id
   @javax.persistence.SequenceGenerator(sequenceName = "CHILDREN_ID_SEQ", name = "CHILDREN_ID_GENERATOR")
   private Long id;

   @org.kie.api.definition.type.Label("Name")
   private String name;

   @org.kie.api.definition.type.Label("Last Name")
   private String lastName;

   public Children()
   {
   }

   public Long getId()
   {
      return this.id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public String getName()
   {
      return this.name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getLastName()
   {
      return this.lastName;
   }

   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   public Children(Long id, String name,
         String lastName)
   {
      this.id = id;
      this.name = name;
      this.lastName = lastName;
   }

}