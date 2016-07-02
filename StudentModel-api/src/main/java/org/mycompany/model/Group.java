package org.mycompany.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "groups")
@NamedNativeQuery(name = "findAllGroups", query = "SELECT g FROM groups g ORDER BY g.group_number")
public class Group implements EntityModel, Serializable
{
    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "generate_id", sequenceName = "generate_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generate_id")
    private BigInteger id;

    @Column(name = "group_number", nullable = false)
    private Integer groupNumber;

    @Column(name = "faculty_name", nullable = false)
    private String facultyName;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Student> students;

    public Group()
    {
    }

    public Group(Integer groupNumber, String facultyName)
    {
        this.groupNumber = groupNumber;
        this.facultyName = facultyName;
    }

    public BigInteger getId()
    {
        return id;
    }

    public void setId(BigInteger id)
    {
        this.id = id;
    }

    public Integer getGroupNumber()
    {
        return groupNumber;
    }

    public void setGroupNumber(Integer groupNumber)
    {
        this.groupNumber = groupNumber;
    }

    public String getFacultyName()
    {
        return facultyName;
    }

    public void setFacultyName(String facultyName)
    {
        this.facultyName = facultyName;
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    @Override
    public String toString()
    {
        return "Group{" +
                "id=" + id +
                ", groupNumber=" + groupNumber +
                ", facultyName='" + facultyName + '\'' +
                '}';
    }

}
