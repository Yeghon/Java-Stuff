import java.util.List;
import java.util.Map;

/**
 * Graph_
 * Used to store connected data with vertices being the entities (i.e. people)
 * and the edges being the relationships (i.e. friendship)
 */
public class Graph_ {
  Map<Vertex, List<Vertex>> adjacencies;
}

// Vertex, the entity
/**
 * Vertex
 */
class Vertex {
  String label;

  public Vertex(String label) {
    this.label = label;
  }

  @Override
  public int hashCode() {
    // TODO Auto-generated method stub
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    // TODO Auto-generated method stub
    return super.equals(obj);
  }
}
