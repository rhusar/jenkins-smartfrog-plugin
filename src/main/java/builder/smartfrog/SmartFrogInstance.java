/*
 * SmartFrogInstance.java
 *
 * Created on 22.10.2007, 11:28:46
 *
 */
package builder.smartfrog;

/**
 * Represents an installation object - name of the SmartFrog environment installation
 * and the path where it's located.
 *
 * @author dominik
 */
public class SmartFrogInstance {

   private String name;
   private String path;
   private String scripts;

   public SmartFrogInstance() {
   }

   public SmartFrogInstance(String name, String path, String scripts) {
      this.name = name;
      this.path = path;
      this.scripts = scripts;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPath() {
      return path;
   }

   public void setPath(String path) {
      this.path = path;
   }

   public String getScripts() {
      return scripts;
   }

   public void setScripts(String scripts) {
      this.scripts = scripts;
   }
}
