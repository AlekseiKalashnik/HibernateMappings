package hibernate_many_to_many.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.REFRESH,
            CascadeType.PERSIST, CascadeType.DETACH})
    @JoinTable(name = "child_section",
            //название JoinTable
            joinColumns = @JoinColumn(name = "section_id"),
            //с помощью какого столбца таблица child_section связывается с нашей таблицей children
            inverseJoinColumns = @JoinColumn(name = "child_id")
            //с помощью какого столбца таблица child_section будет связана с таблицей section

    )
    private List<Child> children;

    public Section() {
    }

    public Section(String name) {
        this.name = name;
    }

    public void addChildrenToSection(Child child) {
            if (children == null) {
                children = new ArrayList<>();
            }
            children.add(child);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
